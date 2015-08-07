package com.amittaigames.ludumgl.graphics;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import com.amittaigames.ludumgl.Util;

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
	
	public void drawTexture(TexturedRect r) {
		Texture t = null;
		try {
			t = TextureLoader.getTexture("PNG", this.getClass().getResourceAsStream(r.getTexture()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (t == null) {
			return;
		}
		
		t.bind();
		
		GL11.glPushMatrix();
		
		GL11.glTranslatef(r.getX() + (r.getWidth() / 2), r.getY() + (r.getHeight() / 2), 0);
		GL11.glRotatef(r.getAngle(), 0, 0, 1);
		GL11.glTranslatef(-r.getX() - (r.getWidth() / 2), -r.getY() - (r.getHeight() / 2), 0);
		
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(r.getX(), r.getY());
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(r.getX() + r.getWidth(), r.getY());
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(r.getX() + r.getWidth(), r.getY() + r.getHeight());
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(r.getX(), r.getY() + r.getHeight());
		}
		GL11.glEnd();
		
		GL11.glPopMatrix();
	}
	
	// Draws a texture to the screen
	public void drawTexture(String texture, int x, int y, int w, int h) {
		Texture t = null;
		try {
			t = TextureLoader.getTexture("PNG", this.getClass().getResourceAsStream(texture));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (t == null) {
			return;
		}
		
		t.bind();
		
		GL11.glPushMatrix();
		
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(x, y);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(x + w, y);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(x + w, y + h);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(x, y + h);
		}
		GL11.glEnd();
		
		GL11.glPopMatrix();
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