package com.eshimoniak.conlangstudio.ui.panels.editor.dict;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DictionarySetup extends JFrame {
	private JPanel content;
	private List<DictionaryHeaderField> props;
	private JButton newProp;
	private JButton createDict;
	
	public DictionarySetup(File f) {
		super("Dictionary Creator");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		props = new ArrayList<>();
		props.add(new DictionaryHeaderField("Word", props));
		props.add(new DictionaryHeaderField("IPA", props));
		props.add(new DictionaryHeaderField("Translation", props));
		props.add(new DictionaryHeaderField("Notes", props));
		for (DictionaryHeaderField prop : props) {
			content.add(prop);
		}
		newProp = new JButton("Add property");
		newProp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				props.add(new DictionaryHeaderField("New Property", props));
				content.add(props.get(props.size() - 1), props.size() - 1);
			}
		});
		content.add(newProp);
		
		createDict = new JButton("Create Dictionary");
		createDict.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispatchEvent(new WindowEvent(DictionarySetup.this, WindowEvent.WINDOW_CLOSING));
			}
		});
		content.add(createDict);
		add(content);
		
		setSize(300, 500);
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public String[] getHeaders() {
		String[] headers = new String[props.size()];
		for (int i = 0; i < headers.length; i++) {
			headers[i] = props.get(i).getText();
		}
		return headers;
	}
}
