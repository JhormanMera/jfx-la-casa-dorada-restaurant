package model;

public class ProductSize {
	private String name;
	private String code;
	private boolean state;
	private User creator;
	private User lastEditor;
	
	public ProductSize(String name,String code,boolean state ,User creator, User lastEditor) {
		this.name = name;
		this.code=code;
		this.state=state;
		this.creator=creator;
		this.lastEditor=lastEditor;
	}
	public ProductSize(String name) {
		this.name=name;
	}
	public String getStateSize(){
		String enable="";
		if(state) {
			enable="Enable";
		}else {
			enable="Disable";
		}
		return enable;
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

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
}
