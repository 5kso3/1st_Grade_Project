package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import Control.DataFile_Control;
import Data.DataFile;
import Global.GraphicsConstants.GColor;
import ValueObject.DataFile_CValue;

public class MajorPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JList<String> majorList;
	private Vector<DataFile> dataFileVector;
	private Vector<String> listVector;

	MajorPanel(ListSelectionListener listSelectionHandler) {
		this.setLayout(new GridLayout(1, 1));
		majorList = new JList<String>();
		listVector = new Vector<String>();
		majorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		majorList.addListSelectionListener(listSelectionHandler);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(majorList);
		scrollPane.setPreferredSize(new Dimension(1, 1));
		this.add(scrollPane);
	}

	public void refresh(String fileName) {
		if (fileName != null) {
			this.setReadFile(fileName);
			this.setMajor();
			this.majorList.setSelectedIndex(0);
			repaint();
		}
	}

	public void setMajor() {
		listVector.removeAllElements();
		for (DataFile dataFile : this.dataFileVector) {
			listVector.add(dataFile.getName());
		}
		this.majorList.setListData(listVector);
	}

	public Vector<DataFile> getDataFile(String FileName) {
		DataFile_Control major_Control = new DataFile_Control();
		DataFile_CValue major_CValue = major_Control.getDataFile(FileName);
		return major_CValue.getDataFileVector();
	}

	public void setReadFile(String actionCommand) {
		this.dataFileVector = getDataFile(actionCommand);
	}

	public JList getList() {
		return this.majorList;
	}

	public String getSelectedFile() {
		if (majorList.getSelectedIndex() != -1) {
			return dataFileVector.elementAt(majorList.getSelectedIndex()).getFileName();
		} else {
			return null;
		}
	}

	public void changeTheme() {
		majorList.setBackground(GColor.buttonColor.getValue());
	}

	public void changeOrigin() {
		majorList.setBackground(GColor.defultPanelColor.getValue());
	}
}
