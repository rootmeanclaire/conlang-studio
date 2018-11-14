package com.eshimoniak.conlangstudio.ui.panels;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RawEditor extends JPanel {
	private JScrollPane scroller;
	private JTextArea textArea;
	private boolean matchesFile = true;
	
	public RawEditor() {
		super(new BorderLayout());
		textArea = new JTextArea();
		textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
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
	
	public void setText(String str) {
		textArea.setText(str);
		matchesFile = false;
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
}
