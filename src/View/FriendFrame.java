package View;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Data.ClassData;
import Global.Constants.EFriendFrame;
import Global.GraphicsConstants.GFriendFrame;

public class FriendFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel;
	private JTextField nameText;
	private JButton searchButton;
	private JTable friendTable;
	private String[] tableHeader = {EFriendFrame.className.getValue(), EFriendFrame.professor.getValue(), EFriendFrame.grades.getValue(), EFriendFrame.date.getValue()};
	private String[][] tableContents;
	private Vector<ClassData> dataFileVector;
	private File file;
	private GBLPanel namePanel;
	private GridBagLayout gridBag;
	
	FriendFrame(ActionListener actionListener) {
		this.setSize(GFriendFrame.width.getValue(), GFriendFrame.height.getValue());
		this.gridBag = new GridBagLayout();
		this.setLayout(gridBag);
		this.setLocationRelativeTo(null);
		
		namePanel = new GBLPanel();
		nameLabel = new JLabel(EFriendFrame.nameLabel.getValue());
		namePanel.gridBagInsert(gridBag, nameLabel, 0, 0, 0.3, 1);
		nameText = new JTextField(10);
		namePanel.gridBagInsert(gridBag, nameText, 1, 0, 0.5, 1);
		searchButton = new JButton(EFriendFrame.searchButton.getValue());
		searchButton.addActionListener(actionListener);
		searchButton.setActionCommand("searchButton");
		namePanel.gridBagInsert(gridBag, searchButton, 2, 0, 0.2, 1);
		this.gridBagInsert(gridBag, namePanel, 0, 0, 1, 0);
		
		friendTable = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(friendTable);
		scrollPane.setPreferredSize(new Dimension(1, 1));
		this.gridBagInsert(gridBag, scrollPane, 0, 1, 0.8, 1);
		
		dataFileVector = new Vector<ClassData>();
		this.initalize();
		this.setVisible(true);
	}
	
	public void searchFriend() {
		file = new File("apply/"+nameText.getText()+".cdv");
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(file)));
			Object object = objectInputStream.readObject();
			dataFileVector = (Vector<ClassData>) object;
			objectInputStream.close();
		} catch (IOException e2) {
			JOptionPane.showMessageDialog(this, EFriendFrame.errorMassage.getValue());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	public void showFriendTable() {
		this.searchFriend();
		int i = 0;
		tableContents = new String[dataFileVector.size()][4];
		for (ClassData classData : dataFileVector) {
			tableContents[i][0] = classData.getName();
			tableContents[i][1] = classData.getProfessor();
			tableContents[i][2] = Integer.toString(classData.getHour());
			tableContents[i][3] = classData.getDate();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(tableContents, tableHeader) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
			       return false;
			    }
		};
		this.friendTable.setModel(model);
		repaint();
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
	
	public void initalize() {
		int i = 0;
		tableContents = new String[dataFileVector.size()][4];
		for (ClassData classData : dataFileVector) {
			tableContents[i][0] = classData.getName();
			tableContents[i][1] = classData.getProfessor();
			tableContents[i][2] = Integer.toString(classData.getHour());
			tableContents[i][3] = classData.getDate();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(tableContents, tableHeader);
		this.friendTable.setModel(model);
	}
}
