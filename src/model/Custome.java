package model;


public class Custome   {
	
	private String name;
	private String lastName;
	private String ID;
	private String address;
	private String phone;
	private String observations;
	

	public Custome(String name, String lastName, String ID, String address, String phone, String observations) {
		this.name = name;
		this.lastName = lastName;
		this.ID=ID;
		this.address = address;
		this.phone=phone;
		this.observations=observations;
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

}


