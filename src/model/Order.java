package model;

import java.util.ArrayList;

public class Order {
	
	private String state;
	private String code;
	private ArrayList<Product> products;
	private ArrayList<Integer> amount;
	private Custome custome;
	private Employee employee;
	private Date date;
	private String observation;
	
	
	public Order(Custome custome,Employee employee, Date date, String observation) {
		this.state = State.valueOf("REQUESTED").toString();
		this.code = String.format("P%04d", 100);
		this.products = new ArrayList<Product>();
		this.amount = new ArrayList<Integer>();
		this.custome = custome;
		this.employee = employee;
		this.date = date;
		this.observation = observation;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products.add(products);
	}

	public ArrayList<Integer> getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount.add(amount);
	}

	public Custome getCustome() {
		return custome;
	}

	public void setCustome(Custome custome) {
		this.custome = custome;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		if (state.equalsIgnoreCase("")) {
			this.state = State.valueOf("REQUESTED").toString();
		} else if (state.equalsIgnoreCase("")) {
			this.state = State.valueOf("IN_PROCESS").toString();
		} else if (state.equalsIgnoreCase("")) {
			this.state = State.valueOf("SENT").toString();
		} else if (state.equalsIgnoreCase("")) {
			this.state = State.valueOf("DELIVERED").toString();
		}
	}

	
}
