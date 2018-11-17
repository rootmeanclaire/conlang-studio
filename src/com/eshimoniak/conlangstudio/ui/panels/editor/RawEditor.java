package com.eshimoniak.conlangstudio.ui.panels.editor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 * A simple monospaced text editor
 * @author Evan Shimoniak
**/
public class RawEditor extends JPanel {
	private JScrollPane scroller;
	private JTextArea textArea;
	private boolean matchesFile = true;
	private UndoManager undoManager;
	
	public RawEditor() {
		super(new BorderLayout());
		textArea = new JTextArea();
		textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
		textArea.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				matchesFile = false;
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				matchesFile = false;
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				matchesFile = false;
			}
		});
		scroller = new JScrollPane(textArea);
		add(scroller, BorderLayout.CENTER);
		
		undoManager = new UndoManager();
		Document doc = textArea.getDocument();
		doc.addUndoableEditListener(new UndoableEditListener() {
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				undoManager.addEdit(e.getEdit());
			}
		});
		
		InputMap im = textArea.getInputMap(JComponent.WHEN_FOCUSED);
		ActionMap am = textArea.getActionMap();
		
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Undo");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Redo");
		
		am.put("Undo", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (undoManager.canUndo()) {
						undoManager.undo();
					}
				} catch (CannotUndoException exp) {
					exp.printStackTrace();
				}
			}
		});
		am.put("Redo", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (undoManager.canRedo()) {
						undoManager.redo();
					}
				} catch (CannotUndoException exp) {
					exp.printStackTrace();
				}
			}
		});
	}
	
	public void setText(String str) {
		textArea.setText(str);
		matchesFile = false;
	}
	public String getText() {
		return textArea.getText();
	}
	public int getCaretPosition() {
		return textArea.getCaretPosition();
	}
	public boolean matchesFile() {
		return matchesFile;
	}
	public void matchesFile(boolean matchesFile) {
		this.matchesFile = matchesFile;
	}
	public void loadFile(String fileContents) {
		matchesFile = true;
		textArea.setText(fileContents);
	}
}
