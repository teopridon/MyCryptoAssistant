package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class PageCaesarEncryption implements Initializable {

    @FXML
    private TextField messageTextField;

    @FXML
    private VBox vBox;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextField resultTextField;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    public char[] englishAlphabet = new char[26];
    public String message = "";
    public int key = 3;
    public String result = "";


    public void transferMessage(String msg) {
        messageTextField.setText(msg);
        message = msg;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void Encrypt(){

        fillEnglishAlphabet();
        getEncryptedMessage();

    }

    public void getEncryptedMessage(){
        result = "";

        scrollPane.setContent(vBox);
        label2.setVisible(true);
        label3.setVisible(true);
        label4.setVisible(true);
        vBox.getChildren().add(new Label(""));

        for (int i = 0; i < message.length() ; i++) {
            for (int j = 0; j < 26; j++) {
                if (message.charAt(i)==englishAlphabet[j]){

                    String s = " " + englishAlphabet[j] + "  from position  " + j + ",    turns to:   " + englishAlphabet[(j + key)%26] + "   which is situated on position  " + (j + key)%26 + "  in the english alphabet";
                    vBox.getChildren().add(new Label(s));

                    result= result + englishAlphabet[(j + key)%26];
                }
            }
        }
        vBox.getChildren().add(new Label(""));
        resultTextField.setText(result);
    }

    public void Exit(){

        Platform.exit();
    }

    public void fillEnglishAlphabet(){
        englishAlphabet[0] = 'A';
        englishAlphabet[1] = 'B';
        englishAlphabet[2] = 'C';
        englishAlphabet[3] = 'D';
        englishAlphabet[4] = 'E';
        englishAlphabet[5] = 'F';
        englishAlphabet[6] = 'G';
        englishAlphabet[7] = 'H';
        englishAlphabet[8] = 'I';
        englishAlphabet[9] = 'J';
        englishAlphabet[10] = 'K';
        englishAlphabet[11] = 'L';
        englishAlphabet[12] = 'M';
        englishAlphabet[13] = 'N';
        englishAlphabet[14] = 'O';
        englishAlphabet[15] = 'P';
        englishAlphabet[16] = 'Q';
        englishAlphabet[17] = 'R';
        englishAlphabet[18] = 'S';
        englishAlphabet[19] = 'T';
        englishAlphabet[20] = 'U';
        englishAlphabet[21] = 'V';
        englishAlphabet[22] = 'W';
        englishAlphabet[23] = 'X';
        englishAlphabet[24] = 'Y';
        englishAlphabet[25] = 'Z';
    }
}
