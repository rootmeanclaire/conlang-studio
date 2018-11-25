package com.eshimoniak.conlangstudio.ui.panels.editor.dict;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.eshimoniak.conlangstudio.Main;

@SuppressWarnings("serial")
public class DictionaryAdder extends JPanel {
	private List<DictionaryFieldAdder> fields = new ArrayList<>();
	private JPanel content;
	private JButton add;
	private JTextField focusedTextField = null;
	
	public DictionaryAdder(String[] headers, DictionaryEditor de) {
		content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		for (String header : headers) {
			DictionaryFieldAdder dfa = new DictionaryFieldAdder(header);
			dfa.getTextField().addFocusListener(new FocusListener() {
				@Override
				public void focusLost(FocusEvent e) {}
				
				@Override
				public void focusGained(FocusEvent e) {
					focusedTextField = dfa.getTextField();
				}
			});
			fields.add(dfa);
			content.add(dfa);
		}
		add = new JButton("Add Entry");
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] entry = getEntry();
				if (!de.hasEntry(entry[0])) {
					de.addEntry(entry);
					for (DictionaryFieldAdder field : fields) {
						field.getTextField().setText("");
					}
				} else {
					JOptionPane.showMessageDialog(Main.getWindow(), "An entry with that key already exists", "Dictionary Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		content.add(add);
		add(new JScrollPane(content));
	}
	
	public String[] getEntry() {
		String[] entry = new String[fields.size()];
		
		for (int i = 0; i < entry.length; i++) {
			entry[i] = fields.get(i).getValue();
		}
		
		
		return entry;
	}
	
	public JTextField getFocusedTextField() {
		return focusedTextField;
	}
}
