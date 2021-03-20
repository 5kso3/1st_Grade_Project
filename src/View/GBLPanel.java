package View;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class GBLPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public void gridBagInsert(GridBagLayout gridBag, Component c, int x, int y, double w, double h){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = w;
        gbc.weighty = h;
        gridBag.setConstraints(c,gbc);
        this.add(c);
    }
}
