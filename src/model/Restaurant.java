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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Restaurant {
	private static final String BASE_PRODUCT_SAVE_PATH_FILE="";
	private static final String CUSTOMES_SAVE_PATH_FILE="";
	private static final String INGREDIENTS_SAVE_PATH_FILE="";
	private static final String PRODUCTS_SAVE_PATH_FILE="";
	private static final String ORDERS_SAVE_PATH_FILE="";
	private static final String PRODUCT_TYPE_SAVE_PATH_FILE="";
	private static final String ORDER_CODE= String.format("P%04d", 100000);
	private static String FILE_SEPARATOR=";";
	private static String FILE_SEPARATOR_IMPORT=";";
	private User userLogged;
	private List<Custome> customes;
	private List<Ingredients> ingredients;
	private List<Product> products;
	private List<ProductType> productType;
	private List<Order> orders;
	private List<Employee> employees;
	private List<User> users;
	private List<BaseProduct> baseProducts;
	private List<ProductSize> productSize;
	private ArrayList<Ingredients> ingredientBP;
	private ArrayList<Product> productsOrder;
	private ArrayList<Integer> amountProductsOrder;
	private OrdersComparator oc;
	
	public Restaurant() {
		customes = new ArrayList<>();
		ingredients=new ArrayList<>();
		products = new ArrayList<>();	
		orders = new ArrayList<>();
		employees=new ArrayList<>();
		users=new ArrayList<>();
		baseProducts=new ArrayList<>();
		productSize=new ArrayList<>();
		ingredientBP=new ArrayList<>();
		productsOrder=new ArrayList<>();
		amountProductsOrder=new ArrayList<>();
	}
	
//-------------------------------------------------SEPARATOR---------------------------------------------------------------------
	
	public  String getFILE_SEPARATOR() {
		return FILE_SEPARATOR;
	}

	public void setFILE_SEPARATOR(String fILE_SEPARATOR) {
		FILE_SEPARATOR = fILE_SEPARATOR;
	}

//-------------------------------------SERIALIZABLE-----------------------------------------------------
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
	    public void saveBaseProducts() throws FileNotFoundException, IOException {
	        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BASE_PRODUCT_SAVE_PATH_FILE));
	       oos.writeObject(baseProducts);
	       oos.close();
	    }

	    @SuppressWarnings("unchecked")
	    public void loadBaseProducts() throws FileNotFoundException, IOException, ClassNotFoundException {
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BASE_PRODUCT_SAVE_PATH_FILE));
	        baseProducts = (List<BaseProduct>) ois.readObject();
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
	    public void saveProductSize() throws FileNotFoundException, IOException {
	        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INGREDIENTS_SAVE_PATH_FILE));
	       oos.writeObject(productSize);
	       oos.close();
	    }

	    @SuppressWarnings("unchecked")
	    public void loadProductSize() throws FileNotFoundException, IOException, ClassNotFoundException {
	       ObjectInputStream ois = new ObjectInputStream(new FileInputStream(INGREDIENTS_SAVE_PATH_FILE));
	       productSize = (List<ProductSize>) ois.readObject();
	        ois.close();
	    }

//---------------------------------------------------ORDER--------------------------------------------------------	    
	
	public List<Order> getOrders() {
		return orders;
	}
	    
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	  public void addOrder(String state, Custome custome,Employee employee, Date date, String observation, User creator, User lastEditor, ArrayList<Product> products, ArrayList<Integer> amount) throws ParseException {
	    	Order newOrder =new Order(state,ORDER_CODE, products,amount, custome, employee, date, observation, creator, lastEditor);
	    	orders.add(newOrder);
	    	sortOrderByDate();
	    }
	  
	  public int searchOrders(String code) {
	    	int myOrder = -10;
	    	boolean flag=false;
	    	for(int i=0;i<orders.size()&&!flag;i++) {
	    		if(orders.get(i).getCode().equals(code)) {
	    			myOrder=i;
	    			flag=true;
	    		}
	    	}
	    	return myOrder;
	    }
	  
	  public void sortOrderByDate() {
	    	this.oc= new OrdersComparator();
	    	Collections.sort(orders,oc);
	    }
	  
	  public void eraseOrder(String code) {    	
	    	boolean erased=false;
	    	int i=searchOrders(code);
	    	if (i>=0) {
	    			orders.remove(i);
	    			erased=true;
	    	}   		
	    			
	    	if(erased==true) {
	    		Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Erase Order");
				alert.setContentText("Order Erased Successfully");
				alert.showAndWait();
	    	}else {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erase Order");
				alert.setContentText("An error has occurred when removing the Order, the Order code doesn't exist");
				alert.showAndWait();
	    	}
	    }

