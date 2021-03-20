package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Control.DataFile_Control;
import Data.DataFile;
import Global.GraphicsConstants.GColor;
import ValueObject.DataFile_CValue;

public class CampusPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JList<String> campusList;
	private Vector<DataFile> dataFileVector;
	private Vector<String> listVector;

	CampusPanel(ListSelectionListener listSelectionHandler) {
		this.setLayout(new GridLayout(1, 1));
		campusList = new JList<String>();
		listVector = new Vector<String>();
		campusList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		campusList.addListSelectionListener(listSelectionHandler);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(campusList);
		scrollPane.setPreferredSize(new Dimension(1,1));
		this.add(scrollPane);
	}
	
	public void setReadFile(String actionCommand) {
		this.dataFileVector = getDataFile(actionCommand);
	}
	
	public void setCampus() {
		listVector.removeAllElements();
		for (DataFile dataFile : this.dataFileVector) {
			listVector.add(dataFile.getName());
		}
		this.campusList.setListData(listVector);
	}
	

	
	public Vector<DataFile> getDataFile(String FileName) {
		DataFile_Control campus_Control = new DataFile_Control();
		DataFile_CValue campus_CValue = campus_Control.getDataFile(FileName);
		return campus_CValue.getDataFileVector();
	}
	
	public JList getList() {
		return this.campusList;
	}
	
	public String getSelectedFile() {
		return dataFileVector.elementAt(campusList.getSelectedIndex()).getFileName();
	}

	public void initalize(int campusID) {
		this.setReadFile("root");
		this.setCampus();
		this.campusList.setSelectedIndex(campusID-1);
	}

	public void changeTheme() {
		campusList.setBackground(GColor.buttonColor.getValue());
	}

	public void changeOrigin() {
		campusList.setBackground(GColor.defultPanelColor.getValue());
	}
}
