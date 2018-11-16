package com.eshimoniak.conlangstudio.ui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.eshimoniak.conlangstudio.ui.panels.editor.Editor;
import com.eshimoniak.conlangstudio.ui.panels.editor.EditorWrapper;
import com.eshimoniak.conlangstudio.ui.panels.editor.RawEditor;

/**
 * A button that when clicked adds its text to the given editor
 * @author Evan Shimoniak
**/
public class KeyboardButton extends JButton {
	/**
	 * @param editorWrapper The editor to modify when the button is pressed
	 * @param text The text of the button
	**/
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
