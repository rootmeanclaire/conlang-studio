package com.eshimoniak.conlangstudio.ui.popups;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

import com.eshimoniak.conlangstudio.ui.panels.editor.dict.DictionaryEditor;

@SuppressWarnings("serial")
public class DictionaryTablePopup extends JPopupMenu {
	private JMenuItem miDelete;
	
	public DictionaryTablePopup(DictionaryEditor de, int row) {
		miDelete = new JMenuItem("Delete Entry");
		miDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this file/folder?") == JOptionPane.YES_NO_OPTION) {
					JTable table = de.getDictionaryViewer().getTable();
					de.removeEntry(row);
				}
			}
		});
		add(miDelete);
	}
}
