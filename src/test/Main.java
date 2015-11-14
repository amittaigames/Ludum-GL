package test;

import org.lwjgl.input.Keyboard;

import com.amittaigames.ludumgl.CoreGame;
import com.amittaigames.ludumgl.Window;
import com.amittaigames.ludumgl.graphics.Cube;
import com.amittaigames.ludumgl.graphics.Render;
import com.amittaigames.ludumgl.scripts.DataArray;
import com.amittaigames.ludumgl.scripts.DataType;
import com.amittaigames.ludumgl.scripts.ScriptHandler;

public class Main extends CoreGame {
	
	private static Cube c;
	private static DataArray da;
	
	private float speed = 2.5f;
	
	public static void main(String[] args) {
		Window.config(200, 800);
		Window.init("Ludum GL", 800, 600, new Main(), 60);
	}

	@Override
	public void init() {
		Window.enable("3d", "light");
		c = new Cube(200, 200, 1, 200, 200, 200);
		da = ScriptHandler.compileScript("/scripts/rainbow_cube.ludumgl", DataType.COLOR);
	}

	@Override
	public void render(Render r) {
		r.clear(0, 0, 0);
		
		r.setColor(0, 122, 163);
		r.fillCube(c, da, DataType.COLOR);
	}

	@Override
	public void update(int delta) {
		c.rotate(1.25f, 1, 1, 1);
		
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
			c.translate(speed, 0, 0);
		if (Keyboard.isKeyDown(Keyboard.KEY_A))
			c.translate(-speed, 0, 0);
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
			c.translate(0, -speed, 0);
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
			c.translate(0, speed, 0);
	}
	
}