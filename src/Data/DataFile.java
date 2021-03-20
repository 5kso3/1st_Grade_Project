package Data;

import java.util.Scanner;

public class DataFile {
	private String id;
	private String name;
	private String fileName;
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileName() {
		return this.fileName;
	}
	public void readFromFile(Scanner scanner) {
		this.id = scanner.next();
		this.name = scanner.next();
		this.fileName = scanner.next();
	}
}
