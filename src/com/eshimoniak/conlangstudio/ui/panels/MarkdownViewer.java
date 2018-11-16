package com.eshimoniak.conlangstudio.ui.panels;

import java.awt.Font;

import javax.swing.JTextArea;

/**
 * A viewer of standard markdown
 * @author Evan Shimoniak
**/
public class MarkdownViewer extends JTextArea {
	public MarkdownViewer() {
		setEditable(false);
		setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
	}
}