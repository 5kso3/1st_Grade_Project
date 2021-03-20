package Control;

import Model.ID_Entity;

public class ID_Control {
	private ID_Entity iD_Entity;

	public ID_Control() {
		this.iD_Entity = new ID_Entity();
	}
	public String Validate(String name, String birthday) {
		return this.iD_Entity.Validate(name, birthday);
	}
	public boolean getID(String id, String birthday) {
		return this.iD_Entity.getID(id, birthday);
	}
}