//-------------------------------------------------CUSTOME-------------------------------------------------------	  
	  
	public List<Custome> getCustomes() {
	    return customes;
	}

	public void setCustomes(List<Custome> customes) {
		this.customes = customes;
	}
	
	public void addCustomesListSorted(String name, String lastname, String ID, String address, String phone, String observations) {
    	Custome newCustome=new Custome(name, lastname, ID, address, phone, observations);
    	if(customes.isEmpty()) {
    		customes.add(newCustome);
    	}else{
    		int i=0;
    		while(i<customes.size() && newCustome.getLastname().compareTo(customes.get(i).getLastname())<0) {
    			i++;
    		}
    		customes.add(i, newCustome);
    	}
    }
	
	  public boolean searchCustomeInOrders(Custome custome) {
	    	boolean found=false;
	    	for(int i=0;i<orders.size()&&!found;i++) {
	    		if(custome==orders.get(i).getCustome()&&(orders.get(i).getState()=="REQUESTED"||orders.get(i).getState()=="IN PROCESS")) {
	    				found=true;
	    			}
	    		}
	    	return found;
	    }
	  
		public int binarySearchCustomes(String name, String lastName) {
			Custome a=null;
			int b=-1;
			int start =0;
			int finish=customes.size()-1;
			boolean end=true;
			for (int i=0;i<customes.size() && end;i++) {
				a=customes.get(i);
				while (start<= finish&&end) {
					int mid=(start+finish)/2;
					if(a.getLastname().compareTo(lastName)<0) {
						finish=mid+1;
					}else if(a.getLastname().compareTo(lastName)>0) {
						start=mid-1;
					}else {
						if(a.getName().equalsIgnoreCase(name)) {
						b=i;
						end=false;
						}
					}
				}
			}
			return b;
	  }  
	
	  public void eraseCustome(String name, String lastName) {
	    	long start = System.nanoTime();
	    	boolean erased=false;    	
	    	int index= binarySearchCustomes(name,lastName);
	    	if(index>=0) {
	    		boolean found=searchCustomeInOrders(customes.get(index));
	    		if(found==false) {
	    			customes.remove(index);
	    			erased=true;
	    		}    			
	    	} 
	    	long finish= System.nanoTime();
			long total = finish-start;	
	    	if(erased==true) {
	    		Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Erase Custome");
				alert.setContentText("Custome Erased Successfully,the search took "+total+" nanoseconds");
				alert.showAndWait();
	    	}else {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erase Custome");
				alert.setContentText("An error has occurred when removing the Custome,"
						+ " the Custome doesn't exist or is part of a order requested/in process"+"\n"
				+"the search took "+total+" nanoseconds");
				alert.showAndWait();
	    	}
	    }
	
	
//--------------------------------------------------EMPLOYEE------------------------------------------------------
	  
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	 public void addEmployee(String name, String lastname, String ID) {
	    	if(searchEmployees(ID)<0) {
	        	employees.add(new Employee(name, lastname, ID));
	    	} else {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Add Employee");
				alert.setContentText("An error has occurred when adding the employee, the ID already exist");
				alert.showAndWait();
	    	}
	    }
	 
	 public int searchEmployees(String ID) {
	    	int myEmployee = -10;
	    	boolean flag=false;
	    	for(int i=0;i<employees.size()&&!flag;i++) {
	    		if(employees.get(i).getID().equals(ID)) {
	    			myEmployee=i;
	    			flag=true;
	    		}
	    	}
	    	return myEmployee;
	    }
	  
	    
	    public void eraseEmployee(String ID) {    	
	    	boolean erased=false;
	    	int i=searchEmployees(ID);
	    	if (i>=0) {
	    			employees.remove(i);
	    			erased=true;
	    	}   		
	    			
	    	if(erased==true) {
	    		Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Erase Employee");
				alert.setContentText("Employee Erased Successfully");
				alert.showAndWait();
	    	}else {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erase Employee");
				alert.setContentText("An error has occurred when removing the Employee, the Employee does not exist");
				alert.showAndWait();
	    	}
	    }
	    
