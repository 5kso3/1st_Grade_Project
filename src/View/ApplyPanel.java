package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Data.ClassData;
import Global.Constants.ETableHeader;
import Global.GraphicsConstants.GColor;

public class ApplyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private String[] tableHeader = { ETableHeader.eClass.getValue(), ETableHeader.eProfessor.getValue() };
	private String[][] tableContents;
	private Vector<ClassData> dataFileVector;
	private JTable applyTable;
	private File file;
	private int hour;
	private int applyHour;

	ApplyPanel() {
		this.applyHour = 0;
		this.dataFileVector = new Vector<ClassData>();
		
		this.setLayout(new GridLayout(1, 1));
		this.applyTable = new JTable();
		applyTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(applyTable);
		scrollPane.setPreferredSize(new Dimension(1, 1));
		this.add(scrollPane);
	}

	public boolean goApply(Vector<ClassData> basketVector) {
		boolean flag = false;
		boolean isFail = false;
		for (ClassData classData : basketVector) {
			for (ClassData originData : dataFileVector) {
				if (originData.getId().equals(classData.getId())) {
					JOptionPane.showMessageDialog(this, "중복된 강좌입니다.");
					flag = true;
					isFail = true;
				}
			}
			if (!flag) {
				if(applyHour < hour) {
					dataFileVector.add(classData);
					applyHour = applyHour + classData.getHour();
				} else {
					JOptionPane.showMessageDialog(this, "신청가능한 학점 초과");
					isFail = true;
				}
			}
		}
		showApply();
		return isFail;
	}

	private void showApply() {
		int i = 0;
		tableContents = new String[dataFileVector.size()][2];
		for (ClassData classData : dataFileVector) {
			tableContents[i][0] = classData.getName();
			tableContents[i][1] = classData.getProfessor();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(tableContents, tableHeader) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
			       return false;
			    }
		};
		this.applyTable.setModel(model);
		repaint();
		this.save();
	}

	public void outApply() {
		int[] row = applyTable.getSelectedRows();
		Vector<ClassData> ClassVector = new Vector<ClassData>();
		for (int i = 0; i < row.length; i++) {
			ClassVector.add(dataFileVector.elementAt(row[i]));
		}
		for (ClassData classData : ClassVector) {
			dataFileVector.remove(classData);
			applyHour = applyHour - classData.getHour();
		}
		showApply();
		this.save();
	}

	public void setPersonalInfo(String userName) {
		this.file = new File("apply/" + userName + ".cdv");
		this.readObject();
		this.showApply();
	}

	public void save() {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(file)));
			objectOutputStream.writeObject(dataFileVector);
			objectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readObject() {
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(this.file)));
			Object object = objectInputStream.readObject();
			dataFileVector = (Vector<ClassData>) object;
			objectInputStream.close();
		} catch (IOException e2) {
			this.save();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public Vector<ClassData> getClassVector() {
		return this.dataFileVector;
	}
	
	public void changeTheme() {
		applyTable.setBackground(GColor.buttonColor.getValue());
	}

	public void changeOrigin() {
		applyTable.setBackground(GColor.defultPanelColor.getValue());
	}
	
	public Vector<ClassData> throwVector() {
		int[] row = applyTable.getSelectedRows();
		Vector<ClassData> ClassVector = new Vector<ClassData>();
		for(int i = 0; i < row.length; i++) {
			ClassVector.add(dataFileVector.elementAt(row[i]));
		}
		return ClassVector;
	}
	
	public void selectIndex() {
		if(dataFileVector.size() != 0) {
			applyTable.setRowSelectionInterval(0, 0);
		}
	}
	
	public Vector<ClassData> getVector() {
		return throwVector();
	}
	
	public void initalize(int hour) {
		this.hour = hour;
		for (ClassData classData : dataFileVector) {
			this.applyHour = applyHour + classData.getHour();
		}
		this.selectIndex();
	}
}
