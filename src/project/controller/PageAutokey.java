package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PageAutokey {

    @FXML
    private TextField messageTextField;

    @FXML
    private TextField keyTextField;

    @FXML
    private Label messageLabel;

    @FXML
    private Label keyLabel;


    public String message = "";
    public String key = "";


    public void Encrypt(){
        try{
            message = "";
            key = "";
            messageLabel.setText("");
            keyLabel.setText("");

            message = messageTextField.getText();
            key = keyTextField.getText();


            if (!(message.matches("[a-zA-Z ]+$"))){
                messageLabel.setText("Please insert a message that contains only letters and white spaces.");
            }else {
                message = transformToUppercase(message);

                if (!(keyTextField.getText().matches("[a-zA-Z ]+$"))){
                    keyLabel.setText("Please insert a key that contains only letters and white spaces.");
                }else {
                    key = transformToUppercase(key);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/views/pageAutokeyEncryption.fxml"));
                    Parent root = loader.load();

                    PageAutokeyEncryption pageAutokeyEncryption = loader.getController();
                    pageAutokeyEncryption.transferMessage(message, key);


                    Stage primaryStage = new Stage();
                    Scene scene = new Scene(root, 775, 430);
                    primaryStage.setTitle("Autokey Cipher Encryption");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void Decrypt(){
        try {
            message = "";
            key = "";
            messageLabel.setText("");
            keyLabel.setText("");

            message = messageTextField.getText();
            key = keyTextField.getText();


            if (!(message.matches("[a-zA-Z ]+$"))){
                messageLabel.setText("Please insert a message that contains only letters and white spaces.");
            }else {
                message = transformToUppercase(message);

                if (!(keyTextField.getText().matches("[a-zA-Z ]+$"))){
                    keyLabel.setText("Please insert a key that contains only letters and white spaces.");
                }else {
                    key = transformToUppercase(key);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/views/pageAutokeyDecryption.fxml"));
                    Parent root = loader.load();

                    PageAutokeyDecryption pageAutokeyDecryption = loader.getController();
                    pageAutokeyDecryption.transferMessage(message, key);


                    Stage primaryStage = new Stage();
                    Scene scene = new Scene(root, 775, 430);
                    primaryStage.setTitle("Autokey Cipher Decryption");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void Exit(){
        Platform.exit();
    }

    public String transformToUppercase(String s){
        String res = "";
        char[] messageChars = s.toCharArray();
        for (int i = 0; i < messageChars.length ; i++) {
            if (messageChars[i]=='A'||messageChars[i]=='B'||messageChars[i]=='C'||messageChars[i]=='D'||messageChars[i]=='E'||messageChars[i]=='F'||messageChars[i]=='G'||messageChars[i]=='H'||messageChars[i]=='I'||messageChars[i]=='J'||messageChars[i]=='K'||messageChars[i]=='L'||messageChars[i]=='M'||messageChars[i]=='N'||messageChars[i]=='O'||messageChars[i]=='P'||messageChars[i]=='Q'||messageChars[i]=='R'||messageChars[i]=='S'||messageChars[i]=='T'||messageChars[i]=='U'||messageChars[i]=='V'||messageChars[i]=='W'||messageChars[i]=='X'||messageChars[i]=='Y'||messageChars[i]=='Z'||messageChars[i]=='0'||messageChars[i]=='1'||messageChars[i]=='2'||messageChars[i]=='3'||messageChars[i]=='4'||messageChars[i]=='5'||messageChars[i]=='6'||messageChars[i]=='7'||messageChars[i]=='8'||messageChars[i]=='9'){
                res = res + messageChars[i];
            }else {
                switch (messageChars[i]) {
                    case 'a':
                        res = res + 'A';
                        break;
                    case 'b':
                        res = res + 'B';
                        break;
                    case 'c':
                        res = res + 'C';
                        break;
                    case 'd':
                        res = res + 'D';
                        break;
                    case 'e':
                        res = res + 'E';
                        break;
                    case 'f':
                        res = res + 'F';
                        break;
                    case 'g':
                        res = res + 'G';
                        break;
                    case 'h':
                        res = res + 'H';
                        break;
                    case 'i':
                        res = res + 'I';
                        break;
                    case 'j':
                        res = res + 'J';
                        break;
                    case 'k':
                        res = res + 'K';
                        break;
                    case 'l':
                        res = res + 'L';
                        break;
                    case 'm':
                        res = res + 'M';
                        break;
                    case 'n':
                        res = res + 'N';
                        break;
                    case 'o':
                        res = res + 'O';
                        break;
                    case 'p':
                        res = res + 'P';
                        break;
                    case 'q':
                        res = res + 'Q';
                        break;
                    case 'r':
                        res = res + 'R';
                        break;
                    case 's':
                        res = res + 'S';
                        break;
                    case 't':
                        res = res + 'T';
                        break;
                    case 'u':
                        res = res + 'U';
                        break;
                    case 'v':
                        res = res + 'V';
                        break;
                    case 'w':
                        res = res + 'W';
                        break;
                    case 'x':
                        res = res + 'X';
                        break;
                    case 'y':
                        res = res + 'Y';
                        break;
                    case 'z':
                        res = res + 'Z';
                        break;
                }
            }
        }
        return res;
    }
}
