package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import ValueObject.ClassData_EValue;

public class ClassData_Entity {

	public ClassData_EValue getDataFile(String fileName) {
		ClassData_EValue classData_EValue = new ClassData_EValue();
		try {
			File file = new File("text/"+fileName);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				classData_EValue.readFromFile(scanner);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return classData_EValue;
	}

}
