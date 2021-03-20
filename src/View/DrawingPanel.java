package View;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingPanel extends GBLPanel {
	private static final long serialVersionUID = 1L;
	private PersonalInfoPanel personalInfo;
	private WorkingPanel workingPanel;
	private String name;
	private GridBagLayout gridBag;
	private boolean flag;
	
	DrawingPanel(ActionListener actionHandler) {
		this.flag = false;
		this.gridBag = new GridBagLayout();
		this.setLayout(gridBag);

		this.personalInfo = new PersonalInfoPanel(actionHandler);
		gridBagInsert(gridBag, personalInfo, 0, 0, 1, 0.05);

		this.workingPanel = new WorkingPanel();
		gridBagInsert(gridBag, workingPanel, 0, 2, 1, 0.95);
	}

	public void setPersonalInfo(String userName) {
		this.name = userName;
		this.workingPanel.setPersonalInfo(userName);
	}

	public void loginSucess() {
		this.personalInfo.setPersonalInfo(name);
		this.personalInfo.loginSucess();
	}

	public void showDetail() {
		personalInfo.showDetailFrame(workingPanel.getClassVector());
	}
	
	public void showFriend() {
		personalInfo.showFriendFrame();
	}

	public void changeTheme() {
		if(!flag) {
			personalInfo.changeTheme();
			workingPanel.changeTheme();
			flag = true;
		} else {
			personalInfo.changeOrigin();
			workingPanel.changeOrigin();
			flag = false;
		}
	}
	
	public void initalize(int campusID, int hour) {
		this.workingPanel.initalize(campusID, hour);
		personalInfo.changeOrigin();
		workingPanel.changeOrigin();
	}

	public void showFriendTable() {
		personalInfo.showFriendTable();
	}
}