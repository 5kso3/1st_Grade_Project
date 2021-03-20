package Control;
import java.io.FileNotFoundException;

import Model.Login_Entity;

public class Login_Control {
	private Login_Entity login_Entity;
	
	public Login_Control() {
		this.login_Entity = new Login_Entity();
	}

	public boolean Validate(String ID, String Password) throws FileNotFoundException {
		return this.login_Entity.Validate(ID,Password);
	}
}
