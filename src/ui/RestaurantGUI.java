package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import model.BaseProduct;
import model.Custome;
import model.Employee;
import model.Ingredients;
import model.Order;
import model.Product;
import model.ProductSize;
import model.ProductType;
import model.Restaurant;
import model.User;


public class RestaurantGUI implements Initializable {

	private Restaurant restaurant;

	private static final String LOGIN_IMAGE_PATH = "data/images/Lacasadorada.jpg";

	private static final String MAIN_MENU_IMAGE_PATH = "data/images/Lacasadorada.jpg";

	private static final String REGISTER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_BASE_PRODUCT_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_PRODUCT_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_ORDER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_PRODUCT_TYPE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_PRODUCT_SIZE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_CUSTOME_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_EMPLOYEE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_USER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REPORT_ORDER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REPORT_PRODUCTS_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REPORT_EMPLOYEE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private String hours, minutes, seconds,time;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;


	//-----------MAIN MENU GUI------------
	@FXML
	private Label mainPaneHour;
	@FXML
	private Label mainPaneDate;
	@FXML
	private ImageView mainImage;

	public void showMainMenu() throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("main-menu.fxml"));
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(MAIN_MENU_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.mainImage.setImage(img);	
	}

	@FXML
	public void BackToMenu(ActionEvent event) throws IOException {
		showMainMenu();
	}
	@FXML
	public void mainPaneExportEmployees(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("generate-report-employee.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REPORT_EMPLOYEE_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.reportEmployeeImage.setImage(img);
	}

	@FXML
	public void mainPaneExportOrders(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("generate-report-order.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REPORT_ORDER_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.reportOrderImage.setImage(img);
	}

	@FXML
	public void mainPaneExportProductsSales(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("generate-report-products.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REPORT_PRODUCTS_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.reportProductImage.setImage(img);
	}

	@FXML
	public void mainPaneGestionateBaseProduct(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("baseProduct-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
	}

	@FXML
	public void mainPaneGestionateCustome(ActionEvent event)throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("custome-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
	}

	@FXML
	public void mainPaneGestionateEmployee(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("employee-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
	}

	@FXML
	public void mainPaneGestionateIngredient(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("ingredients-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
	}

	@FXML
	public void mainPaneGestionateProduct(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("products-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
	}

	@FXML
	public void mainPaneGestionateUser(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("user-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
	}

	@FXML
	public void mainPaneImportCustomes(ActionEvent event) throws IOException {
		FileChooser fc = new FileChooser();		
		File selectedFile = fc.showSaveDialog(mainPane.getScene().getWindow());
		if (selectedFile !=null) {			
			restaurant.importCustomes(selectedFile.getAbsolutePath());
		}
	}

	@FXML
	public void mainPaneImportOrders(ActionEvent event) {

	}

	@FXML
	public void mainPaneImportBaseProducts(ActionEvent event) throws IOException {
		FileChooser fc = new FileChooser();		
		File selectedFile = fc.showSaveDialog(mainPane.getScene().getWindow());
		if (selectedFile !=null) {			
			restaurant.importBaseProducts(selectedFile.getAbsolutePath());
		}
	}
	@FXML
	public void mainPaneImportProducts(ActionEvent event) throws IOException {    	
		FileChooser fc = new FileChooser();		
		File selectedFile = fc.showSaveDialog(mainPane.getScene().getWindow());
		if (selectedFile !=null) {			
			restaurant.importProducts(selectedFile.getAbsolutePath());
		}
	}

	//---------------MAIN PANE GUI-----------------

	@FXML
	private Pane mainPane;


	//----------LOGIN GUI----------
	@FXML
	private Pane loginPane;

	@FXML
	private Label showMessage;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private TextField txtUserName;

	@FXML
	private ImageView loginImage;

	@FXML
	public void Login(ActionEvent event) {

	}

	@FXML
	public void loginCreateAnAccount(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("register-user.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REGISTER_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.regUserImage.setImage(img);
	}

	public void showLogin() throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("login.fxml"));
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(LOGIN_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.loginImage.setImage(img);	
	}
	// ---------------REGISTER USER GUI------------- 

	@FXML
	private TextField txtRegLastName;

	@FXML
	private TextField txtRegUsername;

	@FXML
	private PasswordField txtRegPassword;

	@FXML
	private TextField txtRegName;

	@FXML
	private TextField txtRegIdentification;

	@FXML
	private ImageView regUserImage;

	@FXML
	public void regUserGoToLogin(ActionEvent event) throws IOException {
		showLogin();
	}

	@FXML
	public void RegSignIn(ActionEvent event) throws IOException {

	}
	// -------REGISTER BASEPRODUCT GUI------------

	@FXML
	private TextField txtRegisterBaseProductName;

	@FXML
	private TextField txtRegisterBaseProductType;

	@FXML
	private TextField txtRegisterBaseProductIngredients;

	@FXML
	private Label txtRegBaseProductMessage;

	@FXML
	private ImageView regBaseProductImage;

	@FXML
	public void AddIngredientBaseProduct(ActionEvent event) {
		restaurant.getIngredientBP().add(restaurant.searchIngredient(txtRegisterBaseProductIngredients.getText()));
		txtRegisterBaseProductIngredients.setText("");
	}

	@FXML
	public void CreateABaseProduct(ActionEvent event) {
		restaurant.addBaseProduct(txtRegisterBaseProductName.getText(),restaurant.searchTypeProduct(txtRegisterBaseProductType.getText()),
				restaurant.getIngredientBP());
	}

	@FXML
	public void EraseLastIngredientBaseProduct(ActionEvent event) {
		int lastIngredient=restaurant.getIngredientBP().size();
		restaurant.getIngredientBP().remove(lastIngredient);
	}
	// ------------REGISTER PRODUCT TYPE GUI------------
	@FXML
	private TextField txtRegisterProductTypeName;

	@FXML
	private TextField txtRegisterProductTypeCode;

	@FXML
	private ImageView registerProductTypeImage;

	@FXML
	public void CreateAProductType(ActionEvent event) {
		restaurant.addProductType(txtRegisterProductTypeName.getText(),txtRegisterProductTypeCode.getText(), 
				restaurant.getUserLogged(), restaurant.getUserLogged());
	}
	//-----------REGISTER ORDER GUI---------

	@FXML
	private TextField txtRegisterOrderAmount;

	@FXML
	private Label txtRegisterOrderMessage;

	@FXML
	private TextField txtRegisterOrderCustomeLastName;

	@FXML
	private TextField txtRegisterOrderCustomeName;

	@FXML
	private TextField txtRegisterOrderEmployee;

	@FXML
	private TextField txtRegisterOrderProduct;

	@FXML
	private TextArea txtRegisterOrderObservations;    

	@FXML
	private ImageView registerOrderImage;

	@FXML
	public void AddProductOrder(ActionEvent event) {
		restaurant.getProductsOrder().add(restaurant.getProducts().get(restaurant.searchProduct(txtRegisterOrderProduct.getText())));
		int amount = Integer.parseInt(txtRegisterOrderAmount.getText());
		restaurant.getAmountProductsOrder().add(amount);
		txtRegisterOrderAmount.setText("");
		txtRegisterOrderProduct.setText("");
	}

	@FXML
	public void CreateAnOrder(ActionEvent event) throws ParseException {
		Date date = new Date();	
		restaurant.addOrder("REQUESTED", 
				restaurant.getCustomes().get(restaurant.binarySearchCustomes(txtRegisterOrderCustomeName.getText(),txtRegisterOrderCustomeLastName.getText())),
				restaurant.getEmployees().get(restaurant.searchEmployees(txtRegisterOrderEmployee.getText())), 
				date,
				txtRegisterOrderObservations.getText(), 
				restaurant.getUserLogged(),
				restaurant.getUserLogged(), 
				restaurant.getProductsOrder(), 
				restaurant.getAmountProductsOrder());
	}

	@FXML
	public void EraseLastProductOrder(ActionEvent event) {
		int lastProduct=restaurant.getProductsOrder().size();
		restaurant.getProductsOrder().remove(lastProduct);
		restaurant.getAmountProductsOrder().remove(lastProduct);
	}

	// ----------------- REGISTER CUSTOME GUI----------------
	@FXML
	private TextField txtRegisterCustomeName;

	@FXML
	private TextField txtRegisterCustomeLas;

	@FXML
	private TextField txtRegisterCustomeID;

	@FXML
	private TextField txtRegisterCustomeAddress;

	@FXML
	private TextField txtRegisterCustomePhone;

	@FXML
	private TextArea txtRegisterCustomeObservations;    

	@FXML
	private ImageView registerCustomeImage;

	@FXML
	public void CreateACustome(ActionEvent event) {
		restaurant.addCustomesListSorted(txtRegisterCustomeName.getText(),txtRegisterCustomeLas.getText(),
				txtRegisterCustomeID.getText(), txtRegisterCustomeAddress.getText(),txtRegisterCustomePhone.getText(),
				txtRegisterCustomeObservations.getText());
	}
	// ------------REGISTER EMPLOYEE GUI----------------
	@FXML
	private TextField txtRegisterEmployeeName;

	@FXML
	private TextField txtRegisterEmployeeLastnames;

	@FXML
	private TextField txtRegisterEmployeeID;

	@FXML
	private ImageView registerEmployeeImage;

	@FXML
	public void CreateAnEmployee(ActionEvent event) {
		restaurant.addEmployee(txtRegisterEmployeeName.getText(),txtRegisterEmployeeLastnames.getText(), 
				txtRegisterEmployeeID.getText());
	}
	// --------------REGISTER PRODUCT SIZE GUI-----------
	@FXML
	private TextField txtRegisterProductSizeName;

	@FXML
	private TextField txtRegisterProductSizeCode;

	@FXML
	private ImageView regProductSizeImage;

	@FXML
	public void CreateAProductSize(ActionEvent event) {
		restaurant.addProductSize(txtRegisterProductSizeName.getText(),txtRegisterProductSizeCode.getText(),
				restaurant.getUserLogged(), restaurant.getUserLogged());
	}
	//---------------REGISTER PRODUCT GUI---------------

	@FXML
	private TextField txtRegisterProductBaseProductName;

	@FXML
	private TextField txtRegisterProductSize;

	@FXML
	private TextField txtRegisterProductPrice;

	@FXML
	private TextField txtRegisterProductCode;

	@FXML
	private ImageView regProductImage;

	@FXML
	public void CreateAProduct(ActionEvent event) {
		double price= Double.parseDouble(txtRegisterProductPrice.getText());
		restaurant.addProduct(txtRegisterProductCode.getText(),restaurant.getBaseProducts().get(restaurant.searchBaseProduct(txtRegisterProductBaseProductName.getText())), 
				true, price, restaurant.getProductSize().get(restaurant.searchProductSize(txtRegisterProductSize.getText())),restaurant.getUserLogged(), restaurant.getUserLogged());
	}

	//---------REGISTER INGREDIENTS GUI-------------------

	@FXML
	private TextField txtRegisterIngredientName;

	@FXML
	private ImageView registerIngredientImage;

	@FXML
	public void CreateAnIngredient(ActionEvent event) {
		restaurant.addIngredients(txtRegisterIngredientName.getText(),restaurant.getUserLogged(),restaurant.getUserLogged());
	}

	//----------UPDATE CUSTOMES GUI--------------
	@FXML
	private TextField txtUpdateCustomeName;

	@FXML
	private TextField txtUpdateCustomeLastnames;

	@FXML
	private TextField txtUpdateCustomeID;

	@FXML
	private TextField txtUpdateCustomeAddress;

	@FXML
	private TextField txtUpdateCustomePhone;

	@FXML
	private TextArea txtUpdateCustomeObservations;

	@FXML
	private ImageView updateCustomeImage;

	@FXML
	public void UpdateCustome(ActionEvent event) {

	}

	//---------UPDATE EMPLOYEE GUI----------

	@FXML
	private TextField txtUpdateEmployeeName;

	@FXML
	private TextField txtUpdateEmployeeID;

	@FXML
	private TextField txtUpdateEmployeeLastnames;

	@FXML
	private ImageView updateEmployeeImage;

	@FXML
	public void UpdateEmployee(ActionEvent event) {

	}
	// -----------UPDATE ORDER GUI--------------
	@FXML
	private TextField txtUpdateOrderCustome;

	@FXML
	private TextField txtUpdateOrderAmount;

	@FXML
	private TextField txtUpdateOrderEmployee;

	@FXML
	private TextField txtUpdateOrderProduct;

	@FXML
	private TextField txtUpdateOrderObservations;

	@FXML
	private ImageView updateOrderImage;

	@FXML
	public void updateAddProductOrder(ActionEvent event) {

	}

	@FXML
	public void updateEraseLastProductOrder(ActionEvent event) {

	}

	@FXML
	public void UpdateOrder(ActionEvent event) {

	}
	//----------------UPDATE USER GUI----------------------
	@FXML
	private TextField txtUpdateUserName;

	@FXML
	private TextField txtUpdateUserLastnames;

	@FXML
	private TextField txtUpdateUserID;

	@FXML
	private TextField txtUpdateUserUsername;

	@FXML
	private TextField txtUpdateUserPassword;

	@FXML
	private ImageView updateUserImage;

	@FXML
	public void UpdateUser(ActionEvent event) {

	}

	//----------UPDATE BASE PRODUCT GUI-----------------
	@FXML
	private TextField txtUpdateBaseProductName;

	@FXML
	private TextField txtUpdateBaseProductTypeProduct;

	@FXML
	private TextField txtUpdateBaseProductIngredients;

	@FXML
	private ImageView updateBaseProductImage;

	@FXML
	public void AddIngredientsBaseProduct(ActionEvent event) {

	}

	@FXML
	public void EraseIngredientsBaseProduct(ActionEvent event) {

	}

	@FXML
	public void UpdateBaseProduct(ActionEvent event) {

	}
	//-------------UPDATE PRODUCT SIZE GUI--------------------
	@FXML
	private TextField txtUpdateProductSizeName;

	@FXML
	private TextField txtUpdateProductSizeCode;

	@FXML
	private ImageView updateProductSizeImage;

	@FXML
	public void UpdateProductSize(ActionEvent event) {

	}
	//-----------UPDATE PRODUCT GUI---------------
	@FXML
	private TextField txtUpdateProductName;

	@FXML
	private TextField txtUpdateProductSize;

	@FXML
	private TextField txtUploadProductPrice;

	@FXML
	private ImageView updateProductImage;

	@FXML
	public void updateProduct(ActionEvent event) {

	}
	//----------UPDATE PRODUCT TYPE GUI-------------
	@FXML
	private TextField txtUpdateProductTypeName;

	@FXML
	private TextField txtUpdateProductTypeCode;

	@FXML
	private TextField txtUpdateProductTypeState;

	@FXML
	private ImageView updateProductTypeImage;

	@FXML
	public void UpdateProductType(ActionEvent event) {

	}

	//----------UPDATE INGREDIENTS GUI-------------

	@FXML
	private TextField txtUpdateIngredientName;

	@FXML
	private TextField txtUpdateIngredientState;

	@FXML
	private ImageView updateIngredientImage;

	@FXML
	void UpdateIngredient(ActionEvent event) {

	}

	//------------- USER VIEW GUI-----------------

	@FXML
	private TableView<User> userTableView;

	@FXML
	private TableColumn<User, String> userName;

	@FXML
	private TableColumn<User, String> userLastname;

	@FXML
	private TableColumn<User, String> userUsername;

	@FXML
	private TableColumn<User, String> userPassword;

	@FXML
	private TextField txtUserUsername;

	@FXML
	public void AddNewUser(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("register-user.fxml"));
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REGISTER_USER_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.regUserImage.setImage(img);
	}

	@FXML
	public void DeleteUser(ActionEvent event) {
		restaurant.eraseUser(txtUserUsername.getText());
	}

	public void initializableTableUserView() {
		ObservableList <User> userList = FXCollections.observableArrayList(restaurant.getUsers());
		userTableView.setItems(userList); 
		userName.setCellValueFactory(new PropertyValueFactory <User,String>("name"));
		userLastname.setCellValueFactory(new PropertyValueFactory <User,String>("lastname"));
		userUsername.setCellValueFactory(new PropertyValueFactory <User,String>("username"));
		userPassword.setCellValueFactory(new PropertyValueFactory <User,String>("password"));
	}

	//------------ORDER VIEW GUI------------
	@FXML
	private TableView<Order> ordersTableView;

	@FXML
	private TableColumn<Order, String> ordersCode;

	@FXML
	private TableColumn<Order, String> ordersDate;

	@FXML
	private TableColumn<Order, String> ordersAmount;

	@FXML
	private TableColumn<Order, String> ordersProduct;

	@FXML
	private TableColumn<Order, String> ordersCustome;

	@FXML
	private TableColumn<Order, String> ordersObservations;

	@FXML
	private TableColumn<Order, String> ordersState;

	@FXML
	private TableColumn<Order, String> ordersEmployee;

	@FXML
	private TextField txtOrdersCode;

	@FXML
	public void AddNewOrder(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("register-Order.fxml"));
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REGISTER_ORDER_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.registerOrderImage.setImage(img);
	}

	@FXML
	public void DeleteOrder(ActionEvent event) {
		restaurant.eraseOrder(txtOrdersCode.getText());
	}

	public void initializableTableOrderView() {
		ObservableList <Order> orderList = FXCollections.observableArrayList(restaurant.getOrders());
		ordersTableView.setItems(orderList); 
		ordersCode.setCellValueFactory(new PropertyValueFactory <Order,String>("code"));
		ordersDate.setCellValueFactory(new PropertyValueFactory <Order,String>("date"));
		ordersAmount.setCellValueFactory(new PropertyValueFactory <Order,String>("amount"));
		ordersProduct.setCellValueFactory(new PropertyValueFactory <Order,String>("product"));
		ordersCustome.setCellValueFactory(new PropertyValueFactory <Order,String>("custome"));
		ordersObservations.setCellValueFactory(new PropertyValueFactory <Order,String>("observations"));
		ordersState.setCellValueFactory(new PropertyValueFactory <Order,String>("state"));
		ordersEmployee.setCellValueFactory(new PropertyValueFactory <Order,String>("employee"));
	}

	//-------------PRODUCT VIEW GUI------------------
	@FXML
	private TableView<Product> productsTableView;

	@FXML
	private TableColumn<Product, String> productsName;

	@FXML
	private TableColumn<Product, String> productsCode;

	@FXML
	private TableColumn<Product, String> productsType;

	@FXML
	private TableColumn<Product, String> productsIngredients;

	@FXML
	private TableColumn<Product, String>productsState;

	@FXML
	private TableColumn<Product, String> productsPrice;

	@FXML
	private TableColumn<Product, String>productsSize;

	@FXML
	private TextField txtProductCode;

	@FXML
	public void AddNewProduct(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("register-Product.fxml"));
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REGISTER_PRODUCT_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.regProductImage.setImage(img);
	}

	@FXML
	public void DeleteProduct(ActionEvent event) {
		restaurant.eraseProduct(txtProductCode.getText());
	}

	public void initializableTableProductView() {
		ObservableList <Product> productList = FXCollections.observableArrayList(restaurant.getProducts());
		productsTableView.setItems(productList); 
		productsName.setCellValueFactory(new PropertyValueFactory <Product,String>("name"));
		productsCode.setCellValueFactory(new PropertyValueFactory <Product,String>("code"));
		productsType.setCellValueFactory(new PropertyValueFactory <Product,String>("type"));
		productsIngredients.setCellValueFactory(new PropertyValueFactory <Product,String>("ingredients"));
		productsState.setCellValueFactory(new PropertyValueFactory <Product,String>("state"));
		productsPrice.setCellValueFactory(new PropertyValueFactory <Product,String>("price"));
		productsSize.setCellValueFactory(new PropertyValueFactory <Product,String>("size"));
	}

	//-------------------BASEPRODUCT VIEW GUI--------------------
	@FXML
	private TableView<BaseProduct> baseProductTableView;

	@FXML
	private TableColumn<BaseProduct, String> baseProductName;

	@FXML
	private TableColumn<BaseProduct, String> baseProductType;

	@FXML
	private TableColumn<BaseProduct, String> baseProductIngredients;

	@FXML
	private TextField txtBaseProductName;

	@FXML
	public void AddNewBaseProduct(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("register-baseProduct.fxml"));
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REGISTER_BASE_PRODUCT_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.regBaseProductImage.setImage(img);
	}    

	@FXML
	public void DeleteBaseProduct(ActionEvent event) {
		restaurant.eraseBaseProduct(txtBaseProductName.getText());

	}	

	public void initializableTableBaseProductView() {
		ObservableList <BaseProduct> baseProductList = FXCollections.observableArrayList(restaurant.getBaseProducts());
		baseProductTableView.setItems(baseProductList); 
		baseProductName.setCellValueFactory(new PropertyValueFactory <BaseProduct,String>("name"));
		baseProductType.setCellValueFactory(new PropertyValueFactory <BaseProduct,String>("type"));
		baseProductIngredients.setCellValueFactory(new PropertyValueFactory <BaseProduct,String>("ingredients"));
	}
	// ---------------INGREDIENTS VIEW GUI------------


	@FXML
	private TableView<Ingredients> ingredientsTableView;

	@FXML
	private TableColumn<Ingredients,String> ingredientsName;

	@FXML
	private TableColumn<Ingredients,String> ingredientsState;

	@FXML
	private TextField txtIngredientName;


	@FXML
	public void AddNewIngredient(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("NO EXISTE"));//****************CREAR GUI REGISTER INGREDIENT Y UPDATE INGREDIENT**************
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(MAIN_MENU_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.mainImage.setImage(img);	
	}

	@FXML
	public void DeleteIngredients(ActionEvent event) {
		restaurant.eraseIngredient(txtIngredientName.getText());
	}

	public void initializableTableIngredientsView() {
		ObservableList <Ingredients> ingredients = FXCollections.observableArrayList(restaurant.getIngredients());
		ingredientsTableView.setItems(ingredients); 
		ingredientsName.setCellValueFactory(new PropertyValueFactory <Ingredients,String>("name"));
		ingredientsState.setCellValueFactory(new PropertyValueFactory <Ingredients,String>("state"));		 
	}
	//----------EMPLOYEE VIEW GUI-----------

	@FXML
	private TableView<Employee> employeeTableView;

	@FXML
	private TableColumn<Employee, String> employeeName;

	@FXML
	private TableColumn<Employee, String> employeeLastName;

	@FXML
	private TableColumn<Employee, String> employeeID;

	@FXML
	private TableColumn<Employee, String> employeeState;

	@FXML
	private TextField txtEmployeeID;

	@FXML
	public void AddNewEmployee(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("register-employee.fxml"));
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REGISTER_EMPLOYEE_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.registerEmployeeImage.setImage(img);    	
	}

	@FXML
	public void DeleteEmployee(ActionEvent event) {
		restaurant.eraseEmployee(txtEmployeeID.getText());
	}

	public void initializableTableEmployeeView() {
		ObservableList <Employee> employeesList = FXCollections.observableArrayList(restaurant.getEmployees());
		employeeTableView.setItems(employeesList); 
		employeeName.setCellValueFactory(new PropertyValueFactory <Employee,String>("name"));
		employeeLastName.setCellValueFactory(new PropertyValueFactory <Employee,String>("lastname"));
		employeeID.setCellValueFactory(new PropertyValueFactory <Employee,String>("id"));		 
		employeeState.setCellValueFactory(new PropertyValueFactory <Employee,String>("state"));		 
	}
	//------------CUSTOMES VIEW GUI-------------------

	@FXML
	private TableView<Custome> customeTableView;

	@FXML
	private TableColumn<Custome, String> customesLastName;

	@FXML
	private TableColumn<Custome, String> customesName;

	@FXML
	private TableColumn<Custome, String> customesID;

	@FXML
	private TableColumn<Custome, String> customesAddress;

	@FXML
	private TableColumn<Custome, String> customesPhone;

	@FXML
	private TableColumn<Custome, String> customesObservations;

	@FXML
	private TableColumn<Custome, String> customesState;

	@FXML
	private TextField txtCustomeLastName;

	@FXML
	private TextField txtCustomeName;

	@FXML
	public void AddNewCustome(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("register-custome.fxml"));
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REGISTER_CUSTOME_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.registerCustomeImage.setImage(img); 
	}

	@FXML
	public void DeleteCustome(ActionEvent event) {
		restaurant.eraseCustome(txtCustomeName.getText(),txtCustomeLastName.getText());
	}

	public void initializableTableCustomeView() {
		ObservableList <Custome> customeList = FXCollections.observableArrayList(restaurant.getCustomes());
		customeTableView.setItems(customeList); 
		customesLastName.setCellValueFactory(new PropertyValueFactory <Custome,String>("lastname"));
		customesName.setCellValueFactory(new PropertyValueFactory <Custome,String>("name"));
		customesID.setCellValueFactory(new PropertyValueFactory <Custome,String>("id"));		 
		customesAddress.setCellValueFactory(new PropertyValueFactory <Custome,String>("address"));	
		customesPhone.setCellValueFactory(new PropertyValueFactory <Custome,String>("phone"));		 
		customesObservations.setCellValueFactory(new PropertyValueFactory <Custome,String>("observations"));
		customesState.setCellValueFactory(new PropertyValueFactory <Custome,String>("state"));
	}
	//------------PRODUCT TYPE VIEW GUI------------
	@FXML
	private TableView<ProductType> productTypeTableView;

	@FXML
	private TableColumn<ProductType, String> productTypeName;

	@FXML
	private TableColumn<ProductType, String> productTypeCode;

	@FXML
	private TextField txtProductTypeCode;

	@FXML
	public void AddNewProductType(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("register-productType.fxml"));
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REGISTER_PRODUCT_TYPE_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.registerProductTypeImage.setImage(img); 
	}

	@FXML
	public void DeleteProductType(ActionEvent event) { 
		restaurant.eraseProductType(txtProductTypeCode.getText());

	}

	public void initializableTableProductTypeView() {
		ObservableList <ProductType> productTypeList = FXCollections.observableArrayList(restaurant.getProductType());
		productTypeTableView.setItems(productTypeList); 
		productTypeName.setCellValueFactory(new PropertyValueFactory <ProductType,String>("name"));
		productTypeCode.setCellValueFactory(new PropertyValueFactory <ProductType,String>("code"));
	}

	//------------PRODUCT SIZE VIEW GUI------------
	@FXML
	private TableView<ProductSize> productSizeTableView;

	@FXML
	private TableColumn<ProductSize, String> productSizeName;

	@FXML
	private TableColumn<ProductSize, String> productSizeCode;

	@FXML
	private TextField txtProductSizeCode;

	@FXML
	public void AddNewProductSize(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("register-productSize.fxml"));
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REGISTER_PRODUCT_SIZE_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.regProductSizeImage.setImage(img); 
	}

	@FXML
	public void DeleteProductSize(ActionEvent event) {
		restaurant.eraseProductSize(txtProductSizeCode.getText());

	}

	public void initializableTableProductSizeView() {
		ObservableList <ProductSize> productSizeList = FXCollections.observableArrayList(restaurant.getProductSize());
		productSizeTableView.setItems(productSizeList); 
		productSizeName.setCellValueFactory(new PropertyValueFactory <ProductSize,String>("name"));
		productSizeCode.setCellValueFactory(new PropertyValueFactory <ProductSize,String>("code"));
	}

	//-------------GENERATE REPORT PRODUCTS GUI-----------
	@FXML
	private DatePicker initialDateProductReport;

	@FXML
	private TextField initialHourProductReport;

	@FXML
	private DatePicker finalDateProductReport;

	@FXML
	private TextField finalHourProductReport;

	@FXML
	private ImageView reportProductImage;

	@FXML
	private TextField fileSeparatorReportProduct;

	@FXML
	public void generateReportByProduct(ActionEvent event)throws FileNotFoundException {
		restaurant.setFILE_SEPARATOR(fileSeparatorReportProduct.getText());
		String initialDay=initialDateProductReport.getValue().toString();
		String finalDay=finalDateProductReport.getValue().toString();
		String initialHour=initialHourProductReport.getText();
		String finalHour=finalHourProductReport.getText();;
		FileChooser fc = new FileChooser();		
		File selectedFile = fc.showSaveDialog(mainPane.getScene().getWindow());
		if (selectedFile !=null) {			
			restaurant.productsOrderReport(selectedFile.getAbsolutePath(), initialDay, finalDay, initialHour, finalHour);
		}

	}
	//---------------GENERATE REPORT EMPLOYEEE GUI---------------

	@FXML
	private DatePicker initialDateEmployeeReport;

	@FXML
	private TextField initialHourEmployeeReport;

	@FXML
	private DatePicker finalDateEmployeeReport;

	@FXML
	private TextField finalHourEmployeeReport;

	@FXML
	private ImageView reportEmployeeImage;

	@FXML
	private TextField fileSeparatorReportEmployee;

	@FXML
	public void generateReportByEmployee(ActionEvent event) throws FileNotFoundException {
		restaurant.setFILE_SEPARATOR(fileSeparatorReportEmployee.getText());
		String initialDay=initialDateEmployeeReport.getValue().toString();
		String finalDay=finalDateEmployeeReport.getValue().toString();
		String initialHour=initialHourEmployeeReport.getText();
		String finalHour=finalHourEmployeeReport.getText();;
		FileChooser fc = new FileChooser();		
		File selectedFile = fc.showSaveDialog(mainPane.getScene().getWindow());
		if (selectedFile !=null) {			
			restaurant.employeesOrdersReport(selectedFile.getAbsolutePath(), initialDay, finalDay, initialHour, finalHour);
		}
	}   
	//----------------GENERATE REPORT ORDER GUI------------

	@FXML
	private DatePicker initialDateOrderReport;

	@FXML
	private TextField initialHourOrderReport;

	@FXML
	private DatePicker finalDateOrderReport;

	@FXML
	private TextField finalHourOrderReport;

	@FXML
	private ImageView reportOrderImage;

	@FXML
	private TextField fileSeparatorReportOrder;



	@FXML
	public void generateOrderReport(ActionEvent event) throws FileNotFoundException {
		restaurant.setFILE_SEPARATOR(fileSeparatorReportOrder.getText());
		String initialDay=initialDateOrderReport.getValue().toString();
		String finalDay=finalDateOrderReport.getValue().toString();
		String initialHour=initialHourOrderReport.getText();
		String finalHour=finalHourOrderReport.getText();;
		FileChooser fc = new FileChooser();		
		File selectedFile = fc.showSaveDialog(mainPane.getScene().getWindow());
		if (selectedFile !=null) {			
			restaurant.exportOrdersReport(selectedFile.getAbsolutePath(), initialDay, finalDay, initialHour, finalHour);
		}
	}

	//----------------OTHER METHODS--------------


	@FXML
	public void initialize() {

	} 
	
	public void digitalClock() {
		Calendar calendar = new GregorianCalendar();
		Date currentTime = new Date();
		calendar.setTime(currentTime);
		time="";
		hours = calendar.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendar.get(Calendar.HOUR_OF_DAY)
		: "0" + calendar.get(Calendar.HOUR_OF_DAY);
		minutes = calendar.get(Calendar.MINUTE) > 9 ? "" + calendar.get(Calendar.MINUTE)
		: "0" + calendar.get(Calendar.MINUTE);
		seconds = calendar.get(Calendar.SECOND) > 9 ? "" + calendar.get(Calendar.SECOND)
		: "0" + calendar.get(Calendar.SECOND);
		time=hours+":"+minutes+":"+seconds;
	}

	public RestaurantGUI(Restaurant restaurant) {
		this.restaurant=restaurant;	

	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SimpleDateFormat objSDFDay= new SimpleDateFormat("dd/MM/YYYY");
		Date newDate = new Date();
		mainPaneDate.setText(objSDFDay.format(newDate));	
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000000000; i++) {
					digitalClock();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							mainPaneHour.setText(time);
						}
					});
				}
			}
		}).start();
	}

}
