package com.eshimoniak.conlangstudio.ui.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import com.eshimoniak.conlangstudio.ui.buttons.ButtonPair;
import com.eshimoniak.conlangstudio.ui.buttons.KeyboardButton;
import com.eshimoniak.conlangstudio.ui.labels.PaddedLabel;
import com.eshimoniak.conlangstudio.ui.labels.TableLabel;
import com.eshimoniak.conlangstudio.ui.panels.editor.EditorWrapper;

/**
 * A sheet of IPA symbol pasting buttons
 * @author Evan Shimoniak
**/
public class IpaKeyboard extends JTabbedPane {
	private JPanel kbVowels, kbPcons, kbNPcons, kbTones, kbDiacritics;
	private JScrollPane scrVowels, scrPcons, scrNPcons, scrTones, scrDiacritics;
	
	public IpaKeyboard(EditorWrapper editorWrapper) {
		kbVowels = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		{
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridwidth = 1;
			gbc.gridx = 1;
			gbc.gridy = 0;
			kbVowels.add(new TableLabel("Front"), gbc);
			gbc.gridx++;
			kbVowels.add(new TableLabel("Central"), gbc);
			gbc.gridx++;
			kbVowels.add(new TableLabel("Back"), gbc);
		}
		{
			gbc.gridx = 0;
			gbc.gridy = 1;
			kbVowels.add(new TableLabel("Close"), gbc);
			gbc.gridy++;
			kbVowels.add(new TableLabel("Near-Close"), gbc);
			gbc.gridy++;
			kbVowels.add(new TableLabel("CLose-Mid"), gbc);
			gbc.gridy++;
			kbVowels.add(new TableLabel("Mid"), gbc);
			gbc.gridy++;
			kbVowels.add(new TableLabel("Open-Mid"), gbc);
			gbc.gridy++;
			kbVowels.add(new TableLabel("Near-Open"), gbc);
			gbc.gridy++;
			kbVowels.add(new TableLabel("Open"), gbc);
		}
		{
			gbc.gridx = 1;
			gbc.gridy = 1;
			kbVowels.add(new ButtonPair(editorWrapper, "i", "y"), gbc);
			gbc.gridy++;
			kbVowels.add(new ButtonPair(editorWrapper, "ɪ", "ʏ"), gbc);
			gbc.gridy++;
			kbVowels.add(new ButtonPair(editorWrapper, "e", "ø"), gbc);
			gbc.gridy += 2;
			kbVowels.add(new ButtonPair(editorWrapper, "ɛ", "œ"), gbc);
			gbc.gridy++;
			kbVowels.add(new ButtonPair(editorWrapper, "æ", null), gbc);
			gbc.gridy++;
			kbVowels.add(new ButtonPair(editorWrapper, "a", "ɶ"), gbc);
		}
		{
			gbc.gridx = 2;
			gbc.gridy = 1;
			kbVowels.add(new ButtonPair(editorWrapper, "ɨ", "ʉ"), gbc);
			gbc.gridy += 2;
			kbVowels.add(new ButtonPair(editorWrapper, "ɘ", "ɵ"), gbc);
			gbc.gridy++;
			kbVowels.add(new KeyboardButton(editorWrapper, "ə"), gbc);
			gbc.gridy++;
			kbVowels.add(new ButtonPair(editorWrapper, "ɜ", "ɞ"), gbc);
			gbc.gridy++;
			kbVowels.add(new KeyboardButton(editorWrapper, "ɐ"), gbc);
		}
		{
			gbc.gridx = 3;
			gbc.gridy = 1;
			kbVowels.add(new ButtonPair(editorWrapper, "ɯ", "u"), gbc);
			gbc.gridy++;
			kbVowels.add(new ButtonPair(editorWrapper, null, "ʊ"), gbc);
			gbc.gridy++;
			kbVowels.add(new ButtonPair(editorWrapper, "ɤ", "o"), gbc);
			gbc.gridy += 2;
			kbVowels.add(new ButtonPair(editorWrapper, "ʌ", "ɔ"), gbc);
			gbc.gridy += 2;
			kbVowels.add(new ButtonPair(editorWrapper, "ɑ", "ɒ"), gbc);
		}
		scrVowels = new JScrollPane(kbVowels);
		addTab("Vowels", scrVowels);
		kbPcons = new JPanel(new GridBagLayout());
		{
			gbc.gridwidth = 1;
			gbc.gridx = 1;
			gbc.gridy = 0;
			kbPcons.add(new TableLabel("Bilabial"), gbc);
			gbc.gridx++;
			kbPcons.add(new TableLabel("Labio-Dental"), gbc);
			gbc.gridx++;
			kbPcons.add(new TableLabel("Dental"), gbc);
			gbc.gridx++;
			kbPcons.add(new TableLabel("Alveolar"), gbc);
			gbc.gridx++;
			kbPcons.add(new TableLabel("Post-Alveolar"), gbc);
			gbc.gridx++;
			kbPcons.add(new TableLabel("Retroflex"), gbc);
			gbc.gridx++;
			kbPcons.add(new TableLabel("Palatal"), gbc);
			gbc.gridx++;
			kbPcons.add(new TableLabel("Velar"), gbc);
			gbc.gridx++;
			kbPcons.add(new TableLabel("Uvular"), gbc);
			gbc.gridx++;
			kbPcons.add(new TableLabel("Pharyngeal"), gbc);
			gbc.gridx++;
			kbPcons.add(new TableLabel("Glottal"), gbc);
		}
		{
			gbc.gridx = 0;
			gbc.gridy = 1;
			kbPcons.add(new TableLabel("Plosive"), gbc);
			gbc.gridy++;
			kbPcons.add(new TableLabel("Nasal"), gbc);
			gbc.gridy++;
			kbPcons.add(new TableLabel("Trill"), gbc);
			gbc.gridy++;
			kbPcons.add(new TableLabel("Tap"), gbc);
			gbc.gridy++;
			kbPcons.add(new TableLabel("Fricative"), gbc);
			gbc.gridy++;
			kbPcons.add(new TableLabel("Lateral Fricatice"), gbc);
			gbc.gridy++;
			kbPcons.add(new TableLabel("Approximant"), gbc);
			gbc.gridy++;
			kbPcons.add(new TableLabel("Lateral Approximant"), gbc);
		}
		{
			gbc.gridx = 1;
			gbc.gridy = 1;
			kbPcons.add(new ButtonPair(editorWrapper, "p", "b"), gbc);
			gbc.gridx += 2;
			gbc.gridwidth = 3;
			kbPcons.add(new ButtonPair(editorWrapper, "t", "d"), gbc);
			gbc.gridx += 3;
			gbc.gridwidth = 1;
			kbPcons.add(new ButtonPair(editorWrapper, "ʈ", "ɖ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, "c", "ɟ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, "k", "ɡ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, "q", "ɢ"), gbc);
			gbc.gridx += 2;
			kbPcons.add(new ButtonPair(editorWrapper, "ʔ", null), gbc);
		}
		{
			gbc.gridx = 1;
			gbc.gridy++;
			kbPcons.add(new ButtonPair(editorWrapper, null, "m"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ɱ"), gbc);
			gbc.gridx++;
			gbc.gridwidth = 3;
			kbPcons.add(new ButtonPair(editorWrapper, null, "n"), gbc);
			gbc.gridx += 3;
			gbc.gridwidth = 1;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ɳ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ɲ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ɴ"), gbc);
		}
		{
			gbc.gridx = 1;
			gbc.gridy++;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ʙ"), gbc);
			gbc.gridx += 2;
			gbc.gridwidth = 3;
			kbPcons.add(new ButtonPair(editorWrapper, null, "r"), gbc);
			gbc.gridx += 6;
			gbc.gridwidth = 1;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ʀ"), gbc);
		}
		{
			gbc.gridx = 2;
			gbc.gridy++;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ⱱ"), gbc);
			gbc.gridx++;
			gbc.gridwidth = 3;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ɾ"), gbc);
			gbc.gridx += 3;
			gbc.gridwidth = 1;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ɽ"), gbc);
		}
		{
			gbc.gridx = 1;
			gbc.gridy++;
			kbPcons.add(new ButtonPair(editorWrapper, "ɸ", "β"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, "f", "v"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, "θ", "ð"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, "s", "z"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, "ʃ", "ʒ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, "ʂ", "ʐ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, "ç", "ʝ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, "x", "ɣ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, "χ", "ʁ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, "ħ", "ʕ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, "h", "ɦ"), gbc);
		}
		{
			gbc.gridx = 3;
			gbc.gridy++;
			gbc.gridwidth = 3;
			kbPcons.add(new ButtonPair(editorWrapper, "ɬ", "ɮ"), gbc);
		}
		{
			gbc.gridx = 2;
			gbc.gridy++;
			gbc.gridwidth = 1;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ʋ"), gbc);
			gbc.gridx++;
			gbc.gridwidth = 3;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ɹ"), gbc);
			gbc.gridx += 3;
			gbc.gridwidth = 1;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ɻ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, null, "j"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ɰ"), gbc);
		}
		{
			gbc.gridx = 3;
			gbc.gridy++;
			gbc.gridwidth = 3;
			kbPcons.add(new ButtonPair(editorWrapper, null, "l"), gbc);
			gbc.gridx += 3;
			gbc.gridwidth = 1;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ɭ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ʎ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(editorWrapper, null, "ʟ"), gbc);	
		}
		scrPcons = new JScrollPane(kbPcons);
		addTab("Pulmonic Consonants", scrPcons);
		
		kbNPcons = new JPanel(new GridBagLayout());
		{
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 2;
			kbNPcons.add(new TableLabel("Clicks"), gbc);
			gbc.gridx += 2;
			kbNPcons.add(new TableLabel("Voiced Implosives"), gbc);
			gbc.gridx += 2;
			kbNPcons.add(new TableLabel("Ejectives"), gbc);
			gbc.gridx += 2;
			kbNPcons.add(new TableLabel("Other"), gbc);
		}
		{
			gbc.gridx = 0;
			gbc.gridy++;
			gbc.gridwidth = 1;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ʘ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ǀ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "!"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ǂ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ǁ"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 1;
			kbNPcons.add(new PaddedLabel("Bilabial"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Dental"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("(Post)alveolar"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Palatoalveolar"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Alveolar Lateral"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 1;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ɓ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ɗ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ʄ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ɠ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ʛ"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 1;
			kbNPcons.add(new PaddedLabel("Bilabial"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Dental/Alveolar"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Palatal"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Velar"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Uvular"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 1;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ʼ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "pʼ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "tʼ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "kʼ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "sʼ"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 1;
			kbNPcons.add(new PaddedLabel("Modifier"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Bilabial"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Dental/Alveolar"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Velar"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Alveolar Fricative"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 1;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ʍ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "w"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ɥ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ʜ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ʢ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ʡ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new ButtonPair(editorWrapper, "ɕ", "ʑ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ɺ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(editorWrapper, "ɧ"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 1;
			kbNPcons.add(new PaddedLabel("Voiceless Labial-Velar Fricative"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Voiced Labial-Velar Fricative"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Voiced Labial-Palatal Approximant"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Voiceless Epiglottal Fricative"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Voiced Epiglottal Fricative"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Epiglottal Plosive"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Alveo-Palatla Fricatives"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Voiced Alveolar Lateral Tap"), gbc);
			gbc.gridy++;
			kbNPcons.add(new PaddedLabel("Simulataneous ʃ and x"), gbc);
		}
		scrNPcons = new JScrollPane(kbNPcons);
		addTab("Non-Pulmonic Cononants", scrNPcons);
		
		kbTones = new JPanel(new GridBagLayout());
		{
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 2;
			kbTones.add(new TableLabel("Level"), gbc);
			gbc.gridx += 2;
			kbTones.add(new TableLabel("Contour"), gbc);
		}
		{
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = 1;
			kbTones.add(new ButtonPair(editorWrapper, "◌̋ ", "˥"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(editorWrapper, "◌́ ", "˦"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(editorWrapper, "◌̄ ", "˧"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(editorWrapper, "◌̀ ", "˨"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(editorWrapper, "◌̏ ", "˩"), gbc);
			gbc.gridy++;
			kbTones.add(new KeyboardButton(editorWrapper, "◌ꜜ"), gbc);
			gbc.gridy++;
			kbTones.add(new KeyboardButton(editorWrapper, "◌ꜛ"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 1;
			gbc.gridwidth = 1;
			kbTones.add(new PaddedLabel("Extra High"), gbc);
			gbc.gridy++;
			kbTones.add(new PaddedLabel("High"), gbc);
			gbc.gridy++;
			kbTones.add(new PaddedLabel("Mid"), gbc);
			gbc.gridy++;
			kbTones.add(new PaddedLabel("Low"), gbc);
			gbc.gridy++;
			kbTones.add(new PaddedLabel("Extra Low"), gbc);
			gbc.gridy++;
			kbTones.add(new PaddedLabel("Downstep"), gbc);
			gbc.gridy++;
			kbTones.add(new PaddedLabel("Upstep"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 1;
			gbc.gridwidth = 1;
			kbTones.add(new ButtonPair(editorWrapper, "◌̌ ", "˩˥"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(editorWrapper, "◌̂ ", "˥˩"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(editorWrapper, "◌᷄", "˦˥"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(editorWrapper, "◌᷅ ", "˩˨"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(editorWrapper, "◌᷈ ", "˧˦˧"), gbc);
			gbc.gridy++;
			kbTones.add(new KeyboardButton(editorWrapper, "↗︎"), gbc);
			gbc.gridy++;
			kbTones.add(new KeyboardButton(editorWrapper, "↘︎"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 1;
			gbc.gridwidth = 1;
			kbTones.add(new PaddedLabel("Rising"), gbc);
			gbc.gridy++;
			kbTones.add(new PaddedLabel("Falling"), gbc);
			gbc.gridy++;
			kbTones.add(new PaddedLabel("High Rising"), gbc);
			gbc.gridy++;
			kbTones.add(new PaddedLabel("Low Rising"), gbc);
			gbc.gridy++;
			kbTones.add(new PaddedLabel("Rising-Falling"), gbc);
			gbc.gridy++;
			kbTones.add(new PaddedLabel("Global Rise"), gbc);
			gbc.gridy++;
			kbTones.add(new PaddedLabel("Global Fall"), gbc);
		}
		scrTones = new JScrollPane(kbTones);
		addTab("Tones", scrTones);
		
		kbDiacritics = new JPanel(new GridBagLayout());
		{
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 1;
			kbDiacritics.add(new ButtonPair(editorWrapper, "◌̥ ", "◌̊"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌̬"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌ʰ"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(editorWrapper, new String[] {"◌̹ ", "◌͗", "◌˒"}), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(editorWrapper, new String[] {"◌̜ ", "◌͑ ","◌˓"}), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(editorWrapper, "◌̟ ", "◌˖"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(editorWrapper, "◌̠ ", "◌˗"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌̈"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌̽"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(editorWrapper, "◌̩ ", "◌̍"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(editorWrapper, "◌̯ ", "◌̑"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌˞"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 0;
			kbDiacritics.add(new PaddedLabel("Voiceless"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Voiced"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Aspirated"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("More Rounded"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Less Rounded"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Advanced"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Retracted"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Centralized"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Mid-Centralized"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Syllabic"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Non-Syllabic"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Rhoticity"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 0;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌̤"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌̰"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌̼"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌ʷ"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌ʲ"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌ˠ"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌ˁ"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌̴"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(editorWrapper, "◌̝ ", "◌˔"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(editorWrapper, "◌̞ ", "◌˕"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌̘"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌̙"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 0;
			kbDiacritics.add(new PaddedLabel("Breathy Voiced"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Creaky Voiced"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Linguolabial"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Labialized"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Palatalized"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Velarized"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Pharyngealized"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Velarized or Pharyngealized"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Raized"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Lowered"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Advanced Tongue Root"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Retracted Tongue Root"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 0;
			kbDiacritics.add(new ButtonPair(editorWrapper, "◌̪ ", "◌͆"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌̺"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌̻"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌̃"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌ⁿ"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌ˡ"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(editorWrapper, "◌̚"), gbc);
		}
		{
			gbc.gridx++;
			gbc.gridy = 0;
			kbDiacritics.add(new PaddedLabel("Dental"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Apical"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Laminal"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Nasalized"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Nasal Release"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("Lateral Release"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new PaddedLabel("No Audible Release"), gbc);
		}
		scrDiacritics = new JScrollPane(kbDiacritics);
		addTab("Diacritics", scrDiacritics);
	}
}
