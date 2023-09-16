package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PageRouteEncryption {
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
        vBox.getChildren().add(new Label(" Step1: We write the message in a grid, on columns, from top to bottom, where the number of rows is given by the key."));
        vBox.getChildren().add(new Label(""));


        int param = (int) Math.ceil((double) message.length()/key) ;
        matrix = new char[key][param];

        int k = 0;
        for (int j = 0; j < param ; j++) {
            for (int i = 0; i < key  ; i++) {

                if (k < message.length()){
                    matrix[i][j] = message.charAt(k);
                }else{
                    matrix[i][j] = 'X';
                }

                k++;
            }
        }

        showMatrix();

        result = "";
        for (int i = key - 1; i >= 0 ; i--) {
            for (int j = param - 1; j >= 0 ; j--) {

                result = result + matrix[i][j];
            }
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step2: The encrypted message is formed out of the rows of the grid, from right to left and from bottom to top."));

        vBox.getChildren().add(new Label(""));
        resultTextField.setText(result);

    }


    public void showMatrix(){

        vBox.getChildren().add(new Label(""));

        for (int i = 0; i < key ; i++) {
            String line = " ";
            for (int j = 0; j < (int) Math.ceil((double) message.length()/key) ; j++) {
                line = line + matrix[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void Exit(){
        Platform.exit();
    }
}
