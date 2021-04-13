package ui;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Restaurant;



public class Main extends Application{
	
	private RestaurantGUI restaurantGUI;
	private Restaurant restaurant;
    
    
    public Main () {
    	restaurant =new Restaurant();
    	restaurantGUI= new RestaurantGUI(restaurant);
    }
    
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
    	FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
        fxmlloader.setController(restaurantGUI);
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("La Casa Dorada Restaurant");
        primaryStage.show();
        primaryStage.setResizable(false);
        this.restaurantGUI.showLogin();
       
    }

}