package com.eshimoniak.conlangstudio.ui.panels.editor;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.commonmark.Extension;
import org.commonmark.ext.autolink.AutolinkExtension;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.ins.InsExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import com.eshimoniak.conlangstudio.Main;
import com.eshimoniak.conlangstudio.MarkdownExtensions;
import com.eshimoniak.conlangstudio.ui.panels.HtmlViewer;
import com.eshimoniak.conlangstudio.ui.panels.MarkdownViewer;

/**
 * A combination of markdown editor and markdown viewer
 * @author Evan Shimoniak
**/
public class Editor extends JTabbedPane {
	private RawEditor rawEditor;
	private MarkdownViewer mdViewer;
	private HtmlViewer htmlViewer;
	
	public Editor() {
		this(null);
	}
	public Editor(File f) {
		rawEditor = new RawEditor();
		addTab("Markdown Editor", rawEditor);
		mdViewer = new MarkdownViewer();
		addTab("Compiled Markdown", mdViewer);
		htmlViewer = new HtmlViewer();
		addTab("Rendered Preview", htmlViewer);
		
		ChangeListener tabChangeListener = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent changeEvent) {
				JTabbedPane parent = (JTabbedPane) changeEvent.getSource();

				if (parent.getSelectedIndex() == 1) {
					mdViewer.setText(MarkdownExtensions.parseMarkdownExtensions(rawEditor.getText()));
				} else if (parent.getSelectedIndex() == 2) {
					List<Extension> extensions = Arrays.asList(TablesExtension.create(), AutolinkExtension.create(), StrikethroughExtension.create(), InsExtension.create());
					Parser parser = Parser.builder().extensions(extensions).build();
					Node document = parser.parse(MarkdownExtensions.parseMarkdownExtensions(rawEditor.getText()));
					HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
					
					htmlViewer.setText(renderer.render(document));
				}
			}
		};
		addChangeListener(tabChangeListener);
		setTabPlacement(BOTTOM);
		if (f != null) {
			Main.setCurrFile(f);
		}
	}
	
	public RawEditor getRawEditor() {
		return rawEditor;
	}
}
