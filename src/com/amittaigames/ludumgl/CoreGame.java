package com.amittaigames.ludumgl;

import com.amittaigames.ludumgl.graphics.Render;

public abstract class CoreGame {

	// Have your main class extend this
	public CoreGame() {
		Natives.load();
	}
	
	// These methods will be implemented
	public abstract void init();
	public abstract void render(Render r);
	public abstract void update(int delta);
	
}