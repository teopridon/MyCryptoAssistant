package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PageAES {

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


            if (message.length() != 16){
                messageLabel.setText("Please insert a message that is exactly 16 characters long.");
            }else {

                if (key.length() != 16){
                    keyLabel.setText("Please insert a key that is exactly 16 characters long.");
                }else {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/views/pageAesEncryption.fxml"));
                    Parent root = loader.load();

                    PageAESEncryption pageAesEncryption = loader.getController();
                    pageAesEncryption.transferMessage(message, key);


                    Stage primaryStage = new Stage();
                    Scene scene = new Scene(root, 775, 430);
                    primaryStage.setTitle("AES Encryption");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void Decrypt(){
        try{
            message = "";
            key = "";
            messageLabel.setText("");
            keyLabel.setText("");

            message = messageTextField.getText();
            key = keyTextField.getText();


            if (message.length() != 32 || !(message.matches("[A-Fa-f0-9]+"))){
                messageLabel.setText("Please insert a message that is exactly 32 characters long and contains only hexadecimal digits.");
            }else {
                message = transformToUppercase();

                if (key.length() != 16){
                    keyLabel.setText("Please insert a key that is exactly 16 characters long.");
                }else {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/views/pageAesDecryption.fxml"));
                    Parent root = loader.load();

                    PageAESDecryption pageAesDecryption = loader.getController();
                    pageAesDecryption.transferMessage(message, key);


                    Stage primaryStage = new Stage();
                    Scene scene = new Scene(root, 775, 430);
                    primaryStage.setTitle("AES Decryption");
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

    public String transformToUppercase() {
        String res = "";
        char[] messageChars = message.toCharArray();
        for (int i = 0; i < messageChars.length; i++) {
            if (messageChars[i] == 'A' || messageChars[i] == 'B' || messageChars[i] == 'C' || messageChars[i] == 'D' || messageChars[i] == 'E' || messageChars[i] == 'F' || messageChars[i] == '0' || messageChars[i] == '1' || messageChars[i] == '2' || messageChars[i] == '3' || messageChars[i] == '4' || messageChars[i] == '5' || messageChars[i] == '6' || messageChars[i] == '7' || messageChars[i] == '8' || messageChars[i] == '9') {
                res = res + messageChars[i];
            } else {
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
                }
            }
        }
        return res;
    }
}
