package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import project.models.CharAscii;
import project.repository.*;

import java.util.ArrayList;
import java.util.List;

public class PageAESEncryption {

    @FXML
    private TextField messageTextField;

    @FXML
    private TextField keyTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private VBox vBox;


    public AsciiRepo asciiRepo = new AsciiRepo();
    public AsciiController asciiContrl = new AsciiController(asciiRepo);

    public String initmessage;
    public String initkey;

    public List<String> hexamessage = new ArrayList<>();
    public List<String> hexakey = new ArrayList<>();

    public String[][] sBox = new String[16][16];
    public String[][] xorTable = new String[16][16];
    public String[][] mixColumn = new String[4][4];
    public String[][] inverseMixColumn = new String[4][4];
    public String[][] binaryTable = new String[16][2];

    public String[] roundconst1 = {"01", "00", "00", "00"};
    public String[] roundconst2 = {"02", "00", "00", "00"};
    public String[] roundconst3 = {"04", "00", "00", "00"};
    public String[] roundconst4 = {"08", "00", "00", "00"};
    public String[] roundconst5 = {"10", "00", "00", "00"};
    public String[] roundconst6 = {"20", "00", "00", "00"};
    public String[] roundconst7 = {"40", "00", "00", "00"};
    public String[] roundconst8 = {"80", "00", "00", "00"};
    public String[] roundconst9 = {"1B", "00", "00", "00"};
    public String[] roundconst10 = {"36", "00", "00", "00"};

    public String[] roundkey0 = new String[16];
    public String[] roundkey1 = new String[16];
    public String[] roundkey2 = new String[16];
    public String[] roundkey3 = new String[16];
    public String[] roundkey4 = new String[16];
    public String[] roundkey5 = new String[16];
    public String[] roundkey6 = new String[16];
    public String[] roundkey7 = new String[16];
    public String[] roundkey8 = new String[16];
    public String[] roundkey9 = new String[16];
    public String[] roundkey10 = new String[16];

    public static String[] actualroundkey = new String[16];


    public static String[][] stateMatrix = new String[4][4];
    public static String[][] newstateMatrix = new String[4][4];

    public static String[][] roundkeyMatrix0 = new String[4][4];
    public static String[][] roundkeyMatrix1 = new String[4][4];
    public static String[][] roundkeyMatrix2 = new String[4][4];
    public static String[][] roundkeyMatrix3 = new String[4][4];
    public static String[][] roundkeyMatrix4 = new String[4][4];
    public static String[][] roundkeyMatrix5 = new String[4][4];
    public static String[][] roundkeyMatrix6 = new String[4][4];
    public static String[][] roundkeyMatrix7 = new String[4][4];
    public static String[][] roundkeyMatrix8 = new String[4][4];
    public static String[][] roundkeyMatrix9 = new String[4][4];
    public static String[][] roundkeyMatrix10 = new String[4][4];

    public static String[] resultround0 = new String[16];
    public static String[] resultround1 = new String[16];
    public static String[] resultround2 = new String[16];
    public static String[] resultround3 = new String[16];
    public static String[] resultround4 = new String[16];
    public static String[] resultround5 = new String[16];
    public static String[] resultround6 = new String[16];
    public static String[] resultround7 = new String[16];
    public static String[] resultround8 = new String[16];
    public static String[] resultround9 = new String[16];
    public static String[] resultround10 = new String[16];

    public static String result = "";


    public void transferMessage(String msg, String k){
        messageTextField.setText(msg);
        keyTextField.setText(k);

        initmessage = "";
        initkey = "";
        initmessage = msg;
        initkey = k;
    }

    public void Exit(){
        Platform.exit();
    }


