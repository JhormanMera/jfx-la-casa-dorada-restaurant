package model;

import java.io.Serializable;
import java.util.ArrayList;

public class BaseProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private ProductType type;
	private ArrayList<Ingredients> ingredients;
	
	public BaseProduct(String name, ProductType type, ArrayList<Ingredients> ingredients) {
		this.name = name;
		this.type = type;
		this.ingredients = ingredients;
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
	public void setIngredients(ArrayList<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}
	
	
}
