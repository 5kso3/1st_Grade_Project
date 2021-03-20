package ValueObject;

import java.util.Scanner;
import java.util.Vector;

import Data.ClassData;

public class ClassData_EValue {
	private Vector<ClassData> dataFileVector;

	public ClassData_EValue() {
		this.dataFileVector = new Vector<ClassData>();
	}
	
	public Vector<ClassData> getDataFileVector() {
		return this.dataFileVector;
	}

	public void readFromFile(Scanner scanner) {
		ClassData classData = new ClassData();
		classData.readFromFile(scanner);
		this.dataFileVector.add(classData);
	}
}
