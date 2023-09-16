package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PageRailFenceEncryption {

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

    public void Encrypt(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step1: Start writing the letters of the plaintext diagonally down to the right until you reach the number of rows specified by the key. Then bounce back up diagonally until you hit the first row again. This continues until the end of the plaintext."));
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
                matrix[i][j] = message.charAt(j);
                i++;
            }else if (i>=key && i<(2*key)){
                matrix[(key-1) - (i%key) - 1][j] = message.charAt(j);
                i++;
            }

            if (i == 2*key - 1 ){
                i = 1;
            }


        }

        showMatrix();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step2: The encrypted message is formed out of the rows of the grid, from left to right and from top to bottom."));


        result = "";
        for (i = 0; i < key ; i++) {
            for (int j = 0; j < message.length() ; j++) {

                if (matrix[i][j] != ' '){
                    result = result + matrix[i][j];
                }

            }
        }

        vBox.getChildren().add(new Label(""));
        resultTextField.setText(result);

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
