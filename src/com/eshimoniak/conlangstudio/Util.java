package com.eshimoniak.conlangstudio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import org.json.JSONObject;

/**
 * Miscellaneous utility functions
 * @author Evan Shimoniak
**/
public class Util {
	public static boolean isDirectory(File f) {
		if (f != null) {
			return f.isDirectory() && !f.isFile();
		} else {
			return false;
		}
	}
	
	public static String capitalize(String str) {
		StringBuilder sb = new StringBuilder();
		boolean shouldCapitalize = true;
		
		for (int i = 0; i < str.length(); i++) {
			if (shouldCapitalize) {
				sb.append(Character.toUpperCase(str.charAt(i)));
				shouldCapitalize = false;
			} else {
				sb.append(str.charAt(i));
				if (str.charAt(i) == '-') {
					shouldCapitalize = true;
				}
			}
		}
		
		return sb.toString();
	}
	
	public static String loadFile(File f) {
		if (!Util.isDirectory(f) && f != null && f.exists()) {
			StringBuilder sb = new StringBuilder();
			String ln;
			
			try {
				FileInputStream is = new FileInputStream(f);
				BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				while ((ln = in.readLine()) != null) {
					sb.append(ln);
					sb.append('\n');
				}
				in.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error reading file", "IO Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
			return sb.toString().replaceAll("\\n$", "");
		} else {
			return null;
		}
	}
	
	public static JSONObject readPrefs() {
		String jsonStr = loadFile(new File("prefs.json"));
		if (jsonStr == null) {
			return new JSONObject();
		} else {
			return new JSONObject(jsonStr);
		}
	}
	public static void writePrefs() {
		File prefsFile = new File("prefs.json");
		JSONObject jsonPrefs = readPrefs();
		
		jsonPrefs.put("lastWorkspace", Main.projectRoot.getAbsolutePath());
		
		//Write the file
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(prefsFile));
			writer.write(jsonPrefs.toString());
			writer.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(Main.getWindow(), "Error saving file", "IO Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}