package model;

public class ProductSize {
	private String name;
	private String code;
	private User creator;
	private User lastEditor;
	
	public ProductSize(String name,String code, User creator, User lastEditor) {
		this.name = name;
		this.code=code;
		this.creator=creator;
		this.lastEditor=lastEditor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
}
