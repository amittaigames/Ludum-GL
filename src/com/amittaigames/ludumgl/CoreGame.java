package com.amittaigames.ludumgl;

import com.amittaigames.ludumgl.graphics.Render;

public abstract class CoreGame {

	public abstract void init();
	public abstract void render(Render r);
	public abstract void update(int delta);
	
}