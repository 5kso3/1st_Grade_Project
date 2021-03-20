package ValueObject;

import java.util.Vector;

import Data.ClassData;
import Data.DataFile;

public class ClassData_CValue {
	private Vector<ClassData> dataFileVector;

	public Vector<ClassData> getClassDataVector() {
		return dataFileVector;
	}

	public void setDataFileVector(Vector<ClassData> dataFileVector) {
		this.dataFileVector = dataFileVector;
	}
}
