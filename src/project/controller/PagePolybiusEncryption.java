package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PagePolybiusEncryption {

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

    public void Encrypt(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step1: Use the polybius square in order to encode the message."));
        vBox.getChildren().add(new Label(""));

        fillPolybiusMatrix();
        showPolybiusMatrix();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step2: Replace every letter from the message with the number, formed out of the row number and the column number of that letter."));


        result = "";
        for (int i = 0; i < message.length() ; i++) {

            if (message.charAt(i) == 'Y'){
                result = result + 43;
            }
            else{
                for (int j = 0; j < 5 ; j++) {
                    for (int k = 0; k < 5 ; k++) {

                        if (polybiusMatrix[j][k] == message.charAt(i)){

                            result = result + j + k;
                        }

                    }
                }
            }

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
