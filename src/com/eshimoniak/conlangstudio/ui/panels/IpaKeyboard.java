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

public class IpaKeyboard extends JTabbedPane {
	private JPanel kbVowels, kbPcons, kbNPcons, kbTones, kbDiacritics;
	private JScrollPane scrVowels, scrPcons, scrNPcons, scrTones, scrDiacritics;
	
	public IpaKeyboard(RawEditor rawEditor) {
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
			kbVowels.add(new ButtonPair(rawEditor, "i", "y"), gbc);
			gbc.gridy++;
			kbVowels.add(new ButtonPair(rawEditor, "ɪ", "ʏ"), gbc);
			gbc.gridy++;
			kbVowels.add(new ButtonPair(rawEditor, "e", "ø"), gbc);
			gbc.gridy += 2;
			kbVowels.add(new ButtonPair(rawEditor, "ɛ", "œ"), gbc);
			gbc.gridy++;
			kbVowels.add(new ButtonPair(rawEditor, "æ", null), gbc);
			gbc.gridy++;
			kbVowels.add(new ButtonPair(rawEditor, "a", "ɶ"), gbc);
		}
		{
			gbc.gridx = 2;
			gbc.gridy = 1;
			kbVowels.add(new ButtonPair(rawEditor, "ɨ", "ʉ"), gbc);
			gbc.gridy += 2;
			kbVowels.add(new ButtonPair(rawEditor, "ɘ", "ɵ"), gbc);
			gbc.gridy++;
			kbVowels.add(new KeyboardButton(rawEditor, "ə"), gbc);
			gbc.gridy++;
			kbVowels.add(new ButtonPair(rawEditor, "ɜ", "ɞ"), gbc);
			gbc.gridy++;
			kbVowels.add(new KeyboardButton(rawEditor, "ɐ"), gbc);
		}
		{
			gbc.gridx = 3;
			gbc.gridy = 1;
			kbVowels.add(new ButtonPair(rawEditor, "ɯ", "u"), gbc);
			gbc.gridy++;
			kbVowels.add(new ButtonPair(rawEditor, null, "ʊ"), gbc);
			gbc.gridy++;
			kbVowels.add(new ButtonPair(rawEditor, "ɤ", "o"), gbc);
			gbc.gridy += 2;
			kbVowels.add(new ButtonPair(rawEditor, "ʌ", "ɔ"), gbc);
			gbc.gridy += 2;
			kbVowels.add(new ButtonPair(rawEditor, "ɑ", "ɒ"), gbc);
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
			kbPcons.add(new ButtonPair(rawEditor, "p", "b"), gbc);
			gbc.gridx += 2;
			gbc.gridwidth = 3;
			kbPcons.add(new ButtonPair(rawEditor, "t", "d"), gbc);
			gbc.gridx += 3;
			gbc.gridwidth = 1;
			kbPcons.add(new ButtonPair(rawEditor, "ʈ", "ɖ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "c", "ɟ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "k", "ɡ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "q", "ɢ"), gbc);
			gbc.gridx += 2;
			kbPcons.add(new ButtonPair(rawEditor, "ʔ", null), gbc);
		}
		{
			gbc.gridx = 1;
			gbc.gridy++;
			kbPcons.add(new ButtonPair(rawEditor, null, "m"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, null, "ɱ"), gbc);
			gbc.gridx++;
			gbc.gridwidth = 3;
			kbPcons.add(new ButtonPair(rawEditor, null, "n"), gbc);
			gbc.gridx++;
			gbc.gridwidth = 1;
			kbPcons.add(new ButtonPair(rawEditor, "c", "ɟ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "k", "ɡ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "q", "ɢ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "ʔ", null), gbc);
		}
		{
			gbc.gridx = 1;
			gbc.gridy++;
			kbPcons.add(new ButtonPair(rawEditor, null, "ʙ"), gbc);
			gbc.gridx += 2;
			gbc.gridwidth = 3;
			kbPcons.add(new ButtonPair(rawEditor, null, "r"), gbc);
			gbc.gridx += 6;
			gbc.gridwidth = 1;
			kbPcons.add(new ButtonPair(rawEditor, null, "ʀ"), gbc);
		}
		{
			gbc.gridx = 2;
			gbc.gridy++;
			kbPcons.add(new ButtonPair(rawEditor, null, "ⱱ"), gbc);
			gbc.gridx++;
			gbc.gridwidth = 3;
			kbPcons.add(new ButtonPair(rawEditor, null, "ɾ"), gbc);
			gbc.gridx += 3;
			gbc.gridwidth = 1;
			kbPcons.add(new ButtonPair(rawEditor, null, "ɽ"), gbc);
		}
		{
			gbc.gridx = 1;
			gbc.gridy++;
			kbPcons.add(new ButtonPair(rawEditor, "ɸ", "β"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "f", "v"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "θ", "ð"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "s", "z"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "ʃ", "ʒ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "ʂ", "ʐ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "ç", "ʝ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "x", "ɣ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "χ", "ʁ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "ħ", "ʕ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, "h", "ɦ"), gbc);
		}
		{
			gbc.gridx = 3;
			gbc.gridy++;
			gbc.gridwidth = 3;
			kbPcons.add(new ButtonPair(rawEditor, "ɬ", "ɮ"), gbc);
		}
		{
			gbc.gridx = 2;
			gbc.gridy++;
			gbc.gridwidth = 1;
			kbPcons.add(new ButtonPair(rawEditor, null, "ʋ"), gbc);
			gbc.gridx++;
			gbc.gridwidth = 3;
			kbPcons.add(new ButtonPair(rawEditor, null, "ɹ"), gbc);
			gbc.gridx += 3;
			gbc.gridwidth = 1;
			kbPcons.add(new ButtonPair(rawEditor, null, "ɻ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, null, "j"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, null, "ɰ"), gbc);
		}
		{
			gbc.gridx = 3;
			gbc.gridy++;
			gbc.gridwidth = 3;
			kbPcons.add(new ButtonPair(rawEditor, null, "l"), gbc);
			gbc.gridx += 3;
			gbc.gridwidth = 1;
			kbPcons.add(new ButtonPair(rawEditor, null, "ɭ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, null, "ʎ"), gbc);
			gbc.gridx++;
			kbPcons.add(new ButtonPair(rawEditor, null, "ʟ"), gbc);	
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
			kbNPcons.add(new KeyboardButton(rawEditor, "ʘ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "ǀ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "!"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "ǂ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "ǁ"), gbc);
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
			kbNPcons.add(new KeyboardButton(rawEditor, "ɓ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "ɗ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "ʄ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "ɠ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "ʛ"), gbc);
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
			kbNPcons.add(new KeyboardButton(rawEditor, "ʼ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "pʼ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "tʼ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "kʼ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "sʼ"), gbc);
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
			kbNPcons.add(new KeyboardButton(rawEditor, "ʍ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "w"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "ɥ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "ʜ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "ʢ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "ʡ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new ButtonPair(rawEditor, "ɕ", "ʑ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "ɺ"), gbc);
			gbc.gridy++;
			kbNPcons.add(new KeyboardButton(rawEditor, "ɧ"), gbc);
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
			kbTones.add(new ButtonPair(rawEditor, "◌̋ ", "˥"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(rawEditor, "◌́ ", "˦"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(rawEditor, "◌̄ ", "˧"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(rawEditor, "◌̀ ", "˨"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(rawEditor, "◌̏ ", "˩"), gbc);
			gbc.gridy++;
			kbTones.add(new KeyboardButton(rawEditor, "◌ꜜ"), gbc);
			gbc.gridy++;
			kbTones.add(new KeyboardButton(rawEditor, "◌ꜛ"), gbc);
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
			kbTones.add(new ButtonPair(rawEditor, "◌̌ ", "˩˥"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(rawEditor, "◌̂ ", "˥˩"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(rawEditor, "◌᷄", "˦˥"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(rawEditor, "◌᷅ ", "˩˨"), gbc);
			gbc.gridy++;
			kbTones.add(new ButtonPair(rawEditor, "◌᷈ ", "˧˦˧"), gbc);
			gbc.gridy++;
			kbTones.add(new KeyboardButton(rawEditor, "↗︎"), gbc);
			gbc.gridy++;
			kbTones.add(new KeyboardButton(rawEditor, "↘︎"), gbc);
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
			kbDiacritics.add(new ButtonPair(rawEditor, "◌̥ ", "◌̊"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌̬"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌ʰ"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(rawEditor, new String[] {"◌̹ ", "◌͗", "◌˒"}), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(rawEditor, new String[] {"◌̜ ", "◌͑ ","◌˓"}), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(rawEditor, "◌̟ ", "◌˖"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(rawEditor, "◌̠ ", "◌˗"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌̈"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌̽"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(rawEditor, "◌̩ ", "◌̍"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(rawEditor, "◌̯ ", "◌̑"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌˞"), gbc);
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
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌̤"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌̰"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌̼"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌ʷ"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌ʲ"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌ˠ"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌ˁ"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌̴"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(rawEditor, "◌̝ ", "◌˔"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new ButtonPair(rawEditor, "◌̞ ", "◌˕"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌̘"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌̙"), gbc);
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
			kbDiacritics.add(new ButtonPair(rawEditor, "◌̪ ", "◌͆"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌̺"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌̻"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌̃"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌ⁿ"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌ˡ"), gbc);
			gbc.gridy++;
			kbDiacritics.add(new KeyboardButton(rawEditor, "◌̚"), gbc);
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
