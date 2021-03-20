package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ID_Entity {

	public String Validate(String name, String birthday) {
		try {
			File file = new File("resource/user.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String id = scanner.next();
				String Name = scanner.next();
				String Birthday = scanner.next();
				if (Name.matches(name)) {
					if (Birthday.matches(birthday)) {
						return id;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean getID(String id, String birthday) {
		try {
			File file = new File("resource/user.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String ID = scanner.next();
				String Name = scanner.next();
				String Birthday = scanner.next();
				if (ID.matches(id)) {
					if (Birthday.matches(birthday)) {
						return true;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}
