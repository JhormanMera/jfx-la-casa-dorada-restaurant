package model;

public class Employee extends Person  {

	private static final long serialVersionUID = 1L;	
	private String ID;
	private boolean state;
	
	public Employee(String name, String lastname, String ID) {
		super(name, lastname);
		this.ID=ID;
		this.state=true;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getStateEmployee(){
		String enable="";
		if(state) {
			enable="Enable";
		}else {
			enable="Disable";
		}
		return enable;
	}
	
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	
	
}
