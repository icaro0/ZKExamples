package com.everis.component.ZKWebTest;

import java.util.Collection;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;

public class CustomRenderer implements TreeitemRenderer {

	public void render(Treeitem item, Object data) throws Exception {
		if (data instanceof DefaultTreeNode) {
			DefaultTreeNode itemData = (DefaultTreeNode) data;
			Treerow tr = new Treerow();
			tr.addEventListener(Events.ON_CLICK, new EventListener() {
				public void onEvent(Event event) throws Exception {
					Treeitem item = (Treeitem) event.getTarget().getParent();
					//TODO: implement recursive search here
					if (item.getTreechildren() != null) {
						Collection<Treeitem> hijos = item.getTreechildren().getItems();
						for (Treeitem h : hijos) {
							if(item.isSelected()){
								item.getTree().addItemToSelection(h);
							}else{
								item.getTree().removeItemFromSelection(h);
							}
						}
					}
					//TODO: uncheck root if children is unchecked
					/*else{
						if(!item.isSelected()){
							((Tree)item.getParent().getParent()).removeItemFromSelection(item);
						}
					}*/
				}
			});
			tr.appendChild(new Treecell(itemData.getData().toString()));
			item.appendChild(tr);
			item.setOpen(true);
		}

	}
}
