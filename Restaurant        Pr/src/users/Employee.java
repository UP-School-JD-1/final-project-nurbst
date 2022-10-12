package users;

public abstract class Employee extends Person {

	public Department department;

	public Employee(String name, String tckn, Gender gender, Department department) {
		super(name, tckn, gender);
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


}