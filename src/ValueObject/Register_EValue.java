package ValueObject;

import java.util.Scanner;

public class Register_EValue {
	
	private String id;
	private String name;
	private String birthday;
	private int campus;
	private int hour;
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void readFromFile(Scanner scanner) {
		this.id = scanner.next();
		this.name = scanner.next();
		this.birthday = scanner.next();
		this.campus = scanner.nextInt();
		this.hour = scanner.nextInt();
	}

	public int getCampus() {
		return campus;
	}

	public void setCampus(int campus) {
		this.campus = campus;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}