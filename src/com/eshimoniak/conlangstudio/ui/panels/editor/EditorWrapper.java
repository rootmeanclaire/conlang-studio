package com.eshimoniak.conlangstudio.ui.panels.editor;

import java.io.File;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.eshimoniak.conlangstudio.Main;
import com.eshimoniak.conlangstudio.ui.CloseableTab;
import com.eshimoniak.conlangstudio.ui.panels.editor.dict.DictionaryEditor;
import com.eshimoniak.conlangstudio.ui.panels.editor.markdown.MarkdownEditor;

/**
 * A tabbed holder for several Editors
 * @author Evan Shimoniak
**/
@SuppressWarnings("serial")
public class EditorWrapper extends JTabbedPane {
	public EditorWrapper() {
		addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JTabbedPane parent = (JTabbedPane) changeEvent.getSource();
				FileEditor selected = (FileEditor) parent.getSelectedComponent();
				
				if (selected != null) {
					Main.setCurrFile(selected.getFile());
				}
			}
		});
	}
	
	public void addTab(File f) {
		FileEditor fe = null;
		
		if (f != null) {
			if (f.getName().endsWith(".md")) {
				fe = new MarkdownEditor(f);
			} else if (f.getName().endsWith(".csv")) {
				fe = new DictionaryEditor(f);
			} else {
				return;
			}
		}
		
		add(fe);
		
		int ti = getTabCount() - 1;
		
		if (f != null) {
			setTabComponentAt(ti, new CloseableTab(f.getName(), this, fe));
		} else {
			setTabComponentAt(ti, new CloseableTab("New file", this, fe));
		}
		setSelectedIndex(ti);
	}
	
	public boolean hasUnsavedFiles() {
		for (int i = 0; i < getTabCount(); i++) {
			if (!((FileEditor) getComponentAt(i)).isSaved()) {
				return true;
			}
		}
		
		return false;
	}
}