//-------------------------------------------------------USER------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	    
	    public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}
		
	    public void addUser(String name, String lastName, String ID, String userName, String password) {
	    	if(searchUser(userName)<0&&searchEmployees(ID)<0) {
	    		users.add(new User(name, lastName, ID, userName, password));
	    		employees.add(new User(name, lastName, ID, userName, password));
	    	} else {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Add User");
				alert.setContentText("An error has occurred when adding the user, the userName or the ID already exist");
				alert.showAndWait();
	    	}
	    }   
		
	    public int searchUser(String userName) {
	    	boolean found=false;
	    	int myUser=-1;
	    	for(int i=0;i<users.size()&& !found;i++) {
	    		if(users.get(i).getUserName().equals(userName)) {
	    			myUser=i;
	    			found=true;
	    		}
	    	}
	    	return myUser;
	    }
	    
        
    public void eraseUser(String Username) {    	
    	boolean erased=false;
    	int i=searchUser(Username);
    	if (i>0) {
    			users.remove(i);
    			erased=true;
    	} 	
    			
    	if(erased==true) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erase User");
			alert.setContentText("User Erased Successfully");
			alert.showAndWait();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erase User");
			alert.setContentText("An error has occurred when removing the User, the User doesn't exist");
			alert.showAndWait();
    	}
    }
		
