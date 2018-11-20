package com.eshimoniak.conlangstudio.ui.panels.editor.dict;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DictionaryFieldAdder extends JPanel {
	private JLabel nameLabel;
	private JTextField input;
	
	public DictionaryFieldAdder(String label) {
		nameLabel = new JLabel(label);
		add(nameLabel);
		input = new JTextField();
		input.setPreferredSize(new Dimension(250, 25));
		add(input);
	}
	
	public String getValue() {
		return input.getText();
	}
	
	public void setValue(String str) {
		input.setText(str);
	}
	
	public JTextField getTextField() {
		return input;
	}
}
