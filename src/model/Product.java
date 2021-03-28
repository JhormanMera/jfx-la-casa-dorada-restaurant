package model;

import java.io.Serializable;

public class Product implements Serializable, Comparable<Product>{ 

	private static final long serialVersionUID = 1L;
	private BaseProduct baseProduct;
	private String code;
	private boolean state;
	private double price;
	private ProductSize size;
	private User creator;
	private User lastEditor;

	public Product(String code,BaseProduct baseProduct, boolean state, double price, ProductSize size, User creator, User lastEditor) {
		this.code=code;
		this.baseProduct = baseProduct;
		this.state = state;
		this.price = price;
		this.size = size;
		this.creator = creator;
		this.lastEditor = creator;
	}
	
	public String getName() {
		String name=baseProduct.getName();
		return name;
	}
	
	public String getSizeName() {
		String name=size.getName();
		return name;
	}
	
	public BaseProduct getBaseProduct() {
		return baseProduct;
	}
	
	public void setBaseProduct(BaseProduct baseProduct) {
		this.baseProduct = baseProduct;
	}
	
	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public ProductSize getSize() {
		return size;
	}
	
	public void setSize(ProductSize size) {
		this.size = size;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int compareTo(Product o) {
		return (int)(price-o.getPrice());
	}
	
}
