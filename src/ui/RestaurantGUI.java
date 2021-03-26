package ui;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Restaurant;
//import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
//import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;


public class RestaurantGUI {

	private Restaurant restaurant;

	private static final String LOGIN_IMAGE_PATH = "data/images/Lacasadorada.jpg";
	
	private static final String MAIN_MENU_IMAGE_PATH = "data/images/Lacasadorada.jpg";

	private static final String REGISTER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	/*
	private static final String REGISTER_BASE_PRODUCT_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String REGISTER_PRODUCT_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String REGISTER_ORDER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String REGISTER_PRODUCT_TYPE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String REGISTER_PRODUCT_SIZE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String REGISTER_CUSTOME_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String REGISTER_EMPLOYEE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String REGISTER_USER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String REPORT_ORDRER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String REPORT_PRODUCTS_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String REPORT_EMPLOYEE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
*/
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
    }
    
    @FXML
    public void mainPaneExportOrders(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("generate-report-order.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
    }

    @FXML
    public void mainPaneExportProductsSales(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("generate-report-products.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
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
    public void mainPaneImportCustomes(ActionEvent event) {

    }

    @FXML
    public void mainPaneImportOrders(ActionEvent event) {

    }

    @FXML
    public void mainPaneImportProducts(ActionEvent event) {

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
    }

    @FXML
    public void CreateABaseProduct(ActionEvent event) {
    	restaurant.addBaseProduct(txtRegisterBaseProductName.getText(),restaurant.searchTypeProduct(txtRegisterBaseProductType.getText()),
    			restaurant.getIngredientBP());
    }

    @FXML
    public void EraseLastIngredientBaseProduct(ActionEvent event) {

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
    private TextField txtRegisterOrderCode;

    @FXML
    private TextField txtRegisterOrderAmount;

    @FXML
    private Label txtRegisterOrderMessage;

    @FXML
    private TextField txtRegisterOrderCustome;

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

    }

    @FXML
    public void CreateAnOrder(ActionEvent event) {

    }

    @FXML
    public void EraseLastProductOrder(ActionEvent event) {

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
    //
    
    /*
    
    @FXML
    public void AddNewProduct(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("register-Product.fxml"));
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REGISTER_PRODUCT_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.mainImage.setImage(img);
    }

    @FXML
    public void DeleteProduct(ActionEvent event) {
    	restaurant.eraseProduct(txtProductCode.getText());
    }
    
    
    @FXML
    public void AddNewOrder(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("register-Order.fxml"));
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REGISTER_PRODUCT_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.mainImage.setImage(img);
    }

    @FXML
    public void DeleteOrder(ActionEvent event) {
    	restaurant.eraseOrder(txtOrdersCode.getText());
    }
    
    

    @FXML
    public void AddNewIngredient(ActionEvent event) throws IOException {
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
    public void DeleteIngredients(ActionEvent event) {
    	restaurant.eraseIngredient(txtIngredientName.getText());
    }

    @FXML
    public void generateReportByProduct(ActionEvent event) {

    }

    @FXML
    public void generateOrderReport(ActionEvent event) {

    }

    @FXML
    public void generateReportByEmployee(ActionEvent event) {

    }

    @FXML
    public void AddNewEmployee(ActionEvent event) {

    }

    @FXML
    public void DeleteEmployee(ActionEvent event) {
    	restaurant.eraseEmployee(txtEmployeeID.getText());
    }

    @FXML
    public void AddNewCustome(ActionEvent event) {

    }

    @FXML
    public void DeleteCustome(ActionEvent event) {
    	restaurant.eraseCustome(txtCustomeName.getText(),txtCustomeLastName.getText());
    }

    @FXML
    public void AddNewBaseProduct(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("register-baseProduct.fxml"));
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REGISTER_BASE_PRODUCT_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.mainImage.setImage(img);
    }    
    
    @FXML
    public void DeleteBaseProduct(ActionEvent event) {
    	restaurant.eraseBaseProduct(txtBaseProductName.getText());

    }	
	*/
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
