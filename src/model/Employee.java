package model;

public class Employee extends Person  {

	private static final long serialVersionUID = 1L;	
	private String ID;
	
	public Employee(String name, String lastname, String ID) {
		super(name, lastname);
		this.setID(ID);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	
	
}
