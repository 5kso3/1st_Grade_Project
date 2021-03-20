package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Control.Login_Control;

public class InputPanel extends GBLPanel{
	private static final long serialVersionUID = 1L;
	private GridBagLayout gridBag;
	private JLabel nameLable;
	private JTextField nameText;
	private JLabel passwordLable;
	private JTextField passwordText;
	private JButton okButton, idButton, pwButton;
	private Login_Control Login_Control;
	private boolean loginSuccess;
	
	InputPanel(ActionListener actionHandler, KeyListener keyHandler) {
		this.gridBag = new GridBagLayout();
		this.setLayout(gridBag);
		this.setPreferredSize(new Dimension(1,1));
		GBLPanel panel = new GBLPanel();
		panel.setLayout(gridBag);
		nameLable = new JLabel("           ID");
		nameLable.setBackground(new Color(0x99CCFF));
		nameLable.setOpaque(true);
		nameLable.setFont(nameLable.getFont().deriveFont(15.0f));
		nameLable.setPreferredSize(new Dimension(1,1));
		panel.gridBagInsert(gridBag, nameLable, 0, 0, 0.4, 1);
		nameText = new JTextField();
		nameText.addKeyListener(keyHandler);
		nameText.setPreferredSize(new Dimension(1,1));
		panel.gridBagInsert(gridBag, nameText, 1, 0, 0.6, 1);
		this.gridBagInsert(gridBag, panel, 0, 0, 1, 0.3);
		
		GBLPanel panel2 = new GBLPanel();
		panel2.setLayout(gridBag);
		passwordLable = new JLabel("    Password");
		passwordLable.setBackground(new Color(0x99CCFF));
		passwordLable.setOpaque(true);
		passwordLable.setFont(passwordLable.getFont().deriveFont(15.0f));
		passwordLable.setPreferredSize(new Dimension(1,1));
		panel2.gridBagInsert(gridBag, passwordLable, 0, 0, 0.4, 1);
		passwordText = new JPasswordField();
		passwordText.addKeyListener(keyHandler);
		passwordText.setPreferredSize(new Dimension(1,1));
		panel2.gridBagInsert(gridBag, passwordText, 1, 0, 0.6, 1);
		this.gridBagInsert(gridBag, panel2, 0, 1, 1, 0.3);
		
		GBLPanel panel3 = new GBLPanel();
		panel3.setLayout(gridBag);
		idButton = new JButton("아이디 찾기");
		idButton.addActionListener(actionHandler);
		idButton.setActionCommand("idButton");
		idButton.setBackground(new Color(0x99CCFF));
		idButton.setPreferredSize(new Dimension(1,1));
		panel3.gridBagInsert(gridBag, idButton, 0, 0, 0.5, 1);
		pwButton = new JButton("비밀번호 찾기");
		pwButton.addActionListener(actionHandler);
		pwButton.setActionCommand("pwButton");
		pwButton.setBackground(new Color(0x99CCFF));
		pwButton.setPreferredSize(new Dimension(1,1));
		panel3.gridBagInsert(gridBag, pwButton, 1, 0, 0.5, 1);
		this.gridBagInsert(gridBag, panel3, 0, 2, 1, 0.1);
		
		okButton = new JButton();
		okButton.setIcon(new ImageIcon("resource/Ok_Button.png"));
		okButton.addActionListener(actionHandler);
		okButton.setActionCommand("okBtton");
		okButton.setBackground(new Color(0x99CCFF));
		okButton.setPreferredSize(new Dimension(1,1));
		okButton.addKeyListener(keyHandler);
		this.gridBagInsert(gridBag, okButton, 0, 3, 1, 0.3);
		
		this.loginSuccess = false;
	}
	
	public String Validate() throws FileNotFoundException {
		String ID = nameText.getText();
		String Password = passwordText.getText();
		this.Login_Control = new Login_Control();
		this.loginSuccess = this.Login_Control.Validate(ID,Password);
		if(!this.loginSuccess) {
			JOptionPane errorDialog = new JOptionPane();
			errorDialog.showMessageDialog(this, "Login_Fail");
			return null;
		} return ID;
	}
	
	public boolean LoginSuccess() {
		return this.loginSuccess;
	}
	
	public void selectButton() {
		this.okButton.setSelected(true);
	}
}
