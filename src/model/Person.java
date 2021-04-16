package model;

import java.io.Serializable;

public abstract class Person implements Serializable {

	private static final long serialVersionUID = -7223714510283829008L;
	private String name;
	private String lastname;
	private User lastEditor;
	private User creator;
	
	public Person(String name, String lastname, User lastEditor, User creator) {
		this.name = name;
		this.lastname = lastname;
		this.creator=creator;
		this.lastEditor=lastEditor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public User getLastEditor() {
		return lastEditor;
	}
	public void setLastEditor(User lastEditor) {
		this.lastEditor = lastEditor;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	
}
