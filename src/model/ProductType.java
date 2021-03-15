package model;

public class ProductType {
	private String name;
	private User creator;
	private User lastEditor;
	private boolean state;	
	

	public ProductType(String name, User creator, User lastEditor) {
		this.name = name;
		this.creator = creator;
		this.lastEditor = creator;
		this.state = true;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getLastEditor() {
		return lastEditor;
	}

	public void setLastEditor(User lastEditor) {
		this.lastEditor = lastEditor;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
