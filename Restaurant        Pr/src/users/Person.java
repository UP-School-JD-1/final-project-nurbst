package users;

public abstract class Person implements Runnable {

	public String name;
	public String tckn;
	public Gender gender;

	public Person(String name, String tckn, Gender gender) {
		this.name = name;
		this.tckn = tckn;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTckn() {
		return tckn;
	}

	public void setTckn(String tckn) {
		this.tckn = tckn;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}