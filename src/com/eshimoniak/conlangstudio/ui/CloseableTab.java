package com.eshimoniak.conlangstudio.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.eshimoniak.conlangstudio.ui.panels.editor.FileEditor;

/**
 * A tab with a close button
 * @author Evan Shimoniak
**/
@SuppressWarnings("serial")
public class CloseableTab extends JPanel {
	private JLabel label;
	private JButton closeButton;
	
	public CloseableTab(String title, JTabbedPane parent, FileEditor fe) {
		label = new JLabel(title);
		add(label);
		closeButton = new JButton("X");
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fe.isSaved() || JOptionPane.showConfirmDialog(parent, "Are you sure you want to close without saving \"" + title + "\"?") == JOptionPane.YES_OPTION) {
					parent.remove(parent.indexOfTabComponent(CloseableTab.this));
				}
			}
		});
		add(closeButton);
	}
}