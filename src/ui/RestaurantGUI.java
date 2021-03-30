package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
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

	private static final String REGISTER_BASE_PRODUCT_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_PRODUCT_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_ORDER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_PRODUCT_TYPE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_PRODUCT_SIZE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_CUSTOME_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_EMPLOYEE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REGISTER_USER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String REGISTER_INGREDIENT_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String UPDATE_BASE_PRODUCT_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String UPDATE_PRODUCT_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String UPDATE_ORDER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String UPDATE_PRODUCT_TYPE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String UPDATE_PRODUCT_SIZE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String UPDATE_CUSTOME_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String UPDATE_EMPLOYEE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String UPDATE_USER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String UPDATE_INGREDIENT_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REPORT_ORDER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REPORT_PRODUCTS_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private static final String REPORT_EMPLOYEE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";

	private String hours, minutes, seconds,time;
	
	private User selectedUser;
	
	private Employee selectedEmployee;
	
	private Product selectedProduct;
	
	private ProductSize selectedPZ;
	
	private Custome selectedCustome;
	
	private Ingredients selectedIngredient;
	
	private Order selectedOrder;
	
	private ProductType selectedPT;
	
	private BaseProduct selectedBP;

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
	public void logOut(ActionEvent event) throws IOException {
		showLogin();
		restaurant.setUserLogged(null);
		setAllNull();
	}
	
	@FXML
	public void BackToMenu(ActionEvent event) throws IOException {
		showMainMenu();
		setAllNull();
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
		LocalDate now = LocalDate.now();
		initialDateEmployeeReport.setValue(now);
		finalDateEmployeeReport.setValue(now);
		
		initialHourEmployeeReport.setText("00:00:00");
		finalHourEmployeeReport.setText("23:59:59");
		fileSeparatorReportEmployee.setText(";");
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
		LocalDate now = LocalDate.now();
		initialDateOrderReport.setValue(now);
		finalDateOrderReport.setValue(now);
		
		initialHourOrderReport.setText("00:00:00");
		finalHourOrderReport.setText("23:59:59");
		fileSeparatorReportOrder.setText(";");
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
		LocalDate now = LocalDate.now();
		initialDateProductReport.setValue(now);
		finalDateProductReport.setValue(now);
		
		initialHourProductReport.setText("00:00:00");
		finalHourProductReport.setText("23:59:59");;
		fileSeparatorReportProduct.setText(";");;
	}

	@FXML
	public void mainPaneGestionateBaseProduct(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("baseProduct-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		initializableTableBaseProductView();
		setAllNull();
	}

	@FXML
	public void mainPaneGestionateCustome(ActionEvent event)throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("custome-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		initializableTableCustomeView();
		setAllNull();
	}

	@FXML
	public void mainPaneGestionateEmployee(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("employee-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		initializableTableEmployeeView();
		setAllNull();
	}

	@FXML
	public void mainPaneGestionateIngredient(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("ingredients-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		initializableTableIngredientsView();
		setAllNull();
	}

	@FXML
	public void mainPaneGestionateProduct(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("products-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		initializableTableProductView();
		setAllNull();
	}

	@FXML
	public void mainPaneGestionateUser(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("user-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		initializableTableUserView();
		setAllNull();
	}
	
	@FXML
    public void mainPaneGestionateOrder(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("order-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		initializableTableOrderView();
		setAllNull();
    }
	
    @FXML
    public void mainPaneGestionateProductSize(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("productSize-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		initializableTableProductSizeView();
		setAllNull();
    }

    @FXML
    public void mainPaneGestionateProductType(ActionEvent event) throws IOException {
    	FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("productType-view.fxml"));
		fxmlloader.setController(this);
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		initializableTableProductTypeView();
		setAllNull();
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
	public void mainPaneImportOrders(ActionEvent event) throws IOException, ParseException {
		FileChooser fc = new FileChooser();		
		File selectedFile = fc.showSaveDialog(mainPane.getScene().getWindow());
		if (selectedFile !=null) {			
			restaurant.importOrders(selectedFile.getAbsolutePath());
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
		File f = new File(REGISTER_USER_IMAGE_PATH);
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
		String space=" ";
		String empty="";
		if(txtRegName.getText()!=space&&txtRegName.getText()!=empty&&
			txtRegLastName.getText()!=space&&txtRegLastName.getText()!=empty&&
					txtRegIdentification.getText()!=space&&txtRegIdentification.getText()!=empty&&
							txtRegUsername.getText()!=space&&txtRegUsername.getText()!=empty&&
									txtRegPassword.getText()!=space&&txtRegPassword.getText()!=empty) {
			
		restaurant.addUser(txtRegName.getText(), txtRegLastName.getText(), txtRegIdentification.getText(), txtRegUsername.getText(),txtRegPassword.getText(),restaurant.getUserLogged(),restaurant.getUserLogged(),true);
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Register User");
			alert.setContentText("An error has occurred registering the User, fields can´t be empty");
			alert.showAndWait();
		}
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
		String space=" ";
		String empty="";
		if(txtRegisterBaseProductIngredients.getText()!=space&&txtRegisterBaseProductIngredients.getText()!=empty&&restaurant.searchIngredient(txtRegisterBaseProductIngredients.getText()).getState()==true) {
		restaurant.getIngredientBP().add(restaurant.searchIngredient(txtRegisterBaseProductIngredients.getText()));
		txtRegisterBaseProductIngredients.setText("");
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Register Base Product");
			alert.setContentText("An error has occurred registering the Ingredient into the Base Product, fields can´t be empty or the Ingredient can´t be disabled");
			alert.showAndWait();
		}
	}
	
	@FXML
	public void CreateABaseProduct(ActionEvent event) throws FileNotFoundException, IOException {
		String space=" ";
		String empty="";
		if(txtRegisterBaseProductName.getText()!=space&&txtRegisterBaseProductName.getText()!=empty&&
				txtRegLastName.getText()!=space&&txtRegLastName.getText()!=empty&&
				txtRegisterBaseProductType.getText()!=space&&txtRegisterBaseProductType.getText()!=empty &&
				restaurant.getIngredientBP()!=null&&restaurant.searchTypeProduct(txtRegisterBaseProductType.getText()).getState()==true) {			
			restaurant.addBaseProduct(txtRegisterBaseProductName.getText(),restaurant.searchTypeProduct(txtRegisterBaseProductType.getText()),
					restaurant.getIngredientBP());
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Register Base Product");
			alert.setContentText("An error has occurred registering the Base Product, fields can´t be empty or the Product Type can´t be disabled");
			alert.showAndWait();
		}
		restaurant.setIngredientBP(null);
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
	public void CreateAProductType(ActionEvent event) throws FileNotFoundException, IOException {
		String space=" ";
		String empty="";
		if(txtRegisterProductTypeName.getText()!=space&&txtRegisterProductTypeName.getText()!=empty&&
				txtRegisterProductTypeCode.getText()!=space&&txtRegisterProductTypeCode.getText()!=empty) {	
			
			restaurant.addProductType(txtRegisterProductTypeName.getText(),txtRegisterProductTypeCode.getText(), 
					restaurant.getUserLogged(), restaurant.getUserLogged());
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Register Product Type");
			alert.setContentText("An error has occurred registering the Product Type, fields can´t be empty");
			alert.showAndWait();
		}
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
		String space=" ";
		String empty="";
		if(txtRegisterOrderProduct.getText()!=space&&txtRegisterOrderProduct.getText()!=empty&&
				txtRegisterOrderAmount.getText()!=space&&txtRegisterOrderAmount.getText()!=empty) {
			
			if(restaurant.searchProduct(txtRegisterOrderProduct.getText())>=0&&
					restaurant.getProducts().get(restaurant.searchProduct(txtRegisterOrderProduct.getText())).getState()==true) {

				restaurant.getProductsOrder().add(restaurant.getProducts().get(restaurant.searchProduct(txtRegisterOrderProduct.getText())));
				int amount = Integer.parseInt(txtRegisterOrderAmount.getText());
				restaurant.getAmountProductsOrder().add(amount);
				txtRegisterOrderAmount.setText("");
				txtRegisterOrderProduct.setText("");
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Register Order");
				alert.setContentText("An error has occurred registering the Product into the Order, the product is disabled or doesnt exist");
				alert.showAndWait();
			}
		}
	}

	@FXML
	public void CreateAnOrder(ActionEvent event) throws ParseException, FileNotFoundException, IOException {
		Date date = new Date();	
		String space=" ";
		String empty="";
		if(txtRegisterOrderCustomeName.getText()!=space&&txtRegisterOrderCustomeName.getText()!=empty&&
				txtRegisterOrderCustomeLastName.getText()!=space&&txtRegisterOrderCustomeLastName.getText()!=empty&&
				txtRegisterOrderEmployee.getText()!=space&&txtRegisterOrderEmployee.getText()!=empty) {	
				
				if(restaurant.getEmployees().get(restaurant.searchEmployees(txtRegisterOrderEmployee.getText())).getState()==true&&
						restaurant.getCustomes().get(restaurant.binarySearchCustomes(txtRegisterOrderCustomeName.getText(),txtRegisterOrderCustomeLastName.getText())).getState()==true) {				

			restaurant.addOrder("REQUESTED", 
					restaurant.getCustomes().get(restaurant.binarySearchCustomes(txtRegisterOrderCustomeName.getText(),txtRegisterOrderCustomeLastName.getText())),
					restaurant.getEmployees().get(restaurant.searchEmployees(txtRegisterOrderEmployee.getText())), 
					date,
					txtRegisterOrderObservations.getText(), 
					restaurant.getUserLogged(),
					restaurant.getUserLogged(), 
					restaurant.getProductsOrder(), 
					restaurant.getAmountProductsOrder());
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Register Order");
					alert.setContentText("An error has occurred registering the Order, the Custome or the Employee is disabled or doesnt exist");
					alert.showAndWait();
				}
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Register Order");
			alert.setContentText("An error has occurred registering the Order, fields can´t be empty");
			alert.showAndWait();
		}
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
	public void CreateACustome(ActionEvent event) throws FileNotFoundException, IOException {
		String space=" ";
		String empty="";
		if(txtRegisterCustomeName.getText()!=space&&txtRegisterCustomeName.getText()!=empty&&
				txtRegisterCustomeLas.getText()!=space&&txtRegisterCustomeLas.getText()!=empty&&
						txtRegisterCustomeID.getText()!=space&&txtRegisterCustomeID.getText()!=empty&&
								txtRegisterCustomeAddress.getText()!=space&&txtRegisterCustomeAddress.getText()!=empty&&
										txtRegisterCustomePhone.getText()!=space&&txtRegisterCustomePhone.getText()!=empty&&
												txtRegisterCustomeObservations.getText()!=space&&txtRegisterCustomeObservations.getText()!=empty) {	
			if(restaurant.binarySearchCustomes(txtRegisterCustomeName.getText(),txtRegisterCustomeLas.getText())<0) {

			restaurant.addCustomesListSorted(txtRegisterCustomeName.getText(),txtRegisterCustomeLas.getText(),
					txtRegisterCustomeID.getText(), txtRegisterCustomeAddress.getText(),txtRegisterCustomePhone.getText(),
					txtRegisterCustomeObservations.getText());
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Register Custome");
				alert.setContentText("An error has occurred registering the Custome, there is already a client with that first and last name");
				alert.showAndWait();
			}
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Register Custome");
			alert.setContentText("An error has occurred registering the Custome, fields can´t be empty");
			alert.showAndWait();
		}
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
	public void CreateAnEmployee(ActionEvent event) throws FileNotFoundException, IOException {
		String space=" ";
		String empty="";
		if(txtRegisterEmployeeName.getText()!=space&&txtRegisterEmployeeName.getText()!=empty&&
				txtRegisterEmployeeLastnames.getText()!=space&&txtRegisterEmployeeLastnames.getText()!=empty&&
						txtRegisterEmployeeID.getText()!=space&&txtRegisterEmployeeID.getText()!=empty) {
			
			restaurant.addEmployee(txtRegisterEmployeeName.getText(),txtRegisterEmployeeLastnames.getText(), 
					txtRegisterEmployeeID.getText(),restaurant.getUserLogged(),restaurant.getUserLogged(),true);
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Register Employee");
			alert.setContentText("An error has occurred registering the Employee, fields can´t be empty");
			alert.showAndWait();
		}
	
	}
	// --------------REGISTER PRODUCT SIZE GUI-----------
	@FXML
	private TextField txtRegisterProductSizeName;

	@FXML
	private TextField txtRegisterProductSizeCode;

	@FXML
	private ImageView regProductSizeImage;

	@FXML
	public void CreateAProductSize(ActionEvent event) throws FileNotFoundException, IOException {
		String space=" ";
		String empty="";
		if(txtRegisterProductSizeName.getText()!=space&&txtRegisterProductSizeName.getText()!=empty&&
				txtRegisterProductSizeCode.getText()!=space&&txtRegisterProductSizeCode.getText()!=empty) {	
			
			restaurant.addProductSize(txtRegisterProductSizeName.getText(),txtRegisterProductSizeCode.getText(),
					restaurant.getUserLogged(), restaurant.getUserLogged());
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Register Product Size");
			alert.setContentText("An error has occurred registering the Product Size, fields can´t be empty");
			alert.showAndWait();
		}
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
	public void CreateAProduct(ActionEvent event) throws FileNotFoundException, IOException {
		String space=" ";
		String empty="";
		if(txtRegisterProductBaseProductName.getText()!=space&&txtRegisterProductBaseProductName.getText()!=empty&&
				txtRegisterProductSize.getText()!=space&&txtRegisterProductSize.getText()!=empty&&
						txtRegisterProductPrice.getText()!=space&&txtRegisterProductPrice.getText()!=empty&&
								txtRegisterProductCode.getText()!=space&&txtRegisterProductCode.getText()!=empty) {	
			
			double price= Double.parseDouble(txtRegisterProductPrice.getText());
			restaurant.addProduct(txtRegisterProductCode.getText(),restaurant.getBaseProducts().get(restaurant.searchBaseProduct(txtRegisterProductBaseProductName.getText())), 
					true, price, restaurant.getProductSize().get(restaurant.searchProductSize(txtRegisterProductSize.getText())),restaurant.getUserLogged(), restaurant.getUserLogged());
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Register Product");
			alert.setContentText("An error has occurred registering the Product, fields can´t be empty");
			alert.showAndWait();
		}
	}

	//---------REGISTER INGREDIENTS GUI-------------------

	@FXML
	private TextField txtRegisterIngredientName;

	@FXML
	private ImageView registerIngredientImage;

	@FXML
	public void CreateAnIngredient(ActionEvent event) throws FileNotFoundException, IOException {
		String space=" ";
		String empty="";
		if(txtRegisterIngredientName.getText()!=space&&txtRegisterIngredientName.getText()!=empty) {	
			
			restaurant.addIngredients(txtRegisterIngredientName.getText(),restaurant.getUserLogged(),restaurant.getUserLogged());
			
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Register Ingredient");
			alert.setContentText("An error has occurred registering the Ingredient, fields can´t be empty");
			alert.showAndWait();
		}
		
	}

	//----------UPDATE CUSTOMES GUI--------------
	@FXML
	private TextField txtUpdateCustomeName;

	@FXML
	private TextField txtUpdateCustomeLastnames;

	@FXML
	private TextField txtUpdateCustomeAddress;

	@FXML
	private TextField txtUpdateCustomePhone;

	@FXML
	private TextArea txtUpdateCustomeObservations;

	@FXML
	private ImageView updateCustomeImage;
	
	@FXML
    private RadioButton customeEnable;

    @FXML
    private ToggleGroup customeStateGroup;

    @FXML
    private RadioButton customeDisable;

	@FXML
	public void UpdateCustome(ActionEvent event) {
		String space=" ";
		String empty="";
		if(txtUpdateCustomeName.getText()!=space&&txtUpdateCustomeName.getText()!=empty&&
				txtUpdateCustomeLastnames.getText()!=space&&txtUpdateCustomeLastnames.getText()!=empty&&
						txtUpdateCustomeAddress.getText()!=space&&txtUpdateCustomeAddress.getText()!=empty&&
								txtUpdateCustomePhone.getText()!=space&&txtUpdateCustomePhone.getText()!=empty&&
										txtUpdateCustomeObservations.getText()!=space&&txtUpdateCustomeObservations.getText()!=empty) {	
			
			selectedCustome.setName(txtUpdateCustomeName.getText());
			selectedCustome.setLastname(txtUpdateCustomeLastnames.getText());
			selectedCustome.setAddress(txtUpdateCustomeAddress.getText());
			selectedCustome.setPhone(txtUpdateCustomePhone.getText());		
			selectedCustome.setObservations(txtUpdateCustomeObservations.getText());
			
			if(customeEnable.isSelected()) {

				selectedCustome.setState(true);

			}else if(customeDisable.isSelected()) {

				selectedCustome.setState(false);

			}
			
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Update Custome");
			alert.setContentText("An error has occurred Updating the Custome, fields can´t be empty");
			alert.showAndWait();
		}
	}

    @FXML
    public void BacktoCustomeView(ActionEvent event) throws IOException {
    	mainPaneGestionateCustome(event);
    }

	//---------UPDATE EMPLOYEE GUI----------

	@FXML
	private TextField txtUpdateEmployeeName;

	@FXML
	private TextField txtUpdateEmployeeLastnames;

	@FXML
	private ImageView updateEmployeeImage;
	
	 @FXML
	private ToggleGroup employeeStateGroup;
	
	@FXML
    private RadioButton employeeEnable;
	
	@FXML
    private RadioButton employeeDisable;

	@FXML
	public void UpdateEmployee(ActionEvent event) {
		String space=" ";
		String empty="";
		if(txtUpdateEmployeeName.getText()!=space&&txtUpdateEmployeeName.getText()!=empty&&
				txtUpdateEmployeeLastnames.getText()!=space&&txtUpdateEmployeeLastnames.getText()!=empty) {	
			
			selectedEmployee.setName(txtUpdateEmployeeName.getText());
			selectedEmployee.setLastname(txtUpdateEmployeeLastnames.getText());
			
			if(employeeEnable.isSelected()) {

				selectedEmployee.setState(true);

			}else if(employeeDisable.isSelected()) {

				selectedEmployee.setState(false);

			}
			
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Update Employee");
			alert.setContentText("An error has occurred Updating the Employee, fields can´t be empty");
			alert.showAndWait();
		}
	}	

    @FXML
    public void BacktoEmployeeView(ActionEvent event) throws IOException {
    	mainPaneGestionateEmployee(event);

}
    
	// -----------UPDATE ORDER GUI--------------

    @FXML
    private TextField txtUpdateOrderCustomeName;
    
    @FXML
    private TextField txtUpdateOrderCustomeLastName;

	@FXML
	private TextField txtUpdateOrderAmount;

	@FXML
	private TextField txtUpdateOrderEmployee;

	@FXML
	private TextField txtUpdateOrderProduct;

	@FXML
	private TextField txtUpdateOrderObservations;

    @FXML
    private TextField txtUpdateOrderEmployeeName;    

    @FXML
    private RadioButton orderInProcess;

    @FXML
    private ToggleGroup orderStateGroup;

    @FXML
    private RadioButton orderSent;

    @FXML
    private RadioButton orderDelivered;

	@FXML
	private ImageView updateOrderImage;
	
	@FXML
	public void BacktoOrderView(ActionEvent event) throws IOException {
		mainPaneGestionateOrder(event);
	}

	@FXML
	public void updateAddProductOrder(ActionEvent event) {

	}

	@FXML
	public void updateEraseLastProductOrder(ActionEvent event) {

	}

	@FXML
	public void UpdateOrder(ActionEvent event) {

	}
	
	@FXML
	public void verificateEmployee(ActionEvent event) {

    }
	//----------------UPDATE USER GUI----------------------
	@FXML
	private TextField txtUpdateUserName;

	@FXML
	private TextField txtUpdateUserLastnames;


	@FXML
	private TextField txtUpdateUserPassword;

	@FXML
	private ImageView updateUserImage;
	
	@FXML
    private RadioButton userEnable;

    @FXML
    private ToggleGroup userStateGroup;

    @FXML
    private RadioButton userDisable;

	@FXML
	public void UpdateUser(ActionEvent event) {
		String space=" ";
		String empty="";
		if(txtUpdateUserName.getText()!=space&&txtUpdateUserName.getText()!=empty&&
				txtUpdateUserLastnames.getText()!=space&&txtUpdateUserLastnames.getText()!=empty&&
				txtUpdateUserPassword.getText()!=space&&txtUpdateUserPassword.getText()!=empty) {	
				
				selectedUser.setName(txtUpdateUserName.getText());
				selectedUser.setLastname(txtUpdateUserLastnames.getText());
				selectedUser.setPassword(txtUpdateUserPassword.getText());
				
				if(userEnable.isSelected()) {

					selectedUser.setState(true);

				}else if(userDisable.isSelected()) {

					selectedUser.setState(false);

				}
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Update User");
			alert.setContentText("An error has occurred Updating the User, fields can´t be empty");
			alert.showAndWait();
		}
	}

	@FXML
	public void BacktoUserView(ActionEvent event) throws IOException {
		mainPaneGestionateUser(event);
	}
	  
	//----------UPDATE BASE PRODUCT GUI-----------------
	@FXML
	private TextField txtUpdateBaseProductName;

	@FXML
	private TextField txtUpdateBaseProductTypeProduct;

	@FXML
	private TextField txtUpdateBPTypeCode;

	@FXML
	private TextField txtUpdateBaseProductIngredients;

	@FXML
	private TextField txtUpdateBPTypeVerification;	

    @FXML
    private RadioButton enableBaseProduct;

    @FXML
    private ToggleGroup baseProductState;

    @FXML
    private RadioButton disableBaseProduct;

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
	

    @FXML
    public void BacktoBaseProductView(ActionEvent event) throws IOException {
    	mainPaneGestionateBaseProduct(event);
    }
    
    @FXML
    public void verificateBPcode(ActionEvent event) {
    	
    }
    
	//-------------UPDATE PRODUCT SIZE GUI--------------------
	@FXML
	private TextField txtUpdateProductSizeName;

	@FXML
	private TextField txtUpdateProductSizeCode;	

    @FXML
    private RadioButton enableProductSize;

    @FXML
    private ToggleGroup productSizeStateGroup;

    @FXML
    private RadioButton disableProductSize;

	@FXML
	private ImageView updateProductSizeImage;

	@FXML
	public void UpdateProductSize(ActionEvent event) {
		String space=" ";
		String empty="";
		if(txtUpdateProductSizeName.getText()!=space&&txtUpdateProductSizeName.getText()!=empty&&
				txtUpdateProductSizeCode.getText()!=space&&txtUpdateProductSizeCode.getText()!=empty) {	

			if(restaurant.getProductSize().get(restaurant.searchProductSize(txtUpdateProductSizeCode.getText()))==null
					|| restaurant.getProductSize().get(restaurant.searchProductSize(txtUpdateProductSizeCode.getText())).getName().equals(selectedPZ.getName())) {	
				
				selectedPZ.setName(txtUpdateProductSizeName.getText());
				selectedPZ.setCode(txtUpdateProductSizeCode.getText());
			}
			if(enableProductSize.isSelected()) {

				selectedPZ.setState(true);

			}else if(disableProductSize.isSelected()) {

				selectedPZ.setState(false);

			}
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Update Product Size");
			alert.setContentText("An error has occurred Updating the Product Size, fields can´t be empty");
			alert.showAndWait();
		}
	}
	
    @FXML
    public void BacktoProductSizeView(ActionEvent event) throws IOException {
    	mainPaneGestionateProductSize(event);
    }
	//-----------UPDATE PRODUCT GUI---------------
	@FXML
	private TextField txtUpdateProductName;

	@FXML
	private TextField txtUpdateProductSize;

	@FXML
	private TextField txtUploadProductPrice;

    @FXML
    private RadioButton enableProduct;

    @FXML
    private ToggleGroup productState;

    @FXML
    private RadioButton disableProduct;
	
	@FXML
	private ImageView updateProductImage;
	
    @FXML
    private TextField txtUpdateProductSizeVerification;

    @FXML
	public void updateProduct(ActionEvent event) {
		String space=" ";
		String empty="";
		if(txtUpdateProductName.getText()!=space&&txtUpdateProductName.getText()!=empty&&
				txtUpdateProductSize.getText()!=space&&txtUpdateProductSize.getText()!=empty&&
				txtUploadProductPrice.getText()!=space&&txtUploadProductPrice.getText()!=empty){
			if(restaurant.searchBaseProduct(txtUpdateProductName.getText())>=0&&
					restaurant.searchProductSize(txtUpdateProductSize.getText())>=0&&
					restaurant.getBaseProducts().get(restaurant.searchBaseProduct
							(txtUpdateProductName.getText())).getState()==true&&
							restaurant.getProductSize().get(restaurant.searchProductSize
									(txtUpdateProductSize.getText())).getState()==true){


				selectedProduct.setBaseProduct(restaurant.getBaseProducts().get(restaurant
						.searchBaseProduct(txtUpdateProductName.getText())));
				selectedProduct.setSize(restaurant.getProductSize().get(restaurant.searchProductSize(txtUpdateProductSize.getText())));
				selectedProduct.setPrice(Double.parseDouble(txtUploadProductPrice.getText()));

			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Update Product ");
				alert.setContentText("An error has occurred Updating the Product, Base Product"
						+ " or the Product Size wasn't found or is disable ");
				alert.showAndWait();
			}



			if(enableProduct.isSelected()) {

				selectedProduct.setState(true);

			}else if(disableProduct.isSelected()) {

				selectedProduct.setState(false);

			}

		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Update Product ");
			alert.setContentText("An error has occurred Updating the Product, fields can´t be empty");
			alert.showAndWait();
		}
	}
	
    @FXML
    public void BacktoProductView(ActionEvent event) throws IOException {
    	mainPaneGestionateProduct(event);
    }
    
	//----------UPDATE PRODUCT TYPE GUI-------------
	@FXML
	private TextField txtUpdateProductTypeName;

	@FXML
	private TextField txtUpdateProductTypeCode;	

    @FXML
    private RadioButton enableProductType;

    @FXML
    private ToggleGroup productTypeStateGroup;

    @FXML
    private RadioButton disableProductType;

	@FXML
	private ImageView updateProductTypeImage;

	@FXML
	public void UpdateProductType(ActionEvent event) {
		String space=" ";
		String empty="";
		if(txtUpdateProductTypeName.getText()!=space&&txtUpdateProductTypeName.getText()!=empty&&
				txtUpdateProductTypeCode.getText()!=space&&txtUpdateProductTypeCode.getText()!=empty) {
			
			selectedPT.setName(txtUpdateProductTypeName.getText());
			selectedPT.setCode(txtUpdateProductTypeCode.getText());
			
			if(enableProductType.isSelected()) {
				
				selectedPT.setState(true);
				
			}else if(disableProductType.isSelected()) {
				
				selectedPT.setState(false);
				
			}
			
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Update Product Type");
			alert.setContentText("An error has occurred Updating the Product Type, fields can´t be empty");
			alert.showAndWait();
		}
	}

    @FXML
    public void BacktoProductTypeView(ActionEvent event) throws IOException {
    	mainPaneGestionateProductType(event);
    }
    
	//----------UPDATE INGREDIENTS GUI-------------

	@FXML
	private TextField txtUpdateIngredientName;

    @FXML
    private RadioButton enableIngredient;

    @FXML
    private ToggleGroup ingredientStateGroup;

    @FXML
    private RadioButton disableIngredient;

	@FXML
	private ImageView updateIngredientImage;

	@FXML
	public void UpdateIngredient(ActionEvent event) {
		String space=" ";
		String empty="";
		if(txtUpdateIngredientName.getText()!=space&&txtUpdateIngredientName.getText()!=empty) {
			if(restaurant.searchIngredient(txtUpdateIngredientName.getText())!=null) {
			
			selectedIngredient.setName(txtUpdateIngredientName.getText());
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Update Ingredient");
				alert.setContentText("An error has occurred Updating the Ingredient, there´s already an Ingredient with that name");
				alert.showAndWait();
			}
			
			if(enableIngredient.isSelected()) {
				
				selectedIngredient.setState(true);
				
			}else if(disableIngredient.isSelected()) {
				
				selectedIngredient.setState(false);
				
			}
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Update Ingredient");
			alert.setContentText("An error has occurred Updating the Ingredient, fields can´t be empty");
			alert.showAndWait();
		}
	}
	
    @FXML
    public void BacktoIngredientView(ActionEvent event) throws IOException {
    	mainPaneGestionateIngredient(event);
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
	public void selectedUser(MouseEvent event) throws IOException {
		if (event.getClickCount()==2) {
			selectedUser = userTableView.getSelectionModel().getSelectedItem();
			if(selectedUser.getUserName().equals(restaurant.getUserLogged().getUserName())) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Selected User");
				alert.setContentText("An error has occurred when selecting the User, you can't update the same user you are logged into");
				alert.showAndWait();
			}else {
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("update-user.fxml"));
				fxmlloader.setController(this);		
				Parent root = fxmlloader.load();
				mainPane.getChildren().clear();
				mainPane.getChildren().setAll(root);
				File f = new File(UPDATE_USER_IMAGE_PATH);
				Image img = new Image(f.toURI().toString());
				this.updateUserImage.setImage(img);
				
				txtUpdateUserName.setText(selectedUser.getName());
				txtUpdateUserLastnames.setText(selectedUser.getLastname());
				txtUpdateUserPassword.setText(selectedUser.getPassword());	
			}
		}
	}

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
	public void DeleteUser(ActionEvent event) throws FileNotFoundException, IOException {
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
	public void selectedOrder(MouseEvent event) throws IOException {
		if (event.getClickCount()==2) {
			selectedOrder = ordersTableView.getSelectionModel().getSelectedItem();
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("update-order.fxml"));
			fxmlloader.setController(this);		
			Parent root = fxmlloader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().setAll(root);
			File f = new File(UPDATE_ORDER_IMAGE_PATH);
			Image img = new Image(f.toURI().toString());
			this.updateOrderImage.setImage(img);
			
			txtUpdateOrderCustomeName.setText(selectedOrder.getCustome().getName());
			txtUpdateOrderCustomeLastName.setText(selectedOrder.getCustome().getLastname());
			txtUpdateOrderObservations.setText(selectedOrder.getObservation());
			txtUpdateOrderEmployee.setText(selectedOrder.getEmployee().getID());
			txtUpdateOrderEmployeeName.setText(selectedOrder.getEmployee().getName());
			restaurant.setProductsOrder(selectedOrder.getProducts());
			restaurant.setAmountProductsOrder(selectedOrder.getAmount());
			
			if (selectedOrder.getState().equalsIgnoreCase("IN_PROCESS")) {
				orderInProcess.setSelected(true);
			} else if (selectedOrder.getState().equalsIgnoreCase("SENT")){
				orderSent.setSelected(true);
			} else if (selectedOrder.getState().equalsIgnoreCase("DELIVERED")){
				orderDelivered.setSelected(true);
			}
		}
    }

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
	public void DeleteOrder(ActionEvent event) throws FileNotFoundException, IOException {
		restaurant.eraseOrder(txtOrdersCode.getText());
	}

	public void initializableTableOrderView() {
		ObservableList <Order> orderList = FXCollections.observableArrayList(restaurant.getOrders());
		ordersTableView.setItems(orderList); 
		ordersCode.setCellValueFactory(new PropertyValueFactory <Order,String>("code"));
		ordersDate.setCellValueFactory(new PropertyValueFactory <Order,String>("dayAndHour"));
		ordersAmount.setCellValueFactory(new PropertyValueFactory <Order,String>("productsAmount"));
		ordersProduct.setCellValueFactory(new PropertyValueFactory <Order,String>("productsName"));
		ordersCustome.setCellValueFactory(new PropertyValueFactory <Order,String>("customeName"));
		ordersObservations.setCellValueFactory(new PropertyValueFactory <Order,String>("observations"));
		ordersState.setCellValueFactory(new PropertyValueFactory <Order,String>("state"));
		ordersEmployee.setCellValueFactory(new PropertyValueFactory <Order,String>("employeeName"));
	}

	//-------------PRODUCT VIEW GUI------------------
	@FXML
	private TableView<Product> productsTableView;

	@FXML
	private TableColumn<Product, String> productsName;

	@FXML
	private TableColumn<Product, String> productsCode;

	@FXML
	private TableColumn<Product, String>productsState;

	@FXML
	private TableColumn<Product, String> productsPrice;

	@FXML
	private TableColumn<Product, String>productsSize;

	@FXML
	private TextField txtProductCode;
	
	@FXML
	public void selectedProduct(MouseEvent event) throws IOException {
		if (event.getClickCount()==2) {
			selectedProduct = productsTableView.getSelectionModel().getSelectedItem();
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("update-product.fxml"));
			fxmlloader.setController(this);		
			Parent root = fxmlloader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().setAll(root);
			File f = new File(UPDATE_PRODUCT_IMAGE_PATH);
			Image img = new Image(f.toURI().toString());
			this.updateProductImage.setImage(img);
			txtUpdateProductName.setText(selectedProduct.getName());
			txtUpdateProductSize.setText(selectedProduct.getSize().getCode());
			txtUpdateProductSizeVerification.setText(selectedProduct.getSize().getName());
			txtUploadProductPrice.setText(selectedProduct.getPrice()+"");		

			if (selectedProduct.getState()) {
				enableProduct.setSelected(true);
			} else {
				disableProduct.setSelected(true);
			}
		}
	}


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
	public void DeleteProduct(ActionEvent event) throws FileNotFoundException, IOException {
		restaurant.eraseProduct(txtProductCode.getText());
	}

	public void initializableTableProductView() {
		ObservableList <Product> productList = FXCollections.observableArrayList(restaurant.getProducts());
		productsTableView.setItems(productList); 
		productsName.setCellValueFactory(new PropertyValueFactory <Product,String>("name"));
		productsCode.setCellValueFactory(new PropertyValueFactory <Product,String>("code"));
		productsState.setCellValueFactory(new PropertyValueFactory <Product,String>("state"));
		productsPrice.setCellValueFactory(new PropertyValueFactory <Product,String>("price"));
		productsSize.setCellValueFactory(new PropertyValueFactory <Product,String>("sizeName"));
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
	 public void selectedBaseProduct(MouseEvent event) throws IOException {
		 if (event.getClickCount()==2) {
				selectedBP = baseProductTableView.getSelectionModel().getSelectedItem();
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("update-baseProduct.fxml"));
				fxmlloader.setController(this);		
				Parent root = fxmlloader.load();
				mainPane.getChildren().clear();
				mainPane.getChildren().setAll(root);
				File f = new File(UPDATE_BASE_PRODUCT_IMAGE_PATH);
				Image img = new Image(f.toURI().toString());
				this.updateBaseProductImage.setImage(img);
				
				txtUpdateBaseProductName.setText(selectedBP.getName());
				txtUpdateBaseProductTypeProduct.setText(selectedBP.getName());
				restaurant.setIngredientBP(selectedBP.getIngredients());	
		 }
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
		this.regBaseProductImage.setImage(img);
	}    

	@FXML
	public void DeleteBaseProduct(ActionEvent event) throws FileNotFoundException, IOException {
		restaurant.eraseBaseProduct(txtBaseProductName.getText());
	}	

	public void initializableTableBaseProductView() {
		ObservableList <BaseProduct> baseProductList = FXCollections.observableArrayList(restaurant.getBaseProducts());
		baseProductTableView.setItems(baseProductList); 
		baseProductName.setCellValueFactory(new PropertyValueFactory <BaseProduct,String>("name"));
		baseProductType.setCellValueFactory(new PropertyValueFactory <BaseProduct,String>("typeName"));
		baseProductIngredients.setCellValueFactory(new PropertyValueFactory <BaseProduct,String>("ingredientsName"));
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
    public void selectedIngredient(MouseEvent event) throws IOException {
		 if (event.getClickCount()==2) {
				selectedIngredient = ingredientsTableView.getSelectionModel().getSelectedItem();
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("update-ingredient.fxml"));
				fxmlloader.setController(this);		
				Parent root = fxmlloader.load();
				mainPane.getChildren().clear();
				mainPane.getChildren().setAll(root);
				File f = new File(UPDATE_INGREDIENT_IMAGE_PATH);
				Image img = new Image(f.toURI().toString());
				this.updateIngredientImage.setImage(img);
				
				txtUpdateIngredientName.setText(selectedIngredient.getName());
				
				if (selectedProduct.getState()) {
					enableIngredient.setSelected(true);
				} else {
					disableIngredient.setSelected(true);
				}
		 }
    }

	@FXML
	public void AddNewIngredient(ActionEvent event) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("register-ingredient.fxml"));
		fxmlloader.setController(this);		
		Parent root = fxmlloader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().setAll(root);
		File f = new File(REGISTER_INGREDIENT_IMAGE_PATH);
		Image img = new Image(f.toURI().toString());
		this.registerIngredientImage.setImage(img);	
	}

	@FXML
	public void DeleteIngredients(ActionEvent event) throws FileNotFoundException, IOException {
		restaurant.eraseIngredient(txtIngredientName.getText());
	}

	public void initializableTableIngredientsView() {
		ObservableList <Ingredients> ingredients = FXCollections.observableArrayList(restaurant.getIngredients());
		ingredientsTableView.setItems(ingredients); 
		ingredientsName.setCellValueFactory(new PropertyValueFactory <Ingredients,String>("name"));
		ingredientsState.setCellValueFactory(new PropertyValueFactory <Ingredients,String>("stateIngredient"));		 
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
	public void selectedEmployee(MouseEvent event) throws IOException {
		 if (event.getClickCount()==2) {
				selectedEmployee = employeeTableView.getSelectionModel().getSelectedItem();
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("update-employee.fxml"));
				fxmlloader.setController(this);		
				Parent root = fxmlloader.load();
				mainPane.getChildren().clear();
				mainPane.getChildren().setAll(root);
				File f = new File(UPDATE_EMPLOYEE_IMAGE_PATH);
				Image img = new Image(f.toURI().toString());
				this.updateEmployeeImage.setImage(img);
				
				txtUpdateEmployeeName.setText(selectedEmployee.getName());
				txtUpdateEmployeeLastnames.setText(selectedEmployee.getLastname());				
		 }				
	}

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
	public void DeleteEmployee(ActionEvent event) throws FileNotFoundException, IOException {
		restaurant.eraseEmployee(txtEmployeeID.getText());
	}

	public void initializableTableEmployeeView() {
		ObservableList <Employee> employeesList = FXCollections.observableArrayList(restaurant.getEmployees());
		employeeTableView.setItems(employeesList); 
		employeeName.setCellValueFactory(new PropertyValueFactory <Employee,String>("name"));
		employeeLastName.setCellValueFactory(new PropertyValueFactory <Employee,String>("lastname"));
		employeeID.setCellValueFactory(new PropertyValueFactory <Employee,String>("id"));		 
		employeeState.setCellValueFactory(new PropertyValueFactory <Employee,String>("stateEmployee"));		 
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
    public void selectedCustome(MouseEvent event) throws IOException {
		 if (event.getClickCount()==2) {
				selectedCustome = customeTableView.getSelectionModel().getSelectedItem();
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("update-customes.fxml"));
				fxmlloader.setController(this);		
				Parent root = fxmlloader.load();
				mainPane.getChildren().clear();
				mainPane.getChildren().setAll(root);
				File f = new File(UPDATE_CUSTOME_IMAGE_PATH);
				Image img = new Image(f.toURI().toString());
				this.updateCustomeImage.setImage(img);
				
				txtUpdateCustomeName.setText(selectedCustome.getName());
				txtUpdateCustomeLastnames.setText(selectedCustome.getLastname());
				txtUpdateCustomeAddress.setText(selectedCustome.getAddress());
				txtUpdateCustomePhone.setText(selectedCustome.getPhone());
				txtUpdateCustomeObservations.setText(selectedCustome.getObservations());
		 }
    }

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
	public void DeleteCustome(ActionEvent event) throws FileNotFoundException, IOException {
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
		customesState.setCellValueFactory(new PropertyValueFactory <Custome,String>("stateCustome"));
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
	public void selectedProductType(MouseEvent event) throws IOException {
		if (event.getClickCount()==2) {
			selectedPT = productTypeTableView.getSelectionModel().getSelectedItem();
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("update-productType.fxml"));
			fxmlloader.setController(this);		
			Parent root = fxmlloader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().setAll(root);
			File f = new File(UPDATE_PRODUCT_TYPE_IMAGE_PATH);
			Image img = new Image(f.toURI().toString());
			this.updateProductTypeImage.setImage(img);

			txtUpdateProductTypeName.setText(selectedPT.getName());
			txtUpdateProductTypeCode.setText(selectedPT.getCode());

			if (selectedPT.getState()) {
				enableProductType.setSelected(true);
			} else {
				disableProductType.setSelected(true);
			}
		}
	}

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
	public void DeleteProductType(ActionEvent event) throws FileNotFoundException, IOException { 
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
    private TableColumn<ProductSize, String> productSizeState;

	@FXML
	private TextField txtProductSizeCode;

	@FXML
    public void selectedProductSize(MouseEvent event) throws IOException {
		if (event.getClickCount()==2) {
			selectedPZ = productSizeTableView.getSelectionModel().getSelectedItem();
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("update-productSize.fxml"));
			fxmlloader.setController(this);		
			Parent root = fxmlloader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().setAll(root);
			File f = new File(UPDATE_PRODUCT_SIZE_IMAGE_PATH);
			Image img = new Image(f.toURI().toString());
			this.updateProductSizeImage.setImage(img);

			txtUpdateProductSizeName.setText(selectedPZ.getName());
			txtUpdateProductSizeCode.setText(selectedPZ.getCode());

			if (selectedPT.getState()) {
				enableProductSize.setSelected(true);
			} else {
				disableProductSize.setSelected(true);
			}
		}
    }

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
	public void DeleteProductSize(ActionEvent event) throws FileNotFoundException, IOException {
		restaurant.eraseProductSize(txtProductSizeCode.getText());
	}

	public void initializableTableProductSizeView() {
		ObservableList <ProductSize> productSizeList = FXCollections.observableArrayList(restaurant.getProductSize());
		productSizeTableView.setItems(productSizeList); 
		productSizeName.setCellValueFactory(new PropertyValueFactory <ProductSize,String>("name"));
		productSizeCode.setCellValueFactory(new PropertyValueFactory <ProductSize,String>("code"));
		productSizeState.setCellValueFactory(new PropertyValueFactory <ProductSize,String>("stateSize"));
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

	public void setAllNull() {
		selectedUser=null;		
		selectedEmployee=null;		
		selectedProduct=null;		
		selectedPZ=null;		
		selectedCustome=null;		
		selectedIngredient=null;		
		selectedOrder=null;		
		selectedPT=null;		
		selectedBP=null;
	}
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
