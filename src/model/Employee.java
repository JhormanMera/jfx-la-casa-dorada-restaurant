package model;

public class Employee extends Person  {

	private static final long serialVersionUID = -1264442306796036178L;
	private String ID;
	private boolean state;
	
	public Employee(String name, String lastname, String ID, User creator, User lastEditor,boolean state) {
		super(name, lastname, lastEditor, creator);
		this.ID=ID;
		this.state=state;
	}
	public Employee(String ID,User lastEditor, User creator) {
		super(" ", " ", lastEditor, creator);
		this.ID=ID;
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
	
	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	
	
}
