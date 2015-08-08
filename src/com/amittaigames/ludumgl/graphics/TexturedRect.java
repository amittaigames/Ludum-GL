package com.amittaigames.ludumgl.graphics;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TexturedRect {

	private Texture texture;
	private int x;
	private int y;
	private int w;
	private int h;
	
	private int angle;
	
	public TexturedRect(String texture, int x, int y, int w, int h) {
		try {
			this.texture = TextureLoader.getTexture("PNG", this.getClass().getResourceAsStream(texture));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	// Rotates rectangle
	// 'angle' is pretty much the speed of rotation if constantly updated
	public void rotate(int angle) {
		this.angle += angle;
	}
	
	public void translate(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public int getAngle() {
		return angle;
	}
	
	public void setAngle(int angle) {
		this.angle = angle;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return w;
	}

	public void setWidth(int w) {
		this.w = w;
	}

	public int getHeight() {
		return h;
	}

	public void setHeight(int h) {
		this.h = h;
	}
	
}