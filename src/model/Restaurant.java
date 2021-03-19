package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Restaurant {
	private static final String PEOPLE_SAVE_PATH_FILE="";
	private static final String CUSTOMES_SAVE_PATH_FILE="";
	private static final String INGREDIENTS_SAVE_PATH_FILE="";
	private static final String PRODUCTS_SAVE_PATH_FILE="";
	private static final String ORDERS_SAVE_PATH_FILE="";
	private static final String PRODUCT_TYPE_SAVE_PATH_FILE="";
	//private static final String ORDER_CODE= String.format("P%04d", 100);
	private static final String FILE_SEPARATOR=";";
	private static List<Custome> customes;
	private static List<Person> people;
	private static List<Ingredients> ingredients;
	private static List<Product> products;
	private static List<ProductType> productType;
	private static List<Order> orders;
	private static List<Employee> employees;
	private static List<User> users;
	
	
	
	public Restaurant() {
		customes = new ArrayList<>();
		people= new ArrayList<>();
		ingredients=new ArrayList<>();
		products = new ArrayList<>();	
		orders = new ArrayList<>();
		employees=new ArrayList<>();
		users=new ArrayList<>();
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
    
    
    public void sortByIngredients() {
		for(int i=0; i<ingredients.size(); i++) {
			int posMin=i;
			for(int j=i+1; j<ingredients.size(); j++) {
				if(ingredients.get(j).getName().compareTo(ingredients.get(posMin).getName())>0) {
					posMin=j;
				}

			}
			Ingredients aux=ingredients.get(i);
			ingredients.set(i,ingredients.get(posMin));
			ingredients.set(posMin,aux);

		}

    }
    
    public static void SortProductsByPrice() {
    	for(int i=0;i<products.size();i++) {
    		for(int j=i;j>0&&products.get(j-1).getPrice()>products.get(j).getPrice();j--) {
    			Product temp=products.get(j);
    			products.set(j,products.get(j-1));
    			products.set(j-1,temp);
    		}
    	}
    }
    
    public static void addCustomesListSorted(String name, String lastname, String ID, String address, String phone, String observations) {
    	Custome newCustome=new Custome(name, lastname, ID, address, phone, observations);
    	if(customes.isEmpty()) {
    		customes.add(newCustome);
    	}else{
    		int i=0;
    		while(i<customes.size() && newCustome.getLastname().compareTo(customes.get(i).getLastname())<0) {
    			i++;
    		}
    		customes.add(i, newCustome);
    		people.add(newCustome);
    	}
    }
    public static void addOrder (String state, String code, Custome custome, Employee employee, Date date, String observation, User creator, User lastEditor) {
    	Order newOrder =new Order( state,  code,  custome,  employee,  date,  observation,  creator,  lastEditor);
    	//newOrder.setProducts(null);
    	//newOrder.setAmount();
    	orders.add(newOrder);
    }
    public static void addProductType(String name, User creator, User lastEditor) {
    	productType.add(new ProductType(name, creator, lastEditor));
    }
    public static void addEmployee(String name, String lastname, String ID) {
    	people.add(new Employee(name, lastname, ID));
    	employees.add(new Employee(name, lastname, ID));
    }
    public static void addUser(String name, String lastName, String ID, String userName, String password) {
    	people.add(new User(name, lastName, ID, userName, password));
    	users.add(new User(name, lastName, ID, userName, password));
    }
    public static void addProduct(String name, ProductType type, boolean available, double price, String productSize, User creator, User lastEditor) {
    	products.add(new Product(name, type, available, price, productSize, creator, lastEditor));
    }
    public static void addIngredients(String name, User creator, User lastEditor) {
    	ingredients.add(new Ingredients(name, creator, lastEditor));
    }
    public static void employeesOrdersReport(String fileName) throws FileNotFoundException {
    	PrintWriter writer = new PrintWriter (fileName);
		for (int i=0;i<employees.size();i++) {
			for(int j=0;j<orders.size();j++) {
			Employee myEmployee =employees.get(i);
			double[] employeeOrder= employeesOrders(myEmployee,orders.get(j));
			writer.println("The employee "+myEmployee.getName()+" "+myEmployee.getLastname()+"with ID"+myEmployee.getID()+" sold "+employeeOrder[0]+" orders with a total price of: "+employeeOrder[1]);
			}
		}
		writer.close();
    }
    public static double[] employeesOrders(Employee employee, Order order) {
    	double[] orders=new double[2];
    	double ordernum=0;
    	double orderprice=0.0;
    	if(employee==order.getEmployee()) {
    		ordernum++;
    		for(int i=0;i<order.getProducts().size();i++) {
    			orderprice+=order.getAmount().get(i)*order.getProducts().get(i).getPrice();
    		}
    	}
    	orders[0]=ordernum;
    	orders[1]=orderprice;
    	return orders;
    }
    public static boolean searchProductsInOrders(Product product) {
    	boolean found=false;
    	for(int i=0;i<orders.size()&&!found;i++) {
    		for(int j=0;j<orders.get(i).getProducts().size()&&!found;j++) {
    			if(product==orders.get(j).getProducts().get(j)&&(orders.get(i).getState()=="Solicitado"||orders.get(j).getState()=="En Proceso")) {
    				found=true;
    			}
    		}
    	}   
    	return found;
    }
    public static int searchProduct(String name,String size) {
    	int index=-10;
    	boolean flag=false;
    	for(int i=0;i<products.size()&&!flag;i++) {
    		if(products.get(i).getName().equalsIgnoreCase(name)&&products.get(i).getProductSize().equalsIgnoreCase(size)) {
    			index=i;
    			flag=true;
    		}
    	}
    	return index;
    }
    public static void eraseProduct(String name,String size) {    	
    	boolean erased=false;
    	int i=searchProduct(name,size);
    	if (i>=0) {
    		boolean found=searchProductsInOrders(products.get(i));
    		if(found==false) {
    			products.remove(i);
    			erased=true;
    		}
    	}   		
    			
    	if(erased==true) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erase Product");
			alert.setContentText("Product Erased Successfully");
			alert.showAndWait();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erase Product");
			alert.setContentText("An error has occurred when removing the product, the product does not exist or is part of an order Requested / In process");
			alert.showAndWait();
    	}
    }
    public static boolean searchIngredientInProducts(Ingredients ingredient) {
    	boolean found=false;
    	for(int i=0;i<products.size()&&found;i++) {
    		for(int k=0;k<products.get(i).getIngredients().size();k++) {
    			if(ingredient==products.get(i).getIngredients().get(k)) {
    				found=true;
    			}    			
    		}
    	}
    	return found;
    }
    public static void eraseIngredient(String name) {
    	boolean erased=false;    	
    	for(int i=0;i<ingredients.size()&&!erased;i++) {
    		boolean found=searchIngredientInProducts(ingredients.get(i));
    		if(ingredients.get(i).getName().equalsIgnoreCase(name)&&found==false) {
    			ingredients.remove(i);
    			erased=true;
    			}    			
    		}
    	if(erased==true) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erase Ingredients");
			alert.setContentText("Ingredient Erased Successfully");
			alert.showAndWait();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erase Ingredients");
			alert.setContentText("An error has occurred when removing the Ingredient, the ingredient does not exist or is part of a product/order Requested / In process");
			alert.showAndWait();
    	}
    }
    public static boolean searchTypeInProducts(ProductType type) {
    	boolean found=false;
    	for(int i=0;i<products.size()&&found;i++) {
    			if(type==products.get(i).getType()) {
    				found=true;
    			}    			
    		}
    	return found;
    }
    public static void eraseProductType(String name) {
    	boolean erased=false;    	
    	for(int i=0;i<productType.size()&&!erased;i++) {
    		boolean found=searchTypeInProducts(productType.get(i));
    		if(productType.get(i).getName().equalsIgnoreCase(name)&&found==false) {
    			productType.remove(i);
    			erased=true;
    			}    			
    		}
    	if(erased==true) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erase Product Type");
			alert.setContentText("Product Type Erased Successfully");
			alert.showAndWait();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erase Product Type");
			alert.setContentText("An error has occurred when removing the ProductType, the ProductType does not exist or is part of a product");
			alert.showAndWait();
    	}
    }
    public static void stateProduct(String name,String size,boolean state) {
    	int index=searchProduct(name,size);
    	boolean found=false;
    	if(index>=0) {
    		found=true;
    		products.get(index).setAvailable(state);
    	}
    	if(found==true) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("State Product");
			alert.setContentText("Product state has changed Successfully");
			alert.showAndWait();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("State Product");
			alert.setContentText("An error has occurred changing the Product's state, the Product does not exist");
			alert.showAndWait();
    	}
    }
    public static void stateProductType(String name,boolean state) {
    	boolean found=false;
    	for(int i=0;i<productType.size()&&!found;i++) {
    		if(productType.get(i).getName().equalsIgnoreCase(name)) {
    			productType.get(i).setState(state);
    			found=true;
    			}    			
    		}
    	if(found==true) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("State Product Type");
			alert.setContentText("Product type state has changed Successfully");
			alert.showAndWait();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("State Product Type");
			alert.setContentText("An error has occurred changing the Product-Type's state, the Product type does not exist");
			alert.showAndWait();
    	}
    }
    public static void stateIngredient(String name, boolean state) {
    	boolean found=false;
    	for(int i=0;i<ingredients.size()&&!found;i++) {
    		if(ingredients.get(i).getName().equalsIgnoreCase(name)) {
    			ingredients.get(i).setState(state);
    			found=true;
    			}    			
    		}
    	if(found==true) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("State Ingredient");
			alert.setContentText("Ingredient state has changed Successfully");
			alert.showAndWait();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("State Ingredient");
			alert.setContentText("An error has occurred changing the Ingredient's state, the Ingredient does not exist");
			alert.showAndWait();
    	}
    }
  /*  public void importCustomes (String fileName) throws IOException{
		BufferedReader br = new BufferedReader (new FileReader(fileName));
		String line = br.readLine();
		while (line!=null) {
			String [] parts = line.split(";");
			addContact(parts[0],parts[1]);
			line = br.readLine();
		}
		br.close();

	}
    public void importProducts (String fileName) throws IOException{
		BufferedReader br = new BufferedReader (new FileReader(fileName));
		String line = br.readLine();
		while (line!=null) {
			String [] parts = line.split(";");
			addContact(parts[0],parts[1]);
			line = br.readLine();
		}
		br.close();

	}
	*/
    public void importOrders (String fileName) throws IOException{
		BufferedReader br = new BufferedReader (new FileReader(fileName));
		String line = br.readLine();
		while (line!=null) {
			//String [] parts = line.split(";");
			
			//addOrder(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],parts[8]);
			line = br.readLine();
		}
		br.close();

	}
	public void exportOrders(String fileName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter (fileName);
		for (int i=0;i<orders.size();i++) {
			Order myOrder = orders.get(i);
			writer.println(myOrder.getState()+FILE_SEPARATOR+myOrder.getCode()+FILE_SEPARATOR+myOrder.getCustome().getLastname()
					+FILE_SEPARATOR+myOrder.getCustome().getName()+FILE_SEPARATOR+myOrder.getEmployee().getID()+FILE_SEPARATOR+myOrder.getDate()
					+FILE_SEPARATOR+myOrder.getObservation()+FILE_SEPARATOR+myOrder.getCreator().getUserName()+FILE_SEPARATOR+myOrder.getLastEditor().getUserName());
		}
		writer.close();
	}
    /*
    public static String binarySearch(String name, String lastName) {
		Custome a=null;
		Custome b=null;
		int start =0;
		int finish=customes.size()-1;
		boolean end=true;
		for (int i=0;i<customes.size() && end;i++) {
			a=customes.get(i);
			while (start<= finish&&end) {
				int mid=(start+finish)/2;
				if(a) {
					finish=mid-1;
				}else if(a>array[mid]) {
					start=mid+1;
				}else {
					b=array[i];
					end=false;
				}
			}
		}
		return c;
	}*/


  }

