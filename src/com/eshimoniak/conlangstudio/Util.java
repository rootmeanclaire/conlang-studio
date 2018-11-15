package com.eshimoniak.conlangstudio;

import java.io.File;

public class Util {
	public static boolean isDirectory(File f) {
		return f.isDirectory() && !f.isFile();
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
}