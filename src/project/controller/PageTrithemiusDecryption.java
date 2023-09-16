package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PageTrithemiusDecryption {


    @FXML
    private TextField messageTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private VBox vBox;

    public char[][] tabulaRecta = new char[26][26];
    public String message = "";
    public String result = "";

    public void transferMessage(String msg){
        messageTextField.setText(msg);
        message = msg;
    }

    public void Decrypt(){

        fillTabulaRecta();
        showTabulaRecta();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" To decrypt the given message we use the above shown matrix, called tabula recta."));
        vBox.getChildren().add(new Label(" Each letter of the message will be replaced with the letter found in the tabula recta, on the column 0 and the row where, at the column determined by the position of the letter in the message, we find that letter."));
        vBox.getChildren().add(new Label(""));

        result = "";

        for (int i = 0; i < message.length() ; i++) {

            for (int j = 0; j < 26 ; j++) {

                if (tabulaRecta[j][i] == message.charAt(i)){

                    vBox.getChildren().add(new Label(" Letter  " + message.charAt(i) + "  is replaced with letter on row " + j + " and column " + 0 + " from tabula recta, which is letter:  " + tabulaRecta[j][0]));
                    result = result + tabulaRecta[j][0];
                    break;
                }
            }
        }
        vBox.getChildren().add(new Label(""));
        resultTextField.setText(result);
    }

    public void Exit(){

        Platform.exit();
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

        vBox.getChildren().add(new Label(" Tabula Recta is: "));
        for (int i = 0; i < 26 ; i++) {
            String line = " ";
            for (int j = 0; j < 26 ; j++) {

                line = line + tabulaRecta[i][j] + "  ";

            }
            vBox.getChildren().add(new Label(line));
        }
    }
}
