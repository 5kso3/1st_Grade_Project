package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import Control.ClassData_Control;
import Data.ClassData;
import Global.Constants.ETableHeader;
import Global.GraphicsConstants.GColor;
import ValueObject.ClassData_CValue;

public class ClassPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Vector<ClassData> dataFileVector;
	private String[] tableHeader = {ETableHeader.eClass.getValue(), ETableHeader.eProfessor.getValue()};
	private String[][] tableContents;
	private JTable classTable;

	ClassPanel(ListSelectionListener listSelectionHandler) {
		this.dataFileVector = new Vector<ClassData>();
		
		this.setLayout(new GridLayout(1, 1));
		this.classTable = new JTable();
		classTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(classTable);
		scrollPane.setPreferredSize(new Dimension(1,1));
		
		this.add(scrollPane);
	}
	
	public void setReadFile(String fileName) {
		this.dataFileVector = getClassData(fileName);
	}
	
	private Vector<ClassData> getClassData(String fileName) {
		ClassData_Control classData_Control = new ClassData_Control();
		ClassData_CValue classData_CValue = classData_Control.getClassData(fileName);
		return classData_CValue.getClassDataVector();
	}

	public void setClass() {
		int i = 0;
		tableContents = new String[dataFileVector.size()][2];
		for (ClassData classData : this.dataFileVector) {
			tableContents[i][0] = classData.getName();
			tableContents[i][1] = classData.getProfessor();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(tableContents, tableHeader) {
			public boolean isCellEditable(int row, int column) {
			       return false;
			    }
		};
		this.classTable.setModel(model);
		repaint();
	}
	
	public Vector<ClassData> getVector() {
		int[] row = classTable.getSelectedRows();
		Vector<ClassData> ClassVector = new Vector<ClassData>();
		for(int i = 0; i < row.length; i++) {
			ClassVector.add(dataFileVector.elementAt(row[i]));
		}
		return ClassVector;
	}
	
	public Vector<ClassData> goBasket() {
		return getVector();
	}

	public void refresh(String fileName) {
		if (fileName != null) {
			this.setReadFile(fileName);
			this.setClass();
			repaint();
		}
	}

	public void changeTheme() {
		classTable.setBackground(GColor.buttonColor.getValue());
	}

	public void changeOrigin() {
		classTable.setBackground(GColor.defultPanelColor.getValue());
	}
}
