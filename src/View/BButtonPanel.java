package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Global.Constants.EButtonPanel;
import Global.GraphicsConstants.GColor;

public class BButtonPanel extends GBLPanel {
	private static final long serialVersionUID = 1L;
	private GridBagLayout gridBag;
	private JButton goBasket, outBasket;
	private JPanel top, middle, bottom;
	
	BButtonPanel(ActionListener actionHandler) {
		this.gridBag = new GridBagLayout();
		this.setLayout(gridBag);
		
		top = new JPanel();
		top.setPreferredSize(new Dimension(1,1));
		gridBagInsert(gridBag, top, 0, 0, 1, 0.3);
		
		goBasket = new JButton(EButtonPanel.eGoButton.getValue());
		goBasket.setPreferredSize(new Dimension(1,1));
		goBasket.addActionListener(actionHandler);
		goBasket.setActionCommand("goBasket");
		gridBagInsert(gridBag, goBasket, 0, 1, 1, 0.15);
		
		middle = new JPanel();
		middle.setPreferredSize(new Dimension(1,1));
		gridBagInsert(gridBag, middle, 0, 2, 1, 0.1);
		
		outBasket = new JButton(EButtonPanel.eOutButton.getValue());
		outBasket.setPreferredSize(new Dimension(1,1));
		outBasket.addActionListener(actionHandler);
		outBasket.setActionCommand("outBasket");
		gridBagInsert(gridBag, outBasket, 0, 3, 1, 0.15);

		bottom = new JPanel();
		bottom.setPreferredSize(new Dimension(1,1));
		gridBagInsert(gridBag, bottom, 0, 4, 1, 0.3);
	}

	public void changeTheme() {
		this.top.setBackground(GColor.panelColor.getValue());
		this.goBasket.setBackground(GColor.buttonColor.getValue());
		this.middle.setBackground(GColor.panelColor.getValue());
		this.outBasket.setBackground(GColor.buttonColor.getValue());
		this.bottom.setBackground(GColor.panelColor.getValue());
	}

	public void changeOrigin() {
		this.top.setBackground(GColor.defultButtonPanelColor.getValue());
		this.goBasket.setBackground(GColor.defultButtonColor.getValue());
		this.middle.setBackground(GColor.defultButtonPanelColor.getValue());
		this.outBasket.setBackground(GColor.defultButtonColor.getValue());
		this.bottom.setBackground(GColor.defultButtonPanelColor.getValue());
	}
}
