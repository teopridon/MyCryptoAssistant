package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PagePortaEncryption {

    @FXML
    private TextField messageTextField;

    @FXML
    private TextField keyTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private VBox vBox;

    public char[] columnAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public char[][] portaTable = new char[13][26];
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
        fillPortaTable();
        showPortaTable();

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
        vBox.getChildren().add(new Label(" Step 2: Now, for each letter in the message, we replace the letter, with the letter found in the table above, on the column corresponding to the letter from the message and on the row corresponding to the letter from the key, which is at the same position in the key, as the letter is, in the message. "));
        vBox.getChildren().add(new Label(" (the letter from the message, indicates the column and the letter from the key, indicates the row)"));
        vBox.getChildren().add(new Label(""));

        result = "";

        for (int i = 0; i < message.length() ; i++) {

            int column = 0;
            int line = 0;

            for (int j = 0; j < 26; j++) {
                if (message.charAt(i) == columnAlphabet[j]){
                    column = j;
                }
            }

            switch (key.charAt(i)){
                case 'A':
                    line = 0;
                    break;
                case 'B':
                    line = 0;
                    break;
                case 'C':
                    line = 1;
                    break;
                case 'D':
                    line = 1;
                    break;
                case 'E':
                    line = 2;
                    break;
                case 'F':
                    line = 2;
                    break;
                case 'G':
                    line = 3;
                    break;
                case 'H':
                    line = 3;
                    break;
                case 'I':
                    line = 4;
                    break;
                case 'J':
                    line = 4;
                    break;
                case 'K':
                    line = 5;
                    break;
                case 'L':
                    line = 5;
                    break;
                case 'M':
                    line = 6;
                    break;
                case 'N':
                    line = 6;
                    break;
                case 'O':
                    line = 7;
                    break;
                case 'P':
                    line = 7;
                    break;
                case 'Q':
                    line = 8;
                    break;
                case 'R':
                    line = 8;
                    break;
                case 'S':
                    line = 9;
                    break;
                case 'T':
                    line = 9;
                    break;
                case 'U':
                    line = 10;
                    break;
                case 'V':
                    line = 10;
                    break;
                case 'W':
                    line = 11;
                    break;
                case 'X':
                    line = 11;
                    break;
                case 'Y':
                    line = 12;
                    break;
                case 'Z':
                    line = 12;
                    break;
            }

            vBox.getChildren().add(new Label(" For letter  " + message.charAt(i) + "  we get from the table, on column " + column + " (corresponding to letter " + message.charAt(i) + " from the message) and the row " + line + " (corresponding to the letter " + key.charAt(i) + " from key),  letter:  " + portaTable[line][column]));
            result = result + portaTable[line][column];
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

    public void showPortaTable(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" The table used for Porta encryption is this: "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label("            A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z "));
        vBox.getChildren().add(new Label(" ------------------------------------------------------------------------------------------"));

        for (int i = 0; i < 13; i++) {

            String line = " ";
            switch (i){
                case 0:
                    line = line + "A,B  ||  ";
                    break;
                case 1:
                    line = line + "C,D  ||  ";
                    break;
                case 2:
                    line = line + "E,F  ||  ";
                    break;
                case 3:
                    line = line + "G,H  ||  ";
                    break;
                case 4:
                    line = line + "I,J  ||  ";
                    break;
                case 5:
                    line = line + "K,L  ||  ";
                    break;
                case 6:
                    line = line + "M,N  ||  ";
                    break;
                case 7:
                    line = line + "O,P  ||  ";
                    break;
                case 8:
                    line = line + "Q,R  ||  ";
                    break;
                case 9:
                    line = line + "S,T  ||  ";
                    break;
                case 10:
                    line = line + "U,V  ||  ";
                    break;
                case 11:
                    line = line + "W,X  ||  ";
                    break;
                case 12:
                    line = line + "Y,Z  ||  ";
                    break;
            }

            for (int j = 0; j < 26; j++) {
                line = line + portaTable[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }

    }

    public void fillPortaTable(){

        portaTable[0][0] = 'N';
        portaTable[0][1] = 'O';
        portaTable[0][2] = 'P';
        portaTable[0][3] = 'Q';
        portaTable[0][4] = 'R';
        portaTable[0][5] = 'S';
        portaTable[0][6] = 'T';
        portaTable[0][7] = 'U';
        portaTable[0][8] = 'V';
        portaTable[0][9] = 'W';
        portaTable[0][10] = 'X';
        portaTable[0][11] = 'Y';
        portaTable[0][12] = 'Z';
        portaTable[0][13] = 'A';
        portaTable[0][14] = 'B';
        portaTable[0][15] = 'C';
        portaTable[0][16] = 'D';
        portaTable[0][17] = 'E';
        portaTable[0][18] = 'F';
        portaTable[0][19] = 'G';
        portaTable[0][20] = 'H';
        portaTable[0][21] = 'I';
        portaTable[0][22] = 'J';
        portaTable[0][23] = 'K';
        portaTable[0][24] = 'L';
        portaTable[0][25] = 'M';

        portaTable[1][0] = 'O';
        portaTable[1][1] = 'P';
        portaTable[1][2] = 'Q';
        portaTable[1][3] = 'R';
        portaTable[1][4] = 'S';
        portaTable[1][5] = 'T';
        portaTable[1][6] = 'U';
        portaTable[1][7] = 'V';
        portaTable[1][8] = 'W';
        portaTable[1][9] = 'X';
        portaTable[1][10] = 'Y';
        portaTable[1][11] = 'Z';
        portaTable[1][12] = 'N';
        portaTable[1][13] = 'M';
        portaTable[1][14] = 'A';
        portaTable[1][15] = 'B';
        portaTable[1][16] = 'C';
        portaTable[1][17] = 'D';
        portaTable[1][18] = 'E';
        portaTable[1][19] = 'F';
        portaTable[1][20] = 'G';
        portaTable[1][21] = 'H';
        portaTable[1][22] = 'I';
        portaTable[1][23] = 'J';
        portaTable[1][24] = 'K';
        portaTable[1][25] = 'L';

        portaTable[2][0] = 'P';
        portaTable[2][1] = 'Q';
        portaTable[2][2] = 'R';
        portaTable[2][3] = 'S';
        portaTable[2][4] = 'T';
        portaTable[2][5] = 'U';
        portaTable[2][6] = 'V';
        portaTable[2][7] = 'W';
        portaTable[2][8] = 'X';
        portaTable[2][9] = 'Y';
        portaTable[2][10] = 'Z';
        portaTable[2][11] = 'N';
        portaTable[2][12] = 'O';
        portaTable[2][13] = 'L';
        portaTable[2][14] = 'M';
        portaTable[2][15] = 'A';
        portaTable[2][16] = 'B';
        portaTable[2][17] = 'C';
        portaTable[2][18] = 'D';
        portaTable[2][19] = 'E';
        portaTable[2][20] = 'F';
        portaTable[2][21] = 'G';
        portaTable[2][22] = 'H';
        portaTable[2][23] = 'I';
        portaTable[2][24] = 'J';
        portaTable[2][25] = 'K';

        portaTable[3][0] = 'Q';
        portaTable[3][1] = 'R';
        portaTable[3][2] = 'S';
        portaTable[3][3] = 'T';
        portaTable[3][4] = 'U';
        portaTable[3][5] = 'V';
        portaTable[3][6] = 'W';
        portaTable[3][7] = 'X';
        portaTable[3][8] = 'Y';
        portaTable[3][9] = 'Z';
        portaTable[3][10] = 'N';
        portaTable[3][11] = 'O';
        portaTable[3][12] = 'P';
        portaTable[3][13] = 'K';
        portaTable[3][14] = 'L';
        portaTable[3][15] = 'M';
        portaTable[3][16] = 'A';
        portaTable[3][17] = 'B';
        portaTable[3][18] = 'C';
        portaTable[3][19] = 'D';
        portaTable[3][20] = 'E';
        portaTable[3][21] = 'F';
        portaTable[3][22] = 'G';
        portaTable[3][23] = 'H';
        portaTable[3][24] = 'I';
        portaTable[3][25] = 'J';

        portaTable[4][0] = 'R';
        portaTable[4][1] = 'S';
        portaTable[4][2] = 'T';
        portaTable[4][3] = 'U';
        portaTable[4][4] = 'V';
        portaTable[4][5] = 'W';
        portaTable[4][6] = 'X';
        portaTable[4][7] = 'Y';
        portaTable[4][8] = 'Z';
        portaTable[4][9] = 'N';
        portaTable[4][10] = 'O';
        portaTable[4][11] = 'P';
        portaTable[4][12] = 'Q';
        portaTable[4][13] = 'J';
        portaTable[4][14] = 'K';
        portaTable[4][15] = 'L';
        portaTable[4][16] = 'M';
        portaTable[4][17] = 'A';
        portaTable[4][18] = 'B';
        portaTable[4][19] = 'C';
        portaTable[4][20] = 'D';
        portaTable[4][21] = 'E';
        portaTable[4][22] = 'F';
        portaTable[4][23] = 'G';
        portaTable[4][24] = 'H';
        portaTable[4][25] = 'I';

        portaTable[5][0] = 'S';
        portaTable[5][1] = 'T';
        portaTable[5][2] = 'U';
        portaTable[5][3] = 'V';
        portaTable[5][4] = 'W';
        portaTable[5][5] = 'X';
        portaTable[5][6] = 'Y';
        portaTable[5][7] = 'Z';
        portaTable[5][8] = 'N';
        portaTable[5][9] = 'O';
        portaTable[5][10] = 'P';
        portaTable[5][11] = 'Q';
        portaTable[5][12] = 'R';
        portaTable[5][13] = 'I';
        portaTable[5][14] = 'J';
        portaTable[5][15] = 'K';
        portaTable[5][16] = 'L';
        portaTable[5][17] = 'M';
        portaTable[5][18] = 'A';
        portaTable[5][19] = 'B';
        portaTable[5][20] = 'C';
        portaTable[5][21] = 'D';
        portaTable[5][22] = 'E';
        portaTable[5][23] = 'F';
        portaTable[5][24] = 'G';
        portaTable[5][25] = 'H';

        portaTable[6][0] = 'T';
        portaTable[6][1] = 'U';
        portaTable[6][2] = 'V';
        portaTable[6][3] = 'W';
        portaTable[6][4] = 'X';
        portaTable[6][5] = 'Y';
        portaTable[6][6] = 'Z';
        portaTable[6][7] = 'N';
        portaTable[6][8] = 'O';
        portaTable[6][9] = 'P';
        portaTable[6][10] = 'Q';
        portaTable[6][11] = 'R';
        portaTable[6][12] = 'S';
        portaTable[6][13] = 'H';
        portaTable[6][14] = 'I';
        portaTable[6][15] = 'J';
        portaTable[6][16] = 'K';
        portaTable[6][17] = 'L';
        portaTable[6][18] = 'M';
        portaTable[6][19] = 'A';
        portaTable[6][20] = 'B';
        portaTable[6][21] = 'C';
        portaTable[6][22] = 'D';
        portaTable[6][23] = 'E';
        portaTable[6][24] = 'F';
        portaTable[6][25] = 'G';

        portaTable[7][0] = 'U';
        portaTable[7][1] = 'V';
        portaTable[7][2] = 'W';
        portaTable[7][3] = 'X';
        portaTable[7][4] = 'Y';
        portaTable[7][5] = 'Z';
        portaTable[7][6] = 'N';
        portaTable[7][7] = 'O';
        portaTable[7][8] = 'P';
        portaTable[7][9] = 'Q';
        portaTable[7][10] = 'R';
        portaTable[7][11] = 'S';
        portaTable[7][12] = 'T';
        portaTable[7][13] = 'G';
        portaTable[7][14] = 'H';
        portaTable[7][15] = 'I';
        portaTable[7][16] = 'J';
        portaTable[7][17] = 'K';
        portaTable[7][18] = 'L';
        portaTable[7][19] = 'M';
        portaTable[7][20] = 'A';
        portaTable[7][21] = 'B';
        portaTable[7][22] = 'C';
        portaTable[7][23] = 'D';
        portaTable[7][24] = 'E';
        portaTable[7][25] = 'F';

        portaTable[8][0] = 'V';
        portaTable[8][1] = 'W';
        portaTable[8][2] = 'X';
        portaTable[8][3] = 'Y';
        portaTable[8][4] = 'Z';
        portaTable[8][5] = 'N';
        portaTable[8][6] = 'O';
        portaTable[8][7] = 'P';
        portaTable[8][8] = 'Q';
        portaTable[8][9] = 'R';
        portaTable[8][10] = 'S';
        portaTable[8][11] = 'T';
        portaTable[8][12] = 'U';
        portaTable[8][13] = 'F';
        portaTable[8][14] = 'G';
        portaTable[8][15] = 'H';
        portaTable[8][16] = 'I';
        portaTable[8][17] = 'J';
        portaTable[8][18] = 'K';
        portaTable[8][19] = 'L';
        portaTable[8][20] = 'M';
        portaTable[8][21] = 'A';
        portaTable[8][22] = 'B';
        portaTable[8][23] = 'C';
        portaTable[8][24] = 'D';
        portaTable[8][25] = 'E';

        portaTable[9][0] = 'W';
        portaTable[9][1] = 'X';
        portaTable[9][2] = 'Y';
        portaTable[9][3] = 'Z';
        portaTable[9][4] = 'N';
        portaTable[9][5] = 'O';
        portaTable[9][6] = 'P';
        portaTable[9][7] = 'Q';
        portaTable[9][8] = 'R';
        portaTable[9][9] = 'S';
        portaTable[9][10] = 'T';
        portaTable[9][11] = 'U';
        portaTable[9][12] = 'V';
        portaTable[9][13] = 'E';
        portaTable[9][14] = 'F';
        portaTable[9][15] = 'G';
        portaTable[9][16] = 'H';
        portaTable[9][17] = 'I';
        portaTable[9][18] = 'J';
        portaTable[9][19] = 'K';
        portaTable[9][20] = 'L';
        portaTable[9][21] = 'M';
        portaTable[9][22] = 'A';
        portaTable[9][23] = 'B';
        portaTable[9][24] = 'C';
        portaTable[9][25] = 'D';

        portaTable[10][0] = 'X';
        portaTable[10][1] = 'Y';
        portaTable[10][2] = 'Z';
        portaTable[10][3] = 'N';
        portaTable[10][4] = 'O';
        portaTable[10][5] = 'P';
        portaTable[10][6] = 'Q';
        portaTable[10][7] = 'R';
        portaTable[10][8] = 'S';
        portaTable[10][9] = 'T';
        portaTable[10][10] = 'U';
        portaTable[10][11] = 'V';
        portaTable[10][12] = 'W';
        portaTable[10][13] = 'D';
        portaTable[10][14] = 'E';
        portaTable[10][15] = 'F';
        portaTable[10][16] = 'G';
        portaTable[10][17] = 'H';
        portaTable[10][18] = 'I';
        portaTable[10][19] = 'J';
        portaTable[10][20] = 'K';
        portaTable[10][21] = 'L';
        portaTable[10][22] = 'M';
        portaTable[10][23] = 'A';
        portaTable[10][24] = 'B';
        portaTable[10][25] = 'C';

        portaTable[11][0] = 'Y';
        portaTable[11][1] = 'Z';
        portaTable[11][2] = 'N';
        portaTable[11][3] = 'O';
        portaTable[11][4] = 'P';
        portaTable[11][5] = 'Q';
        portaTable[11][6] = 'R';
        portaTable[11][7] = 'S';
        portaTable[11][8] = 'T';
        portaTable[11][9] = 'U';
        portaTable[11][10] = 'V';
        portaTable[11][11] = 'W';
        portaTable[11][12] = 'X';
        portaTable[11][13] = 'C';
        portaTable[11][14] = 'D';
        portaTable[11][15] = 'E';
        portaTable[11][16] = 'F';
        portaTable[11][17] = 'G';
        portaTable[11][18] = 'H';
        portaTable[11][19] = 'I';
        portaTable[11][20] = 'J';
        portaTable[11][21] = 'K';
        portaTable[11][22] = 'L';
        portaTable[11][23] = 'M';
        portaTable[11][24] = 'A';
        portaTable[11][25] = 'B';

        portaTable[12][0] = 'Z';
        portaTable[12][1] = 'N';
        portaTable[12][2] = 'O';
        portaTable[12][3] = 'P';
        portaTable[12][4] = 'Q';
        portaTable[12][5] = 'R';
        portaTable[12][6] = 'S';
        portaTable[12][7] = 'T';
        portaTable[12][8] = 'U';
        portaTable[12][9] = 'V';
        portaTable[12][10] = 'W';
        portaTable[12][11] = 'X';
        portaTable[12][12] = 'Y';
        portaTable[12][13] = 'B';
        portaTable[12][14] = 'C';
        portaTable[12][15] = 'D';
        portaTable[12][16] = 'E';
        portaTable[12][17] = 'F';
        portaTable[12][18] = 'G';
        portaTable[12][19] = 'H';
        portaTable[12][20] = 'I';
        portaTable[12][21] = 'J';
        portaTable[12][22] = 'K';
        portaTable[12][23] = 'L';
        portaTable[12][24] = 'M';
        portaTable[12][25] = 'A';

    }
}
