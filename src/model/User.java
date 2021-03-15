package model;

public class User extends Employee {
	String userName;
	String password;
	
	public User(String name, String lastName, String ID, String userName, String password) {
		super(name, lastName, ID);
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
