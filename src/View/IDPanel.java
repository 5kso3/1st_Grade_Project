package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Control.ID_Control;
import Global.Constants.EIDPanel;


public class IDPanel extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel, birthdayLabel;
	private JTextField nameText, birthdayText;
	private JButton okButton, cancelButton;
	private ID_Control iD_Control;
	private String foundID;
	
	IDPanel(){
		this.setSize(400, 200);
		this.setLayout(new GridLayout(3,3));
		this.setLocationRelativeTo(null);
		
		ActionHandler actionHandler = new ActionHandler();
		
		nameLabel = new JLabel(EIDPanel.eNameLabel.getValue());
		nameLabel.setFont(nameLabel.getFont().deriveFont(15.0f));
		this.add(nameLabel);
		nameText = new JTextField(15);
		this.add(nameText);
		
		birthdayLabel = new JLabel(EIDPanel.eBirthdayLabel.getValue());
		birthdayLabel.setFont(birthdayLabel.getFont().deriveFont(15.0f));
		this.add(birthdayLabel);
		birthdayText = new JTextField(15);
		this.add(birthdayText);
		
		this.okButton = new JButton(EIDPanel.eOkButton.getValue());
		this.okButton.addActionListener(actionHandler);
		this.okButton.setActionCommand("okButton");
		this.add(okButton);
		
		this.cancelButton = new JButton(EIDPanel.eCancelButton.getValue());
		this.cancelButton.addActionListener(actionHandler);
		this.cancelButton.setActionCommand("cancelButton");
		this.add(cancelButton);
		
		this.setVisible(true);
	}
	
	public void findID() {
		String name = nameText.getText();
		String birthday = birthdayText.getText();
		this.iD_Control = new ID_Control();
		this.foundID = this.iD_Control.Validate(name, birthday);
		if(foundID == null) { 
			JOptionPane.showMessageDialog(this, EIDPanel.eErrorMessage.getValue());
		} else {
			JOptionPane.showMessageDialog(this, EIDPanel.eIDMessage.getValue() + foundID);
		}
	}
	
	private class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("okButton")) {
				findID();
			} else {
				dispose();
			}
		}
	}
}
