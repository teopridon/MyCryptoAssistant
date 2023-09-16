package project.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Page1 implements Initializable {

    @FXML
    ChoiceBox<String> choiceBox1;

    public void Page1(javafx.event.ActionEvent actionEvent) {

        if (!choiceBox1.getValue().equals(" - Select a cipher - ")){
            switch (choiceBox1.getValue()){

                case "Caesar Cipher":

                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageCaesar.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Caesar Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    break;

                case "Shift Cipher":

                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageShift.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Shift Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "Affine Cipher":

                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageAffine.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Affine Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case "Monoalphabetic Substitution Cipher":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageMonoalphabeticSubstitution.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Monoalphabetic Substitution Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "Trithemius Cipher":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageTrithemius.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Trithemius Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "Porta Cipher":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pagePorta.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Porta Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "Vigenere Cipher":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageVigenere.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Vigenere Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "Beaufort Cipher":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageBeaufort.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Beaufort Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "Autokey Cipher":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageAutokey.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Autokey Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "Scytale Cipher":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageScytale.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Scytale Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "Regular Columnar Transposition Cipher":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageRegularColumnar.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Regular Columnar Transposition Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "Rail Cipher":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageRail.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Rail Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "Rail-Fence Cipher":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageRailFence.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Rail-Fence Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "Route Cipher":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageRoute.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Route Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "Polybius Cipher":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pagePolybius.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Polybius Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "Double Columnar Transposition Cipher":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageDoubleColumnar.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("Double Columnar Transposition Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "ABC Cipher":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageAbc.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("ABC Cipher");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "DES (Data Encryption Standard)":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageDes.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("DES (Data Encryption Standard)");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "AES (Advanced Encryption Standard)":
                    try{
                        Stage primaryStage = new Stage();

                        Parent root = FXMLLoader.load(getClass().getResource("/project/views/pageAes.fxml"));
                        Scene scene = new Scene(root, 775, 430);
                        primaryStage.setTitle("AES (Advanced Encryption Standard)");
                        primaryStage.setScene(scene);
                        primaryStage.show();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox1.setValue(" - Select a cipher - ");
    }
}
