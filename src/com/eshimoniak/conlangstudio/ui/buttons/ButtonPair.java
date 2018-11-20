package com.eshimoniak.conlangstudio.ui.buttons;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.eshimoniak.conlangstudio.ui.panels.editor.EditorWrapper;

/**
 * A "pair" of two or more related buttons
 * @author Evan Shimoniak
**/
@SuppressWarnings("serial")
public class ButtonPair extends JPanel {
	/**
	 * @param editor The editor to modify when one of the buttons is pushed
	 * @param buttonTexts Texts of the buttons in the "pair", listed left to right
	**/
	public ButtonPair(EditorWrapper editor, String[] buttonTexts) {
		setLayout(new GridLayout(1, buttonTexts.length));
		for (int i = 0; i < buttonTexts.length; i++) {
			if (buttonTexts[i] == null) {
				JButton none = new JButton("a");
				none.setVisible(false);
				add(none);
			} else {
				add(new KeyboardButton(editor, buttonTexts[i]));
			}
		}
	}
	/**
	 * @param editor The editor to modify when one of the buttons is pushed
	 * @param buttonText1 Text of the left button in the pair
	 * @param buttonText2 Text of the right button in the pair
	**/
	public ButtonPair(EditorWrapper editor, String buttonText1, String buttonText2) {
		this(editor, new String[] {buttonText1, buttonText2});
	}
}
