package com.amittaigames.ludumgl.graphics;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.TrueTypeFont;

public class FontHandler {

	private static List<FontGL> fonts = new ArrayList<FontGL>();
	
	public static void setFont(String name) {
		Render.setFont(getFont(name));
	}
	
	public static void registerFont(Font f, boolean antiAliasing) {
		System.out.println("[Ludum GL] Loading font: " + f.getName() + " " + f.getSize());
		fonts.add(new FontGL(f.getName() + " " + f.getSize(), new TrueTypeFont(f, antiAliasing)));
	}
	
	private static TrueTypeFont getFont(String name) {
		TrueTypeFont ttf = null;
		for (int i = 0; i < fonts.size(); i++) {
			FontGL font = fonts.get(i);
			if (font.getName().equals(name)) {
				ttf = font.getFont();
				break;
			}
		}
		if (ttf == null) {
			System.out.println("Could not load font: " + name);
		}
		return ttf;
	}
	
}