package com.eshimoniak.conlangstudio.ui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.eshimoniak.conlangstudio.ui.panels.editor.EditorWrapper;
import com.eshimoniak.conlangstudio.ui.panels.editor.FileEditor;
import com.eshimoniak.conlangstudio.ui.panels.editor.dict.DictionaryAdder;
import com.eshimoniak.conlangstudio.ui.panels.editor.dict.DictionaryEditor;
import com.eshimoniak.conlangstudio.ui.panels.editor.dict.DictionaryViewer;
import com.eshimoniak.conlangstudio.ui.panels.editor.markdown.MarkdownEditor;
import com.eshimoniak.conlangstudio.ui.panels.editor.markdown.RawEditor;

/**
 * A button that when clicked adds its text to the given editor
 * @author Evan Shimoniak
**/
@SuppressWarnings("serial")
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
				FileEditor editor = ((FileEditor) editorWrapper.getSelectedComponent());
				if (editor != null) {
					if (editor instanceof MarkdownEditor) {
						RawEditor re = ((MarkdownEditor) editor).getRawEditor();
						if (re != null) {
							String oldText = re.getText();
							re.setText(oldText.substring(0, re.getCaretPosition()) + text.replaceAll("◌", "") + oldText.substring(re.getCaretPosition()));
							re.focus();
						}
					} else if (editor instanceof DictionaryEditor) {
						if (editor.getSelectedComponent() instanceof DictionaryViewer) {
							DictionaryViewer dv = ((DictionaryEditor) editor).getDictionaryViewer();
							JTextField textField = (JTextField) dv.getTable().getEditorComponent();
							String oldText = textField.getText();
							textField.setText(oldText.substring(0, textField.getCaretPosition()) + text.replaceAll("◌", "") + oldText.substring(textField.getCaretPosition()));
							textField.grabFocus();
						} else if (editor.getSelectedComponent() instanceof DictionaryAdder) {
							DictionaryAdder da = (DictionaryAdder) editor.getSelectedComponent();
							JTextField textField = da.getFocusedTextField();
							String oldText = textField.getText();
							textField.setText(oldText.substring(0, textField.getCaretPosition()) + text.replaceAll("◌", "") + oldText.substring(textField.getCaretPosition()));
							textField.grabFocus();
						}
					}
				}
			}
		});
	}
}
