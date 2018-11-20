package com.eshimoniak.conlangstudio.ui.labels;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * A padded JLabel
 * @author Evan Shimoniak
**/
@SuppressWarnings("serial")
public class PaddedLabel extends JLabel {
	public PaddedLabel(String text) {
		super(text);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}
	public PaddedLabel(String text, int align) {
		super(text, align);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}
}
