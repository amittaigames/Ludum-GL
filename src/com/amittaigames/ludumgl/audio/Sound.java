package com.amittaigames.ludumgl.audio;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;

public class Sound {

	private String name;
	private Audio audio;
	
	// Create new sound from name (no extension, must be .wav file)
	public Sound(String name) {
		try {
			this.name = name;
			this.audio = AudioLoader.getAudio("WAV", this.getClass().getResourceAsStream(AudioHandler.dir + name + ".wav"));
			AudioHandler.addSound(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name;
	}
	
	public Audio getAudio() {
		return audio;
	}
	
}