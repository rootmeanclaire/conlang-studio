package com.eshimoniak.conlangstudio.ui.panels.editor.dict;

import java.io.File;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.eshimoniak.conlangstudio.Main;
import com.eshimoniak.conlangstudio.dict.Dictionary;
import com.eshimoniak.conlangstudio.ui.panels.editor.FileEditor;

/**
 * @author Evan Shimoniak
**/
@SuppressWarnings("serial")
public class DictionaryEditor extends FileEditor {
	private DictionaryViewer dv;
	private DictionaryAdder da;
	private Dictionary dict;
	
	public DictionaryEditor(File f, String... headers) {
		super(f);
		dict = new Dictionary(headers);
		init(f);
	}
	public DictionaryEditor(File f) {
		super(f);
		dict = new Dictionary(f);
		init(f);
	}
	private void init(File f) {
		setTabPlacement(BOTTOM);
		dv = new DictionaryViewer(dict);
		addTab("Dictionary Viewer", dv);
		da = new DictionaryAdder(dict.getHeaders(), this);
		addTab("New Entry", da);
		Main.setCurrFile(f);
	}
	
	@Override
	public void loadFile(String data) {
		dv.setData(data);
		dict = dv.getData();
	}
	
	@Override
	public String getFileText() {
		return dict.toFileString();
	}
	
	public DictionaryViewer getDictionaryViewer() {
		return dv;
	}
	
	public void addEntry(String[] entry) {
		dict.addEntry(entry);
		dv.addEntry(entry);
	}
	public void removeEntry(int row) {
		DefaultTableModel dtm = dv.getDTModel();
		dtm.removeRow(row);
		dict = dv.getData();
		
		dv.validate();
		dv.repaint();
	}
	
	public DictionaryAdder getDictionaryAdder() {
		return da;
	}
}