    public void Encrypt(){

        getInitialValues();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" ----------------------------STEP I: FIND ALL 10 ROUNDKEYS-----------------------------------"));
        vBox.getChildren().add(new Label(""));
        findRoundkeys();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" ----------------------------STEP II: CALCULATE ALL 10 ROUNDS-----------------------------------"));
        vBox.getChildren().add(new Label(""));
        getAllRounds();

    }

    public void getAllRounds(){

        initialRound();                                     //Round 0

        intermediateRounds();                               //Rounds 1-9

        finalRound();                                       //Round 10
    }

    public void finalRound(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step5: Finally we calculate round 10."));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" ROUND 10: "));

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step5.1: We replace each element in the state matrix resulted at Round 9 with it's correspondent in the Rijndael S-Box."));


        for (int i = 0; i < 4 ; i++) {                                               //S-BOX
            for (int j = 0; j < 4 ; j++) {

                stateMatrix[i][j] = newstateMatrix[i][j];
                newstateMatrix[i][j] = replacingusingSBox(newstateMatrix[i][j]);
            }
        }

        showStateMatrix();
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" After replacing state matrix elements with S-Box values: "));
        showNewStateMatrix();
        vBox.getChildren().add(new Label(""));


        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step5.2: Now we shift each row of the new state matrix cyclically to the left by offsets of 0,1,2, and 3."));

        for (int i = 0; i < 4 ; i++) {                                                                              //Row shifting
            String[] row = {newstateMatrix[i][0], newstateMatrix[i][1], newstateMatrix[i][2], newstateMatrix[i][3]};
            String[] resultRow = shiftRows(row, i);

            newstateMatrix[i][0] = resultRow[0];
            newstateMatrix[i][1] = resultRow[1];
            newstateMatrix[i][2] = resultRow[2];
            newstateMatrix[i][3] = resultRow[3];
        }

        vBox.getChildren().add(new Label(" State matrix after row shifting: "));
        showNewStateMatrix();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step5.3: Finally we have to calculate the new state matrix XOR matrix formed out of Roundkey10."));

        showRoundkeyMatrixs(10);

        vBox.getChildren().add(new Label(""));

        for (int i = 0; i < 4 ; i++) {                                                     //state Matrix XOR roundkeymatrix
            for (int j = 0; j < 4; j++) {

                newstateMatrix[i][j] = xor(newstateMatrix[i][j], roundkeyMatrix10[i][j]);

            }
        }

        vBox.getChildren().add(new Label(" New state matrix after XOR with roundkeymatrix: "));
        showNewStateMatrix();
        vBox.getChildren().add(new Label(""));

        int k=0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {

                resultround10[k] = newstateMatrix[i][j];
                k++;
            }
        }

        vBox.getChildren().add(new Label(" Result after round10: "));
        String s=" ";

        for (int i = 0; i < k; i++) {
            s = s + resultround10[i] + " ";

        }
        vBox.getChildren().add(new Label(s));
        vBox.getChildren().add(new Label(""));


        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step6: The encrypted message is the result we got after round 10."));

        transformResultRound10ToString();
    }

    public void transformResultRound10ToString(){
        result = "";
        for (int i = 0; i < resultround10.length; i++) {

            result = result + resultround10[i];

        }

        printResult();
    }

    public void printResult(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" The encrypted message is: " + result));
        resultTextField.setText(result);
        vBox.getChildren().add(new Label(""));
    }





    public void intermediateRounds(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step4: Now we need to calculate rounds 1-9."));
        vBox.getChildren().add(new Label(""));


        for (int g = 1; g < 10 ; g++) {

            vBox.getChildren().add(new Label(" ROUND " + g + ": "));

            vBox.getChildren().add(new Label(""));
            vBox.getChildren().add(new Label(" Step4.1: We replace each element in the state matrix resulted at Round" + (g-1) + " with it's correspondent in the Rijndael S-Box."));

            for (int i = 0; i < 4 ; i++) {                                               //S-BOX
                for (int j = 0; j < 4 ; j++) {

                    stateMatrix[i][j] = newstateMatrix[i][j];
                }
            }
            showStateMatrix();
            showRijndaelSBox();
            vBox.getChildren().add(new Label(""));

            for (int i = 0; i < 4 ; i++) {
                for (int j = 0; j < 4 ; j++) {
                    newstateMatrix[i][j] = replacingusingSBox(newstateMatrix[i][j]);
                }
            }

            vBox.getChildren().add(new Label(""));
            vBox.getChildren().add(new Label(" Matrix after replacing state matrix elements with S-Box values: "));
            showNewStateMatrix();
            vBox.getChildren().add(new Label(""));
            vBox.getChildren().add(new Label(" Step4.2: Now we shift each row of the new state matrix cyclically to the left by offsets of 0,1,2, and 3."));


            for (int i = 0; i < 4 ; i++) {                                                                              //Row shifting
                String[] row = {newstateMatrix[i][0], newstateMatrix[i][1], newstateMatrix[i][2], newstateMatrix[i][3]};
                String[] resultRow = shiftRows(row, i);

                newstateMatrix[i][0] = resultRow[0];
                newstateMatrix[i][1] = resultRow[1];
                newstateMatrix[i][2] = resultRow[2];
                newstateMatrix[i][3] = resultRow[3];
            }

            vBox.getChildren().add(new Label(""));
            vBox.getChildren().add(new Label(" State matrix after row shifting: "));
            showNewStateMatrix();

            vBox.getChildren().add(new Label(""));
            vBox.getChildren().add(new Label(" Step4.3: Next we multiply the current state matrix with the Mix Column matrix."));

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    stateMatrix[i][j] = newstateMatrix[i][j];
                }
            }
            showStateMatrix();

            fillMixColumn();
            fillBinaryTable();

            mixColumnsOperation();                                                            //Mix Column

            vBox.getChildren().add(new Label(""));
            vBox.getChildren().add(new Label(" New state matrix after Mix Column:"));
            showNewStateMatrix();

            vBox.getChildren().add(new Label(""));
            vBox.getChildren().add(new Label(" Step 4.4: We have to calculate the new state matrix(from above) XOR the roundkey" + g + " matrix."));
            showRoundkeyMatrixs(g);

            vBox.getChildren().add(new Label(""));

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    stateMatrix[i][j] = newstateMatrix[i][j];
                }
            }

            for (int i = 0; i < 4 ; i++) {                                                     //state Matrix XOR roundkeymatrix
                for (int j = 0; j < 4; j++) {

                    switch (g){
                        case 1:
                            newstateMatrix[i][j] = xor(stateMatrix[i][j], roundkeyMatrix1[i][j]);
                            break;
                        case 2:
                            newstateMatrix[i][j] = xor(stateMatrix[i][j], roundkeyMatrix2[i][j]);
                            break;
                        case 3:
                            newstateMatrix[i][j] = xor(stateMatrix[i][j], roundkeyMatrix3[i][j]);
                            break;
                        case 4:
                            newstateMatrix[i][j] = xor(stateMatrix[i][j], roundkeyMatrix4[i][j]);
                            break;
                        case 5:
                            newstateMatrix[i][j] = xor(stateMatrix[i][j], roundkeyMatrix5[i][j]);
                            break;
                        case 6:
                            newstateMatrix[i][j] = xor(stateMatrix[i][j], roundkeyMatrix6[i][j]);
                            break;
                        case 7:
                            newstateMatrix[i][j] = xor(stateMatrix[i][j], roundkeyMatrix7[i][j]);
                            break;
                        case 8:
                            newstateMatrix[i][j] = xor(stateMatrix[i][j], roundkeyMatrix8[i][j]);
                            break;
                        case 9:
                            newstateMatrix[i][j] = xor(stateMatrix[i][j], roundkeyMatrix9[i][j]);
                            break;
                    }

                }
            }

            vBox.getChildren().add(new Label(" New state matrix after XOR with Roundkey Matrix:"));
            showNewStateMatrix();

            int k=0;
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 4; i++) {
                    switch(g){
                        case 1:
                            resultround1[k] = newstateMatrix[i][j];
                            break;
                        case 2:
                            resultround2[k] = newstateMatrix[i][j];
                            break;
                        case 3:
                            resultround3[k] = newstateMatrix[i][j];
                            break;
                        case 4:
                            resultround4[k] = newstateMatrix[i][j];
                            break;
                        case 5:
                            resultround5[k] = newstateMatrix[i][j];
                            break;
                        case 6:
                            resultround6[k] = newstateMatrix[i][j];
                            break;
                        case 7:
                            resultround7[k] = newstateMatrix[i][j];
                            break;
                        case 8:
                            resultround8[k] = newstateMatrix[i][j];
                            break;
                        case 9:
                            resultround9[k] = newstateMatrix[i][j];
                            break;
                    }

                    k++;
                }
            }

            String s=" ";

            for (int i = 0; i < k; i++) {
                switch (g){
                    case 1:
                        s = s + resultround1[i] + " ";
                        break;
                    case 2:
                        s = s + resultround2[i] + " ";
                        break;
                    case 3:
                        s = s + resultround3[i] + " ";
                        break;
                    case 4:
                        s = s + resultround4[i] + " ";
                        break;
                    case 5:
                        s = s + resultround5[i] + " ";
                        break;
                    case 6:
                        s = s + resultround6[i] + " ";
                        break;
                    case 7:
                        s = s + resultround7[i] + " ";
                        break;
                    case 8:
                        s = s + resultround8[i] + " ";
                        break;
                    case 9:
                        s = s + resultround9[i] + " ";
                        break;
                }

            }

            vBox.getChildren().add(new Label(""));
            switch (g){
                case 1:
                    vBox.getChildren().add(new Label(" Result after round1: "));
                    break;
                case 2:
                    vBox.getChildren().add(new Label(" Result after round2: "));
                    break;
                case 3:
                    vBox.getChildren().add(new Label(" Result after round3: "));
                    break;
                case 4:
                    vBox.getChildren().add(new Label(" Result after round4: "));
                    break;
                case 5:
                    vBox.getChildren().add(new Label(" Result after round5: "));
                    break;
                case 6:
                    vBox.getChildren().add(new Label(" Result after round6: "));
                    break;
                case 7:
                    vBox.getChildren().add(new Label(" Result after round7: "));
                    break;
                case 8:
                    vBox.getChildren().add(new Label(" Result after round8: "));
                    break;
                case 9:
                    vBox.getChildren().add(new Label(" Result after round9: "));
                    break;

            }
            vBox.getChildren().add(new Label(s));

            vBox.getChildren().add(new Label(" "));
            vBox.getChildren().add(new Label(" "));
        }

    }

    public String replacingusingSBox(String s){
        int row = 0;
        int column = 0;

        if (s.charAt(0) != 'A' && s.charAt(0) != 'B' && s.charAt(0) != 'C' && s.charAt(0) != 'D' && s.charAt(0) != 'E' && s.charAt(0) != 'F') {
            row = Character.getNumericValue(s.charAt(0));
        } else if (s.charAt(0) == 'A') {
            row = 10;
        } else if (s.charAt(0) == 'B') {
            row = 11;
        } else if (s.charAt(0) == 'C') {
            row = 12;
        } else if (s.charAt(0) == 'D') {
            row = 13;
        } else if (s.charAt(0) == 'E') {
            row = 14;
        } else if (s.charAt(0) == 'F') {
            row = 15;
        }


        if (s.charAt(1) != 'A' && s.charAt(1) != 'B' && s.charAt(1) != 'C' && s.charAt(1) != 'D' && s.charAt(1) != 'E' && s.charAt(1) != 'F') {
            column = Character.getNumericValue(s.charAt(1));
        } else if (s.charAt(1) == 'A') {
            column = 10;
        } else if (s.charAt(1) == 'B') {
            column = 11;
        } else if (s.charAt(1) == 'C') {
            column = 12;
        } else if (s.charAt(1) == 'D') {
            column = 13;
        } else if (s.charAt(1) == 'E') {
            column = 14;
        } else if (s.charAt(1) == 'F') {
            column = 15;
        }

        vBox.getChildren().add(new Label(" We replace  " + s + "  with  " + sBox[row][column] + "  found on row " + row + " and on column " + column + " in the Rijndael S-Box."));
        s = sBox[row][column];
        return s;
    }



    public String[] shiftRows(String[] strings, int i){

        while(i!=0){
            String aux = strings[0];
            strings[0] = strings[1];
            strings[1] = strings[2];
            strings[2] = strings[3];
            strings[3] = aux;
            i--;
        }

        return strings;
    }


    public void fillMixColumn(){
        MixColumnMatrix mixColumnMatrix = new MixColumnMatrix();
        mixColumnMatrix.setMixColumn();
        mixColumn = mixColumnMatrix.getMixColumn();

        mixColumnToString();
    }

    public void mixColumnToString(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Mix Column Matrix: "));
        for (int i = 0; i < 4; i++) {
            String line = " ";
            for (int j = 0; j < 4; j++) {
                line = line + mixColumn[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }


    public void fillBinaryTable(){
        BinaryCorrespondatsTable binaryCorrespondatsTable = new BinaryCorrespondatsTable();
        binaryCorrespondatsTable.setBinaryTable();

        binaryTable = binaryCorrespondatsTable.getBinaryTable();
    }


    public void mixColumnsOperation(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Mix Column Multiplication:"));

        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 4 ; j++) {

                vBox.getChildren().add(new Label(""));

//                newstateMatrix[i][j] = (mixColumn[i][0]*stateMatrix[0][j]) XOR (mixColumn[i][1]*stateMatrix[1][j]) XOR (mixColumn[i][2]*stateMatrix[2][j]) XOR (mixColumn[i][3]*stateMatrix[3][j]);
                String firstoperand1 = turnIntoBinary(mixColumn[i][0]);
                String firstoperand2 = turnIntoBinary(stateMatrix[0][j]);

                String secondoperand1 = turnIntoBinary(mixColumn[i][1]);
                String secondoperand2 = turnIntoBinary(stateMatrix[1][j]);

                String thirdoperand1 = turnIntoBinary(mixColumn[i][2]);
                String thirdoperand2 = turnIntoBinary(stateMatrix[2][j]);

                String fourthoperand1 = turnIntoBinary(mixColumn[i][3]);
                String fourthoperand2 = turnIntoBinary(stateMatrix[3][j]);



                String result1 = multiplication(firstoperand1, firstoperand2);
                String result2 = multiplication(secondoperand1, secondoperand2);
                String result3 = multiplication(thirdoperand1, thirdoperand2);
                String result4 = multiplication(fourthoperand1, fourthoperand2);

                vBox.getChildren().add(new Label(" "+ mixColumn[i][0] + "  multiplied with  " + stateMatrix[0][j] + "  =  " + result1 + ",  which in hexadecimal is  " + fromBinaryToHexadecimal(result1)));
                vBox.getChildren().add(new Label(" "+ mixColumn[i][1] + "  multiplied with  " + stateMatrix[1][j] + "  =  " + result2 + ",  which in hexadecimal is  " + fromBinaryToHexadecimal(result2)));
                vBox.getChildren().add(new Label(" "+ mixColumn[i][2] + "  multiplied with  " + stateMatrix[2][j] + "  =  " + result3 + ",  which in hexadecimal is  " + fromBinaryToHexadecimal(result3)));
                vBox.getChildren().add(new Label(" "+ mixColumn[i][3] + "  multiplied with  " + stateMatrix[3][j] + "  =  " + result4 + ",  which in hexadecimal is  " + fromBinaryToHexadecimal(result4)));


                String xor1 = xorForBinaryOperands2(result1.toCharArray(), result2.toCharArray());
                String xor2 = xorForBinaryOperands2(xor1.toCharArray(), result3.toCharArray());
                String xor3 = xorForBinaryOperands2(xor2.toCharArray(), result4.toCharArray());


                newstateMatrix[i][j] = fromBinaryToHexadecimal(xor3);
                vBox.getChildren().add(new Label(" "));
                vBox.getChildren().add(new Label(" " + fromBinaryToHexadecimal(result1) + "  XOR  " + fromBinaryToHexadecimal(result2) + "  XOR  " + fromBinaryToHexadecimal(result3) + "  XOR  " + fromBinaryToHexadecimal(result4) + "  =  " + newstateMatrix[i][j]));
            }
        }
        vBox.getChildren().add(new Label(" "));
        vBox.getChildren().add(new Label(" Here you can find more details about how the multiplication between two binary numbers works: https://www.youtube.com/watch?v=nC0mjaUZd8w (min 24). "));
    }


    public String turnIntoBinary(String s){
        String res="";
        if(s.charAt(0)!='A' && s.charAt(0)!='B' && s.charAt(0)!='C' && s.charAt(0)!='D' && s.charAt(0)!='E' && s.charAt(0)!='F'){
            int row = Character.getNumericValue(s.charAt(0));
            res = binaryTable[row][1];
        }else if (s.charAt(0)=='A'){
            res = binaryTable[10][1];
        }else if (s.charAt(0)=='B'){
            res = binaryTable[11][1];
        }else if (s.charAt(0)=='C'){
            res = binaryTable[12][1];
        }else if (s.charAt(0)=='D'){
            res = binaryTable[13][1];
        }else if (s.charAt(0)=='E'){
            res = binaryTable[14][1];
        }else if (s.charAt(0)=='F'){
            res = binaryTable[15][1];
        }

        if(s.charAt(1)!='A' && s.charAt(1)!='B' && s.charAt(1)!='C' && s.charAt(1)!='D' && s.charAt(1)!='E' && s.charAt(1)!='F') {
            int row = Character.getNumericValue(s.charAt(1));
            res = res + binaryTable[row][1];
        }else if (s.charAt(1)=='A'){
            res = res + binaryTable[10][1];
        }else if (s.charAt(1)=='B'){
            res = res + binaryTable[11][1];
        }else if (s.charAt(1)=='C'){
            res = res + binaryTable[12][1];
        }else if (s.charAt(1)=='D'){
            res = res + binaryTable[13][1];
        }else if (s.charAt(1)=='E'){
            res = res + binaryTable[14][1];
        }else if (s.charAt(1)=='F'){
            res = res + binaryTable[15][1];
        }


        return res;
    }


    public String multiplication(String operand1, String operand2){

        String res = "";

        if (operand1.equals("00000001")){
            res = operand2;

        }else if (operand1.equals("00000010")){                 //multiplication with 02

            char[] oneBites = new char[]{operand2.charAt(0), operand2.charAt(1), operand2.charAt(2), operand2.charAt(3),
                    operand2.charAt(4), operand2.charAt(5), operand2.charAt(6), operand2.charAt(7),'0'};


            if (oneBites[0]=='0'){
                for (int i = 1; i < 9; i++) {
                    res = res + oneBites[i];
                }
            }else if (oneBites[0]=='1'){
                char[] reducingPolynom = {'1','0','0','0','1','1','0','1','1'};



                String r = xorForBinaryOperands(oneBites, reducingPolynom);
                for (int i = 1; i < 9; i++){
                    res = res + r.charAt(i);
                }

            }

//            System.out.println("Result after multiplying " + operand1 + " with " + operand2 + " is = " + res);

        }else if (operand1.equals("00000011")){

            String res1 = "";

            char[] oneBites = new char[]{operand2.charAt(0), operand2.charAt(1), operand2.charAt(2), operand2.charAt(3),
                    operand2.charAt(4), operand2.charAt(5), operand2.charAt(6), operand2.charAt(7),'0'};


            if (oneBites[0]=='0'){
                for (int i = 1; i < 9; i++) {
                    res1 = res1 + oneBites[i];
                }
            }else if (oneBites[0]=='1'){
                char[] reducingPolynom = {'1','0','0','0','1','1','0','1','1'};



                String r = xorForBinaryOperands(oneBites, reducingPolynom);
                for (int i = 1; i < 9; i++){
                    res1 = res1 + r.charAt(i);
                }

            }


            char[] operand2Char = {operand2.charAt(0), operand2.charAt(1), operand2.charAt(2), operand2.charAt(3),
                    operand2.charAt(4), operand2.charAt(5), operand2.charAt(6), operand2.charAt(7)};
            res = xorForBinaryOperands2(res1.toCharArray(), operand2Char);
        }

        return res;
    }

    public String xorForBinaryOperands2(char[] op1, char[] op2){
        String result = "";

        for (int i = 0; i < 8; i++) {
            if (op1[i] == '1' && op2[i] == '1') {
                result = result + "0";
            }else if (op1[i] == '0' && op2[i] == '0'){
                result = result + "0";
            }else if (op1[i] == '1' && op2[i] == '0'){
                result = result + "1";
            }else if (op1[i] == '0' && op2[i] == '1'){
                result = result + "1";
            }
        }
        return result;
    }

    public String xorForBinaryOperands(char[] op1, char[] op2){
        String result = "";

        for (int i = 0; i < 9; i++) {
            if (op1[i] == '1' && op2[i] == '1') {
                result = result + "0";
            }else if (op1[i] == '0' && op2[i] == '0'){
                result = result + "0";
            }else if (op1[i] == '1' && op2[i] == '0'){
                result = result + "1";
            }else if (op1[i] == '0' && op2[i] == '1'){
                result = result + "1";
            }
        }
        return result;
    }


    public String fromBinaryToHexadecimal(String s){
        String result = "";
        String string1 = "" + s.charAt(0) + s.charAt(1) + s.charAt(2) + s.charAt(3);
        String string2 = "" + s.charAt(4) + s.charAt(5) + s.charAt(6) + s.charAt(7);

        for (int i = 0; i < 16; i++) {
            if(binaryTable[i][1].equals(string1)){
                string1 = binaryTable[i][0];
            }
            if(binaryTable[i][1].equals(string2)){
                string2 = binaryTable[i][0];
            }
        }

        result = string1 + string2;
        return result;
    }






    public void initialRound(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step3: We need to calculate the result after Round 0."));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" ROUND 0: "));

        vBox.getChildren().add(new Label(""));
        String ss = " The message in hexadecimal is: ";
        for (String s: hexamessage) {
            ss = ss + s + " ";
        }
        vBox.getChildren().add(new Label(ss));

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step3.1: We build the state matrix by writing the hexadecimal message on columns, from top to bottom and from left to right, in a 4x4 table."));

        String[] hexamsg = hexamessage.toArray(new String[0]);

        int k=0;
        for (int j = 0; j < 4 ; j++) {                                              //State Matrix formed out of the hexamessage
            for( int i = 0; i < 4; i++){
                stateMatrix[i][j] = hexamsg[k];
                k++;
            }
        }

        showStateMatrix();

        roundkeyMatrixs();
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step3.2: We have to calculate: the state matrix XOR the matrix built from Roundkey0."));

        showRoundkeyMatrixs(0);

        vBox.getChildren().add(new Label(""));
        for (int i = 0; i < 4 ; i++) {                                                     //fill new state Matrix
            for (int j = 0; j < 4; j++) {
                newstateMatrix[i][j] = xor(stateMatrix[i][j], roundkeyMatrix0[i][j]);
                vBox.getChildren().add(new Label(" " + stateMatrix[i][j] + " XOR " + roundkeyMatrix0[i][j] + " = " + newstateMatrix[i][j]));
            }
        }

        vBox.getChildren().add(new Label(""));
        showNewStateMatrix();

        k=0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                resultround0[k] = newstateMatrix[i][j];
                k++;
            }
        }

        vBox.getChildren().add(new Label(""));
        String s=" Result after round0 is: ";

        for (int i = 0; i < k; i++) {
            s = s + resultround0[i] + " ";
        }

        vBox.getChildren().add(new Label(s));
        vBox.getChildren().add(new Label(""));
    }

    public void showStateMatrix(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" The current state matrix is:"));

        for (int i = 0; i < 4 ; i++) {
            String line = " ";
            for (int j = 0; j < 4; j++) {
                line = line + stateMatrix[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void showNewStateMatrix(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" The new state matrix is:"));
        for (int i = 0; i < 4 ; i++) {
            String line = " ";
            for (int j = 0; j < 4; j++) {
                line = line + newstateMatrix[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void roundkeyMatrixs(){

        int k=0;
        for (int j = 0; j < 4 ; j++) {
            for( int i = 0; i < 4; i++){
                roundkeyMatrix0[i][j] = roundkey0[k];
                k++;
            }
        }

        k=0;
        for (int j = 0; j < 4 ; j++) {
            for( int i = 0; i < 4; i++){
                roundkeyMatrix1[i][j] = roundkey1[k];
                k++;
            }

        }

        k=0;
        for (int j = 0; j < 4 ; j++) {
            for( int i = 0; i < 4; i++){
                roundkeyMatrix2[i][j] = roundkey2[k];
                k++;
            }
        }

        k=0;
        for (int j = 0; j < 4 ; j++) {
            for( int i = 0; i < 4; i++){
                roundkeyMatrix3[i][j] = roundkey3[k];
                k++;
            }
        }

        k=0;
        for (int j = 0; j < 4 ; j++) {
            for( int i = 0; i < 4; i++){
                roundkeyMatrix4[i][j] = roundkey4[k];
                k++;
            }
        }

        k=0;
        for (int j = 0; j < 4 ; j++) {
            for( int i = 0; i < 4; i++){
                roundkeyMatrix5[i][j] = roundkey5[k];
                k++;
            }
        }

        k=0;
        for (int j = 0; j < 4 ; j++) {
            for( int i = 0; i < 4; i++){
                roundkeyMatrix6[i][j] = roundkey6[k];
                k++;
            }
        }

        k=0;
        for (int j = 0; j < 4 ; j++) {
            for( int i = 0; i < 4; i++){
                roundkeyMatrix7[i][j] = roundkey7[k];
                k++;
            }
        }

        k=0;
        for (int j = 0; j < 4 ; j++) {
            for( int i = 0; i < 4; i++){
                roundkeyMatrix8[i][j] = roundkey8[k];
                k++;
            }
        }

        k=0;
        for (int j = 0; j < 4 ; j++) {
            for( int i = 0; i < 4; i++){
                roundkeyMatrix9[i][j] = roundkey9[k];
                k++;
            }
        }

        k=0;
        for (int j = 0; j < 4 ; j++) {
            for( int i = 0; i < 4; i++){
                roundkeyMatrix10[i][j] = roundkey10[k];
                k++;
            }
        }

    }

    public void showRoundkeyMatrixs(int x){

        switch (x){
            case 0:
                vBox.getChildren().add(new Label(""));
                vBox.getChildren().add(new Label(" Roundkey0 matrix is: "));

                for (int i = 0; i < 4 ; i++) {
                    String line = " ";
                    for (int j = 0; j < 4; j++) {
                        line = line + roundkeyMatrix0[i][j] + "  ";
                    }
                    vBox.getChildren().add(new Label(line));
                }
                break;

            case 1:
                vBox.getChildren().add(new Label(""));
                vBox.getChildren().add(new Label(" Roundkey1 matrix is: "));

                for (int i = 0; i < 4 ; i++) {
                    String line = " ";
                    for (int j = 0; j < 4; j++) {
                        line = line + roundkeyMatrix1[i][j] + "  ";
                    }
                    vBox.getChildren().add(new Label(line));
                }
                break;

            case 2:
                vBox.getChildren().add(new Label(""));
                vBox.getChildren().add(new Label(" Roundkey2 matrix is: "));

                for (int i = 0; i < 4 ; i++) {
                    String line = " ";
                    for (int j = 0; j < 4; j++) {
                        line = line + roundkeyMatrix2[i][j] + "  ";
                    }
                    vBox.getChildren().add(new Label(line));
                }
                break;

            case 3:
                vBox.getChildren().add(new Label(""));
                vBox.getChildren().add(new Label(" Roundkey3 matrix is: "));

                for (int i = 0; i < 4 ; i++) {
                    String line = " ";
                    for (int j = 0; j < 4; j++) {
                        line = line + roundkeyMatrix3[i][j] + "  ";
                    }
                    vBox.getChildren().add(new Label(line));
                }
                break;

            case 4:
                vBox.getChildren().add(new Label(""));
                vBox.getChildren().add(new Label(" Roundkey4 matrix is: "));

                for (int i = 0; i < 4 ; i++) {
                    String line = " ";
                    for (int j = 0; j < 4; j++) {
                        line = line + roundkeyMatrix4[i][j] + "  ";
                    }
                    vBox.getChildren().add(new Label(line));
                }
                break;

            case 5:
                vBox.getChildren().add(new Label(""));
                vBox.getChildren().add(new Label(" Roundkey5 matrix is: "));

                for (int i = 0; i < 4 ; i++) {
                    String line = " ";
                    for (int j = 0; j < 4; j++) {
                        line = line + roundkeyMatrix5[i][j] + "  ";
                    }
                    vBox.getChildren().add(new Label(line));
                }
                break;

            case 6:
                vBox.getChildren().add(new Label(""));
                vBox.getChildren().add(new Label(" Roundkey6 matrix is: "));

                for (int i = 0; i < 4 ; i++) {
                    String line = " ";
                    for (int j = 0; j < 4; j++) {
                        line = line + roundkeyMatrix6[i][j] + "  ";
                    }
                    vBox.getChildren().add(new Label(line));
                }
                break;

            case 7:
                vBox.getChildren().add(new Label(""));
                vBox.getChildren().add(new Label(" Roundkey7 matrix is: "));

                for (int i = 0; i < 4 ; i++) {
                    String line = " ";
                    for (int j = 0; j < 4; j++) {
                        line = line + roundkeyMatrix7[i][j] + "  ";
                    }
                    vBox.getChildren().add(new Label(line));
                }
                break;

            case 8:
                vBox.getChildren().add(new Label(""));
                vBox.getChildren().add(new Label(" Roundkey8 matrix is: "));

                for (int i = 0; i < 4 ; i++) {
                    String line = " ";
                    for (int j = 0; j < 4; j++) {
                        line = line + roundkeyMatrix8[i][j] + "  ";
                    }
                    vBox.getChildren().add(new Label(line));
                }
                break;

            case 9:
                vBox.getChildren().add(new Label(""));
                vBox.getChildren().add(new Label(" Roundkey9 matrix is: "));

                for (int i = 0; i < 4 ; i++) {
                    String line = " ";
                    for (int j = 0; j < 4; j++) {
                        line = line + roundkeyMatrix9[i][j] + "  ";
                    }
                    vBox.getChildren().add(new Label(line));
                }
                break;

            case 10:
                vBox.getChildren().add(new Label(""));
                vBox.getChildren().add(new Label(" Roundkey10 matrix is: "));

                for (int i = 0; i < 4 ; i++) {
                    String line = " ";
                    for (int j = 0; j < 4; j++) {
                        line = line + roundkeyMatrix10[i][j] + "  ";
                    }
                    vBox.getChildren().add(new Label(line));
                }
                break;

        }
    }








    public void findRoundkeys(){

        vBox.getChildren().add(new Label(" Roundkey0 is the key written in hexadecimal."));
        roundkey0 = hexakey.toArray(new String[0]);                             //initial key in hexadecimal is roundkey0

        showRoundkey(0);
        actualroundkey = hexakey.toArray(new String[0]);

        rijndaelSBox();                                                         //fill the Rijndael S-Box

        xorMatrix();                                                            //fill the XOR Table


        vBox.getChildren().add(new Label(" "));
        vBox.getChildren().add(new Label(" Step2: We need to calculate all Roundkeys."));
        vBox.getChildren().add(new Label(" "));
        getAllRoundkeys();
        showAllRoundkeys();

    }

    public void showRoundkey(int x){

        String ss = " Roundkey" + x + " is: ";
        for (int i = 0; i < roundkey0.length ; i++) {
            ss = ss + roundkey0[i] + " ";
        }
        vBox.getChildren().add(new Label(ss));
    }

    public void rijndaelSBox(){                // row and column 10 represent row and column A; B is 11; C is 12; D is 13; E is 14; F is 15

        RijndaelSBox rijndaelSBox = new RijndaelSBox();
        rijndaelSBox.setRijndaelSBox();
        sBox = rijndaelSBox.getsBox();
    }

    public void xorMatrix(){

        XorMatrix xorMatrix = new XorMatrix();
        xorMatrix.setXorTable();
        xorTable = xorMatrix.getXorTable();
    }

    public void getAllRoundkeys(){

        //steps for the roundkeys
        for (int i=1; i<=10; i++){

            vBox.getChildren().add(new Label(" Round " + i + ": "));
            vBox.getChildren().add(new Label(" "));

            vBox.getChildren().add(new Label(" Step 2.1: We divide the Roundkey" + (i-1) + " into w[0], w[1], w[2], w[3]. "));
            List<String[]> listofsubsets = splittingActualRoundkeyInto4Arrays(actualroundkey);  //split the actual roundkey into w[0], w[1], w[2] and w[3]
            String[] subW0 = listofsubsets.get(0);
            String[] subW1 = listofsubsets.get(1);
            String[] subW2 = listofsubsets.get(2);
            String[] subW3 = listofsubsets.get(3);


            vBox.getChildren().add(new Label((" w[0] for round" + i + "= (" + subW0[0] + " " + subW0[1] + " " + subW0[2] + " " + subW0[3] + ")")));
            vBox.getChildren().add(new Label((" w[1] for round" + i + "= (" + subW1[0] + " " + subW1[1] + " " + subW1[2] + " " + subW1[3] + ")")));
            vBox.getChildren().add(new Label((" w[2] for round" + i + "= (" + subW2[0] + " " + subW2[1] + " " + subW2[2] + " " + subW2[3] + ")")));
            vBox.getChildren().add(new Label((" w[3] for round" + i + "= (" + subW3[0] + " " + subW3[1] + " " + subW3[2] + " " + subW3[3] + ")")));

            vBox.getChildren().add(new Label(" "));
            vBox.getChildren().add(new Label(" Step 2.2: We calculate g[w[3]] for round" + i + ": "));

            String[] gsubW3 = {subW3[0], subW3[1], subW3[2], subW3[3]};

            vBox.getChildren().add(new Label(" "));
            vBox.getChildren().add(new Label(" Step 2.2.1: We shift w[3] one to the left."));
            shiftingW3(gsubW3);                                                         //shift w[3] one element to the left

            vBox.getChildren().add(new Label(" "));
            vBox.getChildren().add(new Label(" w[3] after shift = (" + gsubW3[0] + " " + gsubW3[1] + " " + gsubW3[2] + " " + gsubW3[3] + ")"));

            vBox.getChildren().add(new Label(" "));
            vBox.getChildren().add(new Label(" Step 2.2.2: Replace every number of w[3] with it's correspondent in the Rijndael S-Box. The correspondent is found in the Rijndael S-Box, on row equal with the first digit of the number and on column equal to the last digit of the number."));
            showRijndaelSBox();

            gsubW3 = replacingW3usingSBox(gsubW3);                                     //replace the elements of w[3] using Rijndael S-Box

            vBox.getChildren().add(new Label(" "));
            vBox.getChildren().add(new Label(" w[3] after Rijndael replacement = (" + gsubW3[0] + " " + gsubW3[1] + " " + gsubW3[2] + " " + gsubW3[3] + ")"));

            vBox.getChildren().add(new Label(" "));
            vBox.getChildren().add(new Label(" Step 2.2.3: We calculate g[w[3]] = w[3] XOR roundconstant."));
            vBox.getChildren().add(new Label(" w[3] = (" + gsubW3[0] + " " + gsubW3[1] + " " + gsubW3[2] + " " + gsubW3[3] + ")"));


            switch (i){                                                               //XOR between the first round constant and w[3]
                case 1:
                    vBox.getChildren().add(new Label(" roundconstant1 = (" + roundconst1[0] + " " + roundconst1[1] + " " + roundconst1[2] + " " + roundconst1[3] + ")"));
                    gsubW3[0] = xor(gsubW3[0], roundconst1[0]);
                    break;
                case 2:
                    vBox.getChildren().add(new Label(" roundconstant2 = (" + roundconst2[0] + " " + roundconst2[1] + " " + roundconst2[2] + " " + roundconst2[3] + ")"));
                    gsubW3[0] = xor(gsubW3[0], roundconst2[0]);
                    break;
                case 3:
                    vBox.getChildren().add(new Label(" roundconstant3 = (" + roundconst3[0] + " " + roundconst3[1] + " " + roundconst3[2] + " " + roundconst3[3] + ")"));
                    gsubW3[0] = xor(gsubW3[0], roundconst3[0]);
                    break;
                case 4:
                    vBox.getChildren().add(new Label(" roundconstant4 = (" + roundconst4[0] + " " + roundconst4[1] + " " + roundconst4[2] + " " + roundconst4[3] + ")"));
                    gsubW3[0] = xor(gsubW3[0], roundconst4[0]);
                    break;
                case 5:
                    vBox.getChildren().add(new Label(" roundconstant5 = (" + roundconst5[0] + " " + roundconst5[1] + " " + roundconst5[2] + " " + roundconst5[3] + ")"));
                    gsubW3[0] = xor(gsubW3[0], roundconst5[0]);
                    break;
                case 6:
                    vBox.getChildren().add(new Label(" roundconstant6 = (" + roundconst6[0] + " " + roundconst6[1] + " " + roundconst6[2] + " " + roundconst6[3] + ")"));
                    gsubW3[0] = xor(gsubW3[0], roundconst6[0]);
                    break;
                case 7:
                    vBox.getChildren().add(new Label(" roundconstant7 = (" + roundconst7[0] + " " + roundconst7[1] + " " + roundconst7[2] + " " + roundconst7[3] + ")"));
                    gsubW3[0] = xor(gsubW3[0], roundconst7[0]);
                    break;
                case 8:
                    vBox.getChildren().add(new Label(" roundconstant8 = (" + roundconst8[0] + " " + roundconst8[1] + " " + roundconst8[2] + " " + roundconst8[3] + ")"));
                    gsubW3[0] = xor(gsubW3[0], roundconst8[0]);
                    break;
                case 9:
                    vBox.getChildren().add(new Label(" roundconstant9 = (" + roundconst9[0] + " " + roundconst9[1] + " " + roundconst9[2] + " " + roundconst9[3] + ")"));
                    gsubW3[0] = xor(gsubW3[0], roundconst9[0]);
                    break;
                case 10:
                    vBox.getChildren().add(new Label(" roundconstant10 = (" + roundconst10[0] + " " + roundconst10[1] + " " + roundconst10[2] + " " + roundconst10[3] + ")"));
                    gsubW3[0] = xor(gsubW3[0], roundconst10[0]);
                    break;
            }


            vBox.getChildren().add(new Label(" "));
            vBox.getChildren().add(new Label( " g(w[3]) for round" + i + "= (" + gsubW3[0] + " " + gsubW3[1] + " " + gsubW3[2] + " " + gsubW3[3] + ")"));
            vBox.getChildren().add(new Label(" "));

            vBox.getChildren().add(new Label(" Step 2.3: Now we have to calculate w[4], w[5], w[6], w[7]."));

            //calculating w[4], w[5], w[6], w[7]
            String[] subW4 = new String[4];                                       // w[4] = w[0] XOR g(w[3])
            subW4[0] = xor(subW0[0], gsubW3[0]);
            subW4[1] = xor(subW0[1], gsubW3[1]);
            subW4[2] = xor(subW0[2], gsubW3[2]);
            subW4[3] = xor(subW0[3], gsubW3[3]);

            vBox.getChildren().add(new Label(" "));
            vBox.getChildren().add(new Label(" w[4] = w[0] XOR g[w[3]]"));
            vBox.getChildren().add(new Label(" w[4] for round" + i + "= (" + subW4[0] + " " + subW4[1] + " " + subW4[2] + " " + subW4[3] + ")"));

            String[] subW5 = new String[4];                                        // w[5] = w[1] XOR w[4]
            subW5[0] = xor(subW1[0], subW4[0]);
            subW5[1] = xor(subW1[1], subW4[1]);
            subW5[2] = xor(subW1[2], subW4[2]);
            subW5[3] = xor(subW1[3], subW4[3]);

            vBox.getChildren().add(new Label(" "));
            vBox.getChildren().add(new Label(" w[5] = w[1] XOR w[4]"));
            vBox.getChildren().add(new Label(" w[5] for round" + i + "= (" + subW5[0] + " " + subW5[1] + " " + subW5[2] + " " + subW5[3] + ")"));

            String[] subW6 = new String[4];                                        // w[6] = w[2] XOR w[5]
            subW6[0] = xor(subW2[0], subW5[0]);
            subW6[1] = xor(subW2[1], subW5[1]);
            subW6[2] = xor(subW2[2], subW5[2]);
            subW6[3] = xor(subW2[3], subW5[3]);

            vBox.getChildren().add(new Label(" "));
            vBox.getChildren().add(new Label(" w[6] = w[2] XOR w[5]"));
            vBox.getChildren().add(new Label(" w[6] for round" + i + "= (" + subW6[0] + " " + subW6[1] + " " + subW6[2] + " " + subW6[3] + ")"));

            String[] subW7 = new String[4];                                        // w[7] = w[3] XOR w[6]
            subW7[0] = xor(subW3[0], subW6[0]);
            subW7[1] = xor(subW3[1], subW6[1]);
            subW7[2] = xor(subW3[2], subW6[2]);
            subW7[3] = xor(subW3[3], subW6[3]);

            vBox.getChildren().add(new Label(" "));
            vBox.getChildren().add(new Label(" w[7] = w[3] XOR w[6]"));
            vBox.getChildren().add(new Label(" w[7] for round" + i + "= (" + subW7[0] + " " + subW7[1] + " " + subW7[2] + " " + subW7[3] + ")"));


            vBox.getChildren().add(new Label(" "));
            vBox.getChildren().add(new Label(" Step 2.4: We build roundkey" + i +" by concatenating w[4], w[5], w[6] and w[7]."));


            switch (i){                                                                       //building the roundkeys
                case 1:

                    buildRoundkey(roundkey1, subW4, subW5, subW6, subW7);
                    vBox.getChildren().add(new Label(" "));

                    String ss = " First roundkey is: ";
                    for (int j = 0; j < roundkey1.length ; j++) {
                        ss = ss + roundkey1[j] + " ";
                        actualroundkey[j] = roundkey1[j];
                    }
                    vBox.getChildren().add(new Label(ss));
                    break;
                case 2:

                    buildRoundkey(roundkey2, subW4, subW5, subW6, subW7);
                    vBox.getChildren().add(new Label(" "));

                    ss = " Second roundkey is: ";
                    for (int j = 0; j < roundkey2.length ; j++) {
                        ss = ss + roundkey2[j] + " ";
                        actualroundkey[j] = roundkey2[j];
                    }
                    vBox.getChildren().add(new Label(ss));
                    break;
                case 3:

                    buildRoundkey(roundkey3, subW4, subW5, subW6, subW7);
                    vBox.getChildren().add(new Label(" "));

                    ss = " Third roundkey is: ";
                    for (int j = 0; j < roundkey3.length ; j++) {
                        ss = ss + roundkey3[j] + " ";
                        actualroundkey[j] = roundkey3[j];
                    }
                    vBox.getChildren().add(new Label(ss));
                    break;
                case 4:

                    buildRoundkey(roundkey4, subW4, subW5, subW6, subW7);
                    vBox.getChildren().add(new Label(" "));

                    ss = " Fourth roundkey is: ";
                    for (int j = 0; j < roundkey4.length ; j++) {
                        ss = ss + roundkey4[j] + " ";
                        actualroundkey[j] = roundkey4[j];
                    }
                    vBox.getChildren().add(new Label(ss));
                    break;
                case 5:

                    buildRoundkey(roundkey5, subW4, subW5, subW6, subW7);
                    vBox.getChildren().add(new Label(" "));

                    ss = " Fifth roundkey is: ";
                    for (int j = 0; j < roundkey5.length ; j++) {
                        ss = ss + roundkey5[j] + " ";
                        actualroundkey[j] = roundkey5[j];
                    }
                    vBox.getChildren().add(new Label(ss));
                    break;
                case 6:

                    buildRoundkey(roundkey6, subW4, subW5, subW6, subW7);
                    vBox.getChildren().add(new Label(" "));

                    ss = " Sixth roundkey is: ";
                    for (int j = 0; j < roundkey6.length ; j++) {
                        ss = ss + roundkey6[j] + " ";
                        actualroundkey[j] = roundkey6[j];
                    }
                    vBox.getChildren().add(new Label(ss));
                    break;
                case 7:

                    buildRoundkey(roundkey7, subW4, subW5, subW6, subW7);
                    vBox.getChildren().add(new Label(" "));

                    ss = " Seventh roundkey is: ";
                    for (int j = 0; j < roundkey7.length ; j++) {
                        ss = ss + roundkey7[j] + " ";
                        actualroundkey[j] = roundkey7[j];
                    }
                    vBox.getChildren().add(new Label(ss));
                    break;
                case 8:

                    buildRoundkey(roundkey8, subW4, subW5, subW6, subW7);
                    vBox.getChildren().add(new Label(" "));

                    ss = " Eighth roundkey is: ";
                    for (int j = 0; j < roundkey8.length ; j++) {
                        ss = ss + roundkey8[j] + " ";
                        actualroundkey[j] = roundkey8[j];
                    }
                    vBox.getChildren().add(new Label(ss));
                    break;
                case 9:

                    buildRoundkey(roundkey9, subW4, subW5, subW6, subW7);
                    vBox.getChildren().add(new Label(" "));

                    ss = " Ninth roundkey is: ";
                    for (int j = 0; j < roundkey9.length ; j++) {
                        ss = ss + roundkey9[j] + " ";
                        actualroundkey[j] = roundkey9[j];
                    }
                    vBox.getChildren().add(new Label(ss));
                    break;
                case 10:

                    buildRoundkey(roundkey10, subW4, subW5, subW6, subW7);
                    vBox.getChildren().add(new Label(" "));

                    ss = " Tenth roundkey is: ";
                    for (int j = 0; j < roundkey10.length ; j++) {
                        ss = ss + roundkey10[j] + " ";
                        actualroundkey[j] = roundkey10[j];
                    }
                    vBox.getChildren().add(new Label(ss));
                    break;
                default:
                    break;

            }

            vBox.getChildren().add(new Label(" "));
        }

    }


    public String[] shiftingW3(String[] s){

        String aux = s[0];
        s[0] = s[1];
        s[1] = s[2];
        s[2] = s[3];
        s[3] = aux;
        return s;
    }


    public List<String[]> splittingActualRoundkeyInto4Arrays(String[] actualKey){

        String[] subW0 = {actualKey[0], actualKey[1], actualKey[2], actualKey[3]};
        String[] subW1 = {actualKey[4], actualKey[5], actualKey[6], actualKey[7]};
        String[] subW2 = {actualKey[8], actualKey[9], actualKey[10], actualKey[11]};
        String[] subW3 = {actualKey[12], actualKey[13], actualKey[14], actualKey[15]};



        List<String[]> subsets = new ArrayList<>();
        subsets.add(subW0);
        subsets.add(subW1);
        subsets.add(subW2);
        subsets.add(subW3);

        return subsets;

    }

    public void showRijndaelSBox(){

        vBox.getChildren().add(new Label(" "));
        vBox.getChildren().add(new Label(" Rijndael S-Box: "));
        for (int i = 0; i < 16; i++) {
            String line = " ";
            for (int j = 0; j < 16; j++) {
                line = line + sBox[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }


    public String[] replacingW3usingSBox(String[] s) {
        int row = 0;
        int column = 0;

        for (int i = 0; i < 4; i++) {
            if (s[i].charAt(0) != 'A' && s[i].charAt(0) != 'B' && s[i].charAt(0) != 'C' && s[i].charAt(0) != 'D' && s[i].charAt(0) != 'E' && s[i].charAt(0) != 'F') {
                row = Character.getNumericValue(s[i].charAt(0));
            } else if (s[i].charAt(0) == 'A') {
                row = 10;
            } else if (s[i].charAt(0) == 'B') {
                row = 11;
            } else if (s[i].charAt(0) == 'C') {
                row = 12;
            } else if (s[i].charAt(0) == 'D') {
                row = 13;
            } else if (s[i].charAt(0) == 'E') {
                row = 14;
            } else if (s[i].charAt(0) == 'F') {
                row = 15;
            }


            if (s[i].charAt(1) != 'A' && s[i].charAt(1) != 'B' && s[i].charAt(1) != 'C' && s[i].charAt(1) != 'D' && s[i].charAt(1) != 'E' && s[i].charAt(1) != 'F') {
                column = Character.getNumericValue(s[i].charAt(1));
            } else if (s[i].charAt(1) == 'A') {
                column = 10;
            } else if (s[i].charAt(1) == 'B') {
                column = 11;
            } else if (s[i].charAt(1) == 'C') {
                column = 12;
            } else if (s[i].charAt(1) == 'D') {
                column = 13;
            } else if (s[i].charAt(1) == 'E') {
                column = 14;
            } else if (s[i].charAt(1) == 'F') {
                column = 15;
            }

            vBox.getChildren().add(new Label(" "));
            vBox.getChildren().add(new Label(" " + s[i] + " is replaced with " + sBox[row][column] + " found on row " + row + " and column " + column + " in the Rijndael S-Box table."));
            s[i] = sBox[row][column];
        }

        return s;
    }


    public String xor(String operand1, String operand2){
        int row = 0;
        int column = 0;
        String result = "";

        for (int i = 0; i < 2; i++) {
            if (operand1.charAt(i)!='A' && operand1.charAt(i)!='B' && operand1.charAt(i)!='C' && operand1.charAt(i)!='D' && operand1.charAt(i)!='E' && operand1.charAt(i)!='F'){
                row = Character.getNumericValue(operand1.charAt(i));
            }else if (operand1.charAt(i)=='A'){
                row = 10;
            }else if (operand1.charAt(i)=='B'){
                row = 11;
            }else if (operand1.charAt(i)=='C'){
                row = 12;
            }else if (operand1.charAt(i)=='D'){
                row = 13;
            }else if (operand1.charAt(i)=='E'){
                row = 14;
            }else if (operand1.charAt(i)=='F'){
                row = 15;
            }

            if (operand2.charAt(i)!='A' && operand2.charAt(i)!='B' && operand2.charAt(i)!='C' && operand2.charAt(i)!='D' && operand2.charAt(i)!='E' && operand2.charAt(i)!='F'){
                column = Character.getNumericValue(operand2.charAt(i));
            }else if (operand2.charAt(i)=='A'){
                column = 10;
            }else if (operand2.charAt(i)=='B'){
                column = 11;
            }else if (operand2.charAt(i)=='C'){
                column = 12;
            }else if (operand2.charAt(i)=='D'){
                column = 13;
            }else if (operand2.charAt(i)=='E'){
                column = 14;
            }else if (operand2.charAt(i)=='F'){
                column = 15;
            }


            result = result + xorTable[row][column];

        }

        return result;
    }

    public void buildRoundkey(String[] roundkey, String[] firstW, String[] secondW, String[] thirdW, String[] fourthW){
        roundkey[0] = firstW[0];
        roundkey[1] = firstW[1];
        roundkey[2] = firstW[2];
        roundkey[3] = firstW[3];
        roundkey[4] = secondW[0];
        roundkey[5] = secondW[1];
        roundkey[6] = secondW[2];
        roundkey[7] = secondW[3];
        roundkey[8] = thirdW[0];
        roundkey[9] = thirdW[1];
        roundkey[10] = thirdW[2];
        roundkey[11] = thirdW[3];
        roundkey[12] = fourthW[0];
        roundkey[13] = fourthW[1];
        roundkey[14] = fourthW[2];
        roundkey[15] = fourthW[3];
    }




    public void getInitialValues(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step1: First we need to covert both the message and the key into hexadecimal, using the ascii table."));

        asciiTable();

        transformMessageIntoHexaArray();                                //transforming the key and message into hexadecimals using ascii table
        showHexaMessage();

        transformKeyIntoHexaArray();
        showHexaKey();
    }


    public void transformMessageIntoHexaArray(){

        String[] splitedmessage = initmessage.split(" ");
        List<String> msglist = new ArrayList<>();

        for(int i = 0; i<splitedmessage.length; i++){
            msglist.add(splitedmessage[i]);

            if (i!=splitedmessage.length-1){
                msglist.add(" ");
            }
        }

        List<String> charactersmsglist = new ArrayList<>();

        for (String s: msglist) {
            for (String st : s.split("")) {
                charactersmsglist.add(st);
            }
        }

        for (String s:charactersmsglist) {
            hexamessage.add(asciiContrl.findAsciiChar(s).getHexValue());
//            System.out.println(asciiContrl.findAsciiChar(s));
        }

    }


    public void showHexaMessage(){
        vBox.getChildren().add(new Label(""));

        String printhexamessage = " The message in hexadecimal is: ";
        for (String s: hexamessage) {
            printhexamessage = printhexamessage + s + " ";
        }
        vBox.getChildren().add(new Label(printhexamessage));
    }


    public void transformKeyIntoHexaArray(){

        String[] splitedmessage = initkey.split(" ");
        List<String> keylist = new ArrayList<>();

        for(int i = 0; i<splitedmessage.length; i++){
            keylist.add(splitedmessage[i]);

            if (i!=splitedmessage.length-1){
                keylist.add(" ");
            }
        }

        List<String> characterskeylist = new ArrayList<>();

        for (String s: keylist) {
            for (String st : s.split("")) {
                characterskeylist.add(st);
            }
        }

        for (String s:characterskeylist) {
            hexakey.add(asciiContrl.findAsciiChar(s).getHexValue());
        }

    }

    public void showHexaKey(){

        vBox.getChildren().add(new Label(""));
        String printhexakey = " The key in hexadecimal is: ";
        for (String s: hexakey) {
            printhexakey = printhexakey + s + " ";
        }
        vBox.getChildren().add(new Label(printhexakey));
    }

    public void asciiTable(){

        asciiRepo.save(new CharAscii(" ","20"));
        asciiRepo.save(new CharAscii("!","21"));
        asciiRepo.save(new CharAscii("\"","22"));
        asciiRepo.save(new CharAscii("#","23"));
        asciiRepo.save(new CharAscii("$","24"));
        asciiRepo.save(new CharAscii("%","25"));
        asciiRepo.save(new CharAscii("&","26"));
        asciiRepo.save(new CharAscii("'","27"));
        asciiRepo.save(new CharAscii("(","28"));
        asciiRepo.save(new CharAscii(")","29"));
        asciiRepo.save(new CharAscii("*","2A"));
        asciiRepo.save(new CharAscii("+","2B"));
        asciiRepo.save(new CharAscii(",","2C"));
        asciiRepo.save(new CharAscii("-","2D"));
        asciiRepo.save(new CharAscii(".","2E"));
        asciiRepo.save(new CharAscii("/","2F"));
        asciiRepo.save(new CharAscii("0","30"));
        asciiRepo.save(new CharAscii("1","31"));
        asciiRepo.save(new CharAscii("2","32"));
        asciiRepo.save(new CharAscii("3","33"));
        asciiRepo.save(new CharAscii("4","34"));
        asciiRepo.save(new CharAscii("5","35"));
        asciiRepo.save(new CharAscii("6","36"));
        asciiRepo.save(new CharAscii("7","37"));
        asciiRepo.save(new CharAscii("8","38"));
        asciiRepo.save(new CharAscii("9","39"));
        asciiRepo.save(new CharAscii(":","3A"));
        asciiRepo.save(new CharAscii(";","3B"));
        asciiRepo.save(new CharAscii("<","3C"));
        asciiRepo.save(new CharAscii("=","3D"));
        asciiRepo.save(new CharAscii(">","3E"));
        asciiRepo.save(new CharAscii("?","3F"));
        asciiRepo.save(new CharAscii("@","40"));
        asciiRepo.save(new CharAscii("A","41"));
        asciiRepo.save(new CharAscii("B","42"));
        asciiRepo.save(new CharAscii("C","43"));
        asciiRepo.save(new CharAscii("D","44"));
        asciiRepo.save(new CharAscii("E","45"));
        asciiRepo.save(new CharAscii("F","46"));
        asciiRepo.save(new CharAscii("G","47"));
        asciiRepo.save(new CharAscii("H","48"));
        asciiRepo.save(new CharAscii("I","49"));
        asciiRepo.save(new CharAscii("J","4A"));
        asciiRepo.save(new CharAscii("K","4B"));
        asciiRepo.save(new CharAscii("L","4C"));
        asciiRepo.save(new CharAscii("M","4D"));
        asciiRepo.save(new CharAscii("N","4E"));
        asciiRepo.save(new CharAscii("O","4F"));
        asciiRepo.save(new CharAscii("P","50"));
        asciiRepo.save(new CharAscii("Q","51"));
        asciiRepo.save(new CharAscii("R","52"));
        asciiRepo.save(new CharAscii("S","53"));
        asciiRepo.save(new CharAscii("T","54"));
        asciiRepo.save(new CharAscii("U","55"));
        asciiRepo.save(new CharAscii("V","56"));
        asciiRepo.save(new CharAscii("W","57"));
        asciiRepo.save(new CharAscii("X","58"));
        asciiRepo.save(new CharAscii("Y","59"));
        asciiRepo.save(new CharAscii("Z","5A"));
        asciiRepo.save(new CharAscii("[","5B"));
        asciiRepo.save(new CharAscii("\\","5C"));
        asciiRepo.save(new CharAscii("]","5D"));
        asciiRepo.save(new CharAscii("^","5E"));
        asciiRepo.save(new CharAscii("_","5F"));
        asciiRepo.save(new CharAscii("`","60"));
        asciiRepo.save(new CharAscii("a","61"));
        asciiRepo.save(new CharAscii("b","62"));
        asciiRepo.save(new CharAscii("c","63"));
        asciiRepo.save(new CharAscii("d","64"));
        asciiRepo.save(new CharAscii("e","65"));
        asciiRepo.save(new CharAscii("f","66"));
        asciiRepo.save(new CharAscii("g","67"));
        asciiRepo.save(new CharAscii("h","68"));
        asciiRepo.save(new CharAscii("i","69"));
        asciiRepo.save(new CharAscii("j","6A"));
        asciiRepo.save(new CharAscii("k","6B"));
        asciiRepo.save(new CharAscii("l","6C"));
        asciiRepo.save(new CharAscii("m","6D"));
        asciiRepo.save(new CharAscii("n","6E"));
        asciiRepo.save(new CharAscii("o","6F"));
        asciiRepo.save(new CharAscii("p","70"));
        asciiRepo.save(new CharAscii("q","71"));
        asciiRepo.save(new CharAscii("r","72"));
        asciiRepo.save(new CharAscii("s","73"));
        asciiRepo.save(new CharAscii("t","74"));
        asciiRepo.save(new CharAscii("u","75"));
        asciiRepo.save(new CharAscii("v","76"));
        asciiRepo.save(new CharAscii("w","77"));
        asciiRepo.save(new CharAscii("x","78"));
        asciiRepo.save(new CharAscii("y","79"));
        asciiRepo.save(new CharAscii("z","7A"));
        asciiRepo.save(new CharAscii("{","7B"));
        asciiRepo.save(new CharAscii("|","7C"));
        asciiRepo.save(new CharAscii("}","7D"));
        asciiRepo.save(new CharAscii("~","7E"));

        showAsciiTable();
    }

    public void showAsciiTable(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" The ascii table:"));
        vBox.getChildren().add(new Label(""));

        for (CharAscii c: asciiRepo.findAll()) {
            vBox.getChildren().add(new Label(" The ascii character " + c.getAsciiChar() + " in hexadecimal is: " + c.getHexValue()));
        }
    }

    public void showAllRoundkeys(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" The Roundkeys are: "));
        vBox.getChildren().add(new Label(""));

        String ss = " Roundkey0 is: ";
        for (int i = 0; i < roundkey0.length ; i++) {
            ss = ss + roundkey0[i] + " ";
        }
        vBox.getChildren().add(new Label(ss));

        vBox.getChildren().add(new Label(""));
        ss = " Roundkey1 is: ";
        for (int i = 0; i < roundkey1.length ; i++) {
            ss = ss + roundkey1[i] + " ";
        }
        vBox.getChildren().add(new Label(ss));

        vBox.getChildren().add(new Label(""));
        ss = " Roundkey2 is: ";
        for (int i = 0; i < roundkey2.length ; i++) {
            ss = ss + roundkey2[i] + " ";
        }
        vBox.getChildren().add(new Label(ss));

        vBox.getChildren().add(new Label(""));
        ss = " Roundkey3 is: ";
        for (int i = 0; i < roundkey3.length ; i++) {
            ss = ss + roundkey3[i] + " ";
        }
        vBox.getChildren().add(new Label(ss));

        vBox.getChildren().add(new Label(""));
        ss = " Roundkey4 is: ";
        for (int i = 0; i < roundkey4.length ; i++) {
            ss = ss + roundkey4[i] + " ";
        }
        vBox.getChildren().add(new Label(ss));

        vBox.getChildren().add(new Label(""));
        ss = " Roundkey5 is: ";
        for (int i = 0; i < roundkey5.length ; i++) {
            ss = ss + roundkey5[i] + " ";
        }
        vBox.getChildren().add(new Label(ss));

        vBox.getChildren().add(new Label(""));
        ss = " Roundkey6 is: ";
        for (int i = 0; i < roundkey6.length ; i++) {
            ss = ss + roundkey6[i] + " ";
        }
        vBox.getChildren().add(new Label(ss));

        vBox.getChildren().add(new Label(""));
        ss = " Roundkey7 is: ";
        for (int i = 0; i < roundkey7.length ; i++) {
            ss = ss + roundkey7[i] + " ";
        }
        vBox.getChildren().add(new Label(ss));

        vBox.getChildren().add(new Label(""));
        ss = " Roundkey8 is: ";
        for (int i = 0; i < roundkey8.length ; i++) {
            ss = ss + roundkey8[i] + " ";
        }
        vBox.getChildren().add(new Label(ss));

        vBox.getChildren().add(new Label(""));
        ss = " Roundkey9 is: ";
        for (int i = 0; i < roundkey9.length ; i++) {
            ss = ss + roundkey9[i] + " ";
        }
        vBox.getChildren().add(new Label(ss));

        vBox.getChildren().add(new Label(""));
        ss = " Roundkey10 is: ";
        for (int i = 0; i < roundkey10.length ; i++) {
            ss = ss + roundkey10[i] + " ";
        }

        vBox.getChildren().add(new Label(ss));

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(""));

    }
}
