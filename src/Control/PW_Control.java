package Control;

import Model.PW_Entity;

public class PW_Control {
	
	private PW_Entity pW_Entity;
	
	public PW_Control() {
		this.pW_Entity = new PW_Entity();
	}

	public String getPW(String foundID) {
		return this.pW_Entity.getPW(foundID);
	}

}
