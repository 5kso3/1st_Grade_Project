package Control;

import Model.DataFile_Entity;
import ValueObject.DataFile_CValue;
import ValueObject.DataFile_EValue;

public class DataFile_Control {
	private DataFile_Entity campus_Entity;
	
	public DataFile_Control() {
		this.campus_Entity = new DataFile_Entity();
	}

	public DataFile_CValue getDataFile(String fileName) {
		DataFile_CValue campus_CValue = new DataFile_CValue();
		DataFile_EValue campus_EValue = campus_Entity.getDataFile(fileName);
		campus_CValue.setDataFileVector(campus_EValue.getDataFileVector());
		return campus_CValue;
	}
}
