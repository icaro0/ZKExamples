package com.everis.component.ZKWebTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treeitem;

public class TreeController extends GenericForwardComposer {
	private Tree tree;
	private List<String> secciones = new ArrayList(Arrays.asList("solicitud1",
			"solicitud2", "solicitud3", "solicitud4"));

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		List<DefaultTreeNode> s = new ArrayList<DefaultTreeNode>();
		for (String seccion : secciones) {
			DefaultTreeNode nodo = new DefaultTreeNode(seccion);
			s.add(nodo);
		}
		List<DefaultTreeNode> t = new ArrayList<DefaultTreeNode>();
		@SuppressWarnings("unchecked")
		DefaultTreeNode root = new DefaultTreeNode("Raiz",
				s.toArray(new DefaultTreeNode[s.size()]));
		t.add(root);
		DefaultTreeNode nodoRaiz = new DefaultTreeNode(null,
				t.toArray(new DefaultTreeNode[t.size()]));
		DefaultTreeModel model = new DefaultTreeModel(nodoRaiz);
		tree.setModel(model);
		tree.setItemRenderer(new CustomRenderer());
	}

}
