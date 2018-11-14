package com.eshimoniak.conlangstudio.ui.panels;

import java.io.File;

import javax.swing.JTabbedPane;

import com.eshimoniak.conlangstudio.ui.CloseableTab;

public class EditorWrapper extends JTabbedPane {
	public void addTab(File f) {
		add(new Editor());
		setTabComponentAt(getTabCount() - 1, new CloseableTab(f.getName(), this));
	}
}
