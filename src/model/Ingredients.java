package model;

import java.io.Serializable;

public class Ingredients implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private User creator;
	private User lastEditor;
	private boolean state;	
	
	

	public Ingredients(String name, User creator, User lastEditor) {
		this.name = name;
		this.creator = creator;
		this.lastEditor = creator;
		this.state = true;
	}

	public String getStateIngredient(){
		String enable="";
		if(state) {
			enable="Enable";
		}else {
			enable="Disable";
		}
		return enable;
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

	public boolean getState() {
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
