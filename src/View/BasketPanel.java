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

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Data.ClassData;
import Global.Constants.ETableHeader;
import Global.GraphicsConstants.GColor;

public class BasketPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private String[] tableHeader = { ETableHeader.eClass.getValue(), ETableHeader.eProfessor.getValue() };
	private String[][] tableContents;
	private Vector<ClassData> dataFileVector;
	private JTable basketTable;
	private File file;

	BasketPanel() {
		this.dataFileVector = new Vector<ClassData>();

		this.setLayout(new GridLayout(1, 1));
		this.basketTable = new JTable();
		basketTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(basketTable);
		scrollPane.setPreferredSize(new Dimension(1, 1));

		this.add(scrollPane);
	}

	public void setVector(Vector<ClassData> classVector) {
		boolean flag = false;
		for (ClassData classData : classVector) {
			for (ClassData originData : dataFileVector) {
				if (originData.getId().equals(classData.getId())) {
					flag = true;
				}
			}
			if (!flag) {
				dataFileVector.add(classData);
				flag = false;
			}
		}
		showBasket();
	}

	public void deletVector() {
		int[] row = basketTable.getSelectedRows();
		Vector<ClassData> ClassVector = new Vector<ClassData>();
		for (int i = 0; i < row.length; i++) {
			ClassVector.add(dataFileVector.elementAt(row[i]));
		}
		for (ClassData classData : ClassVector) {
			dataFileVector.remove(classData);
		}
		showBasket();
	}

	public void showBasket() {
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
		this.basketTable.setModel(model);
		repaint();
		this.save();
	}

	public Vector<ClassData> throwVector() {
		int[] row = basketTable.getSelectedRows();
		Vector<ClassData> ClassVector = new Vector<ClassData>();
		for (int i = 0; i < row.length; i++) {
			ClassVector.add(dataFileVector.elementAt(row[i]));
		}
		return ClassVector;
	}

	public Vector<ClassData> getVector() {
		return throwVector();
	}

	public void setPersonalInfo(String userName) {
		this.file = new File("basket/" + userName + ".cdv");
		this.readObject();
		this.showBasket();
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

	@SuppressWarnings("unchecked")
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

	public void selectIndex() {
		if (dataFileVector.size() != 0) {
			basketTable.setRowSelectionInterval(0, 0);
		}
	}

	public void changeTheme() {
		basketTable.setBackground(GColor.buttonColor.getValue());
	}

	public void changeOrigin() {
		basketTable.setBackground(GColor.defultPanelColor.getValue());
	}

	public void initalize() {
		this.selectIndex();
	}
}
