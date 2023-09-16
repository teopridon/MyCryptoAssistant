package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public void start(Stage primaryStage){

        try{
            Parent root = FXMLLoader.load(getClass().getResource("/project/views/page1.fxml"));
            primaryStage.setTitle("My Crypto Assistant");
            Scene scene = new Scene(root, 775, 430);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}
