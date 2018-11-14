package com.eshimoniak.conlangstudio.ui.labels;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class TableLabel extends PaddedLabel {
	public TableLabel(String text) {
		super(text, JLabel.CENTER);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}
}
