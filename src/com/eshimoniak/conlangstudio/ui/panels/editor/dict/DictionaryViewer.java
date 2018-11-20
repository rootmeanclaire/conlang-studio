package com.eshimoniak.conlangstudio.ui.panels.editor.dict;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.eshimoniak.conlangstudio.dict.Dictionary;

@SuppressWarnings("serial")
public class DictionaryViewer extends JTable {
	private DefaultTableModel dtm;
	
	public DictionaryViewer(Dictionary dict) {
		dtm = new DefaultTableModel(dict.getHeaders(), dict.numEntries());
		setModel(dtm);
		setRowHeight(25);
		setData(dict.toFileString());
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
