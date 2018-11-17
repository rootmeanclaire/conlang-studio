package com.eshimoniak.conlangstudio.ui.panels.editor;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * A simple monospaced text editor
 * @author Evan Shimoniak
**/
public class RawEditor extends JPanel {
	private JScrollPane scroller;
	private HintingTextArea textArea;
	private boolean matchesFile = true;
	
	public RawEditor() {
		super(new BorderLayout());
		textArea = new HintingTextArea();
		textArea.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				matchesFile = false;
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				matchesFile = false;
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				matchesFile = false;
			}
		});
		scroller = new JScrollPane(textArea);
		add(scroller, BorderLayout.CENTER);
		
	}
	
	public void assertMatchesFile(boolean val) {
		matchesFile = val;
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
	public boolean matchesFile() {
		return matchesFile;
	}
	public void matchesFile(boolean matchesFile) {
		this.matchesFile = matchesFile;
	}
	public void loadFile(String fileContents) {
		matchesFile = true;
		textArea.setText(fileContents);
	}
	public void focus() {
		textArea.requestFocus();
	}
}
