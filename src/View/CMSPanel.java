package View;

import java.awt.GridBagLayout;

import javax.swing.event.ListSelectionListener;

public class CMSPanel extends GBLPanel {
	private static final long serialVersionUID = 1L;
	private CampusPanel campusPanel;
	private MajorPanel majorPanel;
	private SubjectPanel subjectPanel;
	private GridBagLayout gridBag;

	CMSPanel(ListSelectionListener listSelectionHandler) {
		this.gridBag = new GridBagLayout();
		this.setLayout(gridBag);

		this.campusPanel = new CampusPanel(listSelectionHandler);
		gridBagInsert(gridBag, campusPanel, 0, 0, 0.18, 1);

		this.majorPanel = new MajorPanel(listSelectionHandler);
		gridBagInsert(gridBag, majorPanel, 1, 0, 0.18, 1);

		this.subjectPanel = new SubjectPanel(listSelectionHandler);
		gridBagInsert(gridBag, subjectPanel, 2, 0, 0.18, 1);
	}

	public String refresh(Object src) {
		String fileName = null;
		if(src.equals(this.campusPanel.getList())) {
			fileName = this.campusPanel.getSelectedFile();
			this.majorPanel.refresh(fileName);
			fileName = this.majorPanel.getSelectedFile();
			this.subjectPanel.refresh(fileName);
			fileName = this.subjectPanel.getSelectedFile();
		} else if (src.equals(this.majorPanel.getList())){
			this.majorPanel.refresh(fileName);
			fileName = this.majorPanel.getSelectedFile();
			this.subjectPanel.refresh(fileName);
			fileName = this.subjectPanel.getSelectedFile();
		} else {
			this.subjectPanel.refresh(fileName);
			fileName = this.subjectPanel.getSelectedFile();
		}
		return fileName;
	}
	
	public void initalize(int campusID) {
		this.campusPanel.initalize(campusID);
	}

	public void changeTheme() {
		campusPanel.changeTheme();
		majorPanel.changeTheme();
		subjectPanel.changeTheme();
	}

	public void changeOrigin() {
		campusPanel.changeOrigin();
		majorPanel.changeOrigin();
		subjectPanel.changeOrigin();
	}
}
