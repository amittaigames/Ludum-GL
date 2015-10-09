package test;

import java.awt.Font;

import org.lwjgl.input.Keyboard;

import com.amittaigames.ludumgl.CoreGame;
import com.amittaigames.ludumgl.Input;
import com.amittaigames.ludumgl.Window;
import com.amittaigames.ludumgl.graphics.FontHandler;
import com.amittaigames.ludumgl.graphics.Rect;
import com.amittaigames.ludumgl.graphics.Render;

public class Main extends CoreGame {
	
	private Rect player;
	
	public static void main(String[] args) {
		Window.init("Ludum GL Test", 800, 600, new Main(), 45);
	}

	@Override
	public void init() {
		player = new Rect(100, 100, 100, 100);
		FontHandler.registerFont(new Font("Arial", Font.PLAIN, 16), true);
	}

	@Override
	public void render(Render r) {
		r.clear(0, 0, 0);
		
		r.setColor(0, 122, 163);
		r.fillRect(player);
		
		r.setColor(255, 255, 255);
		FontHandler.setFont("Arial 16");
		r.drawText("FPS: " + Window.getCurrentFPS(), 15, 15);
	}

	@Override
	public void update(int delta) {
		player.rotate(2);
		
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