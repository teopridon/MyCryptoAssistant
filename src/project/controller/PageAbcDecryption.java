package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PageAbcDecryption {

    @FXML
    private TextField messageTextField;

    @FXML
    private TextField keyTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private VBox vBox;

    public char[] columnAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public char[][] tabulaRecta = new char[26][26];
    public String message = "";
    public String key = "";
    public String key1 = "ABC";
    public String result = "";
    public char[] keyCharsInOrder;
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
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" I. Frist decrypt the message using columnar transposition cipher, with the given key."));
        getColumnarDecryption(0);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" II. Now decrypt the new message using vigenere cipher, with the known key 'ABC'."));
        getVigenereDecryption();
    }

    public void getVigenereDecryption(){
        fillTabulaRecta();
        showTabulaRecta();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 4: Frist we have to repeat the key 'ABC', until it reaches the length of the message."));
        vBox.getChildren().add(new Label(""));

        modifyKeyLength();

        String s = " ";
        for (int i = 0; i < key1.length(); i++) {
            s = s + key1.charAt(i) + "  ";
        }
        vBox.getChildren().add(new Label(s));

        s = " ";
        for (int i = 0; i < message.length(); i++) {
            s = s + message.charAt(i) + "  ";
        }
        vBox.getChildren().add(new Label(s));


        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 5: Now, for each letter in the message, we replace the letter with, the letter found in the tabula recta, on row 0 and column corresponding to the letter from the message found on the row, corresponding to the letter from the key, which is on the same position in the key, as the letter is, in the message. "));
        vBox.getChildren().add(new Label(" (the letter from the key indicates the row on which we search for the letter from the message, when we find it we get the first letter of column on which it is situated)"));
        vBox.getChildren().add(new Label(""));


        result = "";

        for (int i = 0; i < message.length() ; i++) {

            int row = 0;
            int column = 0;

            for (int j = 0; j < 26 ; j++) {

                if (key1.charAt(i) == columnAlphabet[j]){
                    row = j;
                }
            }

            for (int j = 0; j < 26; j++) {

                if (message.charAt(i) == tabulaRecta[row][j]){
                    column = j;
                }
            }

            vBox.getChildren().add(new Label(" For letter  " + message.charAt(i) + "  we get from the table, on row 0 and column corresponding to the letter " + message.charAt(i) + " found, in the tabula recta, on row " + row + " (corresponding to the letter " + key1.charAt(i) + " from key),   the letter:   " + tabulaRecta[0][column]));
            result = result + tabulaRecta[0][column];
        }

        vBox.getChildren().add(new Label(""));
        resultTextField.setText(result);
    }

    public void getColumnarDecryption(int b){
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

        resultTextField.setText("");
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step3: We build the result by reading each row of the matrix, from left to right and from top to bottom."));
        vBox.getChildren().add(new Label(""));
        message = "";
        message = result;
        result = "";
        vBox.getChildren().add(new Label(" " + message));
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

    public void modifyKeyLength(){

        char[] charKey = key1.toCharArray();
        int i = 0;
        while (key1.length() < message.length()){
            key1 = key1 + charKey[i];
            i++;
            if (i == charKey.length){
                i = 0;
            }
        }
    }

    public void fillTabulaRecta(){

        tabulaRecta[0][0] = 'A';
        tabulaRecta[0][1] = 'B';
        tabulaRecta[0][2] = 'C';
        tabulaRecta[0][3] = 'D';
        tabulaRecta[0][4] = 'E';
        tabulaRecta[0][5] = 'F';
        tabulaRecta[0][6] = 'G';
        tabulaRecta[0][7] = 'H';
        tabulaRecta[0][8] = 'I';
        tabulaRecta[0][9] = 'J';
        tabulaRecta[0][10] = 'K';
        tabulaRecta[0][11] = 'L';
        tabulaRecta[0][12] = 'M';
        tabulaRecta[0][13] = 'N';
        tabulaRecta[0][14] = 'O';
        tabulaRecta[0][15] = 'P';
        tabulaRecta[0][16] = 'Q';
        tabulaRecta[0][17] = 'R';
        tabulaRecta[0][18] = 'S';
        tabulaRecta[0][19] = 'T';
        tabulaRecta[0][20] = 'U';
        tabulaRecta[0][21] = 'V';
        tabulaRecta[0][22] = 'W';
        tabulaRecta[0][23] = 'X';
        tabulaRecta[0][24] = 'Y';
        tabulaRecta[0][25] = 'Z';

        for (int i = 1; i < 26 ; i++) {
            for (int j = 0; j < 26 ; j++) {
                if (j != 25){
                    tabulaRecta[i][j] = tabulaRecta[i-1][j+1];
                }else {
                    tabulaRecta[i][j] = tabulaRecta[i-1][0];
                }

            }
        }
    }

    public void showTabulaRecta(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" This is the Tabula recta, the table used for Vigenere encryption: "));
        vBox.getChildren().add(new Label(""));

        for (int i = 0; i < 26 ; i++) {
            String line = " ";
            for (int j = 0; j < 26 ; j++) {

                line = line + tabulaRecta[i][j] + "  ";

            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void Exit(){
        Platform.exit();
    }
}
