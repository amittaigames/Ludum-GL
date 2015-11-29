package test;

import java.awt.Font;

import org.lwjgl.input.Keyboard;

import com.amittaigames.ludumgl.CoreGame;
import com.amittaigames.ludumgl.Window;
import com.amittaigames.ludumgl.graphics.Cube;
import com.amittaigames.ludumgl.graphics.FontHandler;
import com.amittaigames.ludumgl.graphics.Render;

public class Main extends CoreGame {
	
	private static Cube cube;
	
	private float speed = 2.5f;
	
	public static void main(String[] args) {
		Window.config(200, 800);
		Window.init("Ludum GL", 800, 600, new Main(), 60);
	}

	@Override
	public void init() {
		Window.enable("3d", "light");
		cube = new Cube(150, 150, 1, 200, 200, 200);
		FontHandler.registerFont(new Font("Arial", Font.PLAIN, 16), true);
	}

	@Override
	public void render(Render r) {
		r.clear(0, 0, 0);
		
		r.setColor(128, 128, 128);
		r.fillCube(cube);
		
		r.setColor(255, 255, 255);
		FontHandler.setFont("Arial 16");
		r.drawText("FPS: " + Window.getCurrentFPS(), 15, 15);
	}

	@Override
	public void update(int delta) {
		cube.rotate(1.25f, 1, 1, 1);
		
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
			cube.translate(speed, 0, 0);
		if (Keyboard.isKeyDown(Keyboard.KEY_A))
			cube.translate(-speed, 0, 0);
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
			cube.translate(0, -speed, 0);
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
			cube.translate(0, speed, 0);
	}
	
}