package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Data.ClassData;
import Global.Constants.EPersonalInfo;
import Global.GraphicsConstants.GColor;

public class PersonalInfoPanel extends GBLPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel insaLabel;
	private String userNanme;
	private JButton friendButton, detailButton, logoutButton, themeButton;
	private GridBagLayout gridBag; 
	private ActionListener actionListener;
	private FriendFrame friendFrame;
	
	public PersonalInfoPanel(ActionListener actionListener) {
		this.setBackground(Color.WHITE);
		this.gridBag = new GridBagLayout();
		this.setLayout(gridBag);
		this.actionListener = actionListener;
				
		this.userNanme = null;
		this.insaLabel = new JLabel();
		this.insaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.insaLabel.setPreferredSize(new Dimension(1,1));
		this.gridBagInsert(gridBag, insaLabel, 0, 0, 0.4, 1);
		
		this.friendButton = new JButton(EPersonalInfo.eFriendButton.getValue());
		this.friendButton.setToolTipText(EPersonalInfo.eFriendToolTip.getValue());
		this.friendButton.setActionCommand("friendButton");
		this.friendButton.addActionListener(actionListener);
		this.friendButton.setPreferredSize(new Dimension(1,1));
		this.gridBagInsert(gridBag, friendButton, 1, 0, 0.15, 1);
		
		this.detailButton = new JButton(EPersonalInfo.eDetailButton.getValue());
		this.detailButton.setToolTipText(EPersonalInfo.eDetailToolTip.getValue());
		this.detailButton.setActionCommand("detailButton");
		this.detailButton.addActionListener(actionListener);
		this.detailButton.setPreferredSize(new Dimension(1,1));
		this.gridBagInsert(gridBag, detailButton, 2, 0, 0.15, 1);
		
		this.themeButton = new JButton("테마변경");
		this.themeButton.setToolTipText("View의 색상을 변경");
		this.themeButton.setActionCommand("themeButton");
		this.themeButton.addActionListener(actionListener);
		this.themeButton.setPreferredSize(new Dimension(1,1));
		this.gridBagInsert(gridBag, themeButton, 3, 0, 0.15, 1);
		
		this.logoutButton = new JButton(EPersonalInfo.eLogoutButton.getValue());
		this.logoutButton.setActionCommand("logoutButton");
		this.logoutButton.addActionListener(actionListener);
		this.logoutButton.setPreferredSize(new Dimension(1,1));
		this.gridBagInsert(gridBag, logoutButton, 4, 0, 0.15, 1);
	}
	
	public void setPersonalInfo(String name) {
		this.userNanme = name;
	}
	
	public void loginSucess() {
		this.insaLabel.setText(userNanme+EPersonalInfo.eInsaPostfix.getValue());
	}
	
	public void showDetailFrame(Vector<ClassData> vector) {
		DetailFrame detailFrame = new DetailFrame(vector);
	}
	
	public void showFriendFrame() {
		friendFrame = new FriendFrame(actionListener);
	}

	public void showFriendTable() {
		friendFrame.showFriendTable();
	}

	public void changeTheme() {
		this.setBackground(GColor.buttonColor.getValue());
		this.friendButton.setBackground(GColor.buttonColor.getValue());
		this.detailButton.setBackground(GColor.buttonColor.getValue());
		this.themeButton.setBackground(GColor.buttonColor.getValue());
		this.logoutButton.setBackground(GColor.buttonColor.getValue());
	}

	public void changeOrigin() {
		this.setBackground(null);
		this.friendButton.setBackground(GColor.defultButtonColor.getValue());
		this.detailButton.setBackground(GColor.defultButtonColor.getValue());
		this.themeButton.setBackground(GColor.defultButtonColor.getValue());
		this.logoutButton.setBackground(GColor.defultButtonColor.getValue());
	}
}
