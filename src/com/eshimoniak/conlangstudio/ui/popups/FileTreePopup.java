package com.eshimoniak.conlangstudio.ui.popups;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import com.eshimoniak.conlangstudio.Main;
import com.eshimoniak.conlangstudio.Util;
import com.eshimoniak.conlangstudio.ui.panels.FileTreeViewer;

public class FileTreePopup extends JPopupMenu {
	private JMenuItem miNewFile = null;
	private JMenuItem miNewDir = null;
	private JMenuItem miOpen = null;
	
	public FileTreePopup(FileTreeViewer ftv, File clickedFile){
		if (Util.isDirectory(clickedFile)) {
			miNewFile = new JMenuItem("New File...");
			miNewFile.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String filename = JOptionPane.showInputDialog(
							null,
							"Enter a file name",
							"New File...",
							JOptionPane.PLAIN_MESSAGE);
					File newFile = new File(clickedFile, filename);
					if (newFile.exists()) {
						JOptionPane.showMessageDialog(
								null,
								"A file with that name already exists",
								"File System Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							newFile.createNewFile();
							ftv.refreshTree();
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(
									null,
									"Unable to create file",
									"File System Error",
									JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					}
				}
			});
			add(miNewFile);
			miNewDir = new JMenuItem("New Folder...");
			miNewDir.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String filename = JOptionPane.showInputDialog(
							null,
							"Enter a folder name",
							"New Folder...",
							JOptionPane.PLAIN_MESSAGE);
					File newFile = new File(clickedFile, filename);
					if (newFile.exists()) {
						JOptionPane.showMessageDialog(
								null,
								"A folder with that name already exists",
								"File System Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						newFile.mkdir();
						ftv.refreshTree();
					}
				}
			});
			add(miNewDir);
		} else {
			miOpen = new JMenuItem("Open");
			miOpen.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Main.setCurrFile(clickedFile);
				}
			});
			add(miOpen);
		}
    }
}
