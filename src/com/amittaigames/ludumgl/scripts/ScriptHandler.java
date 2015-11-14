package com.amittaigames.ludumgl.scripts;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.amittaigames.ludumgl.Util;

public class ScriptHandler {

	public static DataArray compileScript(String loc, int dataType) {
		DataArray da = null;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(ScriptHandler.class.getResourceAsStream(loc)));
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					if (line.startsWith("@")) {
						line = line.replace("@", "").replace(" ", "");
						String[] strsize = line.split(",");
						int x = Integer.parseInt(strsize[0]);
						int y = Integer.parseInt(strsize[1]);
						da = new DataArray(x, y);
					} else {
						line = replaceAlias(line).replace(" ", "");
						String[] args = line.split(",");
						float[] data = new float[args.length - 1];
						for (int i = 0; i < data.length; i++) {
							float d = Float.parseFloat(args[i + 1]);
							if (dataType == DataType.COLOR) {
								d = Util.rgbConvert((int)d);
							}
							data[i] = d;
						}
						da.setCell(Integer.parseInt(args[0]), data);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return da;
	}
	
	private static String replaceAlias(String str) {
		return str.replace("#front", "0")
				.replace("#back", "1")
				.replace("#right", "2")
				.replace("#left", "3")
				.replace("#top", "4")
				.replace("#bottom", "5");
	}
	
}