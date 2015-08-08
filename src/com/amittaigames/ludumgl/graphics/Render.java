package com.amittaigames.ludumgl.graphics;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import com.amittaigames.ludumgl.Util;

public class Render {

	public boolean WHITE_TEXTURE = true;
	
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
		GL11.glPushMatrix();
		
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
		
		if (WHITE_TEXTURE)
			setColor(255, 255, 255);
		
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
		
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
		GL11.glPushMatrix();
		
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
		
		if (WHITE_TEXTURE)
			setColor(255, 255, 255);
		
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
		
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
	
	// Fills a triangle
	public void fillTriangle(int x, int y, int w, int h) {
		GL11.glPushMatrix();
		
		GL11.glBegin(GL11.GL_TRIANGLES);
		{
			GL11.glVertex2f(x, y + h);
			GL11.glVertex2f(x + w, y + h);
			GL11.glVertex2f(x + (w / 2), y);
		}
		GL11.glEnd();
		
		GL11.glPopMatrix();
	}
	
	public void fillTriangle(Triangle t) {
		GL11.glPushMatrix();
		
		GL11.glTranslatef(t.getX() + (t.getWidth() / 2), t.getY() + (t.getHeight() / 2), 0);
		GL11.glRotatef(t.getAngle(), 0, 0, 1);
		GL11.glTranslatef(-t.getX() - (t.getWidth() / 2), -t.getY() - (t.getHeight() / 2), 0);
		
		GL11.glBegin(GL11.GL_TRIANGLES);
		{
			GL11.glVertex2f(t.getX(), t.getY() + t.getHeight());
			GL11.glVertex2f(t.getX() + t.getWidth(), t.getY() + t.getHeight());
			GL11.glVertex2f(t.getX() + (t.getWidth() / 2), t.getY());
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