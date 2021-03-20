package Control;

import Model.ClassData_Entity;
import ValueObject.ClassData_CValue;
import ValueObject.ClassData_EValue;

public class ClassData_Control {
	private ClassData_Entity classData_Entity;

	public ClassData_Control() {
		this.classData_Entity = new ClassData_Entity();
	}
	
	public ClassData_CValue getClassData(String fileName) {
		ClassData_CValue classData_CValue = new ClassData_CValue();
		ClassData_EValue classData_EValue = classData_Entity.getDataFile(fileName);
		classData_CValue.setDataFileVector(classData_EValue.getDataFileVector());
		return classData_CValue;
	}
}
