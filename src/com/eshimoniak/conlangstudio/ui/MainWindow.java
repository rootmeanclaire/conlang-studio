package com.eshimoniak.conlangstudio.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

import com.eshimoniak.conlangstudio.Main;
import com.eshimoniak.conlangstudio.ui.panels.Editor;
import com.eshimoniak.conlangstudio.ui.panels.EditorWrapper;
import com.eshimoniak.conlangstudio.ui.panels.FileTreeViewer;
import com.eshimoniak.conlangstudio.ui.panels.IpaKeyboard;

public class MainWindow extends JFrame {
	private JSplitPane mainWrapper, editKbWrapper;
	private FileTreeViewer ftv;
	private IpaKeyboard ipaKeyboard;
	private EditorWrapper editor;
	
	private JMenuBar mb;
	private JMenu mFile;
	private JMenuItem miSave;
	
	public MainWindow() {
		super("Conlang Studio");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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