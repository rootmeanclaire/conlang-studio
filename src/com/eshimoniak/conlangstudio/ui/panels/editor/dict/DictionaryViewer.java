package com.eshimoniak.conlangstudio.ui.panels.editor.dict;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.eshimoniak.conlangstudio.dict.Dictionary;
import com.eshimoniak.conlangstudio.ui.popups.DictionaryTablePopup;

@SuppressWarnings("serial")
public class DictionaryViewer extends JPanel {
	private DefaultTableModel dtm;
	private JTable table;
	
	public DictionaryViewer(Dictionary dict) {
		table = new JTable();
		dtm = new DefaultTableModel(dict.getHeaders(), dict.numEntries());
		table.setModel(dtm);
		table.setRowHeight(25);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					new DictionaryTablePopup((DictionaryEditor) getParent(), e.getY() / 25).show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		setData(dict.toFileString());
		add(new JScrollPane(table));
	}
	
	public JTable getTable() {
		return table;
	}
	
	public int getSelectedRow() {
		return table.getSelectedRow();
	}
	
	public int getSelectedColumn() {
		return table.getSelectedColumn();
	}
	
	public void addEntry(String[] entry) {
		dtm.addRow(entry);
		
		validate();
		repaint();
	}
	public void setEntry(String[] entry, int row) {
		for (int i = 0; i < entry.length; i++) {
			dtm.setValueAt(entry[i], row, i);
		}
		
		validate();
		repaint();
	}
	
	public void setData(String str) {
		String[] lines = str.split("\n");
		dtm.setRowCount(0);
		
		dtm.setColumnIdentifiers(lines[0].split("(?<=[^\\\\](\\\\\\\\){0,99})\\,"));
		
		for (int r = 1; r < lines.length; r++) {
			addEntry(lines[r].split("(?<=[^\\\\](\\\\\\\\){0,99})\\,"));
		}
		
		validate();
		repaint();
	}
	
	public Dictionary getData() {
		Dictionary dict;
		String[] headers = new String[dtm.getColumnCount()];
		
		for (int i = 0; i < headers.length; i++) {
			headers[i] = dtm.getColumnName(i);
		}
		
		dict = new Dictionary(headers);
		
		for (int r = 0; r < dtm.getRowCount(); r++) {
			String[] entry = new String[headers.length];
			for (int c = 0; c < headers.length; c++) {
				entry[c] = (String) dtm.getValueAt(r, c);
			}
			dict.addEntry(entry);
		}
		
		
		return dict;
	}
	
	public DefaultTableModel getDTModel() {
		return dtm;
	}
}
