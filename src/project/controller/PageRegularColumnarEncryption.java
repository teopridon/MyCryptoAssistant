package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PageRegularColumnarEncryption {

    @FXML
    private TextField messageTextField;

    @FXML
    private TextField keyTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private VBox vBox;

    public char[] keyCharsInOrder;
    public String message = "";
    public String key = "";
    public String result = "";
    public char[][] matrix;
    public char[][] matrix2;
    public int nrOfRows;
    public int nrOfColumns;

    public void transferMessage(String msg, String k){

        messageTextField.setText(msg);
        keyTextField.setText(k);

        message = msg;
        key = k;
    }

    public void Exit(){
        Platform.exit();
    }

    public void Encrypt(){

        getEncryptedMessage(0);
    }

    public void getEncryptedMessage(int b){

        matrix = new char[150][300];
        matrix2 = new char[150][300];
        int k = 0;
        int i = 0;
        nrOfColumns = key.length();

        while (k < message.length()){
            for (int j = 0; j < nrOfColumns; j++) {
                if(k < message.length()){
                    matrix[i][j] = message.charAt(k);
                }else{
                    if (b == 0){
                        matrix[i][j] = 'X';
                    }else{
                        matrix[i][j] = '\0';
                    }
                }

                k++;
            }

            i++;
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step1: We write the plaintext out in a grid where the number of columns is the number of letters in the keyword. We then title each column with the respective letter from the keyword. The matrix must be complete, so we insert 'X'-s to fill the last row, if there aren't enough letters in the text message."));

        vBox.getChildren().add(new Label(""));

        String s = " ";
        String r = " ";
        for (char c: key.toCharArray()) {
            s = s + c + "  ";
            r = r + "___";
        }

        vBox.getChildren().add(new Label(s));
        vBox.getChildren().add(new Label(r));

        nrOfRows = i;
        showMatrix(matrix);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step2: We take the letters in the keyword in alphabetical order, and read down the columns in this order. If a letter is repeated, we do the one that appears first, then the next and so on."));


        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(""));

        getKeyCharsInOrder();
        printKeyCharsInOrder();
        vBox.getChildren().add(new Label(r));

        int[] columnsInOrder = new int[50];
        char[] charsOfKey = key.toCharArray();

        for (int j = 0; j < keyCharsInOrder.length; j++) {

            for (int l = 0; l < charsOfKey.length ; l++) {

                if (charsOfKey[l] == keyCharsInOrder[j]){
                    columnsInOrder[j] = l;
                    charsOfKey[l] = ' ';
                    break;
                }
            }

        }

        for (int j = 0; j < columnsInOrder.length; j++) {

            for (int l = 0; l < nrOfRows ; l++) {

                matrix2[l][j] = matrix[l][columnsInOrder[j]];
            }

        }


        showMatrix(matrix2);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step3: We built the encrypted message by reading every column from top to bottom."));


        result = "";
        for (int j = 0; j < nrOfColumns ; j++) {
            for (int l = 0; l < nrOfRows ; l++) {
                if (matrix2[l][j] != '\0'){
                    result = result + matrix2[l][j];
                }

            }
        }

        vBox.getChildren().add(new Label(""));
        resultTextField.setText(result);
    }


    public void getKeyCharsInOrder(){
        keyCharsInOrder = new char[50];
        char[] keyChars = key.toCharArray();

        int k = 0;
        for (int i = 0; i < keyChars.length - 1 ; i++) {
            for (int j = i; j < keyChars.length ; j++) {

                if (keyChars[j] < keyChars[i]){
                    char aux = keyChars[i];
                    keyChars[i] = keyChars[j];
                    keyChars[j] = aux;
                }
            }
        }
        for (int i = 0; i < keyChars.length ; i++) {
            keyCharsInOrder[i] = keyChars[i];
        }

    }


    public void printKeyCharsInOrder(){
        String line = " ";
        for (int j = 0; j < keyCharsInOrder.length ; j++) {
            line = line + keyCharsInOrder[j] + "  ";
        }
        vBox.getChildren().add(new Label(line));
    }

    public void showMatrix(char[][] m){

        for (int i = 0; i < nrOfRows ; i++) {
            String line = " ";
            for (int j = 0; j < nrOfColumns ; j++) {
                line = line + m[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));

        }
    }
}
