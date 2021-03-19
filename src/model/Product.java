package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	private String name;
	private ProductType type;
	private ArrayList<Ingredients> ingredients;
	private boolean available;
	private double price;
	private String productSize;
	private User creator;
	private User lastEditor;
	
	
	public Product(String name, ProductType type, boolean available, double price, String productSize, User creator, User lastEditor) {
		this.name = name;
		this.type = type;
		this.ingredients = new ArrayList<>();
		this.available = available;
		this.price = price;
		setProductSize(productSize);
		this.creator = creator;
		this.lastEditor = creator;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductType getType() {
		return type;
	}
	public void setType(ProductType type) {
		this.type = type;
	}
	public ArrayList<Ingredients> getIngredients() {
		return ingredients;
	}
	public boolean eraseIngredient(String name) {
		boolean erased=false;
		for(int i=0;i<ingredients.size()&&!erased;i++) {
			if(name.equalsIgnoreCase(ingredients.get(i).getName())) {
				ingredients.remove(i);
				erased=true;
			}
		}
		return erased;
	}
	public void setIngredients(Ingredients ingredients) {
		this.ingredients.add(ingredients);
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductSize() {
		String size="";
		if (productSize.equalsIgnoreCase("PERSONAL")) {
			size = "Personal";
		} else if (productSize.equalsIgnoreCase("DUAL")) {
			size = "Para dos";
		}
		return size;
	}
	public void setProductSize(String productSize) {
		if (productSize.equalsIgnoreCase("Personal")) {
			this.productSize = ProductSize.valueOf("PERSONAL").toString();
		} else if (productSize.equalsIgnoreCase("Para dos")) {
			this.productSize = ProductSize.valueOf("DUAL").toString();
		}
	}

}
