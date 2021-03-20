package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import Control.Register_Control;
import ValueObject.Register_CValue;

public class Main {
	private LoginDialog loginDialog;
	private String userID;
	private String userName;
	private int campusID;
	private int hour;
	private ActionHandler actionHandler;
	
	Main() {
		this.actionHandler = new ActionHandler();
		this.loginDialog = new LoginDialog(actionHandler, this);
		this.loginDialog.setVisible(true);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
	}
	
	public void nextScreen() {
		this.getPersonalInfo(userID);
		MainFrame mainFrame = new MainFrame(actionHandler, this);
		mainFrame.intalize(campusID, userName, hour);
		mainFrame.setVisible(true);
	}

	public void getPersonalInfo(String ID) {
		Register_Control register_Control = new Register_Control();
		Register_CValue register_Value = register_Control.getPersonalInfo(ID);
		this.userName = register_Value.getName();
		this.campusID = register_Value.getCampus();
		this.hour = register_Value.getHour();
	}
	
	public void changePointer(LoginDialog loginDialog) {
		this.loginDialog = loginDialog;
	}

	public void loginOk() {
		try {
			userID = loginDialog.Validate();
			if (userID != null) {
				nextScreen();
				loginDialog.dispose();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void findID() {
		IDPanel iDPanel = new IDPanel();
	}
	
	public void findPW() {
		PWPanel pWPanel = new PWPanel();
	}

	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("okBtton")) {
				loginOk();
			}else if(event.getActionCommand().equals("idButton")) {
				findID();
			} else {
				findPW();
			}
		}
	}
	
}