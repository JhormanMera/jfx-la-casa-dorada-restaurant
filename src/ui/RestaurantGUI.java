package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import model.Restaurant;


public class RestaurantGUI {

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

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	
	//-----------MAIN MENU GUI------------
	
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
	
	//---------------MAIN PANE GUI-----------------
	@FXML
    private Label mainPaneHour;

    @FXML
    private Pane mainPane;

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
	public  void loginCreateAnAccount(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("register.fxml"));
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
    public void CreateAnAccount(ActionEvent event) {

    }

    @FXML
    public void RegSignIn(ActionEvent event) throws IOException {
    	showLogin();
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
    //------------- USER VIEW GUI-----------------

    @FXML
    private TableView<?> tableViewUser;

    @FXML
    private TableColumn<?, ?> userName;

    @FXML
    private TableColumn<?, ?> userLastname;

    @FXML
    private TableColumn<?, ?> userUsername;

    @FXML
    private TableColumn<?, ?> userPassword;

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
    //------------ORDER VIEW GUI------------
    @FXML
    private TableView<?> ordersTableView;

    @FXML
    private TableColumn<?, ?> ordersCode;

    @FXML
    private TableColumn<?, ?> ordersDate;

    @FXML
    private TableColumn<?, ?> ordersAmount;

    @FXML
    private TableColumn<?, ?> ordersProduct;

    @FXML
    private TableColumn<?, ?> ordersCustome;

    @FXML
    private TableColumn<?, ?> ordersObservations;

    @FXML
    private TableColumn<?, ?> ordersState;

    @FXML
    private TableColumn<?, ?> ordersEmployee;

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
    //-------------PRODUCT VIEW GUI------------------
    @FXML
    private TableView<?> productsTableView;

    @FXML
    private TableColumn<?, ?> productsName;

    @FXML
    private TableColumn<?, ?> productsName1;

    @FXML
    private TableColumn<?, ?> productsType;

    @FXML
    private TableColumn<?, ?> productsIngredients;

    @FXML
    private TableColumn<?, ?> ProductsAvailable;

    @FXML
    private TableColumn<?, ?> productsPrice;

    @FXML
    private TableColumn<?, ?> productsSize;

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
    //-------------------BASEPRODUCT VIEW GUI--------------------
    @FXML
    private TableView<?> baseProductTableView;

    @FXML
    private TableColumn<?, ?> baseProductName;

    @FXML
    private TableColumn<?, ?> baseProductType;

    @FXML
    private TableColumn<?, ?> baseProductIngredients;

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
   // ---------------INGREDIENTS VIEW GUI------------

    @FXML
    private TableView<?> ingredientsTableView;

    @FXML
    private TableColumn<?, ?> ingredientsName;

    @FXML
    private TableColumn<?, ?> ingredientsState;

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
    //----------EMPLOYEE VIEW GUI-----------

    @FXML
    private TableView<?> employeeTableView;

    @FXML
    private TableColumn<?, ?> employeeName;

    @FXML
    private TableColumn<?, ?> employeeLastName;

    @FXML
    private TableColumn<?, ?> employeeID;

    @FXML
    private TableColumn<?, ?> employeeState;

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
    //------------CUSTOMES VIEW GUI-------------------

    @FXML
    private TableView<?> customeTableView;

    @FXML
    private TableColumn<?, ?> customesLastName;

    @FXML
    private TableColumn<?, ?> customesName;

    @FXML
    private TableColumn<?, ?> customesID;

    @FXML
    private TableColumn<?, ?> customesAddress;

    @FXML
    private TableColumn<?, ?> customesPhone;

    @FXML
    private TableColumn<?, ?> customesObservations;

    @FXML
    private TableColumn<?, ?> customesState;

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
    //------------PRODUCT TYPE VIEW GUI------------
    @FXML
    private TableView<?> productTypeTableView;

    @FXML
    private TableColumn<?, ?> ProductTypeName;

    @FXML
    private TableColumn<?, ?> ProductTypeCode;

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

    }
    //------------PRODUCT SIZE VIEW GUI------------
    @FXML
    private TableView<?> productSizeTableView;

    @FXML
    private TableColumn<?, ?> ProductName;

    @FXML
    private TableColumn<?, ?> ProductSizeCode;

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
    	FileChooser fc = new FileChooser();		
		File selectedFile = fc.showSaveDialog(mainPane.getScene().getWindow());
		if (selectedFile !=null) {			
		restaurant.productsOrderReport(selectedFile.getAbsolutePath());
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
    	FileChooser fc = new FileChooser();		
		File selectedFile = fc.showSaveDialog(mainPane.getScene().getWindow());
		if (selectedFile !=null) {			
    	restaurant.employeesOrdersReport(selectedFile.getAbsolutePath());
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
    	FileChooser fc = new FileChooser();		
		File selectedFile = fc.showSaveDialog(mainPane.getScene().getWindow());
		if (selectedFile !=null) {			
    	restaurant.exportOrdersReport(selectedFile.getAbsolutePath());
		}
    }
    
    //----------------OTHER METHODS--------------
    @FXML
    public void initialize() {
    	
     
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
}
