package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PagePolybius {

    @FXML
    private TextField messageTextField;

    @FXML
    private Label messageLabel;

    @FXML
    private Label messageLabel1;

    public String message = "";


    public void Encrypt() {
        try{
            message = "";
            messageLabel.setText("");
            message = messageTextField.getText();


            if (!(message.matches("[a-zA-Z ]+$"))){
                messageLabel.setText("Please insert a message that contains only letters and white spaces.");
            }else {
                message = transformToUppercase();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/views/pagePolybiusEncryption.fxml"));
                Parent root = loader.load();

                PagePolybiusEncryption pagePolybiusEncryption = loader.getController();
                pagePolybiusEncryption.transferMessage(message);


                Stage primaryStage = new Stage();
                Scene scene = new Scene(root, 775, 430);
                primaryStage.setTitle("Polybius Cipher Encryption");
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void Decrypt() {
        try{
            message = "";
            messageLabel.setText("");
            messageLabel1.setText("");
            message = messageTextField.getText();

            if (!(message.matches("[0-9 ]+$") && (message.length()%2 == 0))){
                messageLabel.setText("Please insert a message that contains only two digit numbers and no white spaces.");
                messageLabel1.setText("Each digit must be between 0 and 4.");
            }else {
                message = transformToUppercase();

                int ok = 0;
                for (int i = 0; i < message.length(); i++) {
                    if (message.charAt(i) != '0' && message.charAt(i) != '1' && message.charAt(i) != '2' && message.charAt(i) != '3' && message.charAt(i) != '4'){
                        ok = 1;
                    }
                }

                if (ok == 1){
                    messageLabel.setText("Please insert a message that contains only two digit numbers and no white spaces.");
                    messageLabel1.setText("Each digit must be between 0 and 4.");
                }else {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/views/pagePolybiusDecryption.fxml"));
                    Parent root = loader.load();

                    PagePolybiusDecryption pagePolybiusDecryption = loader.getController();
                    pagePolybiusDecryption.transferMessage(message);


                    Stage primaryStage = new Stage();
                    Scene scene = new Scene(root, 775, 430);
                    primaryStage.setTitle("Polybius Cipher Decryption");
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

    public String transformToUppercase(){
        String res = "";
        char[] messageChars = message.toCharArray();
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
