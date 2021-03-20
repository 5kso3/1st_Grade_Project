package Control;
import Model.Register_Entity;
import ValueObject.Register_CValue;
import ValueObject.Register_EValue;

public class Register_Control {
	private Register_Entity register_Entity;
	
	public Register_Control() {
		this.register_Entity = new Register_Entity();
	}

	public Register_CValue getPersonalInfo(String ID) {
		Register_CValue register_CValue = new Register_CValue();
		Register_EValue register_EValue = register_Entity.getPersonalInfo(ID);
		register_CValue.setId(register_EValue.getId());
		register_CValue.setName(register_EValue.getName());
		register_CValue.setCampus(register_EValue.getCampus());
		register_CValue.setHour(register_EValue.getHour());
		return register_CValue;
	}
}
