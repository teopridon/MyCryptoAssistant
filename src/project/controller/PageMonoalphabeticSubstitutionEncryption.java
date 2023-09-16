package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class PageMonoalphabeticSubstitutionEncryption {

    @FXML
    private TextField messageTextField;

    @FXML
    private TextField keyTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private VBox vBox;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label l;

    public char[][] alphabet = new char[26][2];
    public String message = "";
    public String key = "";
    public String result = "";

    public void transferMessage(String msg, String k){
        messageTextField.setText(msg);
        keyTextField.setText(k);

        message = msg;
        key = k;
    }

    public void Encrypt(){

        fillAlphabet();

        l.setVisible(true);
        label1.setVisible(true);
        label2.setVisible(true);

        result = "";
        String s = "                ";
        for (int i = 0; i < key.length(); i++) {
            s = s + key.charAt(i) + "   ";
        }

        vBox.getChildren().add(new Label(s));
        vBox.getChildren().add(new Label(""));

        for (int i = 0; i < message.length() ; i++) {

            for (int j = 0; j < 26 ; j++) {
                if (message.charAt(i) == alphabet[j][0]){

                    vBox.getChildren().add(new Label(" Letter  " + message.charAt(i) + "  is replaced with letter:  " + alphabet[j][1]));
                    result = result + alphabet[j][1];
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

    public void fillAlphabet(){

        alphabet[0][0] = 'A';
        alphabet[1][0] = 'B';
        alphabet[2][0] = 'C';
        alphabet[3][0] = 'D';
        alphabet[4][0] = 'E';
        alphabet[5][0] = 'F';
        alphabet[6][0] = 'G';
        alphabet[7][0] = 'H';
        alphabet[8][0] = 'I';
        alphabet[9][0] = 'J';
        alphabet[10][0] = 'K';
        alphabet[11][0] = 'L';
        alphabet[12][0] = 'M';
        alphabet[13][0] = 'N';
        alphabet[14][0] = 'O';
        alphabet[15][0] = 'P';
        alphabet[16][0] = 'Q';
        alphabet[17][0] = 'R';
        alphabet[18][0] = 'S';
        alphabet[19][0] = 'T';
        alphabet[20][0] = 'U';
        alphabet[21][0] = 'V';
        alphabet[22][0] = 'W';
        alphabet[23][0] = 'X';
        alphabet[24][0] = 'Y';
        alphabet[25][0] = 'Z';


        for (int i = 0; i < 26 ; i++) {
            alphabet[i][1] = key.charAt(i);
        }


    }


}
