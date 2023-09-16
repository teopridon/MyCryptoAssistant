package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PageRailFenceDecryption {

    @FXML
    private TextField messageTextField;

    @FXML
    private TextField keyTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private VBox vBox;


    public String message = "";
    public int key = 0;
    public String result = "";
    public char[][] matrix;

    public void transferMessage(String msg, int k){
        messageTextField.setText(msg);
        keyTextField.setText(String.valueOf(k));

        message = msg;
        key = k;
    }

    public void Decrypt(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step1: Start by making a grid with as many rows as the key is, and as many columns as the length of the encrypted message. Then place the first letter in the top left square, and dashes diagonally downwards where the letters will be. When you get back to the top row, place the next letter from the message. Continue like this across the row, and start the next row when you reach the end."));
        vBox.getChildren().add(new Label(""));



        matrix = new char[key][message.length()];

        for (int i = 0; i < key ; i++) {
            for (int j = 0; j < message.length() ; j++) {

                matrix[i][j] = ' ';
            }
        }

        int i = 0;
        for (int j = 0; j < message.length(); j++) {

            if (i<key){
                matrix[i][j] = '1';
                i++;
            }else if (i>=key && i<(2*key)){
                matrix[(key-1) - (i%key) - 1][j] = '1';
                i++;
            }

            if (i == 2*key - 1 ){
                i = 1;
            }


        }

        i = 0;
        for (int j = 0; j < key; j++) {
            for (int k = 0; k < message.length(); k++) {
                if(matrix[j][k] == '1'){
                    matrix[j][k] = message.charAt(i);
                    i++;
                }
            }
        }

        showMatrix();

        getResult();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step2: The decrypted message is formed out of the columns of the grid, from left to right."));

        vBox.getChildren().add(new Label(""));
        resultTextField.setText(result);

    }

    public void getResult(){
        result = "";

        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < key; j++) {
                if (matrix[j][i] != ' '){
                    result = result + matrix[j][i];
                }

            }
        }
    }

    public void showMatrix(){

        vBox.getChildren().add(new Label(""));

        for (int i = 0; i < key ; i++) {
            String line = " ";
            for (int j = 0; j < message.length(); j++) {
                line = line + matrix[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void Exit(){
        Platform.exit();
    }
}

