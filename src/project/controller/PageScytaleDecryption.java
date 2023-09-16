package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PageScytaleDecryption {


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

    public void Decrypt(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" The scytale encryption system relies on rods of wood with equal radiuses. The system is a symmetric key system where the radius of the rod is the key."));
        vBox.getChildren().add(new Label(" After establishing keys a messenger winds a strip of leather around the rod. Then he writes the message going across the rod, so that when he unwinds the leather the letters have been jumbled in a meaningless fashion."));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" Step1: The given key represents the number of times the initial leather is winded around the rod, this means we have to divide the message into blocks with " + (int) Math.ceil((float) message.length() / key) + " letters each, and put the letters of the block one under the other and then put the blocks next to one another."));
        vBox.getChildren().add(new Label(" We obtain the following matrix: "));
        vBox.getChildren().add(new Label(""));


//        (int) Math.ceil((float) message.length() / key)
        char[][] scytaleMatrix = new char[ message.length()][key];


        int k = 0;
        int rest = 0;

        if ((message.length() % key) == 0 ){

            rest = 0;
        }else {
            rest = (key * ((int) Math.ceil((float) message.length() / key))) - message.length();
        }

        for (int i = 0; i < key; i++) {

            for (int j = 0; j < (int) Math.ceil((float) message.length() / key) ; j++) {

                if (i < key - rest ){
                    scytaleMatrix[j][i] = message.charAt(k);
                    k++;
                }else {
                    if(j != (int) Math.ceil((float) message.length() / key) - 1){
                        scytaleMatrix[j][i] = message.charAt(k);
                        k++;
                    }else {
                        scytaleMatrix[j][i] = ' ';
                    }
                }

            }
        }

        for (int i = 0; i < (int) Math.ceil((float) message.length() / key); i++) {
            String line = " |  ";
            for (int j = 0; j < key; j++) {
                line = line + scytaleMatrix[i][j] + "  |  ";
            }
            if (line != " |  "){
                vBox.getChildren().add(new Label(line));
            }
        }



        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step2: The decrypted message is built out of the rows of the above shown matrix, read from left to right and from top to bottom. "));
        vBox.getChildren().add(new Label(""));

        result = " ";
        for (int i = 0; i < (int) Math.ceil((float) message.length() / key); i++) {
            for (int j = 0; j < key; j++) {
                if (scytaleMatrix[i][j] != ' '){
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
