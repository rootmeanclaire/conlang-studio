package com.eshimoniak.conlangstudio.ui.panels.editor.markdown;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.eshimoniak.conlangstudio.ui.panels.editor.FileEditor;

/**
 * A simple monospaced text editor
 * @author Evan Shimoniak
**/
@SuppressWarnings("serial")
public class RawEditor extends JPanel {
	private JScrollPane scroller;
	private HintingTextArea textArea;
	
	public RawEditor() {
		super(new BorderLayout());
		textArea = new HintingTextArea();
		textArea.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				((FileEditor) getParent()).assertMatchesFile(false);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				((FileEditor) getParent()).assertMatchesFile(false);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				((FileEditor) getParent()).assertMatchesFile(false);
			}
		});
		scroller = new JScrollPane(textArea);
		add(scroller, BorderLayout.CENTER);
		
	}
	
	public void assertMatchesFile(boolean val) {
		((FileEditor) getParent()).assertMatchesFile(val);
	}
	public void setText(String str) {
		textArea.setText(str);
	}
	public String getText() {
		return textArea.getText();
	}
	public int getCaretPosition() {
		return textArea.getCaretPosition();
	}
	public void loadFile(String fileContents) {
		((FileEditor) getParent()).assertMatchesFile(true);
		textArea.setText(fileContents);
	}
	public void focus() {
		textArea.requestFocus();
	}
}
