package com.eshimoniak.conlangstudio.ui.panels;

import java.awt.BorderLayout;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * An HTML rendering pane
 * @author Evan Shimoniak
**/
public class HtmlViewer extends JPanel {
	private JEditorPane jep;
	private JScrollPane scroller;
	
	public HtmlViewer() {
		this("");
	}
	public HtmlViewer(String doc) {
		super(new BorderLayout());
		jep = new JEditorPane("text/html", doc);
		jep.setEditable(false);
		scroller = new JScrollPane(jep);
		add(scroller, BorderLayout.CENTER);
	}
	public void setText(String str) {
		jep.setText(str);
	}
}