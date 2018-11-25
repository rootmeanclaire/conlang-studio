package com.eshimoniak.conlangstudio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import org.json.JSONObject;

import com.eshimoniak.conlangstudio.ui.MainWindow;

/**
 * The main coordinating class of the program
 * @author Evan Shimoniak
**/
public class Main {
	public static final String VERSION = "0.2.0";
	public static File projectRoot;
	public static File currFile = null;
	private static MainWindow window;
	private static JSONObject prefs;
	
	public static void main(String[] args) {
		prefs = Util.readPrefs();
		//Make UI appear native
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Unable to load system theme", "UI Error", JOptionPane.ERROR_MESSAGE);
		}
		if (prefs == null || !prefs.has("lastWorkspace")) {
			//Select workspace
			JFileChooser jfc = new JFileChooser();
			jfc.setDialogTitle("Select a workspace");
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = jfc.showOpenDialog(null);
			//Exit program if no workspace chosen
			if (returnVal != JFileChooser.APPROVE_OPTION) {
				System.exit(0);
			} else {
				projectRoot = jfc.getSelectedFile();
			}
		} else {
			projectRoot = new File(prefs.getString("lastWorkspace"));
		}
		try {
			MarkdownExtensions.init();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to load markdown extensions", "Interal Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		window = new MainWindow();
	}
	
	/**
	 * Wrapper for System.exit() in case more functionality is needed later
	 * @param code Parameter for System.exit()
	**/
	public static void exit(int code) {
		Util.writePrefs();
		System.exit(code);
	}
	
	/**
	 * Set file being currently edited for global manipulation
	 * @param f File being currently edited
	**/
	public static void setCurrFile(File f) {
		//Make sure file is valid before assignment
		if (!Util.isDirectory(f) && f != null) {
			currFile = f;
		}
	}
	
	public static MainWindow getWindow() {
		return window;
	}
	
	/**
	 * Save the currently edited file
	**/
	public static void saveCurrFile() {
		//If no disk file is currently being edited
		//(i.e. current file is new and unsaved)
		//Then ask the user to choose a save destination
		if (currFile == null) {
			JFileChooser jfc = new JFileChooser();
			jfc.setCurrentDirectory(Main.projectRoot);
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			//Note: currFile will only be null when editing
			//an unsaved markdown file
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
			if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				currFile = jfc.getSelectedFile();
			}
		}
		
		//Write the file
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(currFile));
			writer.write(window.getCurrentEditor().getFileText());
			writer.close();
			//Refresh file tree viewer
			window.getFileTreeViewer().refreshTree();
			//Tell the editor that the file in the editor matches the version on the disk
			window.getCurrentEditor().assertMatchesFile(true);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(window, "Error saving file", "IO Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}