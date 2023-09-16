package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PageVigenereDecryption {



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
    public String result = "";

    public void transferMessage(String msg, String k){

        messageTextField.setText(msg);
        keyTextField.setText(k);

        message = msg;
        key = k;
    }

    public void Decrypt(){
        fillTabulaRecta();
        showTabulaRecta();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 1: Frist we have to repeat the key, until it reaches the length of the message."));
        vBox.getChildren().add(new Label(""));

        modifyKeyLength();

        String s = " ";
        for (int i = 0; i < key.length(); i++) {
            s = s + key.charAt(i) + "  ";
        }
        vBox.getChildren().add(new Label(s));

        s = " ";
        for (int i = 0; i < message.length(); i++) {
            s = s + message.charAt(i) + "  ";
        }
        vBox.getChildren().add(new Label(s));


        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 2: Now, for each letter in the message, we replace the letter with, the letter found in the tabula recta, on row 0 and column corresponding to the letter from the message found on the row, corresponding to the letter from the key, which is on the same position in the key, as the letter is, in the message. "));
        vBox.getChildren().add(new Label(" (the letter from the key indicates the row on which we search for the letter from the message, when we find it we get the first letter of column on which it is situated)"));
        vBox.getChildren().add(new Label(""));


        result = "";

        for (int i = 0; i < message.length() ; i++) {

            int row = 0;
            int column = 0;

            for (int j = 0; j < 26 ; j++) {

                if (key.charAt(i) == columnAlphabet[j]){
                    row = j;
                }
            }

            for (int j = 0; j < 26; j++) {

                if (message.charAt(i) == tabulaRecta[row][j]){
                    column = j;
                }
            }

            vBox.getChildren().add(new Label(" For letter  " + message.charAt(i) + "  we get from the table, on row 0 and column corresponding to the letter " + message.charAt(i) + " found, in the tabula recta, on row " + row + " (corresponding to the letter " + key.charAt(i) + " from key),   the letter:   " + tabulaRecta[0][column]));
            result = result + tabulaRecta[0][column];
        }

        vBox.getChildren().add(new Label(""));
        resultTextField.setText(result);
    }

    public void Exit(){
        Platform.exit();
    }

    public void modifyKeyLength(){

        char[] charKey = key.toCharArray();
        int i = 0;
        while (key.length() < message.length()){
            key = key + charKey[i];
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
        vBox.getChildren().add(new Label(" This is the Tabula recta, the table used for Vigenere decryption: "));
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
