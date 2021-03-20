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

public class SubjectPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JList<String> subjectList;
	private Vector<DataFile> dataFileVector;
	private Vector<String> listVector;

	SubjectPanel(ListSelectionListener listSelectionHandler) {
		this.setLayout(new GridLayout(1, 1));
		listVector = new Vector<String>();
		subjectList = new JList<String>();
		subjectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(subjectList);
		scrollPane.setPreferredSize(new Dimension(1, 1));
		subjectList.addListSelectionListener(listSelectionHandler);
		this.add(scrollPane);
	}

	public void setReadFile(String fileName) {
		this.dataFileVector = getDataFile(fileName);
	}

	public Vector<DataFile> getDataFile(String FileName) {
		DataFile_Control subject_Control = new DataFile_Control();
		DataFile_CValue subject_CValue = subject_Control.getDataFile(FileName);
		return subject_CValue.getDataFileVector();
	}

	public void setSubject() {
		listVector.removeAllElements();
		for (DataFile dataFile : this.dataFileVector) {
			listVector.add(dataFile.getName());
		}
		this.subjectList.setListData(listVector);
	}

	public void refresh(String fileName) {
		if (fileName != null) {
			this.setReadFile(fileName);
			this.setSubject();
			this.subjectList.setSelectedIndex(0);
			repaint();
		}
	}

	public String getSelectedFile() {
		if (subjectList.getSelectedIndex() != -1) {
			return dataFileVector.elementAt(subjectList.getSelectedIndex()).getFileName();
		} else {
			return null;
		}
	}

	public void changeTheme() {
		subjectList.setBackground(GColor.buttonColor.getValue());
	}

	public void changeOrigin() {
		subjectList.setBackground(GColor.defultPanelColor.getValue());
	}
}
