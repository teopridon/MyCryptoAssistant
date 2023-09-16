package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PageAbcEncryption {

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

    public void Encrypt(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" I. Frist encrypt the message using vigenere cipher, with the known key 'ABC'."));
        getVigenereEncryption();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" II. Now encrypt the new message using columnar transposition cipher, with the given key."));
        getColumnarEncryption(0); //1 daca doresc fara X-uri
    }

    public void getColumnarEncryption(int b){

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
        vBox.getChildren().add(new Label(" Step4: We write the new text out in a grid where the number of columns is the number of letters in the keyword. We then title each column with the respective letter from the keyword. The matrix must be complete, so we insert 'X'-s to fill the last row, if there aren't enough letters in the text message."));

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
        vBox.getChildren().add(new Label(" Step5: We take the letters in the keyword in alphabetical order, and read down the columns in this order. If a letter is repeated, we do the one that appears first, then the next and so on."));


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
        vBox.getChildren().add(new Label(" Step6: We built the encrypted message by reading every column from top to bottom."));


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

    public void getVigenereEncryption(){
        fillTabulaRecta();
        showTabulaRecta();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 1: We have to repeat the text 'ABC', until it reaches the length of the message."));
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
        vBox.getChildren().add(new Label(" Step 2: Now, for each letter in the message, we replace the letter with, the letter found in the tabula recta, on the column corresponding to the letter from the message and on the row corresponding to the letter from the key, which is on the same position in the key, as the letter is, in the message. "));
        vBox.getChildren().add(new Label(" (the letter from the message indicates the column and the letter from the key indicates the row from tabula recta)"));
        vBox.getChildren().add(new Label(""));


        result = "";

        for (int i = 0; i < message.length() ; i++) {

            int row = 0;
            int column = 0;

            for (int j = 0; j < 26 ; j++) {
                if (message.charAt(i) == columnAlphabet[j]){
                    column = j;
                }
                if (key1.charAt(i) == columnAlphabet[j]){
                    row = j;
                }
            }

            vBox.getChildren().add(new Label(" For letter  " + message.charAt(i) + "  we get from the table, on column " + column + " (corresponding to letter " + message.charAt(i) + " from the message) and the row " + row + " (corresponding to the letter " + key1.charAt(i) + " from key),  letter:  " + tabulaRecta[row][column]));
            result = result + tabulaRecta[row][column];
        }

        message = "";
        message = result;
        result = "";
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step3: We get the new message:"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" " + message));
    }

    public void Exit(){
        Platform.exit();
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
}
