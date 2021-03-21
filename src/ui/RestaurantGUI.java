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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;


public class RestaurantGUI {

	private Restaurant restaurant;

	private static final String LOGIN_IMAGE_PATH = "data/images/Lacasadorada.jpg";

	private static final String REGISTER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	/*
	private static final String REGISTER_PRODUCT_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String REGISTER_CUSTOME_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String REGISTER_EMPLOYEE_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
	
	private static final String REGISTER_USER_IMAGE_PATH = "data/images/Lacasadoradalogo.jpeg";
*/
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView mainImage;
	
	@FXML
	private Pane mainPane;

	@FXML
	private ImageView loginImage;

	@FXML
	private ImageView registerImage;

	@FXML
	private Label showMessage;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private TextField txtUserName;	


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
    private Pane loginPane;
	
	@FXML
    private Pane registerPane;
    
	@FXML
    private TextField txtRegBaseProductName;

    @FXML
    private TextField txtRegBaseProductType;

    @FXML
    private TextField txtRegProBaseductIngredients;

    @FXML
    private Label txtRegBaseProductMessage;

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
    private TextField txtRegisterEmployeeName;

    @FXML
    private TextField txtRegisterEmployeeLastnames;

    @FXML
    private TextField txtRegisterEmployeeID;
    
    @FXML
    private TextField txtRegProductName;

    @FXML
    private TextField txtRegProductSize;

    @FXML
    private TextField txtRegProductPrice;

    @FXML
    private TextField txtRegisterProductSizeName;

    @FXML
    private TextField txtRegisterProductSizeCode;
   
    @FXML
    private TextField txtRegisterProductName;

    @FXML
    private TextField txtRegisterProductTypeCode;

    @FXML
    private TextField txtRegisterProductTypeCreator;

    @FXML
    private TextField txtRegisterProductTypeState;

    @FXML
    private TextField txtRegisterProductTypeLastCreator;

    @FXML
    private TableColumn<?, ?> baseProductName;
    
    @FXML
    private TableColumn<?, ?> baseProductType;

    @FXML
    private TableColumn<?, ?> baseProductIngredients;

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
    private TableColumn<?, ?> employeeName;

    @FXML
    private TableColumn<?, ?> employeeLastName;

    @FXML
    private TableColumn<?, ?> employeeID;

    @FXML
    private TableColumn<?, ?> employeeState;
   
    @FXML
    private DatePicker initialDateEmployeeReport;

    @FXML
    private TextField initialHourEmployeeReport;

    @FXML
    private DatePicker finalDateEmployeeReport;

    @FXML
    private TextField finalHourEmployeeReport;
    
    @FXML
    private DatePicker initialDateOrderReport;

    @FXML
    private TextField initialHourOrderReport;

    @FXML
    private DatePicker finalDateOrderReport;

    @FXML
    private TextField finalHourOrderReport;
    
    @FXML
    private DatePicker initialDateProductReport;

    @FXML
    private TextField initialHourProductReport;

    @FXML
    private DatePicker finalDateProductReport;

    @FXML
    private TextField finalHourProductReport;
    
    @FXML
    private TableColumn<?, ?> ingredientsName;

    @FXML
    private TableColumn<?, ?> ingredientsState;
    
    @FXML
    private Label mainPaneHour;

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
    private TableColumn<?, ?> productsName;

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
    public void AddNewProduct(ActionEvent event) {

    }

    @FXML
    public void DeleteProduct(ActionEvent event) {

    }
    @FXML
    public void AddNewOrder(ActionEvent event) {

    }

    @FXML
    public void DeleteOrder(ActionEvent event) {

    }
    @FXML
    public void mainPaneExportEmployees(ActionEvent event) {

    }

    @FXML
    public void mainPaneExportOrders(ActionEvent event) {

    }

    @FXML
    public void mainPaneExportProductsSales(ActionEvent event) {

    }

    @FXML
    public void mainPaneGestionateBaseProduct(ActionEvent event) {

    }

    @FXML
    public void mainPaneGestionateCustome(ActionEvent event) {

    }

    @FXML
    public void mainPaneGestionateEmployee(ActionEvent event) {

    }

    @FXML
    public void mainPaneGestionateIngredient(ActionEvent event) {

    }

    @FXML
    public void mainPaneGestionateProduct(ActionEvent event) {

    }

    @FXML
    public void mainPaneGestionateUser(ActionEvent event) {

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

    @FXML
    public void AddNewIngredient(ActionEvent event) {

    }

    @FXML
    public void DeleteIngredients(ActionEvent event) {

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

    }

    @FXML
    public void AddNewCustome(ActionEvent event) {

    }

    @FXML
    public void DeleteCustome(ActionEvent event) {

    }

    @FXML
    public void AddNewBaseProduct(ActionEvent event) {

    }

    @FXML
    public void BackToMenu(ActionEvent event) {

    }

    @FXML
    public void DeleteBaseProduct(ActionEvent event) {

    }

    @FXML
    public void CreateAProductType(ActionEvent event) {

    }

    @FXML
    public void CreateAProductSize(ActionEvent event) {

    }

    @FXML
    public void CreateAProduct(ActionEvent event) {

    }

    @FXML
    public void CreateAnEmployee(ActionEvent event) {

    }

    @FXML
    public void CreateACustome(ActionEvent event) {

    }
	
	@FXML
    public void AddIngredientBaseProduct(ActionEvent event) {

    }

    @FXML
    public void CreateABaseProduct(ActionEvent event) {

    }

    @FXML
    public void EraseLastIngredientBaseProduct(ActionEvent event) {

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
	@FXML
	public void CreateAnAccount(ActionEvent event) {

	}
	@FXML
	public void Login(ActionEvent event) {

	}
    @FXML
    public void RegSignIn(ActionEvent event) throws IOException {
    	showLogin();
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
		this.registerImage.setImage(img);
	}
    @FXML
    public void initialize() {
     
    }
    
    public RestaurantGUI(Restaurant restaurant) {
		this.setRestaurant(restaurant);
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
