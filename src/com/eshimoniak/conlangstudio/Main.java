package com.eshimoniak.conlangstudio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import com.eshimoniak.conlangstudio.ui.MainWindow;

/**
 * The main coordinating class of the program
 * @author Evan Shimoniak
**/
public class Main {
	public static final String VERSION = "0.1.1";
	public static File projectRoot;
	public static File currFile = null;
	private static MainWindow window;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Unable to load system theme", "UI Error", JOptionPane.ERROR_MESSAGE);
		}
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Select a workspace");
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			projectRoot = jfc.getSelectedFile();
			try {
				MarkdownExtensions.init();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Unable to markdown extensions", "Interal Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			window = new MainWindow();
		}
	}
	
	public static void exit(int code) {
		System.exit(code);
	}
	
	public static void setCurrFile(File f) {
		if (!Util.isDirectory(f) && f != null) {
			currFile = f;
		}
	}
	
	public static MainWindow getWindow() {
		return window;
	}
	
	public static void saveCurrFile() {
		if (currFile == null) {
			JFileChooser jfc = new JFileChooser();
			jfc.setCurrentDirectory(Main.projectRoot);
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfc.addChoosableFileFilter(new FileFilter() {
				@Override
				public String getDescription() {
					return "Markdown files";
				}
				
				@Override
				public boolean accept(File f) {
					if (f.getName().endsWith(".md")) {
						return true;
					} else {
						return false;
					}
				}
			});
			jfc.addChoosableFileFilter(new FileFilter() {
				@Override
				public String getDescription() {
					return "Dictionary files";
				}
				
				@Override
				public boolean accept(File f) {
					if (f.getName().endsWith(".csv")) {
						return true;
					} else {
						return false;
					}
				}
			});
			if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				currFile = jfc.getSelectedFile();
			}
		}
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(currFile));
			writer.write(window.getCurrentEditor().getFileText());
			writer.close();
			window.getFileTreeViewer().refreshTree();
			window.getCurrentEditor().assertMatchesFile(true);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(window, "Error saving file", "IO Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}