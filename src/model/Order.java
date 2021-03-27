package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String state;
	private String code;
	private ArrayList<Product> products;
	private ArrayList<Integer> amount;
	private Custome custome;
	private Employee employee;
	private String day;
	private String hour;
	private Date date;
	private String observation;
	private User creator;
	private User lastEditor;
	private SimpleDateFormat objSDFHour;
	private SimpleDateFormat objSDFDay;
	
		public Order(String state, String code, ArrayList<Product> products, ArrayList<Integer> amount, Custome custome,Employee employee, Date date, String observation, User creator, User lastEditor) throws ParseException {
		objSDFHour= new SimpleDateFormat("HH:mm:ss");
		objSDFDay= new SimpleDateFormat("dd/MM/YYYY");
		setState(state);
		this.code = code;
		this.products = products;
		this.amount = amount;
		this.custome = custome;
		this.employee = employee;
		this.date=date;
		this.day = 	objSDFDay.format(date);
		this.hour= objSDFHour.format(date);
		this.observation = observation;
		this.creator = creator;
		this.lastEditor = lastEditor;
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getState() {
		String a="";
		if (state.equalsIgnoreCase("REQUESTED")) {
			a="REQUESTED";
		} else if (state.equalsIgnoreCase("IN_PROCESS")) {
			a="IN PROCESS";
		} else if (state.equalsIgnoreCase("SENT")){
			a= "SENT";
		} else if (state.equalsIgnoreCase("DELIVERED")){
			a= "DELIVERED";
		}
		return a;
	}

	public void setState(String state) {
		if (state.equalsIgnoreCase("REQUESTED")) {
			this.state = State.valueOf("REQUESTED").toString();
		} else if (state.equalsIgnoreCase("IN PROCESS") && this.state.equals(State.valueOf("REQUESTED").toString())) {
			this.state = State.valueOf("IN_PROCESS").toString();
		} else if (state.equalsIgnoreCase("SENT")&& this.state.equals(State.valueOf("IN_PROCESS").toString())) {
			this.state = State.valueOf("SENT").toString();
		} else if (state.equalsIgnoreCase("DELIVERED")&& this.state.equals(State.valueOf("SENT").toString())) {
			this.state = State.valueOf("DELIVERED").toString();
		}
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
