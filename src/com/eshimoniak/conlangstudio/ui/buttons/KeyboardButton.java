package com.eshimoniak.conlangstudio.ui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.eshimoniak.conlangstudio.ui.panels.Editor;
import com.eshimoniak.conlangstudio.ui.panels.EditorWrapper;
import com.eshimoniak.conlangstudio.ui.panels.RawEditor;

public class KeyboardButton extends JButton {
	public KeyboardButton(EditorWrapper editorWrapper, String text) {
		super(text);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RawEditor editor = ((Editor) editorWrapper.getSelectedComponent()).getRawEditor();
				if (editor != null) {
					String oldText = editor.getText();
					editor.setText(oldText.substring(0, editor.getCaretPosition()) + text.replaceAll("◌", "") + oldText.substring(editor.getCaretPosition()));
				}
			}
		});
	}
}
