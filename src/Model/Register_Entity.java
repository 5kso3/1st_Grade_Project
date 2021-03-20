package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ValueObject.Register_EValue;

public class Register_Entity {

	public Register_EValue getPersonalInfo(String ID) {
		Register_EValue register_EValue = new Register_EValue();
		try {
			File IDfile = new File("resource/user.txt");
			Scanner scanner = new Scanner(IDfile);
			while (scanner.hasNextLine()) {
				register_EValue.readFromFile(scanner);
				if (register_EValue.getId().equals(ID)) {
					return register_EValue;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
