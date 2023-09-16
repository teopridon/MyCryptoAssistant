package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PagePolybiusDecryption {

    @FXML
    private TextField messageTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private VBox vBox;

    public String message = "";
    public String result = "";
    public char[][] polybiusMatrix = new char[5][5];

    public void transferMessage(String msg){

        messageTextField.setText(msg);
        message = msg;
    }

    public void Decrypt(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step1: Use the polybius square in order to decode the message."));
        vBox.getChildren().add(new Label(""));

        fillPolybiusMatrix();
        showPolybiusMatrix();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step2: Replace every two digit number from the message with the letter, found on the row determined by the first digit and the column determined by the second digit of the number."));


        int[] rows = new int[30];
        int[] columns = new int[30];

        int b = 0;
        for (int i = 0; i < message.length(); i= i+2) {
            rows[b] = Character.getNumericValue(message.charAt(i));

            if (i+1 < message.length()){
                columns[b] = Character.getNumericValue(message.charAt(i+1));
            }else {
                columns[b] = 0;
            }
            b++;
        }

        result = "";
        for (int i = 0; i < b; i++) {
            result = result + polybiusMatrix[rows[i]][columns[i]];
        }

        vBox.getChildren().add(new Label(""));
        resultTextField.setText(result);
    }

    public void showPolybiusMatrix(){

        vBox.getChildren().add(new Label("      0  1  2  3  4"));
        vBox.getChildren().add(new Label(" ______________________"));


        for (int i = 0; i < 5 ; i++) {
            String line = " " + i + " |  ";
            for (int j = 0; j < 5 ; j++) {
                line = line + polybiusMatrix[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void fillPolybiusMatrix(){

        polybiusMatrix[0][0] = 'A';
        polybiusMatrix[0][1] = 'B';
        polybiusMatrix[0][2] = 'C';
        polybiusMatrix[0][3] = 'D';
        polybiusMatrix[0][4] = 'E';

        polybiusMatrix[1][0] = 'F';
        polybiusMatrix[1][1] = 'G';
        polybiusMatrix[1][2] = 'H';
        polybiusMatrix[1][3] = 'I';
        polybiusMatrix[1][4] = 'J';

        polybiusMatrix[2][0] = 'K';
        polybiusMatrix[2][1] = 'L';
        polybiusMatrix[2][2] = 'M';
        polybiusMatrix[2][3] = 'N';
        polybiusMatrix[2][4] = 'O';

        polybiusMatrix[3][0] = 'P';
        polybiusMatrix[3][1] = 'Q';
        polybiusMatrix[3][2] = 'R';
        polybiusMatrix[3][3] = 'S';
        polybiusMatrix[3][4] = 'T';

        polybiusMatrix[4][0] = 'U';
        polybiusMatrix[4][1] = 'V';
        polybiusMatrix[4][2] = 'W';
        polybiusMatrix[4][3] = 'X';
        polybiusMatrix[4][4] = 'Z';

    }

    public void Exit(){
        Platform.exit();
    }
}
