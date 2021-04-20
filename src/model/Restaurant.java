package model;

import java.io.BufferedReader;
import java.io.File;
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
	private static final String INFORMATION_PATH_FILE="data/information.jpmt";
	private static final String ORDER_CODE= String.valueOf((int)Math.floor(Math.random()*(1000))+1);
	private static String FILE_SEPARATOR;
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
	private OrdersComparator oc;

	public Restaurant() {
		customes = new ArrayList<>();
		ingredients=new ArrayList<>();
		products = new ArrayList<>();
		productType = new ArrayList<>();
		orders = new ArrayList<>();
		employees=new ArrayList<>();
		users=new ArrayList<>();
		baseProducts=new ArrayList<>();
		productSize=new ArrayList<>();
		ingredientBP=new ArrayList<>();
	}

	//-------------------------------------------------SEPARATOR---------------------------------------------------------------------

	public  String getFILE_SEPARATOR() {
		return FILE_SEPARATOR;
	}

	public void setFILE_SEPARATOR(String fILE_SEPARATOR) {
		FILE_SEPARATOR = fILE_SEPARATOR;
	}

	//-------------------------------------SERIALIZABLE-----------------------------------------------------

	public void saveData() throws IOException, ClassNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INFORMATION_PATH_FILE));

		oos.writeObject(employees);
		oos.writeObject(users);
		oos.writeObject(customes);
		oos.writeObject(ingredients);
		oos.writeObject(products);
		oos.writeObject(orders);
		oos.writeObject(productType);
		oos.writeObject(productSize);
		oos.writeObject(baseProducts);

		oos.close();
		loadData();
	}

	@SuppressWarnings("unchecked") 
	public boolean loadData() throws IOException, ClassNotFoundException {
		File f = new File(INFORMATION_PATH_FILE);
		boolean loaded = false;
		if (f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

			employees = (List<Employee>) ois.readObject();
			users = (List<User>) ois.readObject();
			customes = (List<Custome>) ois.readObject();
			ingredients = (List<Ingredients>) ois.readObject();
			products = (List<Product>) ois.readObject();
			orders = (List<Order>) ois.readObject();			
			productType =(List<ProductType>) ois.readObject();
			productSize= (List<ProductSize>) ois.readObject();			
			baseProducts = (List<BaseProduct>) ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	//---------------------------------------------------ORDER--------------------------------------------------------	    

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void addOrder(String state, Custome custome,Employee employee, Date date, String observation, User creator, User lastEditor, ArrayList<Product> products, ArrayList<Integer> amount) throws ParseException, FileNotFoundException, IOException, ClassNotFoundException {
		Order newOrder =new Order(state,ORDER_CODE, products,amount, custome, employee, date, observation, creator, lastEditor);
		orders.add(newOrder);
		sortOrderByDate();
		saveData();
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

	public void eraseOrder(String code) throws FileNotFoundException, IOException, ClassNotFoundException {    	
		boolean erased=false;
		int i=searchOrders(code);
		if (i>=0) {
			orders.remove(i);
			erased=true;
			saveData();
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

	public boolean addCustomesListSorted(String name, String lastname, String ID, String address, String phone, String observations) throws FileNotFoundException, IOException, ClassNotFoundException {
		Custome newCustome=new Custome(name, lastname, ID, address, phone, observations,userLogged,userLogged);
		boolean added= false;
		if(customes.isEmpty()) {
			customes.add(newCustome);
			saveData();
		}else{
			int i=0;
			while(i<customes.size() && newCustome.getLastname().compareTo(customes.get(i).getLastname())<0) {
				i++;
			}
			customes.add(i, newCustome);
			added= true;
			saveData();
		}
		return added;
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

	public void eraseCustome(String name, String lastName) throws FileNotFoundException, IOException, ClassNotFoundException {
		long start = System.nanoTime();
		boolean erased=false;    	
		int index= binarySearchCustomes(name,lastName);
		if(index>=0) {
			boolean found=searchCustomeInOrders(customes.get(index));
			if(found==false) {
				customes.remove(index);
				erased=true;
				saveData();
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

	public boolean addEmployee(String name, String lastname, String ID, User creator, User lastEditor,boolean state) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean added=false;
		if(searchEmployees(ID)<0) {
			employees.add(new Employee(name, lastname, ID, creator, lastEditor,state));
			saveData();
			added=true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Add Employee");
			alert.setContentText("An error has occurred when adding the employee, the ID already exist");
			alert.showAndWait();
		}
		return added;
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


	public void eraseEmployee(String ID) throws FileNotFoundException, IOException, ClassNotFoundException {    	
		boolean erased=false;
		int i=searchEmployees(ID);
		boolean verf = employees.get(i).equals(userLogged);
		if (i>=0 && verf==false) {
			employees.remove(i);
			erased=true;
			saveData();
		}  else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erase Employee");
			alert.setContentText("An error has occurred when removing the Employee, the Employee is already Logged");
			alert.showAndWait();
		}

		if(erased==true && verf==false) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erase Employee");
			alert.setContentText("Employee Erased Successfully");
			alert.showAndWait();
		}else if(erased==false && verf==false) {
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

	public boolean addUser(String name, String lastName, String ID, String userName, String password, User creator, User lastEditor,boolean state) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean added=false;
		if(searchUser(userName)<0&&searchEmployees(ID)<0) {
			users.add(new User(name, lastName, ID, userName, password, creator, lastEditor, state));
			employees.add(new User(name, lastName, ID, userName, password, creator, lastEditor, state));
			saveData();
			added = true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Add User");
			alert.setContentText("An error has occurred when adding the user, the userName or the ID already exist");
			alert.showAndWait();
		}
		return added;
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


	public void eraseUser(String Username) throws FileNotFoundException, IOException, ClassNotFoundException {    	
		boolean erased=false;		
		int i=searchUser(Username);
		boolean verf = users.get(i).equals(userLogged);
		if (i>=0 && verf == false) {
			users.remove(i);
			erased=true;
			saveData();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erase User");
			alert.setContentText("An error has occurred when removing the User, you can't erase the same user you are logged into");
			alert.showAndWait();
		}

		if(erased==true && verf == false) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erase User");
			alert.setContentText("User Erased Successfully");
			alert.showAndWait();
		}else if (erased==false && verf == false) {
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

	public boolean addIngredients(String name, User creator, User lastEditor) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean added=false;
		if(ingredients.isEmpty()) {
			ingredients.add(new Ingredients(name, creator, lastEditor));
			sortByIngredients();
			saveData();
			added=true;
		}else if(searchIngredient(name)==null) {
			ingredients.add(new Ingredients(name, creator, lastEditor));
			sortByIngredients();
			saveData();
			added=true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Add Ingredient");
			alert.setContentText("An error has occurred when adding the ingredient, the name already exist");
			alert.showAndWait();
		}	
		return added;
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

	public void eraseIngredient(String name) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean erased=false;    	
		for(int i=0;i<ingredients.size()&&!erased;i++) {
			boolean found=searchIngredientInProducts(ingredients.get(i));
			if(ingredients.get(i).getName().equalsIgnoreCase(name)&&found==false) {
				ingredients.remove(i);
				erased=true;
				saveData();
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

	public boolean addBaseProduct(String name, ProductType type, ArrayList<Ingredients> ingredients) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean added= false;
		if(searchBaseProduct(name)<0) {
			baseProducts.add(new BaseProduct(name, type, ingredients));
			sortBaseProductByName();
			saveData();
			added=true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Add Base Product");
			alert.setContentText("An error has occurred when adding the Base Product, the name already exist");
			alert.showAndWait();
		}		
		return added;
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

	public void eraseBaseProduct(String name) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean erased=false;
		int i=searchBaseProduct(name);
		if (i>=0) {
			boolean found=searchBaseProductsInProducts(baseProducts.get(i));
			if(found==false) {
				baseProducts.remove(i);
				saveData();;
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
			alert.setContentText("An error has occurred when removing the BaseProduct, the BaseProduct does not exist or is part of a product");
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

	public boolean addProduct(String code,BaseProduct baseProduct, boolean state, double price, ProductSize size, User creator, User lastEditor) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean added=false;
		if(searchProduct(code)<0) {
			products.add(new Product(code,baseProduct, state, price, size, creator, lastEditor));
			sortProductsByPrice();
			saveData();
			added=true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Add Product ");
			alert.setContentText("An error has occurred when adding the Product, the code already exist");
			alert.showAndWait();
		}
		return added;
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

	public void eraseProduct(String code) throws FileNotFoundException, IOException, ClassNotFoundException {    	
		boolean erased=false;
		int i=searchProduct(code);
		if (i>=0) {
			Product found=searchProductsInOrders(products.get(i));
			if(found==null) {
				products.remove(i);
				saveData();
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

	public boolean addProductType(String name,String code ,User creator, User lastEditor) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean added=false;
		if(productType.isEmpty()) {
			productType.add(new ProductType(name, code , creator, lastEditor));
			saveData();
			added=true;
		}else if(searchTypeProduct(name)==null) {
			productType.add(new ProductType(name, code , creator, lastEditor));
			saveData();
			added=true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Add Product Type ");
			alert.setContentText("An error has occurred when adding the Product Type, the code already exist");
			alert.showAndWait();
		}
		return added;
	}

	public ProductType searchTypeProduct(String name) {
		boolean found=true;
		ProductType type=null;
		for(int i=0;i<productType.size()&&found;i++) {
			if(productType.get(i).getName().equalsIgnoreCase(name)) {
				type=productType.get(i);
				found=false;
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

	public void eraseProductType(String name) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean erased=false;    	
		for(int i=0;i<productType.size()&&!erased;i++) {
			boolean found=searchTypeInProducts(productType.get(i));
			if(productType.get(i).getName().equalsIgnoreCase(name)&&found==false) {
				productType.remove(i);
				saveData();
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

	public boolean addProductSize(String name,String code,User creator, User lastEditor) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean added=false;
		if(searchProductSize(code)<0) {
			productSize.add(new ProductSize( name, code,true,creator, lastEditor));
			saveData();
			added=true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Add Product Size");
			alert.setContentText("An error has occurred when adding the Product Size, the code already exist");
			alert.showAndWait();
		}
		return added;
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

	public void eraseProductSize(String Code) throws FileNotFoundException, IOException, ClassNotFoundException {    	
		boolean erased=false;
		int i=searchProductSize(Code);
		if (i>=0) {
			productSize.remove(i);
			erased=true;
			saveData();
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

	public void addBaseProduct(String name) throws FileNotFoundException, IOException, ClassNotFoundException {
		baseProducts.add(new BaseProduct(name));
		saveData();
	}

	public void addProduct(String code) throws FileNotFoundException, IOException, ClassNotFoundException {
		products.add(new Product(code));
		saveData();
	}

	public void addProductType(String name) throws FileNotFoundException, IOException, ClassNotFoundException {
		productType.add(new ProductType(name));
		saveData();
	}

	public void addProductSize(String name) throws FileNotFoundException, IOException, ClassNotFoundException{
		productSize.add(new ProductSize(name));
		saveData();
	}

	public void addCustomesSorted(String name, String lastname) throws FileNotFoundException, IOException, ClassNotFoundException {
		Custome newCustome=new Custome(name, lastname,userLogged,userLogged);
		if(customes.isEmpty()) {
			customes.add(newCustome);
		}else{
			int i=0;
			while(i<customes.size() && newCustome.getLastname().compareTo(customes.get(i).getLastname())<0) {
				i++;
			}
			customes.add(i, newCustome);
			saveData();
		}
	}

	public void addEmployee(String ID) throws FileNotFoundException, IOException, ClassNotFoundException {
		employees.add(new Employee(ID,userLogged,userLogged));
		saveData();
	}

	public void addUser(String userName) throws FileNotFoundException, IOException, ClassNotFoundException {
		users.add(new User(userName,userLogged,userLogged));
		employees.add(new User(userName,userLogged,userLogged));
		saveData();
	}

	public double[] employeesOrders(Employee employee, Order order) {
		double[] orders=new double[2];
		double ordernum=0;
		double orderprice=0.0;
		if(employee.getID().equals(order.getEmployee().getID())) {
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
		if(products.equals(order)) {
			productnum++;
			productprice+=products.getPrice();
		}
		orders[0]=productnum;
		orders[1]=productprice;
		return orders;
	}

	public void importCustomes (String fileName) throws IOException, ClassNotFoundException{
		BufferedReader br = new BufferedReader (new FileReader(fileName));
		String line = br.readLine();
		while (line!=null) {
			String[] parts = line.split(FILE_SEPARATOR_IMPORT);
			addCustomesListSorted(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5]);
			line = br.readLine();
		}
		saveData();
		br.close();
	}

	public void importProducts (String fileName) throws IOException, ClassNotFoundException{
		//String code,BaseProduct baseProduct, boolean state, double price, ProductSize size, User creator, User lastEditor
		BufferedReader br = new BufferedReader (new FileReader(fileName));
		String line = br.readLine();
		while (line!=null) {
			String [] parts = line.split(FILE_SEPARATOR_IMPORT);
			addBaseProduct(parts[1]);
			BaseProduct newBaseProduct = baseProducts.get(baseProducts.size()-1);
			boolean state=Boolean.parseBoolean(parts[2]);
			double price=Double.parseDouble(parts[3]);
			addProductSize(parts[4]);
			ProductSize newProductSize=productSize.get(productSize.size()-1);
			User creator=userLogged;
			User lastEditor=userLogged;
			addProduct(parts[0],newBaseProduct,state,price,newProductSize,creator,lastEditor); 
			line = br.readLine();
		}
		saveData();
		br.close();
	}    

	public void importOrders (String fileName) throws IOException, ParseException, ClassNotFoundException{
		//String state, String code, ArrayList<Product> products, ArrayList<Integer> amount, Custome custome,Employee employee, Date date, String observation, User creator, User lastEditor
		BufferedReader br = new BufferedReader (new FileReader(fileName));
		String line = br.readLine();
		DateFormat objSDF=new SimpleDateFormat("dd/MM/YYYY");
		ArrayList<Product> product = new ArrayList<>();
		ArrayList<Integer> amount = new ArrayList<>();
		while (line!=null) {
			String [] parts = line.split(";");
			String state="REQUESTED";
			Custome custome = new Custome(parts[0],parts[1],userLogged,userLogged);
			Employee myEmployee = new Employee(parts[2],userLogged,userLogged);
			Date date = objSDF.parse(parts[3]);
			User creator = userLogged;
			User lastEditor = userLogged;
			product.add(new Product(parts[5])); 
			amount.add(Integer.parseInt(parts[6]));

			addOrder(state,custome,myEmployee,date,parts[4],creator,lastEditor,product,amount);
			line = br.readLine();
		}
		saveData();
		br.close();
	}

	public void exportOrdersReport(String fileName, String initialDay, String finalDay, String initialHour, String finalHour) throws FileNotFoundException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY hh:mm:ss");
		String startDateFinal = initialDay + " " + initialHour;
		Date startDate = dateFormat.parse(startDateFinal);
		String endDateFinal = finalDay + " " + finalHour;
		Date endDate = dateFormat.parse(endDateFinal);
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
			Order myOrder = orders.get(i); 
			if(myOrder!=null&&myOrder.getDate().after(startDate)&&myOrder.getDate().before(endDate)) {
				for(int j=0;j<myOrder.getProducts().size();j++) {
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
			
		}

		writer.close();
	}
	
	public void exportOrdersReport(String fileName) throws FileNotFoundException {
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
			Order myOrder = orders.get(i);    
			for(int j=0;j<myOrder.getProducts().size();j++) {
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

	public void employeesOrdersReport(String fileName, String initialDay, String finalDay, String initialHour, String finalHour) throws FileNotFoundException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY hh:mm:ss");
		String startDateFinal = initialDay + " " + initialHour;
		Date startDate = dateFormat.parse(startDateFinal);
		String endDateFinal = finalDay + " " + finalHour;
		Date endDate = dateFormat.parse(endDateFinal);
		PrintWriter writer = new PrintWriter (fileName);
		writer.println("EMPLOYEE NAME"+FILE_SEPARATOR
				+"EMPLOYEE LASTNAME"+FILE_SEPARATOR
				+"EMPLOYEE ID"+FILE_SEPARATOR
				+"ORDERS SOLD"+FILE_SEPARATOR
				+"ORDERS PRICE"+FILE_SEPARATOR);
		for (int i=0;i<employees.size();i++) {
			for(int j=0;j<orders.size();j++) {
				Order myOrder= orders.get(i);
				if(myOrder!=null&&myOrder.getDate().after(startDate)&&myOrder.getDate().before(endDate)) {
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
	public void employeesOrdersReport(String fileName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter (fileName);
		writer.println("EMPLOYEE NAME"+FILE_SEPARATOR
				+"EMPLOYEE LASTNAME"+FILE_SEPARATOR
				+"EMPLOYEE ID"+FILE_SEPARATOR
				+"ORDERS SOLD"+FILE_SEPARATOR
				+"ORDERS PRICE"+FILE_SEPARATOR);
		for (int i=0;i<employees.size();i++) {
			for(int j=0;j<orders.size();j++) {
				Order myOrder= orders.get(i);
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

	public void productsOrderReport(String fileName, String initialDay, String finalDay, String initialHour, String finalHour) throws FileNotFoundException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY hh:mm:ss");
		String startDateFinal = initialDay + " " + initialHour;
		Date startDate = dateFormat.parse(startDateFinal);
		String endDateFinal = finalDay + " " + finalHour;
		Date endDate = dateFormat.parse(endDateFinal);
		PrintWriter writer = new PrintWriter (fileName);
		writer.println("PRODUCT NAME"+FILE_SEPARATOR
				+"PRODUCT SOLD"+FILE_SEPARATOR
				+"PRODUCT TOTAL PRICE"+FILE_SEPARATOR);
		for (int i=0;i<products.size();i++) {
			for(int j=0;j<orders.size();j++) {
				Order myOrder = orders.get(j);					
				if(myOrder!=null&&myOrder.getDate().after(startDate)&&myOrder.getDate().before(endDate)) {
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
	public void productsOrderReport(String fileName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter (fileName);
		writer.println("PRODUCT NAME"+FILE_SEPARATOR
				+"PRODUCT SOLD"+FILE_SEPARATOR
				+"PRODUCT TOTAL PRICE"+FILE_SEPARATOR);
		for (int i=0;i<products.size();i++) {
			for(int j=0;j<orders.size();j++) {
				Order myOrder = orders.get(j);					
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

	/*
	 *   @FXML
    void exportEmployees(ActionEvent event) throws ParseException, FileNotFoundException {

        if(restaurantSystem.getEmployees().isEmpty()) {

            showAlert("ERROR", "Error", "Sin Datos", "No hay empleados para exportar.");

        } else {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Exportar Reporte");
            fileChooser.setInitialFileName("reporte-empleados");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", "*.txt"));
            File file = fileChooser.showSaveDialog(mainPane.getScene().getWindow());

            if(file!=null) {

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                String startDateString = startDateEmployee.getValue().toString();
                String startTimeString = startTimeEmployee.getText()+":00";
                String startDateFinal = startDateString + " " + startTimeString;
                Date startDate = dateFormat.parse(startDateFinal);

                String endDateString = endDateEmployee.getValue().toString();
                String endTimeString = endTimeEmployee.getText()+":00";
                String endDateFinal = endDateString + " " + endTimeString;
                Date endDate = dateFormat.parse(endDateFinal);

                restaurantSystem.exportEmployeesReports(file, txtOrderSeparatorExp.getText(), endDate, startDate);

                showAlert("INFORMATION", "Información", "Reporte Generado", "El reporte de los empleados fue generado correctamente.");

            }

        }

    }

    public void exportEmployeesReports(File file, String separator, Date supLimit, Date infLimit)
            throws FileNotFoundException {

        List<String> line = new ArrayList<>();
        List<Integer> countSells = new ArrayList<>();
        List<Long> sellsList = new ArrayList<>();

        Employee tEmployee = null;

        for (int k = 0; k < employees.size(); k++) {
            tEmployee = employees.get(k);
            int count = 0;
            long sellAmount = 0;

            for (int i = 0; i < orders.size(); i++) {
                Date temp = orders.get(i).getOrderDate();
                if (temp.compareTo(infLimit) > 0 && temp.compareTo(supLimit) < 0
                        && orders.get(i).getEmployee().equals(tEmployee)) {
                    count += 1;
                    sellAmount = orders.get(i).getAmount();
                }
            }
            countSells.add(count);
            sellsList.add(sellAmount);
        }

        for (int i = 0; i < employees.size(); i++) {
            line.add(employees.get(i).getName() + " " + employees.get(i).getLastName() + separator + countSells.get(i)
                    + separator + sellsList.get(i));
        }

        exports.exportEmployees(file, line, separator);
    }
	 */
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

}