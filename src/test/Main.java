package test;

import org.lwjgl.input.Keyboard;

import com.amittaigames.ludumgl.CoreGame;
import com.amittaigames.ludumgl.Window;
import com.amittaigames.ludumgl.graphics.Pyramid;
import com.amittaigames.ludumgl.graphics.Render;
import com.amittaigames.ludumgl.scripts.DataArray;
import com.amittaigames.ludumgl.scripts.DataType;
import com.amittaigames.ludumgl.scripts.ScriptHandler;

public class Main extends CoreGame {
	
	private static Pyramid p;
	private static DataArray pColor;
	
	private float speed = 2.5f;
	
	public static void main(String[] args) {
		Window.config(200, 800);
		Window.init("Ludum GL", 800, 600, new Main(), 60);
	}

	@Override
	public void init() {
		Window.enable("3d", "light");
		p = new Pyramid(150, 150, 1, 200, 200, 200);
		pColor = ScriptHandler.compileScript("/scripts/color_tri.ludumgl", DataType.COLOR);
	}

	@Override
	public void render(Render r) {
		r.clear(0, 0, 0);
		
		r.fillPyramid(p, pColor, DataType.COLOR);
	}

	@Override
	public void update(int delta) {
		p.rotate(1.25f, 1, 1, 0);
		
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
			p.translate(speed, 0, 0);
		if (Keyboard.isKeyDown(Keyboard.KEY_A))
			p.translate(-speed, 0, 0);
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
			p.translate(0, -speed, 0);
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
			p.translate(0, speed, 0);
	}
	
}