//-----------------------------------------------------INGREDIENTS----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	    
	public List<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}
	
	public void addIngredients(String name, User creator, User lastEditor) {
    	if(searchIngredient(name)==null) {
        	ingredients.add(new Ingredients(name, creator, lastEditor));
    	} else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Add Ingredient");
			alert.setContentText("An error has occurred when adding the ingredient, the name already exist");
			alert.showAndWait();
    	}
    	sortByIngredients();
    	
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
	
    public Ingredients searchIngredient(String name) {
    	boolean flag=false;
    	Ingredients ingre=null;
    	for(int i=0;i<ingredients.size()&&!flag;i++) {
    		if(ingredients.get(i).getName().equals(name)) {
    			ingre=ingredients.get(i);
    			flag=true;
    		}
    	}
    	return ingre;
    }
    
    public boolean searchIngredientInProducts(Ingredients ingredient) {
    	boolean found=false;
    	for(int i=0;i<baseProducts.size()&&found;i++) {
    		for(int k=0;k<baseProducts.get(i).getIngredients().size();k++) {
    			if(ingredient==baseProducts.get(i).getIngredients().get(k)) {
    				found=true;
    			}    			
    		}
    	}
    	return found;
    }
    
    public void eraseIngredient(String name) {
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

//-------------------------------------------------BASE PRODUCT--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public List<BaseProduct> getBaseProducts() {
		return baseProducts;
	}

	public void setBaseProducts(List<BaseProduct> baseProducts) {
		this.baseProducts = baseProducts;
		
	}
	    
	 public void addBaseProduct(String name, ProductType type, ArrayList<Ingredients> ingredients) {
	    	if(searchBaseProduct(name)<0) {
	        	baseProducts.add(new BaseProduct( name, type, ingredients));
	    	} else {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Add Base Product");
				alert.setContentText("An error has occurred when adding the Base Product, the name already exist");
				alert.showAndWait();
	    	}
	    	sortBaseProductByName();
	    }
	    
	    
	  public void sortBaseProductByName() {
	    	for(int i=0;i<baseProducts.size();i++) {
	    		for(int j=i;j>0&&baseProducts.get(j-1).getName().compareTo(baseProducts.get(j).getName())>0;j--) {
	    			BaseProduct temp= baseProducts.get(j);
	    			baseProducts.set(j,baseProducts.get(j-1));
	    			baseProducts.set(j-1,temp);
	    		}
	    	}
	    }
	  
	  public int searchBaseProduct(String name) {
	    	int index=-10;
	    	boolean flag=false;
	    	for(int i=0;i<baseProducts.size()&&!flag;i++) {
	    		if(baseProducts.get(i).getName().equals(name)) {
	    			index=i;
	    			flag=true;
	    		}
	    	}
	    	return index;
	    }  
	    public boolean searchBaseProductsInProducts(BaseProduct product) {
	    	boolean found=false;
	    	for(int i=0;i<products.size()&&!found;i++) {
	    			if(product==products.get(i).getBaseProduct()) {
	    				found=true;
	    			}
	    		}
	    	return found;
	    }
	  
	   public void eraseBaseProduct(String name) {
	    	boolean erased=false;
	    	int i=searchBaseProduct(name);
	    	if (i>=0) {
	    		boolean found=searchBaseProductsInProducts(baseProducts.get(i));
	    		if(found==false) {
	    			baseProducts.remove(i);
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
	    
//-------------------------------------------------PRODUCT-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
    public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

    public void addProduct(String code,BaseProduct baseProduct, boolean state, double price, ProductSize size, User creator, User lastEditor) {
    	if(searchProduct(code)<0) {
        	products.add(new Product(code,baseProduct, state, price, size, creator, lastEditor));
    	} else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Add Product ");
			alert.setContentText("An error has occurred when adding the Product, the code already exist");
			alert.showAndWait();
    	}
    	sortProductsByPrice();
    }  
	
    public void sortProductsByPrice() {
    	Collections.sort(products);
    }
    
    public Product searchProductsInOrders(Product product) {
    	Product numProduct=null;
    	boolean found=false;
    	for(int i=0;i<orders.size()&&!found;i++) {
    		for(int j=0;j<orders.get(i).getProducts().size()&&!found;j++) {
    			if(product==orders.get(i).getProducts().get(j)&&(orders.get(i).getState()=="REQUESTED"||orders.get(i).getState()=="IN PROCESS")) {
    				found=true;
    				numProduct=orders.get(i).getProducts().get(j);
    			}
    		}
    	} 
    	return numProduct;
    }
    
    public int searchProduct(String code) {
    	int index=-10;
    	boolean flag=false;
    	for(int i=0;i<products.size()&&!flag;i++) {
    		if(products.get(i).getCode().equals(code)) {
    			index=i;
    			flag=true;
    		}
    	}
    	return index;
    }
	
    public void eraseProduct(String code) {    	
    	boolean erased=false;
    	int i=searchProduct(code);
    	if (i>=0) {
    		Product found=searchProductsInOrders(products.get(i));
    		if(found==null) {
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
   
//--------------------------------------------PRODUCT TYPE-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
    
	public List<ProductType> getProductType() {
		return productType;
	}

	public void setProductType(List<ProductType> productType) {
		this.productType = productType;
	} 
	
	public void addProductType(String name,String code ,User creator, User lastEditor) {
	    if(searchTypeProduct(name)==null) {
	        	productType.add(new ProductType(name, code , creator, lastEditor));
	    } else {
	    	Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Add Product Type ");
			alert.setContentText("An error has occurred when adding the Product Type, the code already exist");
			alert.showAndWait();
	    	}
	    }
	
	   public ProductType searchTypeProduct(String name) {
	    	boolean found=false;
	    	ProductType type=null;
	    	for(int i=0;i<productType.size()&&found;i++) {
	    			if(productType.get(i).getName().equals(name)) {
	    				type=productType.get(i);
	    				found=true;
	    			}    			
	    		}
	    	return type;
	    }
	   
	 public boolean searchTypeInProducts(ProductType type) {
	    	boolean found=false;
	    	for(int i=0;i<baseProducts.size()&&found;i++) {
	    			if(type==baseProducts.get(i).getType()) {
	    				found=true;
	    			}    			
	    		}
	    	return found;
	    }
	    
	    public void eraseProductType(String name) {
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
	
	
//----------------------------------------------PRODUCT SIZE-----------------------------------------------------------------------------------------------------

	public List<ProductSize> getProductSize() {
		return productSize;
	}

	public void setProductSize(List<ProductSize> productSize) {
		this.productSize = productSize;
	}
	
    public void addProductSize(String name,String code,User creator, User lastEditor) {
    	if(searchProductSize(code)<0) {
        	productSize.add(new ProductSize( name, code,true,creator, lastEditor));
    	} else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Add Product Size");
			alert.setContentText("An error has occurred when adding the Product Size, the code already exist");
			alert.showAndWait();
    	}
    }
    
    public int searchProductSize(String code) {
    	boolean flag=false;
    	int size=-1;
    	for(int i=0;i<productSize.size()&&!flag;i++) {
    		if(productSize.get(i).getCode().equals(code)) {
    			size=i;
    			flag=true;
    		}
    	}
    	return size;
    }
    
    public void eraseProductSize(String Code) {    	
    	boolean erased=false;
    	int i=searchProductSize(Code);
    	if (i>=0) {
    			productSize.remove(i);
    			erased=true;
    	}   		
    			
    	if(erased==true) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erase Product Size");
			alert.setContentText("Product Size Erased Successfully");
			alert.showAndWait();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erase Product Size");
			alert.setContentText("An error has occurred when removing the Product Size, the Product Size doesn't exist");
			alert.showAndWait();
    	}
    }


//----------------------------------------------------REPORTS-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public double[] employeesOrders(Employee employee, Order order) {
    	double[] orders=new double[2];
    	double ordernum=0;
    	double orderprice=0.0;
    	if(employee==order.getEmployee()&&order.getState().equals("DELIVERED")) {
    		ordernum++;
    		for(int i=0;i<order.getProducts().size();i++) {
    			orderprice+=order.getAmount().get(i)*order.getProducts().get(i).getPrice();
    		}
    	}
    	orders[0]=ordernum;
    	orders[1]=orderprice;
    	return orders;
    }
    
    public double[] productsOrders(Product products, Product order) {
    	double[] orders=new double[2];
    	double productnum=0;
    	double productprice=0.0;
    	if(products==order) {
    		productnum++;
    		productprice+=products.getPrice();
    	}
    	orders[0]=productnum;
    	orders[1]=productprice;
    	return orders;
    }
    
  
    public void importProducts (String fileName) throws IOException{
    	//String code,BaseProduct baseProduct, boolean state, double price, ProductSize size, User creator, User lastEditor
    	BufferedReader br = new BufferedReader (new FileReader(fileName));
    	String line = br.readLine();
    	while (line!=null) {
    		String [] parts = line.split(FILE_SEPARATOR_IMPORT);
    		BaseProduct newBaseProduct = baseProducts.get(searchBaseProduct(parts[1]));
    		boolean state=Boolean.parseBoolean(parts[2]);
    		double price=Double.parseDouble(parts[3]);
    		ProductSize newProductSize=productSize.get(searchProductSize(parts[4]));
    		User creator=users.get(searchUser(parts[5]));
    		User lastEditor=users.get(searchUser(parts[6]));
    		addProduct(parts[0],newBaseProduct,state,price,newProductSize,creator,lastEditor); 
    		line = br.readLine();
    	}
    	br.close();

    }    

    public void importBaseProducts (String fileName) throws IOException{
    	//addBaseProduct(String name, ProductType type, ArrayList<Ingredients> ingredients)
    	ArrayList<Ingredients> myIngredients=new ArrayList<>();
    	BufferedReader br = new BufferedReader (new FileReader(fileName));
    	String line = br.readLine();
    	while (line!=null) {
    		String [] parts = line.split(FILE_SEPARATOR_IMPORT);
    		ProductType type=searchTypeProduct(parts[2]);
    		for(int i=2;i<parts.length;i++) {    			
	    		myIngredients.add(searchIngredient(parts[i]));
	    		}
    		addBaseProduct(parts[0],type,myIngredients);
    		line = br.readLine();
    	}
    	br.close();

    }
    public void importCustomes (String fileName) throws IOException{
  		BufferedReader br = new BufferedReader (new FileReader(fileName));
  		String line = br.readLine();
  		while (line!=null) {
  			String [] parts = line.split(FILE_SEPARATOR_IMPORT);
  			addCustomesListSorted(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5]);
  			line = br.readLine();
  		}
  		br.close();

      }
    
    public void importOrders (String fileName) throws IOException, ParseException{
    	BufferedReader br = new BufferedReader (new FileReader(fileName));
    	String line = br.readLine();
    	DateFormat objSDF=new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
    	ArrayList<Product> product = new ArrayList<>();
    	ArrayList<Integer> amount = new ArrayList<>();
    	while (line!=null) {
    		String [] parts = line.split(";");
    		String state=parts[0];
    		Custome custome = customes.get(binarySearchCustomes(parts[1],parts[2]));
    		Employee myEmployee = employees.get(searchEmployees(parts[3]));
    		Date date = objSDF.parse(parts[4]);
    		User creator = users.get(searchUser(parts[6]));
    		User lastEditor = users.get(searchUser(parts[7]));
    		for(int i=0;i<parts.length;i++) {  
    			if(i+8<=i+8+((parts.length-8)/2)/2) {
    				product.add(products.get(searchProduct(parts[i+8])));    
    			}else {
    				amount.add(Integer.parseInt(parts[i+8]));
    			}
    		}
    		addOrder(state,custome,myEmployee,date,parts[5],creator,lastEditor,product,amount);
    		line = br.readLine();
    	}
    	br.close();
    }
    
    public void exportOrdersReport(String fileName, String initialDay, String finalDay, String initialHour, String finalHour) throws FileNotFoundException {
    	Order myOrder=null;
    	PrintWriter writer = new PrintWriter (fileName);
    	String products="";
    	writer.println("CUSTOME NAME"+FILE_SEPARATOR
				+"CUSTOME LASTNAME"+FILE_SEPARATOR
				+"CUSTOME ADDRESS"+FILE_SEPARATOR
				+"CUSTOME PHONE"+FILE_SEPARATOR
				+"EMPLOYEE NAME"+FILE_SEPARATOR
				+"EMPLOYEE LASTNAME"+FILE_SEPARATOR
				+"ORDER DAY"+FILE_SEPARATOR
				+"ORDER HOUR"+FILE_SEPARATOR
				+"ORDER OBSERVATIONS"+FILE_SEPARATOR);
    	for (int i=0;i<orders.size();i++) {
    		if(orders.get(i).getDay().compareTo(initialDay)==0&&(orders.get(i).getHour().compareTo(initialHour)>=0)) {
    				myOrder = orders.get(i);    
    		}else if(orders.get(i).getDay().compareTo(initialDay)>0&&(orders.get(i).getDay().compareTo(finalDay)<0)) {
    			myOrder = orders.get(i);
    		}else if(orders.get(i).getDay().compareTo(finalDay)==0&&(orders.get(i).getHour().compareTo(finalHour)<=0)) {
    				myOrder = orders.get(i);
    			
    		}
    		for(int j=0;i<myOrder.getProducts().size();j++) {
    			products+=FILE_SEPARATOR+myOrder.getProducts().get(j).getBaseProduct().getName()+FILE_SEPARATOR+myOrder.getAmount().get(j)+FILE_SEPARATOR+myOrder.getProducts().get(j).getPrice();
    		}
    		writer.println(myOrder.getCustome().getName()+
    				FILE_SEPARATOR+myOrder.getCustome().getLastname()+
    				FILE_SEPARATOR+myOrder.getCustome().getAddress()+
    				FILE_SEPARATOR+myOrder.getCustome().getPhone()+
    				FILE_SEPARATOR+myOrder.getEmployee().getName()+
    				FILE_SEPARATOR+myOrder.getEmployee().getLastname()+
    				FILE_SEPARATOR+myOrder.getDay()+
    				FILE_SEPARATOR+myOrder.getHour()+
    				FILE_SEPARATOR+myOrder.getObservation()+products);
    	}
    	writer.close();
    }
    
    public void employeesOrdersReport(String fileName, String initialDay, String finalDay, String initialHour, String finalHour) throws FileNotFoundException {
    	PrintWriter writer = new PrintWriter (fileName);
    	writer.println("EMPLOYEE NAME"+FILE_SEPARATOR
				+"EMPLOYEE LASTNAME"+FILE_SEPARATOR
				+"EMPLOYEE ID"+FILE_SEPARATOR
				+"ORDERS SOLD"+FILE_SEPARATOR
				+"ORDERS PRICE"+FILE_SEPARATOR);
    	for (int i=0;i<employees.size();i++) {
    		for(int j=0;j<orders.size();j++) {
    			Order myOrder= null;
    			if(orders.get(i).getDay().compareTo(initialDay)==0&&(orders.get(i).getHour().compareTo(initialHour)>=0)) {
    				myOrder = orders.get(i);    
    			}else if(orders.get(i).getDay().compareTo(initialDay)>0&&(orders.get(i).getDay().compareTo(finalDay)<0)) {
    				myOrder = orders.get(i);
    			}else if(orders.get(i).getDay().compareTo(finalDay)==0&&(orders.get(i).getHour().compareTo(finalHour)<=0)) {
    				myOrder = orders.get(i);
    			
    		}
    			if(myOrder!=null) {
    			Employee myEmployee =employees.get(i);
    			double[] employeeOrder= employeesOrders(myEmployee,myOrder);
    			writer.println(myEmployee.getName()+
    					FILE_SEPARATOR+myEmployee.getLastname()+
    					FILE_SEPARATOR+myEmployee.getID()+
    					FILE_SEPARATOR+employeeOrder[0]+
    					FILE_SEPARATOR+employeeOrder[1]);
    			}
    		}
    	}
    	writer.close();
    }
    
    public void productsOrderReport(String fileName, String initialDay, String finalDay, String initialHour, String finalHour) throws FileNotFoundException {
    	PrintWriter writer = new PrintWriter (fileName);
    	writer.println("PRODUCT NAME"+FILE_SEPARATOR
				+"PRODUCT SOLD"+FILE_SEPARATOR
				+"PRODUCT TOTAL PRICE"+FILE_SEPARATOR);
    	for (int i=0;i<products.size();i++) {
    		for(int j=0;j<orders.size();j++) {
    			Order myOrder=null;
    			if(orders.get(j).getDay().compareTo(initialDay)==0&&(orders.get(j).getHour().compareTo(initialHour)>=0)) {
    				myOrder = orders.get(j);    
    			}else if(orders.get(j).getDay().compareTo(initialDay)>0&&(orders.get(j).getDay().compareTo(finalDay)<0)) {
    				myOrder = orders.get(j);
    			}else if(orders.get(j).getDay().compareTo(finalDay)==0&&(orders.get(j).getHour().compareTo(finalHour)<=0)) {
    				myOrder = orders.get(j);
    			
    		}
    			if(myOrder!=null) {
    			for(int k=0;k<myOrder.getProducts().size();k++) {
    				Product myProduct =products.get(i);
    				double[] productOrders= productsOrders(myProduct,myOrder.getProducts().get(k));
    				writer.println(myProduct.getBaseProduct().getName()+
    						FILE_SEPARATOR+myProduct.getSize().getName()+
    						FILE_SEPARATOR+productOrders[0]+
    						FILE_SEPARATOR+productOrders[1]);
    				}
    			}
    		}
    	}
    	writer.close();
    }
    
    
//----------------------------------------------------OTHER METHODS----------------------------------------------------------------------------------------------------------------------------------------------------------------
	public User getUserLogged() {
		return userLogged;
	}

	public void setUserLogged(User userLogged) {
		this.userLogged = userLogged;
	}

	public ArrayList<Ingredients> getIngredientBP() {
		return ingredientBP;
	}

	public void setIngredientBP(ArrayList<Ingredients> ingredientBP) {
		this.ingredientBP = ingredientBP;
	}

	public ArrayList<Product> getProductsOrder() {
		return productsOrder;
	}

	public void setProductsOrder(ArrayList<Product> productsOrder) {
		this.productsOrder = productsOrder;
	}

	public ArrayList<Integer> getAmountProductsOrder() {
		return amountProductsOrder;
	}

	public void setAmountProductsOrder(ArrayList<Integer> amountProductsOrder) {
		this.amountProductsOrder = amountProductsOrder;
	}

}