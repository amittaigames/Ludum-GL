package com.amittaigames.ludumgl;

import org.lwjgl.input.Keyboard;

public class Input {

	// Initializes keyboard use
	public static void init() {
		try {
			Keyboard.create();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Returns the use of a key press
	public static boolean key(int key) {
		return Keyboard.isKeyDown(key);
	}
	
}