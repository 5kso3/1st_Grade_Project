package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ValueObject.DataFile_EValue;

public class DataFile_Entity {

	public DataFile_EValue getDataFile(String fileName) {
		DataFile_EValue campus_EValue = new DataFile_EValue();
		try {
			File file = new File("text/"+fileName);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				campus_EValue.readFromFile(scanner);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return campus_EValue;
	}

}
