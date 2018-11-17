package com.eshimoniak.conlangstudio.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

import com.eshimoniak.conlangstudio.Main;
import com.eshimoniak.conlangstudio.ui.panels.FileTreeViewer;
import com.eshimoniak.conlangstudio.ui.panels.IpaKeyboard;
import com.eshimoniak.conlangstudio.ui.panels.editor.Editor;
import com.eshimoniak.conlangstudio.ui.panels.editor.EditorWrapper;

/**
 * The main window of the program
 * @author Evan Shimoniak
**/
public class MainWindow extends JFrame {
	private JSplitPane mainWrapper, editKbWrapper;
	private FileTreeViewer ftv;
	private IpaKeyboard ipaKeyboard;
	private EditorWrapper editor;
	
	private JMenuBar mb;
	private JMenu mFile;
	private JMenuItem miSave;
	private JMenu mHelp;
	private JMenuItem miAbout;
	
	public MainWindow() {
		super("Conlang Studio");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				if (!editor.hasUnsavedFiles() || JOptionPane.showConfirmDialog(MainWindow.this, "Are you sure you want to close; you have unsaved files") == JOptionPane.YES_OPTION) {
					Main.exit(0);
				}
			}
		});
		
		ftv = new FileTreeViewer();
		editor = new EditorWrapper();
		ipaKeyboard = new IpaKeyboard(editor);
		
		editKbWrapper = new JSplitPane(JSplitPane.VERTICAL_SPLIT, editor, ipaKeyboard);
		editKbWrapper.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK), "save");
		editKbWrapper.getActionMap().put("save", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.saveCurrFile();
			}
		});
		mainWrapper = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ftv, editKbWrapper);
		add(mainWrapper);
		
		pack();
		//Maximize window
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		setVisible(true);
		editKbWrapper.setResizeWeight(0.85);
		mainWrapper.setResizeWeight(0.2);
		
		mb = new JMenuBar();
		
		mFile = new JMenu("File");
		miSave = new JMenuItem("Save");
		miSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.saveCurrFile();
			}
		});
		mFile.add(miSave);
		mb.add(mFile);
		
		mHelp = new JMenu("Help");
		miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainWindow.this, "Version " + Main.VERSION, "About Conlang Studio", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mHelp.add(miAbout);
		mb.add(mHelp);
		
		setJMenuBar(mb);
		validate();
		repaint();
	}
	
	public EditorWrapper getEditorWrapper() {
		return editor;
	}
	public Editor getCurrentEditor() {
		return (Editor) editor.getSelectedComponent();
	}
	public FileTreeViewer getFileTreeViewer() {
		return ftv;
	}
}