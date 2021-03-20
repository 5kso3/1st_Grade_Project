package View;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import Data.ClassData;

public class WorkingPanel extends GBLPanel {
	private static final long serialVersionUID = 1L;
	private SelectPanel selectPanel;
	private BButtonPanel bButtonPanel;
	private BasketPanel basketPanel;
	private AButtonButton AButtonPanel;
	private ApplyPanel applyPanel;
	private GridBagLayout gridBag;
	
	WorkingPanel() {
		this.gridBag = new GridBagLayout();
		this.setLayout(gridBag);

		ActionHandler actionHandler = new ActionHandler();
		
		this.applyPanel = new ApplyPanel();
		gridBagInsert(gridBag, applyPanel, 4, 0, 0.18 , 1);
		
		this.basketPanel = new BasketPanel();
		gridBagInsert(gridBag, basketPanel, 2, 0, 0.18, 1);
		
		this.selectPanel = new SelectPanel();
		gridBagInsert(gridBag, selectPanel, 0, 0, 0.54 , 1);
		
		this.bButtonPanel = new BButtonPanel(actionHandler);
		gridBagInsert(gridBag, bButtonPanel, 1, 0, 0.05 , 1);
		
		this.AButtonPanel = new AButtonButton(actionHandler);
		gridBagInsert(gridBag, AButtonPanel, 3, 0, 0.05 , 1);
	}

	public void setPersonalInfo(String userName) {
		applyPanel.setPersonalInfo(userName);
		basketPanel.setPersonalInfo(userName);
	}

	public Vector<ClassData> getClassVector() {
		return applyPanel.getClassVector();
	}
	
	private class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("goBasket")) {
				Vector<ClassData> selectVector = new Vector<ClassData>();
				selectVector = selectPanel.getVector();
				basketPanel.setVector(selectVector);
				basketPanel.selectIndex();
			} else if(e.getActionCommand().equals("outBasket")) {
				basketPanel.deletVector();
				basketPanel.selectIndex();
			} else if(e.getActionCommand().equals("goApply")) {
				Vector<ClassData> selectVector = new Vector<ClassData>();
				selectVector = basketPanel.getVector();
				boolean flag = applyPanel.goApply(selectVector);
				if(!flag) {
					basketPanel.deletVector();
				}
				basketPanel.selectIndex();
				applyPanel.selectIndex();
			} else {
				Vector<ClassData> selectVector = new Vector<ClassData>();
				selectVector = applyPanel.getVector();
				applyPanel.outApply();
				basketPanel.setVector(selectVector);
				basketPanel.selectIndex();
				applyPanel.selectIndex();
			}
		}
	}
	
	public void changeTheme() {
		selectPanel.changeTheme();
		bButtonPanel.changeTheme();
		basketPanel.changeTheme();
		AButtonPanel.changeTheme();
		applyPanel.changeTheme();
	}
	
	public void changeOrigin() {
		selectPanel.changeOrigin();
		bButtonPanel.changeOrigin();
		basketPanel.changeOrigin();
		AButtonPanel.changeOrigin();
		applyPanel.changeOrigin();
	}

	public void initalize(int campusID, int hour) {
		this.selectPanel.initalize(campusID);
		this.basketPanel.initalize();
		this.applyPanel.initalize(hour);
	}
}
