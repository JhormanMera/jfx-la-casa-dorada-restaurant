package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private static final String PEOPLE_SAVE_PATH_FILE="";
	private static final String CUSTOMES_SAVE_PATH_FILE="";
	private static final String INGREDIENTS_SAVE_PATH_FILE="";
	private static final String PRODUCTS_SAVE_PATH_FILE="";
	private static final String ORDERS_SAVE_PATH_FILE="";
	private static final String PRODUCT_TYPE_SAVE_PATH_FILE="";
	private static List<Custome> customes;
	private static List<Person> people;
	private static List<Ingredients> ingredients;
	private static List<Product> products;
	private static List<ProductType> productType;
	private static List<Order> orders;
	
	
	
	public Restaurant() {
		customes = new ArrayList<>();
		people= new ArrayList<>();
		ingredients=new ArrayList<>();
		products = new ArrayList<>();	
		orders = new ArrayList<>();
	}
	
	public void savePeople() throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PEOPLE_SAVE_PATH_FILE));
       oos.writeObject(people);
       oos.close();
    }

    @SuppressWarnings("unchecked")
    public void loadPeople() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PEOPLE_SAVE_PATH_FILE));
       people = (List<Person>) ois.readObject();
        ois.close();
    }
    public void saveCustomes() throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CUSTOMES_SAVE_PATH_FILE));
       oos.writeObject(customes);
       oos.close();
    }

    @SuppressWarnings("unchecked")
    public void loadCustomes() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CUSTOMES_SAVE_PATH_FILE));
       customes = (List<Custome>) ois.readObject();
        ois.close();
    }
    public void saveOrders() throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ORDERS_SAVE_PATH_FILE));
       oos.writeObject(orders);
       oos.close();
    }

    @SuppressWarnings("unchecked")
    public void loadOrders() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ORDERS_SAVE_PATH_FILE));
       orders = (List<Order>) ois.readObject();
        ois.close();
    }
    public void saveProducts() throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PRODUCTS_SAVE_PATH_FILE));
       oos.writeObject(products);
       oos.close();
    }

    @SuppressWarnings("unchecked")
    public void loadProducts() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRODUCTS_SAVE_PATH_FILE));
       products = (List<Product>) ois.readObject();
        ois.close();
    }
    public void saveProductType() throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PRODUCT_TYPE_SAVE_PATH_FILE));
       oos.writeObject(productType);
       oos.close();
    }

    @SuppressWarnings("unchecked")
    public void loadProductType() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRODUCT_TYPE_SAVE_PATH_FILE));
       productType = (List<ProductType>) ois.readObject();
        ois.close();
    }
    public void saveIngredients() throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INGREDIENTS_SAVE_PATH_FILE));
       oos.writeObject(ingredients);
       oos.close();
    }

    @SuppressWarnings("unchecked")
    public void loadIngredients() throws FileNotFoundException, IOException, ClassNotFoundException {
       ObjectInputStream ois = new ObjectInputStream(new FileInputStream(INGREDIENTS_SAVE_PATH_FILE));
       ingredients = (List<Ingredients>) ois.readObject();
        ois.close();
    }
    
}
