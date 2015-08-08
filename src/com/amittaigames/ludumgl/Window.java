package com.amittaigames.ludumgl;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import com.amittaigames.ludumgl.graphics.Render;

public class Window {

	public static boolean USE_VSYNC = true;
	
	private static int width;
	private static int height;
	private static CoreGame cg;
	private static int fps;
	private static long lastFrame;
	
	private static long lastFPS;
	private static int LAST = 0;
	private static int FPS;
	
	// Sets up the window with a title and size
	public static void init(String title, int width, int height, CoreGame cg, int fps) {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
			Display.setVSyncEnabled(USE_VSYNC);
			Display.create();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Window.width = width;
		Window.height = height;
		Window.cg = cg;
		Window.fps = fps;
		start();
	}
	
	// Starts the main loop
	private static void start() {
		initGL();
		getDelta();
		lastFPS = getTime();
		
		// Allows user initialization
		cg.init();
		
		// Main game loop
		while (!Display.isCloseRequested()) {
			int delta = getDelta();
			
			cg.update(delta);
			cg.render(new Render());
			
			Display.update();
			Display.sync(fps); // Game frame-rate (Set to 60 for best results)
		}
		
		// Cleans up
		Display.destroy();
		System.exit(0);
	}
	
	private static void initGL() {
		// Allows texturing
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		// Sets up camera
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	// Gets delta time
	private static int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		return delta;
	}
	
	// Gets system time
	private static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public static int getCurrentFPS() {
		int ret = LAST;
		if (getTime() - lastFPS > 1000) {
			ret = FPS;
			LAST = FPS;
			FPS = 0;
			lastFPS += 1000;
		}
		FPS++;
		return ret;
	}
	
	public static int getWidth() {
		return width;
	}
	
	public static int getHeight() {
		return height;
	}
	
}