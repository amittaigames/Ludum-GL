package com.amittaigames.ludumgl;

import org.lwjgl.input.Keyboard;

public class Input {

	public static void init() {
		try {
			Keyboard.create();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean key(int key) {
		return Keyboard.isKeyDown(key);
	}
	
}