package com.eshimoniak.conlangstudio.ui.panels;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.eshimoniak.conlangstudio.Main;
import com.eshimoniak.conlangstudio.Util;
import com.eshimoniak.conlangstudio.ui.popups.FileTreePopup;

public class FileTreeViewer extends JPanel {
	private JTree tree;
	private JScrollPane scroller;
	
	public FileTreeViewer() {
		super(new BorderLayout());
		tree = new JTree(new DefaultTreeModel(findFiles(null)));
		scroller = new JScrollPane(tree);
		add(scroller, BorderLayout.CENTER);
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = tree.getRowForLocation(e.getX(), e.getY());
				TreePath path = tree.getPathForLocation(e.getX(), e.getY());
				tree.setSelectionPath(path);
				if(row != -1) {
					//Get clicked file
					File f = new File(Main.projectRoot.getParent());
					for (int i = 0; i < tree.getSelectionPath().getPath().length; i++) {
						f = new File(f, path.getPathComponent(i).toString());
					}					
					
					//Do something with clicked file
					if (!e.isPopupTrigger()) {
						if(e.getClickCount() == 1) {
							//TODO Single click
						} else if(e.getClickCount() == 2) {
							Main.setCurrFile(f);
						}
					} else if (e.isPopupTrigger()) {
						new FileTreePopup(FileTreeViewer.this, f).show(e.getComponent(), e.getX(), e.getY());
					}
				}
			}
		});
	}
	
	public void refreshTree() {
		tree.setModel(new DefaultTreeModel(findFiles(null)));
	}
	
	private static DefaultMutableTreeNode findFiles(File parent) {
		DefaultMutableTreeNode root;
		File[] files;
		
		if (parent == null) {
			parent = Main.projectRoot;
		}
		root = new DefaultMutableTreeNode(parent.getName());
		
		files = parent.listFiles();
		for (File f : files) {
			if (Util.isDirectory(f)) {
				root.add(findFiles(f));
			} else {
				root.add(new DefaultMutableTreeNode(f.getName()));
			}
		}

		
		return root;
	}
}