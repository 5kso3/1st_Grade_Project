package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import Global.GraphicsConstants.GLoginDialog;

public class LoginDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private GridBagLayout gridBag;
	private JLabel iconImage;
	private InputPanel inputPanel;
	private Main main;

	public LoginDialog(ActionListener actionHandler, Main main) {
		this.main = main;
		this.setSize(GLoginDialog.width.getValue(), GLoginDialog.height.getValue());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.WHITE);
		this.gridBag = new GridBagLayout();
		this.setLayout(gridBag);
		
		KeyHandler keyHandler = new KeyHandler();
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
		
		this.iconImage = new JLabel(new ImageIcon("resource/icon.png"));
		iconImage.setHorizontalAlignment(JLabel.CENTER);
		this.iconImage.setPreferredSize(new Dimension(1,1));
		this.gridBagInsert(gridBag, iconImage, 0, 0, 0.5, 1);
		
		inputPanel = new InputPanel(actionHandler, keyHandler);
		this.gridBagInsert(gridBag, inputPanel, 1, 0, 0.5, 1);
		
		
	}
	
	public String Validate() throws FileNotFoundException {
		return this.inputPanel.Validate();
	}
	
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
	
	private class KeyHandler implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == 10) {
				main.loginOk();
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
		}
		@Override
		public void keyTyped(KeyEvent e) {
		}
	}
}