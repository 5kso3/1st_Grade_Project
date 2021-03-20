package View;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.Vector;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Data.ClassData;

public class SelectPanel extends GBLPanel {
	private static final long serialVersionUID = 1L;
	private ClassPanel classPanel;
	private CMSPanel cmsPanel;
	private GridBagLayout gridBag;
	
	SelectPanel() {
		this.setBackground(Color.RED);
		ListSelectionHandler listSelectionHandler = new ListSelectionHandler();
		this.gridBag = new GridBagLayout();
		this.setLayout(gridBag);
		
		this.classPanel = new ClassPanel(listSelectionHandler);
		classPanel.setBackground(Color.LIGHT_GRAY);
		gridBagInsert(gridBag, classPanel, 0, 1, 0.27, 1);
		
		this.cmsPanel = new CMSPanel(listSelectionHandler);
		cmsPanel.setBackground(Color.LIGHT_GRAY);
		gridBagInsert(gridBag, cmsPanel, 0, 0, 0.27, 1);
	}

	public void goBasket() {
		this.classPanel.goBasket();
	}

	public Vector<ClassData> getVector() {
		return this.classPanel.goBasket();
	}
	
	private class ListSelectionHandler implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent e) {
			String fileName = cmsPanel.refresh(e.getSource());
			classPanel.refresh(fileName);
		}
	}

	public void changeTheme() {
		classPanel.changeTheme();
		cmsPanel.changeTheme();
	}
	
	public void changeOrigin() {
		classPanel.changeOrigin();
		cmsPanel.changeOrigin();
	}
	
	public void initalize(int campusID) {
		this.cmsPanel.initalize(campusID);
	}
}
