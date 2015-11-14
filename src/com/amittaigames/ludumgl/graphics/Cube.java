package com.amittaigames.ludumgl.graphics;

public class Cube {

	private float x;
	private float y;
	private float z;
	private float width;
	private float height;
	private float depth;
	
	private float angle;
	private float rx;
	private float ry;
	private float rz;
	
	public Cube(float x, float y, float z, float width, float height, float depth) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	public void translate(float x, float y, float z) {
		this.x += x;
		this.y += y;
		this.z += z;
	}
	
	public void rotate(float angle, float rx, float ry, float rz) {
		this.angle += angle;
		this.rx = rx;
		this.ry = ry;
		this.rz = rz;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public float getDepth() {
		return depth;
	}

	public float getAngle() {
		return angle;
	}

	public float getRX() {
		return rx;
	}

	public float getRY() {
		return ry;
	}

	public float getRZ() {
		return rz;
	}
	
}