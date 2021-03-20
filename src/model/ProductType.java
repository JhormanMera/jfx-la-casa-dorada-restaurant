package model;

import java.io.Serializable;

public class ProductType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String code;
	private User creator;
	private User lastEditor;
	private boolean state;	
	

	public ProductType(String name,String code ,User creator, User lastEditor) {
		this.name = name;
		this.code=code;
		this.creator = creator;
		this.lastEditor = creator;
		this.state = true;
	}
	

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
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
