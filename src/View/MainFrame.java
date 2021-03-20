package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import Global.Constants.EMainFrame;
import Global.GraphicsConstants.GMainFrmae;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private DrawingPanel DrawingPanel;
	private ActionListener mainActionListener;
	private Main main;

	public MainFrame(ActionListener mainActionHandler, Main main) {
		this.main = main;
		this.mainActionListener = mainActionHandler;
		ActionHandler actionHandler = new ActionHandler();
		// attribute
		this.setTitle(EMainFrame.eTitle.getString());
		this.setSize(GMainFrmae.width.getValue(), GMainFrmae.height.getValue());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		// components
		this.DrawingPanel = new DrawingPanel(actionHandler);
		this.add(this.DrawingPanel);
	}

	public void intalize(int campusID, String userName, int hour) {
		this.DrawingPanel.setPersonalInfo(userName);
		this.DrawingPanel.loginSucess();
		this.DrawingPanel.initalize(campusID, hour);
	}

	private void logout() {
		this.dispose();
	}

	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("detailButton")) {
				DrawingPanel.showDetail();
			} else if (e.getActionCommand().equals("friendButton")) {
				DrawingPanel.showFriend();
			} else if (e.getActionCommand().equals("themeButton")) {
				DrawingPanel.changeTheme();
			} else if(e.getActionCommand().equals("logoutButton")) {
				LoginDialog loginDialog = new LoginDialog(mainActionListener, main);
				loginDialog.setVisible(true);
				main.changePointer(loginDialog);
				logout();
			} else {
				DrawingPanel.showFriendTable();
			}
		}
	}
}