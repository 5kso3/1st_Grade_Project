package Data;

import java.io.Serializable;
import java.util.Scanner;

public class ClassData implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String professor;
	private int hour;
	private String date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void readFromFile(Scanner scanner) {
		this.id = scanner.next();
		this.name = scanner.next();
		this.professor = scanner.next();
		this.hour = scanner.nextInt();
		this.date = scanner.next();
	}
}
