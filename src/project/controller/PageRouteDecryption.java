package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PageRouteDecryption {

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
        vBox.getChildren().add(new Label(" Step1: We write the message in a grid, on rows, from bottom to top and from right to left, where the number of rows is given by the key."));
        vBox.getChildren().add(new Label(""));

        int param = (int) Math.ceil((double) message.length()/key) ;
        matrix = new char[key][param];

        int k = message.length() - 1;
        for (int i = 0; i < key ; i++) {
            for (int j = 0; j < param  ; j++) {

                if (k < message.length()){
                    matrix[i][j] = message.charAt(k);
                }
                k--;
            }
        }

        showMatrix();

        result = "";
        for (int i = 0; i < param; i++) {
            for (int j = 0; j < key; j++) {

                if (i != param-1){
                    result = result + matrix[j][i];
                }else{
                    if (matrix[j][i] != 'X'){
                        result = result + matrix[j][i];
                    }else{
                        int ok = 0;
                        for (int l = j; l < key; l++) {
                            if (matrix[j][i] != 'X'){
                                ok = 1;
                            }
                        }
                        if (ok == 1){
                            result = result + matrix[j][i];
                        }
                    }
                }

            }
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step2: The encrypted message is formed out of the columns of the grid, from top to bottom and from left to right."));

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
