package ValueObject;

import java.util.Scanner;
import java.util.Vector;

import Data.DataFile;

public class DataFile_EValue {
	private Vector<DataFile> dataFileVector;
	
	public DataFile_EValue() {
		this.dataFileVector = new Vector<DataFile>();
	}
	public void readFromFile(Scanner scanner) {
		DataFile dataFile = new DataFile();
		dataFile.readFromFile(scanner);
		this.dataFileVector.add(dataFile);
	}
	
	public Vector<DataFile> getDataFileVector(){
		return this.dataFileVector;
	}
	
}
