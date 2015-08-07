package com.amittaigames.ludumgl;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Window {

	private static int width;
	private static int height;
	private static CoreGame cg;
	private static long lastFrame;
	
	public static void init(String title, int width, int height, CoreGame cg) {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
			Display.setVSyncEnabled(true);
			Display.create();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Window.width = width;
		Window.height = height;
		Window.cg = cg;
		start();
	}
	
	private static void start() {
		initGL();
		getDelta();
		
		cg.init();
		
		while (!Display.isCloseRequested()) {
			int delta = getDelta();
			
			cg.update(delta);
			cg.render(new Render());
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
		System.exit(0);
	}
	
	private static void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	private static int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		return delta;
	}
	
	private static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
}