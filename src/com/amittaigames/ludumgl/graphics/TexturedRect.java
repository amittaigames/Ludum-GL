package com.amittaigames.ludumgl.graphics;

public class TexturedRect {

	private String texture;
	private int x;
	private int y;
	private int w;
	private int h;
	
	private int angle;
	
	public TexturedRect(String texture, int x, int y, int w, int h) {
		this.texture = texture;
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
	
	public int getAngle() {
		return angle;
	}
	
	public void setAngle(int angle) {
		this.angle = angle;
	}
	
	public String getTexture() {
		return texture;
	}
	
	public void setTexture(String texture) {
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