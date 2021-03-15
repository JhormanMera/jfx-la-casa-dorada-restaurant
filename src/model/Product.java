package model;

import java.util.ArrayList;

public class Product{
	/*
	 * El sistema debe estar en la capacidad de gestionar (crear, actualizar, eliminar y deshabilitar) todos los productos que ofrece. 
	 * Todo producto tiene un nombre, un tipo (plato principal, adicional o bebida -pero estos pueden variar-), un conjunto de ingredientes,
	 *  y tamaños con sus respectivos precios.
	 */
	private String name;
	private ProductType type;
	private ArrayList<Ingredients> ingredients;
	private boolean available;
	private double price;
	private String productSize;
	
	public Product (String name, ProductType type, Ingredients ingredients, double price) {
		this.name=name;
		this.type=type;
		this.ingredients= new ArrayList<>();
		this.available=true;
		this.price=price;
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
		return productSize;
	}
	public void setProductSize(String productSize) {
		if (productSize.equalsIgnoreCase("")) {
			this.productSize = ProductSize.valueOf("").toString();
		} else if (productSize.equalsIgnoreCase("")) {
			this.productSize = ProductSize.valueOf("").toString();
		} else if (productSize.equalsIgnoreCase("")) {
			this.productSize = ProductSize.valueOf("").toString();
		} else if (productSize.equalsIgnoreCase("")) {
			this.productSize = ProductSize.valueOf("").toString();
		}
	}

}
