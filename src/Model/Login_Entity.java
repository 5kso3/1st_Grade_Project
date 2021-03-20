package Model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login_Entity {

	public boolean Validate(String ID, String Password) throws FileNotFoundException {
		File IDfile = new File("resource/data.txt");
		Scanner scanner = new Scanner(IDfile);
		while (scanner.hasNextLine()) {
			String id = scanner.next();
			String PW = scanner.next();
			if (id.matches(ID)) {
				if (PW.matches(Password)) {
					return true;
				}
			}
		}
		scanner.close();
		return false;
	}
}
