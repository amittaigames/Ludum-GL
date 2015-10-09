package com.amittaigames.ludumgl.audio;

import java.util.ArrayList;
import java.util.List;

public class AudioHandler {

	private static List<Sound> sounds = new ArrayList<Sound>();
	public static String dir = "";
	
	public static void setLoadDirectory(String dir) {
		AudioHandler.dir = dir;
	}
	
	public static void addSound(Sound sound) {
		sounds.add(sound);
	}
	
	public static void playSound(String name) {
		for (Sound s : sounds) {
			if (s.getName().equals(name)) {
				if (!s.getAudio().isPlaying())
					s.getAudio().playAsSoundEffect(1.0f, 1.0f, false);
			}
		}
	}
	
}