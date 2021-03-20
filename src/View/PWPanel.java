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
import Control.PW_Control;
import Global.Constants.EPWPanel;

public class PWPanel extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel, birthdayLabel;
	private JTextField nameText, birthdayText;
	private JButton okButton, cancelButton;
	private ID_Control iD_Control;
	private PW_Control pW_Control;
	private String foundPW;
	private boolean iDSuccess;

	PWPanel() {
		this.setSize(400, 200);
		this.setLayout(new GridLayout(3, 3));
		this.setLocationRelativeTo(null);

		ActionHandler actionHandler = new ActionHandler();

		nameLabel = new JLabel(EPWPanel.eNameLabel.getValue());
		nameLabel.setFont(nameLabel.getFont().deriveFont(15.0f));
		this.add(nameLabel);
		nameText = new JTextField(15);
		this.add(nameText);

		birthdayLabel = new JLabel(EPWPanel.eBirthdayLabel.getValue());
		birthdayLabel.setFont(birthdayLabel.getFont().deriveFont(15.0f));
		this.add(birthdayLabel);
		birthdayText = new JTextField(15);
		this.add(birthdayText);

		this.okButton = new JButton(EPWPanel.eOkButton.getValue());
		this.okButton.addActionListener(actionHandler);
		this.okButton.setActionCommand("okButton");
		this.add(okButton);

		this.cancelButton = new JButton(EPWPanel.eCancelButton.getValue());
		this.cancelButton.addActionListener(actionHandler);
		this.cancelButton.setActionCommand("cancelButton");
		this.add(cancelButton);

		this.setVisible(true);
	}

	public void findPW() {
		this.foundPW = null;
		String id = nameText.getText();
		String birthday = birthdayText.getText();
		this.iD_Control = new ID_Control();
		this.iDSuccess = this.iD_Control.getID(id, birthday);
		if (iDSuccess) {
			this.pW_Control = new PW_Control();
			this.foundPW = this.pW_Control.getPW(id);
		}
		if (foundPW == null) {
			JOptionPane.showMessageDialog(this, EPWPanel.eErrorMessage.getValue());
		} else {
			JOptionPane.showMessageDialog(this, EPWPanel.ePWMessage.getValue() + foundPW);
		}
	}

	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("okButton")) {
				findPW();
			} else {
				dispose();
			}
		}
	}
}
