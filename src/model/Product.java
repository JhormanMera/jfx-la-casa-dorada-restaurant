package model;

public class Product {
	/*
	 * El sistema debe estar en la capacidad de gestionar (crear, actualizar, eliminar y deshabilitar) todos los productos que ofrece. 
	 * Todo producto tiene un nombre, un tipo (plato principal, adicional o bebida -pero estos pueden variar-), un conjunto de ingredientes,
	 *  y tamaños con sus respectivos precios.
	 */
	private String name;
	private ProductType type;
	private Ingredients[] ingredients;
	
	public Product (String name, ProductType type, Ingredients[] ingredients) {
		this.setName(name);
		this.setType(type);
		this.setIngredients(ingredients);
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
	public Ingredients[] getIngredients() {
		return ingredients;
	}
	public void setIngredients(Ingredients[] ingredients) {
		this.ingredients = ingredients;
	}
}
