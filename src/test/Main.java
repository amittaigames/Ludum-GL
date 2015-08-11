package test;

import java.awt.Font;

import org.lwjgl.input.Keyboard;

import com.amittaigames.ludumgl.CoreGame;
import com.amittaigames.ludumgl.Input;
import com.amittaigames.ludumgl.Window;
import com.amittaigames.ludumgl.graphics.FontHandler;
import com.amittaigames.ludumgl.graphics.Render;
import com.amittaigames.ludumgl.graphics.TexturedRect;

public class Main extends CoreGame {
	
	private TexturedRect player;
	
	public static void main(String[] args) {
		Window.init("Ludum GL Test", 800, 600, new Main(), 30);
	}

	@Override
	public void init() {
		Input.init();
		FontHandler.registerFont(new Font("Arial", Font.PLAIN, 16), true);
		player = new TexturedRect("/textures/Player.png", 100, 100, 100, 100);
	}

	@Override
	public void render(Render r) {
		r.clear(0, 0, 0);
		
		r.drawTexture(player);
		
		r.setColor(255, 255, 255);
		FontHandler.setFont("Arial");
		r.drawText("FPS: " + Window.getCurrentFPS(), 15, 15);
	}

	@Override
	public void update(int delta) {
		if (Input.key(Keyboard.KEY_D))
			player.translate(delta / 5, 0);
		if (Input.key(Keyboard.KEY_A))
			player.translate(-(delta / 5), 0);
		if (Input.key(Keyboard.KEY_W))
			player.translate(0, -(delta / 5));
		if (Input.key(Keyboard.KEY_S))
			player.translate(0, delta / 5);
	}
	
}