package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PageRegularColumnarDecryption {

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

    public void Decrypt(){
        getDecryptedMessage(0);
    }

    public void getDecryptedMessage(int b) {

        matrix = new char[150][300];
        matrix2 = new char[150][300];
        int k = 0;
        nrOfColumns = key.length();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step1: We take the letters in the keyword in alphabetical order. Then we write the plaintext out in a grid, on columns, from top to bottom, where the number of columns is the number of letters in the keyword."));
        vBox.getChildren().add(new Label(""));

        getKeyCharsInOrder();
        printKeyCharsInOrder();
        String r = " ";
        for (int i = 0; i < key.length(); i++) {
            r = r + "___";
        }
        vBox.getChildren().add(new Label(r));


        while (k < message.length()){
            for (int j = 0; j < nrOfColumns; j++) {
                for (int i = 0; i < (message.length()/nrOfColumns); i++) {
                    if(k < message.length()){
                        matrix[i][j] = message.charAt(k);
                    }else{
                        matrix[i][j] = '\0';
                    }

                    k++;
                }

            }
        }

        nrOfRows = message.length()/nrOfColumns;
        showMatrix(matrix);


        int[] columnsInOrder = new int[50];
        char[] charsOfKey = key.toCharArray();

        for (int i = 0; i < charsOfKey.length; i++) {
            for (int j = 0; j < keyCharsInOrder.length; j++) {

                if (charsOfKey[i] == keyCharsInOrder[j]){
                    columnsInOrder[i] = j;
                    keyCharsInOrder[j] = ' ';
                    break;
                }
            }
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" Step2: We put the columns in the order in which their corresponding key letter appears in the keyword. "));
        vBox.getChildren().add(new Label(""));

        String s = " ";
        for (int i = 0; i < key.length(); i++) {
            s = s + key.charAt(i) + "  ";
        }
        vBox.getChildren().add(new Label(s));

        r = " ";
        for (int i = 0; i < key.length(); i++) {
            r = r + "___";
        }
        vBox.getChildren().add(new Label(r));


        for (int i = 0; i < columnsInOrder.length; i++) {

            for (int j = 0; j < nrOfRows; j++) {
                matrix2[j][i] = matrix[j][columnsInOrder[i]];
            }
        }

        showMatrix(matrix2);

        if(b==0){
            getResult();
        }else{
            getResult2();
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step3: We build the result by reading each row of the matrix, from left to right and from top to bottom."));
        vBox.getChildren().add(new Label(""));
    }

    public void getResult(){
        result = "";

        for (int i = 0; i < nrOfRows; i++) {
            for (int j = 0; j < nrOfColumns; j++) {

                if (i!= nrOfRows-1){
                    result = result + matrix2[i][j];
                }else{
                    if (matrix2[i][j] != 'X'){
                        result = result + matrix2[i][j];
                    }else{
                        int ok = 1;
                        for (int k = j; k < nrOfColumns; k++) {
                            if (matrix2[i][k] != 'X'){
                                ok = 0;
                            }
                        }

                        if (ok == 0){
                            result = result + matrix2[i][j];
                        }
                    }
                }
            }
        }
        vBox.getChildren().add(new Label(""));
        resultTextField.setText(result);
    }


    public void getResult2(){
        result = "";

        for (int i = 0; i < nrOfRows; i++) {
            for (int j = 0; j < nrOfColumns; j++) {

                result = result + matrix2[i][j];
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

    public void Exit(){
        Platform.exit();
    }
}
