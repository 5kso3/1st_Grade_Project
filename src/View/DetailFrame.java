package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Data.ClassData;

public class DetailFrame extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTable classTable;
	private String[] tableHeader = {"강의명", "교수", "학점", "시간"};
	private String[][] tableContents;
	
	public void showTable(Vector<ClassData> classVector) {
		int i = 0;
		tableContents = new String[classVector.size()][4];
		for (ClassData classData : classVector) {
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
		this.classTable.setModel(model);
		repaint();
	}
	
	public DetailFrame(Vector<ClassData> classVector) {
		super();
		this.setSize(500,500);
		this.setTitle("강의 세부사항");
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1,1));
		
		this.classTable = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(classTable);
		scrollPane.setPreferredSize(new Dimension(1, 1));
		this.add(scrollPane);
		
		this.showTable(classVector);
		
		this.setVisible(true);
	}
}
 