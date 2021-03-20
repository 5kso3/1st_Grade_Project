package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import Data.ClassData;
import Global.Constants.EButtonPanel;
import Global.GraphicsConstants.GColor;


public class AButtonButton extends GBLPanel {
	private static final long serialVersionUID = 1L;
	private GridBagLayout gridBag;
	private JButton goApply, outApply;
	private JPanel top, middle, bottom;
	
	AButtonButton(ActionListener actionHandler) {
		this.gridBag = new GridBagLayout();
		this.setLayout(gridBag);
		
		top = new JPanel();
		top.setPreferredSize(new Dimension(1,1));
		gridBagInsert(gridBag, top, 0, 0, 1, 0.3);
		
		goApply = new JButton(EButtonPanel.eGoButton.getValue());
		goApply.setPreferredSize(new Dimension(1,1));
		goApply.addActionListener(actionHandler);
		goApply.setActionCommand("goApply");
		gridBagInsert(gridBag, goApply, 0, 1, 1, 0.15);
		
		middle = new JPanel();
		middle.setPreferredSize(new Dimension(1,1));
		gridBagInsert(gridBag, middle, 0, 2, 1, 0.1);
		
		outApply = new JButton(EButtonPanel.eOutButton.getValue());
		outApply.setPreferredSize(new Dimension(1,1));
		outApply.addActionListener(actionHandler);
		outApply.setActionCommand("outApply");
		gridBagInsert(gridBag, outApply, 0, 3, 1, 0.15);

		bottom = new JPanel();
		bottom.setPreferredSize(new Dimension(1,1));
		gridBagInsert(gridBag, bottom, 0, 4, 1, 0.3);
	}

	public void changeTheme() {
		this.top.setBackground(GColor.panelColor.getValue());
		this.goApply.setBackground(GColor.buttonColor.getValue());
		this.middle.setBackground(GColor.panelColor.getValue());
		this.outApply.setBackground(GColor.buttonColor.getValue());
		this.bottom.setBackground(GColor.panelColor.getValue());
	}

	public void changeOrigin() {
		this.top.setBackground(GColor.defultButtonPanelColor.getValue());
		this.goApply.setBackground(GColor.defultButtonColor.getValue());
		this.middle.setBackground(GColor.defultButtonPanelColor.getValue());
		this.outApply.setBackground(GColor.defultButtonColor.getValue());
		this.bottom.setBackground(GColor.defultButtonPanelColor.getValue());
	}
}
