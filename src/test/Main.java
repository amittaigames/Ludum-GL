package test;

import org.lwjgl.input.Keyboard;

import com.amittaigames.ludumgl.CoreGame;
import com.amittaigames.ludumgl.Input;
import com.amittaigames.ludumgl.Window;
import com.amittaigames.ludumgl.graphics.Render;
import com.amittaigames.ludumgl.graphics.TexturedRect;

public class Main extends CoreGame {
	
	private TexturedRect rect = new TexturedRect("/textures/face.png", 100, 100, 100, 100);
	private TexturedRect light = new TexturedRect("/textures/light.png", 300, 100, 100, 100);
	
	public static void main(String[] args) {
		Window.init("Ludum GL Test", 800, 600, new Main(), 60);
	}

	@Override
	public void init() {
		Input.init();
	}

	@Override
	public void render(Render r) {
		r.clear(0, 0, 0);
		
		r.WHITE_TEXTURE = false;
		
		r.setColor(0, 122, 163);
		r.drawTexture(rect);
		
		r.setColor(255, 255, 255);
		r.drawTexture(light);
	}

	@Override
	public void update(int delta) {
		if (Input.key(Keyboard.KEY_D))
			rect.translate(delta / 5, 0);
		if (Input.key(Keyboard.KEY_A))
			rect.translate(-(delta / 5), 0);
	}
	
}