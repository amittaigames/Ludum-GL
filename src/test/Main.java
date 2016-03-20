package test;

import com.amittaigames.ludumgl.CoreGame;
import com.amittaigames.ludumgl.Window;
import com.amittaigames.ludumgl.graphics.Render;
import com.amittaigames.ludumgl.graphics.TexturedRect;

public class Main extends CoreGame {
	
	private static TexturedRect rect;
	
	public static void main(String[] args) {
		Window.config(200, 800);
		Window.init("Ludum GL", 800, 600, new Main(), 60);
	}

	@Override
	public void init() {
		rect = new TexturedRect("/textures/Human.png", 100, 100, 64, 64);
	}

	@Override
	public void render(Render r) {
		r.clear(0, 0, 0);
		
		r.drawTexture(rect);
	}

	@Override
	public void update(int delta) {
		
	}
	
}