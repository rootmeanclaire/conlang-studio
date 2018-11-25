package com.eshimoniak.conlangstudio.ui.popups;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import com.eshimoniak.conlangstudio.Main;
import com.eshimoniak.conlangstudio.Util;
import com.eshimoniak.conlangstudio.ui.CloseableTab;
import com.eshimoniak.conlangstudio.ui.panels.FileTreeViewer;
import com.eshimoniak.conlangstudio.ui.panels.editor.EditorWrapper;
import com.eshimoniak.conlangstudio.ui.panels.editor.FileEditor;
import com.eshimoniak.conlangstudio.ui.panels.editor.dict.DictionaryEditor;
import com.eshimoniak.conlangstudio.ui.panels.editor.dict.DictionarySetup;
import com.eshimoniak.conlangstudio.ui.panels.editor.markdown.MarkdownEditor;

/**
 * A right click menu for a FileTreeViewer
 * @author Evan Shimoniak
**/
@SuppressWarnings("serial")
public class FileTreePopup extends JPopupMenu {
	private JMenuItem miNewFile = null;
	private JMenuItem miNewDir = null;
	private JMenuItem miOpen = null;
	private JMenuItem miDelete = null;
	
	public FileTreePopup(FileTreeViewer ftv, File clickedFile){
		if (Util.isDirectory(clickedFile)) {
			miNewFile = new JMenuItem("New File...");
			miNewFile.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String fileType = (String) JOptionPane.showInputDialog(
							null,
							"Choose a file type",
							"Choose a file type",
							JOptionPane.QUESTION_MESSAGE,
							null,
							new String[] {"Markdown", "Dictionary"},
							"Markdown"
					);
					String filename = JOptionPane.showInputDialog(
							null,
							"Enter a file name",
							"New File...",
							JOptionPane.PLAIN_MESSAGE);
					if (filename != null) {
						File newFile;
						if (fileType.equals("Markdown")) {
							if (filename.endsWith(".md")) {
								newFile = new File(clickedFile, filename);
							} else {
								newFile = new File(clickedFile, filename + ".md");
							}
							if (newFile != null) {
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
										EditorWrapper ew = Main.getWindow().getEditorWrapper();
										MarkdownEditor editor = new MarkdownEditor(newFile);
										ew.addTab(newFile.getName(), editor);
										ew.setSelectedIndex(ew.getTabCount() - 1);
										ew.setTabComponentAt(ew.getTabCount(), new CloseableTab(newFile.getName(), ew, (FileEditor) ew.getSelectedComponent()));
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
						} else if (fileType.equals("Dictionary")) {
							if (filename.endsWith(".csv")) {
								newFile = new File(clickedFile, filename);
							} else {
								newFile = new File(clickedFile, filename + ".csv");
							}
							if (newFile != null) {
								if (newFile.exists()) {
									JOptionPane.showMessageDialog(
											null,
											"A file with that name already exists",
											"File System Error",
											JOptionPane.ERROR_MESSAGE);
								} else {
									try {
										newFile.createNewFile();
										DictionarySetup winSetup = new DictionarySetup(newFile);
										winSetup.addWindowListener(new WindowAdapter() {
											public void windowClosing(WindowEvent e) {
												if (winSetup.shouldCreate()) {
													FileEditor editor = new DictionaryEditor(newFile, winSetup.getHeaders());
													EditorWrapper ew = Main.getWindow().getEditorWrapper();
													ew.addTab(newFile.getName(), editor);
													ew.setSelectedIndex(ew.getTabCount() - 1);
													ew.setTabComponentAt(ew.getTabCount() - 1, new CloseableTab(newFile.getName(), ew, (FileEditor) ew.getSelectedComponent()));
												}
											}
										});
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

		miDelete = new JMenuItem("Delete");
		miDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this file/folder?") == JOptionPane.YES_NO_OPTION) {
					clickedFile.delete();
					ftv.refreshTree();
				}
			}
		});
		add(miDelete);
    }
}
