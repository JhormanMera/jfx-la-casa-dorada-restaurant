package model;

import java.io.Serializable;
import java.util.ArrayList;

public class BaseProduct implements Serializable {

	private static final long serialVersionUID = 3581140027854608222L;
	private String name;
	private ProductType type;
	private ArrayList<Ingredients> ingredients;
	private boolean state;
	
	public BaseProduct(String name, ProductType type, ArrayList<Ingredients> ingredients) {
		this.name = name;
		this.type = type;
		this.ingredients = ingredients;
		this.state=true;
		
	}
	public BaseProduct(String name) {
		this.name=name;
	}
	public boolean searchIngredientInto(Ingredients in) {
		boolean found=false;
		if(in!=null) {
			for(int i=0;i<ingredients.size()&&!found;i++) {
				if(ingredients.get(i).equals(in)) {
					found=true;
				}
			}
		}
		return found;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTypeName() {
		String name=type.getName();
		return name;
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
	
	public void setIngredients(Ingredients ingredients) {
		this.ingredients.add(ingredients);
	}
	
	public String getIngredientsName() {
		String names=ingredients.get(0).getName();
		for(int i=1;i<ingredients.size();i++) {
			names+=" , "+ingredients.get(i).getName();
		}
		return names;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	
}
