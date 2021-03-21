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
import java.text.ParseException;
import java.util.ArrayList;
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
	private static final String ORDER_CODE= String.format("P%04d", 100);
	private static String FILE_SEPARATOR=";";
	private static List<Custome> customes;
	private static List<Ingredients> ingredients;
	private static List<Product> products;
	private static List<ProductType> productType;
	private static List<Order> orders;
	private static List<Employee> employees;
	private static List<User> users;
	private static List<BaseProduct> baseProducts;
	private static List<ProductSize> productSize;
	
	public Restaurant() {
		customes = new ArrayList<>();
		ingredients=new ArrayList<>();
		products = new ArrayList<>();	
		orders = new ArrayList<>();
		employees=new ArrayList<>();
		users=new ArrayList<>();
		baseProducts=new ArrayList<>();
		productSize=new ArrayList<>();
	}
	
	public  String getFILE_SEPARATOR() {
		return FILE_SEPARATOR;
	}

	public void setFILE_SEPARATOR(String fILE_SEPARATOR) {
		FILE_SEPARATOR = fILE_SEPARATOR;
	}

	public List<Custome> getCustomes() {
		return customes;
	}

	public void setCustomes(List<Custome> customes) {
		Restaurant.customes = customes;
	}

	public List<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredients> ingredients) {
		Restaurant.ingredients = ingredients;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		Restaurant.products = products;
	}

	public List<ProductType> getProductType() {
		return productType;
	}

	public void setProductType(List<ProductType> productType) {
		Restaurant.productType = productType;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		Restaurant.orders = orders;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		Restaurant.employees = employees;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		Restaurant.users = users;
	}

	public List<BaseProduct> getBaseProducts() {
		return baseProducts;
	}

	public void setBaseProducts(List<BaseProduct> baseProducts) {
		Restaurant.baseProducts = baseProducts;
	}

	public List<ProductSize> getProductSize() {
		return productSize;
	}

	public void setProductSize(List<ProductSize> productSize) {
		Restaurant.productSize = productSize;
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
    
    public void SortProductsByPrice() {
    	for(int i=0;i<products.size();i++) {
    		for(int j=i;j>0&&products.get(j-1).getPrice()>products.get(j).getPrice();j--) {
    			Product temp=products.get(j);
    			products.set(j,products.get(j-1));
    			products.set(j-1,temp);
    		}
    	}
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
    public void addOrder(String state, ArrayList<Product> products, ArrayList<Integer> amount, Custome custome,Employee employee, Date date, String observation, User creator, User lastEditor) throws ParseException {
    	Order newOrder =new Order(state,ORDER_CODE, products,amount, custome, employee, date, observation, creator, lastEditor);
    	orders.add(newOrder);
    }
    public void addProductType(String name,String code ,User creator, User lastEditor) {
    	productType.add(new ProductType(name, code , creator, lastEditor));
    }
    public void addEmployee(String name, String lastname, String ID) {
    	employees.add(new Employee(name, lastname, ID));
    }
    public void addUser(String name, String lastName, String ID, String userName, String password) {
    	if(searchUser(userName)!=null) {
    		users.add(new User(name, lastName, ID, userName, password));
    	} else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Add User");
			alert.setContentText("An error has occurred when adding the user, the userName already exist");
			alert.showAndWait();
    	}
    }   
    
    public void addIngredients(String name, User creator, User lastEditor) {
    	ingredients.add(new Ingredients(name, creator, lastEditor));
    }
    public void addBaseProduct(String name, ProductType type, ArrayList<Ingredients> ingredients) {
    	baseProducts.add(new BaseProduct( name, type, ingredients));
    }
    public void addProductSize(String name,String code) {
    	productSize.add(new ProductSize( name, code));
    }
    public void addProduct(String code,BaseProduct baseProduct, boolean state, double price, ProductSize size, User creator, User lastEditor) {
    	products.add(new Product(code,baseProduct, state, price, size, creator, lastEditor));
    }   
  
    public ProductSize searchProductSize(String code) {
    	boolean flag=false;
    	ProductSize size=null;
    	for(int i=0;i<productSize.size()&&!flag;i++) {
    		if(productSize.get(i).getCode().equals(code)) {
    			size=productSize.get(i);
    			flag=true;
    		}
    	}
    	return size;
    }
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
      
    
    public boolean searchCustomeInOrders(Custome custome) {
    	boolean found=false;
    	for(int i=0;i<orders.size()&&!found;i++) {
    		if(custome==orders.get(i).getCustome()&&(orders.get(i).getState()=="REQUESTED"||orders.get(i).getState()=="IN PROCESS")) {
    				found=true;
    			}
    		}
    	return found;
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
    
    public void eraseCustome(String name, String lastName) {
    	boolean erased=false;    	
    	int index= binarySearchCustomes(name,lastName);
    	if(index>=0) {
    		boolean found=searchCustomeInOrders(customes.get(index));
    		if(found==false) {
    			customes.remove(index);
    			erased=true;
    		}    			
    	}    			
    	if(erased==true) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erase Custome");
			alert.setContentText("Custome Erased Successfully");
			alert.showAndWait();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erase Custome");
			alert.setContentText("An error has occurred when removing the Custome, the Custome doesn't exist or is part of a order requested/in process");
			alert.showAndWait();
    	}
    }
    
    public void stateProduct(String code,boolean state) {
    	int index=searchProduct(code);
    	boolean found=false;
    	if(index>=0) {
    		found=true;
    		products.get(index).setState(state);
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
    public void stateProductType(String name,boolean state) {
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
    
    public void stateIngredient(String name, boolean state) {
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
    
    public void stateCustome(String name, String lastName, boolean state) {
    	boolean found=false;
    	int index= binarySearchCustomes(name,lastName);
    		if(index>=0) {
    			customes.get(index).setState(state);
    			found=true;
    			}    			
    		if(found==true) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("State Custome");
			alert.setContentText("Custome state has changed Successfully");
			alert.showAndWait();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("State Custome");
			alert.setContentText("An error has occurred changing the Custome's state, the Custome doesn't exist");
			alert.showAndWait();
    	}
    }
    public void importCustomes (String fileName) throws IOException{
		BufferedReader br = new BufferedReader (new FileReader(fileName));
		String line = br.readLine();
		while (line!=null) {
			String [] parts = line.split(";");
			addCustomesListSorted(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5]);
			line = br.readLine();
		}
		br.close();

    }
    public User searchUser(String userName) {
    	User myUser=null;
    	for(int i=0;i<users.size();i++) {
    		if(users.get(i).getUserName().equals(userName)) {
    			myUser=users.get(i);
    		}
    	}
    	return myUser;
    }
    public ProductType searchTypeProduct(String code) {
    	boolean found=false;
    	ProductType type=null;
    	for(int i=0;i<productType.size()&&found;i++) {
    			if(productType.get(i).getCode().equals(code)) {
    				type=productType.get(i);
    				found=true;
    			}    			
    		}
    	return type;
    }
    public void importProducts (String fileName) throws IOException{
    	//String code,BaseProduct baseProduct, boolean state, double price, ProductSize size, User creator, User lastEditor
    	BufferedReader br = new BufferedReader (new FileReader(fileName));
    	String line = br.readLine();
    	while (line!=null) {
    		String [] parts = line.split(";");
    		BaseProduct newBaseProduct = baseProducts.get(searchBaseProduct(parts[1]));
    		boolean state=Boolean.parseBoolean(parts[2]);
    		double price=Double.parseDouble(parts[3]);
    		ProductSize newProductSize=searchProductSize(parts[4]);
    		User creator=searchUser(parts[5]);
    		User lastEditor=searchUser(parts[6]);
    		addProduct(parts[0],newBaseProduct,state,price,newProductSize,creator,lastEditor); 
    		line = br.readLine();
    	}
    	br.close();

    }    
    /*
    public void importBaseProducts (String fileName) throws IOException{
    	//String name, ProductType type, ArrayList<Ingredients> ingredients
    	BufferedReader br = new BufferedReader (new FileReader(fileName));
    	String line = br.readLine();
    	while (line!=null) {
    		String [] parts = line.split(";");
    		ProductType type=searchTypeProduct(parts[2]);
    		addProduct(parts[0],parts[1],type);
    		line = br.readLine();
    	}
    	br.close();

    }

    public void importOrders (String fileName) throws IOException{
    	//String state, String code, ArrayList<Product> products, ArrayList<Integer> amount, Custome custome,Employee employee, Date date, String observation, User creator, User lastEditor
    	BufferedReader br = new BufferedReader (new FileReader(fileName));
    	String line = br.readLine();
    	while (line!=null) {
    		String [] parts = line.split(";");
    		boolean state=Boolean.parseBoolean(parts[0]);
    		addOrder(state,parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],parts[8]);
    		line = br.readLine();
    	}
    	br.close();
    }
    */
    public void exportOrders(String fileName) throws FileNotFoundException {
    	PrintWriter writer = new PrintWriter (fileName);
    	String products="";
    	for (int i=0;i<orders.size();i++) {
    		Order myOrder = orders.get(i);
    		for(int j=0;i<myOrder.getProducts().size();j++) {
    			products+=FILE_SEPARATOR+myOrder.getProducts().get(j).getBaseProduct().getName()+FILE_SEPARATOR+myOrder.getAmount().get(j)+FILE_SEPARATOR+myOrder.getProducts().get(j).getPrice();
    		}
    		writer.println(myOrder.getCustome().getName()+FILE_SEPARATOR+myOrder.getCustome().getAddress()+
    				FILE_SEPARATOR+myOrder.getCustome().getPhone()+FILE_SEPARATOR+myOrder.getEmployee()+
    				FILE_SEPARATOR+myOrder.getEmployee().getLastname()+FILE_SEPARATOR+myOrder.getDate()+
    				FILE_SEPARATOR+myOrder.getObservation()+products);
    	}
    	writer.close();
    }
    
    public void employeesOrdersReport(String fileName) throws FileNotFoundException {
    	PrintWriter writer = new PrintWriter (fileName);
    	for (int i=0;i<employees.size();i++) {
    		for(int j=0;j<orders.size();j++) {
    			Employee myEmployee =employees.get(i);
    			double[] employeeOrder= employeesOrders(myEmployee,orders.get(j));
    			writer.println(myEmployee.getName()+FILE_SEPARATOR+myEmployee.getLastname()+FILE_SEPARATOR+myEmployee.getID()+FILE_SEPARATOR+employeeOrder[0]+FILE_SEPARATOR+employeeOrder[1]);
    		}
    	}
    	writer.close();
    }
    public void productsOrderReport(String fileName) throws FileNotFoundException {
    	PrintWriter writer = new PrintWriter (fileName);
    	for (int i=0;i<products.size();i++) {
    		for(int j=0;j<orders.size();j++) {
    			for(int k=0;k<orders.get(j).getProducts().size();k++) {
    				Product myProduct =products.get(i);
    				double[] productOrders= productsOrders(myProduct,orders.get(j).getProducts().get(k));
    				writer.println(myProduct.getBaseProduct().getName()+FILE_SEPARATOR+myProduct.getSize().getName()+FILE_SEPARATOR+productOrders[0]+FILE_SEPARATOR+productOrders[1]);
    			}
    		}
    	}
    	writer.close();
    }

    
}

