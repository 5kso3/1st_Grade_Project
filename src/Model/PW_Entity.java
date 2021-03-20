package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PW_Entity {

	public String getPW(String foundID) {
		try {
			File file = new File("resource/data.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String id = scanner.next();
				String pw = scanner.next();
				if (id.matches(foundID)) {
					return pw;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
