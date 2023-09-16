package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PageShiftDecryption {

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
    private Label label3;

    @FXML
    private Label label4;


    public char[] englishAlphabet = new char[26];
    public String message = "";
    public int key = 0;
    public String result = "";

    public void transferMessage(String msg, int k) {
        messageTextField.setText(msg);
        keyTextField.setText(String.valueOf(k));
        message = msg;
        key = k;
    }

    public void Decrypt(){

        fillEnglishAlphabet();

        result = "";
        label1.setVisible(true);
        label2.setVisible(true);
        label3.setVisible(true);
        label4.setVisible(true);
        vBox.getChildren().add(new Label(""));

        for (int i = 0; i < message.length() ; i++) {
            for (int j = 0; j < 26; j++) {
                if (message.charAt(i)==englishAlphabet[j]){

                    vBox.getChildren().add(new Label(" Letter  " + message.charAt(i) + "  is be considered to be:  " + j ));
                }
            }
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label("Step2: For each of the numbers x above we calculate: (x - key) mod 26"));
        vBox.getChildren().add(new Label(""));

        for (int i = 0; i < message.length() ; i++) {
            for (int j = 0; j < 26; j++) {
                if (message.charAt(i)==englishAlphabet[j]){

                    if ((j - key)%26 < 0){
                        vBox.getChildren().add(new Label(" For number  " + j + ":    (" + j + " - " + key +") mod 26 = " + (26 + (j - key)%26)));
                    }else{
                        vBox.getChildren().add(new Label(" For number  " + j + ":    (" + j + " - " + key +") mod 26 = " + (j - key)%26));
                    }

                }
            }
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label("Step3: We get for each of the resulted positions at step2, the letters found on that position in the english alphabet"));
        vBox.getChildren().add(new Label(""));

        result = "";

        for (int i = 0; i < message.length() ; i++) {
            for (int j = 0; j < 26; j++) {
                if (message.charAt(i)==englishAlphabet[j]){

                    if ((j - key)%26 < 0){
                        vBox.getChildren().add(new Label(" For position  " + (26 + (j - key)%26) + "  we find letter:   " + englishAlphabet[26 + (j - key)%26]));
                        result = result + englishAlphabet[26 + (j - key)%26];
                    }else{
                        vBox.getChildren().add(new Label(" For position  " + ((j - key)%26) + "  we find letter:   " + englishAlphabet[(j - key)%26]));
                        result = result + englishAlphabet[(j - key)%26];
                    }

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
