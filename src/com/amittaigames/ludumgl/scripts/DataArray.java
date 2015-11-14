package com.amittaigames.ludumgl.scripts;

public class DataArray {

	private float[][] data;
	
	public DataArray(int cell1, int cell2) {
		data = new float[cell1][cell2];
	}
	
	public float getData(int x, int y) {
		return data[x][y];
	}
	
	public void setData(int x, int y, float value) {
		data[x][y] = value;
	}
	
	public void setCell(int x, float... data) {
		for (int i = 0; i < data.length; i++) {
			this.data[x][i] = data[i];
		}
	}
	
}