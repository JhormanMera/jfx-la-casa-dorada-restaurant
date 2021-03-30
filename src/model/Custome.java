package model;


public class Custome  extends Person {
	
	private static final long serialVersionUID = 1L;
	private String ID;
	private String address;
	private String phone;
	private String observations;
	private boolean state;
	
	public Custome(String name, String lastname, String ID, String address, String phone, String observations) {
		super(name, lastname);
		this.ID = ID;
		this.address = address;
		this.phone = phone;
		this.observations = observations;
		this.state=true;
	}
	public Custome(String name, String lastname) {
		super(name, lastname);
	}
	
	
	public String getStateCustome(){
		String enable="";
		if(state) {
			enable="Enable";
		}else {
			enable="Disable";
		}
		return enable;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getObservations() {
		return observations;
	}
	
	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	public boolean getState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
}


