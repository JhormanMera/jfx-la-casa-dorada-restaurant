package model;

public class User extends Employee {
	private static final long serialVersionUID = 1L;
	String userName;
	String password;
	boolean state; 
	
	public User(String name, String lastName, String ID, String userName, String password, User creator, User lastEditor,boolean state) {
		super(name, lastName, ID, creator,  lastEditor, state);
		this.userName = userName;
		this.password = password;
	}
	public User(String userName, User creator, User lastEditor) {
		super(" ", " ", " ", creator,  lastEditor, true);
		this.userName=userName;
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
