package test;

import com.amittaigames.ludumgl.CoreGame;
import com.amittaigames.ludumgl.Render;
import com.amittaigames.ludumgl.Window;

public class Main extends CoreGame {
	
	public static void main(String[] args) {
		Window.init("Ludum GL Test", 800, 600, new Main());
	}

	@Override
	public void init() {
		
	}

	@Override
	public void render(Render r) {
		r.clear(0, 0, 0);
	}

	@Override
	public void update(int delta) {
		
	}
	
}