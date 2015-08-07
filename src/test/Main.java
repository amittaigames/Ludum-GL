package test;

import com.amittaigames.ludumgl.CoreGame;
import com.amittaigames.ludumgl.Window;
import com.amittaigames.ludumgl.graphics.Render;
import com.amittaigames.ludumgl.graphics.TexturedRect;

public class Main extends CoreGame {
	
	private TexturedRect rect = new TexturedRect("/textures/Vex.png", 100, 100, 100, 100);
	
	public static void main(String[] args) {
		Window.init("Ludum GL Test", 800, 600, new Main(), 60);
	}

	@Override
	public void init() {
		
	}

	@Override
	public void render(Render r) {
		r.clear(0, 0, 0);
		
		r.drawTexture(rect);
	}

	@Override
	public void update(int delta) {
		rect.rotate(delta / 10);
	}
	
}