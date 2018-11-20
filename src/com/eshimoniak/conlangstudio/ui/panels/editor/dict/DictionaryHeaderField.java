package com.eshimoniak.conlangstudio.ui.panels.editor.dict;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DictionaryHeaderField extends JPanel {
	private JTextField nameField;
	private JComboBox<String> dataType;
	private JButton buttonDelete;
	
	public DictionaryHeaderField(String name, List<DictionaryHeaderField> holder) {
		nameField = new JTextField(name);
		nameField.setPreferredSize(new Dimension(250, 30));
		add(nameField);
		dataType = new JComboBox<>(new String[] {"Plain Text"});
		add(dataType);
		buttonDelete = new JButton("X");
		buttonDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Container parent = getParent();
				parent.remove(DictionaryHeaderField.this);
				parent.validate();
				parent.repaint();
				holder.remove(DictionaryHeaderField.this);
			}
		});
		add(buttonDelete);
	}
	
	public String getText() {
		return nameField.getText();
	}
}