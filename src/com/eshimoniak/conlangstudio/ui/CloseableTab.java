package com.eshimoniak.conlangstudio.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * A tab with a close button
 * @author Evan Shimoniak
**/
public class CloseableTab extends JPanel {
	private JLabel label;
	private JButton closeButton;
	
	public CloseableTab(String title, JTabbedPane parent) {
		label = new JLabel(title);
		add(label);
		closeButton = new JButton("X");
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.remove(parent.indexOfTabComponent(CloseableTab.this));
			}
		});
		add(closeButton);
	}
}