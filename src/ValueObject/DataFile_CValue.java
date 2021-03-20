package ValueObject;


import java.util.Vector;

import Data.DataFile;

public class DataFile_CValue {
	private Vector<DataFile> dataFileVector;
	
	public void setDataFileVector(Vector<DataFile> dataFileVector) {
		this.dataFileVector = dataFileVector;
	}

	public Vector<DataFile> getDataFileVector() {
		return dataFileVector;
	}
}
