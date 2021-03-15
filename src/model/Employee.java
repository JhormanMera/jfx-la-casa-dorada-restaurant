package model;

public class Employee  {

	String name;
	String lastName;
	String ID;
	
	public Employee(String name, String lastName, String ID) {
		this.name = name;
		this.lastName = lastName;
		this.ID = ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	

}
