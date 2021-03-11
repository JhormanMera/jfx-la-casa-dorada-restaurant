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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RestaurantGUI {

	private Restaurant restaurant;

	private static final String LOGIN_IMAGE_PATH = "images/Lacasadorada.jpg";

	private static final String REGISTER_IMAGE_PATH = "images/Lacasadoradalogo.jpeg";

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



	public RestaurantGUI(Restaurant restaurant) {
		this.restaurant=restaurant;
	}

	public Restaurant getRestaurant() {
		return restaurant;
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
    void initialize() {
     
    }

}
