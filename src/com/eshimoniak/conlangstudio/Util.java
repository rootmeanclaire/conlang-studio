package com.eshimoniak.conlangstudio;

import java.io.File;

public class Util {
	public static boolean isDirectory(File f) {
		return f.isDirectory() && !f.isFile();
	}
}