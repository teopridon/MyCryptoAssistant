package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PageScytaleEncryption {


    @FXML
    private TextField messageTextField;

    @FXML
    private TextField keyTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private VBox vBox;

    public String message = "";
    public int key;
    public String result = "";

    public void transferMessage(String msg, int k){
        messageTextField.setText(msg);
        keyTextField.setText(String.valueOf(k));

        message = msg;
        key = k;
    }

    public void Encrypt(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" The scytale encryption system relies on rods of wood with equal radiuses. The system is a symmetric key system where the radius of the rod is the key."));
        vBox.getChildren().add(new Label(" After establishing keys a messenger winds a strip of leather around the rod. Then he writes the message going across the rod, so that when he unwinds the leather the letters have been jumbled in a meaningless fashion."));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" Step1: The given key represents the number of times the leather is winded around the rod, this means we have to divide the message into blocks with " + key + " letters each, and put them one under the other."));
        vBox.getChildren().add(new Label(" We obtain the following matrix: "));
        vBox.getChildren().add(new Label(""));


//        (int) Math.ceil((float) message.length() / key)
        char[][] scytaleMatrix = new char[ message.length()][key];
        char[] messageChars = message.toCharArray();

        int k = 0;

        for (int i = 0; i < message.length(); i++) {
            String line = " |  ";
            for (int j = 0; j < key ; j++) {

                if(k<messageChars.length){
                    scytaleMatrix[i][j] = messageChars[k];
                    line = line + scytaleMatrix[i][j] + "  |  ";
                }
                k++;
            }

            if (line!= " |  "){
                vBox.getChildren().add(new Label(line));
            }
        }

        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" Step2: The final result is built out of the columns of the above shown matrix, read from top to bottom and from left to right."));
        vBox.getChildren().add(new Label(""));

        result = "";

        for (int j = 0; j < key ; j++) {
            for (int i = 0; i < message.length(); i++) {

                if (scytaleMatrix[i][j] != '\0'){
                    result = result + scytaleMatrix[i][j];
                }
            }
        }
        vBox.getChildren().add(new Label(""));
        resultTextField.setText(result);
    }

    public void Exit(){
        Platform.exit();
    }
}
