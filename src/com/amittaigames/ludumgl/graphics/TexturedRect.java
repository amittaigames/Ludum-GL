package com.amittaigames.ludumgl.graphics;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TexturedRect {

	private Texture texture;
	private float x;
	private float y;
	private float w;
	private float h;
	
	private float angle;
	
	// Create a renderable texture object
	public TexturedRect(String texture, float x, float y, float w, float h) {
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
	public void rotate(float angle) {
		this.angle += angle;
	}
	
	// Translates the rectangle a given x and y value
	public void translate(float x, float y) {
		this.x += x;
		this.y += y;
	}
	
	public float getAngle() {
		return angle;
	}
	
	public void setAngle(float angle) {
		this.angle = angle;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return w;
	}

	public void setWidth(float w) {
		this.w = w;
	}

	public float getHeight() {
		return h;
	}

	public void setHeight(float h) {
		this.h = h;
	}
	
}