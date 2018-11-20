package com.eshimoniak.conlangstudio.ui.panels.editor;

import java.io.File;

import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public abstract class FileEditor extends JTabbedPane {
	private File f;
	protected boolean matchesFile;
	
	public FileEditor(File f) {
		this.f = f;
		matchesFile = true;
	}
	
	public abstract void loadFile(String data);
	public abstract String getFileText();
	
	public File getFile() {
		return f;
	}
	
	public boolean isSaved() {
		return matchesFile;
	}
	public void assertMatchesFile(boolean val) {
		matchesFile = val;
	}
}
