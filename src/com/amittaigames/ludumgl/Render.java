package com.amittaigames.ludumgl;

import org.lwjgl.opengl.GL11;

public class Render {

	// Clears the screen
	// Use this before anything else!
	public void clear(int r, int g, int b) {
		GL11.glClearColor(Util.rgbConvert(r), Util.rgbConvert(g), Util.rgbConvert(b), 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}
	
	// Sets the color to be used for drawing
	public void setColor(int r, int g, int b) {
		GL11.glColor3f(Util.rgbConvert(r), Util.rgbConvert(g), Util.rgbConvert(b));
	}
	
	// Fills a rectangle
	public void fillRect(int x, int y, int w, int h) {
		GL11.glPushMatrix();
		
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glVertex2f(x, y);
			GL11.glVertex2f(x + w, y);
			GL11.glVertex2f(x + w, y + h);
			GL11.glVertex2f(x, y + h);
		}
		GL11.glEnd();
		
		GL11.glPopMatrix();
	}
	
	// Fills a rectangle using the 'Rect' object
	public void fillRect(Rect r) {
		GL11.glPushMatrix();
		
		GL11.glTranslatef(r.getX() + (r.getWidth() / 2), r.getY() + (r.getHeight() / 2), 0);
		GL11.glRotatef(r.getAngle(), 0, 0, 1);
		GL11.glTranslatef(-r.getX() - (r.getWidth() / 2), -r.getY() - (r.getHeight() / 2), 0);
		
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glVertex2f(r.getX(), r.getY());
			GL11.glVertex2f(r.getX() + r.getWidth(), r.getY());
			GL11.glVertex2f(r.getX() + r.getWidth(), r.getY() + r.getHeight());
			GL11.glVertex2f(r.getX(), r.getY() + r.getHeight());
		}
		GL11.glEnd();
		
		GL11.glPopMatrix();
	}
	
}