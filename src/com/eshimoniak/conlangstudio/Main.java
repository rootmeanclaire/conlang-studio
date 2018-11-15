package com.eshimoniak.conlangstudio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import com.eshimoniak.conlangstudio.ui.MainWindow;

public class Main {
	public static final String VERSION = "0.0.0";
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
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			projectRoot = jfc.getSelectedFile();
			try {
				MarkdownExtensions.init();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Unable to markdown extensions", "Interal ERror", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			window = new MainWindow();
		}
	}
	
	public static void setCurrFile(File f) {
		if (!Util.isDirectory(f)) {
			currFile = f;
			StringBuilder sb = new StringBuilder();
			String ln;
			
			try {
				FileInputStream is = new FileInputStream(currFile);
				BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				while ((ln = in.readLine()) != null) {
					sb.append(ln);
					sb.append('\n');
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(window, "Error reading file", "IO Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
			window.getEditorWrapper().addTab(f);
			window.getCurrentEditor().getRawEditor().loadFile(sb.toString().replaceAll("$\\n", ""));
		}
	}
	
	public static void saveCurrFile() {
		if (currFile == null) {
			JFileChooser jfc = new JFileChooser();
			jfc.setCurrentDirectory(Main.projectRoot);
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfc.setFileFilter(new FileFilter() {
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
			if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				currFile = jfc.getSelectedFile();
			}
			if (!currFile.getName().endsWith(".md")) {
				currFile = new File(currFile.getParentFile().getPath(), currFile.getName() + ".md");
			}
		}
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(currFile));
			writer.write(window.getCurrentEditor().getRawEditor().getText());
			writer.close();
			window.getFileTreeViewer().refreshTree();
			window.getCurrentEditor().getRawEditor().matchesFile(true);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(window, "Error saving file", "IO Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}