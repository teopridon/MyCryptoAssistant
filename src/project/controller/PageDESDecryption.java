package project.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import project.repository.*;

public class PageDESDecryption {
    @FXML
    private TextField messageTextField;

    @FXML
    private TextField keyTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private VBox vBox;

    public String initmessage;
    public String initkey;
    public String[] messageBase2 = new String[16];
    public String[] keyBase2 = new String[16];
    public String[][] base2CorrespondantsMatrix = new String[16][2];
    public int[][] matrixPC1 = new int[8][7];
    public int[][] matrixPC2 = new int[8][6];
    public int[][] matrixIP = new int[8][8];
    public int[][] matrixP = new int[8][4];
    public int[][] matrixE = new int[8][6];
    public int[][] matrixIPminus1 = new int[8][8];
    public char[] bitkey = new char[64];
    public char[] keyAfterPC1 = new char[56];
    public char[] messageAfterIP = new char[64];

    public int[][] sBox1 = new int[4][16];
    public int[][] sBox2 = new int[4][16];
    public int[][] sBox3 = new int[4][16];
    public int[][] sBox4 = new int[4][16];
    public int[][] sBox5 = new int[4][16];
    public int[][] sBox6 = new int[4][16];
    public int[][] sBox7 = new int[4][16];
    public int[][] sBox8 = new int[4][16];

    public String sBox = "";
    public char[] sBoxResultBase2 = new char[28];

    public char[] c0 = new char[28];
    public char[] d0 = new char[28];
    public char[] c1 = new char[28];
    public char[] d1 = new char[28];
    public char[] c2 = new char[28];
    public char[] d2 = new char[28];
    public char[] c3 = new char[28];
    public char[] d3 = new char[28];
    public char[] c4 = new char[28];
    public char[] d4 = new char[28];
    public char[] c5 = new char[28];
    public char[] d5 = new char[28];
    public char[] c6 = new char[28];
    public char[] d6 = new char[28];
    public char[] c7 = new char[28];
    public char[] d7 = new char[28];
    public char[] c8 = new char[28];
    public char[] d8 = new char[28];
    public char[] c9 = new char[28];
    public char[] d9 = new char[28];
    public char[] c10 = new char[28];
    public char[] d10 = new char[28];
    public char[] c11 = new char[28];
    public char[] d11 = new char[28];
    public char[] c12 = new char[28];
    public char[] d12 = new char[28];
    public char[] c13 = new char[28];
    public char[] d13 = new char[28];
    public char[] c14 = new char[28];
    public char[] d14 = new char[28];
    public char[] c15 = new char[28];
    public char[] d15 = new char[28];
    public char[] c16 = new char[28];
    public char[] d16 = new char[28];

    public int[] nrShifts = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};

    public char[] kXORer = new char[48];

    public char[] b1 = new char[6];
    public char[] b2 = new char[6];
    public char[] b3 = new char[6];
    public char[] b4 = new char[6];
    public char[] b5 = new char[6];
    public char[] b6 = new char[6];
    public char[] b7 = new char[6];
    public char[] b8 = new char[6];


    public char[] key1 = new char[48];
    public char[] key2 = new char[48];
    public char[] key3 = new char[48];
    public char[] key4 = new char[48];
    public char[] key5 = new char[48];
    public char[] key6 = new char[48];
    public char[] key7 = new char[48];
    public char[] key8 = new char[48];
    public char[] key9 = new char[48];
    public char[] key10 = new char[48];
    public char[] key11 = new char[48];
    public char[] key12 = new char[48];
    public char[] key13 = new char[48];
    public char[] key14 = new char[48];
    public char[] key15 = new char[48];
    public char[] key16 = new char[48];

    public char[] l0 = new char[32];
    public char[] r0 = new char[32];
    public char[] l1 = new char[32];
    public char[] r1 = new char[32];
    public char[] l2 = new char[32];
    public char[] r2 = new char[32];
    public char[] l3 = new char[32];
    public char[] r3 = new char[32];
    public char[] l4 = new char[32];
    public char[] r4 = new char[32];
    public char[] l5 = new char[32];
    public char[] r5 = new char[32];
    public char[] l6 = new char[32];
    public char[] r6 = new char[32];
    public char[] l7 = new char[32];
    public char[] r7 = new char[32];
    public char[] l8 = new char[32];
    public char[] r8 = new char[32];
    public char[] l9 = new char[32];
    public char[] r9 = new char[32];
    public char[] l10 = new char[32];
    public char[] r10 = new char[32];
    public char[] l11 = new char[32];
    public char[] r11 = new char[32];
    public char[] l12 = new char[32];
    public char[] r12 = new char[32];
    public char[] l13 = new char[32];
    public char[] r13 = new char[32];
    public char[] l14 = new char[32];
    public char[] r14 = new char[32];
    public char[] l15 = new char[32];
    public char[] r15 = new char[32];
    public char[] l16 = new char[32];
    public char[] r16 = new char[32];

    public char[] r16l16;
    public char[] iPminus1 = new char[64];
    public String result = "";


    public void transferMessage(String msg, String k){
        messageTextField.setText(msg);
        keyTextField.setText(k);

        initmessage = msg;
        initkey = k;
    }

    public void Exit(){
        Platform.exit();
    }

    public void Decrypt(){
        transformToBase2();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" ----------------------------STEP I: CREATE ALL 16 SUBKEYS-----------------------------------"));
        step1();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" ------------------------STEP II: DECODE EACH 64-BIT BLOCK OF DATA-----------------------------------"));
        step2Decryption();
    }



    public void step2Decryption(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 5: We get L16 and R16 from the encrypted message."));
        getR16L16Decrypt();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 6: We divide R16L16 into L16 and R16 and get L16 and R16 from the encrypted message."));
        getL16andR16();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 7: We now proceed through 16 iterations, for 1<=n<=16, using a function f which operates on two blocks, a data block of 32 bits and a key Kn of 48 bits, to produce a block of 32 bits."));

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 7.1 : We have to find out pairs LnRn, for 1<=n<=16. Where  Ln = R(n-1)  and  Rn = L(n-1) XOR functionF(R(n-1), Key n)."));

        getAllLnRn();

        createIP();
        getMessageBeforeIP();
    }

    public void getR16L16Decrypt(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 5.1 : We have the message in binary. This counts as the message we would have gotten after the permutation IP-1. "));
        getBitEncryptedMessage();
        showIPminus1();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 5.2 : We invert the permutation IP-1, using the permutation table."));
        fillIPminus1Matrix();

        r16l16 = new char[64];

        int k = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                r16l16[matrixIPminus1[i][j] - 1] = iPminus1[k];
                k++;
            }
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 5.3 : We get R16L16."));
        showR16L16();
    }

    public void showR16L16(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(""));
        String line = " R16L16 is: ";
        for (int i = 0; i < r16l16.length; i++) {
            line = line + r16l16[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
    }

    public void fillIPminus1Matrix(){

        MatrixIPminus1 matrix = new MatrixIPminus1();
        matrix.setMatrixIPminus1();
        matrixIPminus1 = matrix.getMatrixIPminus1();
        matrixIPminus1ToString();
    }

    public void matrixIPminus1ToString(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Permutation table IP-1: "));

        for (int i = 0; i < 8; i++) {
            String line = " ";
            for (int j = 0; j < 8; j++) {
                line = line + matrixIPminus1[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void showIPminus1(){
        vBox.getChildren().add(new Label(""));
        String line = " Result after matrix IP-1: ";
        for (int i = 0; i < iPminus1.length; i++) {
            line = line + iPminus1[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
    }

    public void getBitEncryptedMessage(){

        iPminus1 = new char[64];

        int k = 0;
        for (String s: messageBase2) {
            iPminus1[k] = s.charAt(0);
            k++;
            iPminus1[k] = s.charAt(1);
            k++;
            iPminus1[k] = s.charAt(2);
            k++;
            iPminus1[k] = s.charAt(3);
            k++;
        }
    }

    public void getL16andR16(){

        divideMessageInTwo(r16, l16, r16l16);
        showLR(l16, r16, 16);
    }

    public void divideMessageInTwo(char[] c, char[] d, char[] k){
        for (int i = 0; i < 32 ; i++) {
            c[i] = k[i];
        }

        int i = 0;
        for (int j = 32; j < 64 ; j++) {
            d[i] = k[j];
            i++;
        }
    }

    public void showLR(char[] l, char[] r, int nrOfIteration){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(""));
        String line = " L" + nrOfIteration + ": ";
        for (int i = 0; i < l.length; i++) {
            line = line + l[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        line = " R" + nrOfIteration + ": ";
        for (int i = 0; i < r.length; i++) {
            line = line + r[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
    }


    public void getAllLnRn(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 16 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R15 = L16"));
        vBox.getChildren().add(new Label(" R15 is: "));
        r15 = l16;
        showKey(r15);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L15 = R16 INVERTED-XOR functionF(R15, Key16)"));
        char[] f16 = functionF(r15, key16, 16);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L15 = R16 INVERTED-XOR functionF(R15, Key16), where functionF(R15, Key16) is R after Iteration 16"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R16 is:"));
        showKey(r16);
        vBox.getChildren().add(new Label(""));

        l15 = invertedXor(r16, f16);
        vBox.getChildren().add(new Label(" -> L15 is:"));
        showKey(l15);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 15 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R14 = L15"));
        vBox.getChildren().add(new Label(" R14 is: "));
        r14 = l15;
        showKey(r14);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L14 = R15 INVERTED-XOR functionF(R14, Key15)"));
        char[] f15 = functionF(r14, key15, 15);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L14 = R15 INVERTED-XOR functionF(R14, Key15), where functionF(R14, Key15) is R after Iteration 15"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R15 is:"));
        showKey(r15);
        vBox.getChildren().add(new Label(""));

        l14 = invertedXor(r15, f15);
        vBox.getChildren().add(new Label(" -> L14 is:"));
        showKey(l14);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 14 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R13 = L14"));
        vBox.getChildren().add(new Label(" R13 is: "));
        r13 = l14;
        showKey(r13);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L13 = R14 INVERTED-XOR functionF(R13, Key14)"));
        char[] f14 = functionF(r13, key14, 14);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L13 = R14 INVERTED-XOR functionF(R13, Key14), where functionF(R13, Key14) is R after Iteration 14"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R14 is:"));
        showKey(r14);
        vBox.getChildren().add(new Label(""));

        l13 = invertedXor(r14, f14);
        vBox.getChildren().add(new Label(" -> L13 is:"));
        showKey(l13);


        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 13 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R12 = L13"));
        vBox.getChildren().add(new Label(" R12 is: "));
        r12 = l13;
        showKey(r12);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L12 = R13 INVERTED-XOR functionF(R12, Key13)"));
        char[] f13 = functionF(r12, key13, 13);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L12 = R13 INVERTED-XOR functionF(R12, Key13), where functionF(R12, Key13) is R after Iteration 13"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R13 is:"));
        showKey(r13);
        vBox.getChildren().add(new Label(""));

        l12 = invertedXor(r13, f13);
        vBox.getChildren().add(new Label(" -> L12 is:"));
        showKey(l12);


        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 12 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R11 = L12"));
        vBox.getChildren().add(new Label(" R11 is: "));
        r11 = l12;
        showKey(r11);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L11 = R12 INVERTED-XOR functionF(R11, Key12)"));
        char[] f12 = functionF(r11, key12, 12);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L11 = R12 INVERTED-XOR functionF(R11, Key12), where functionF(R11, Key12) is R after Iteration 12"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R12 is:"));
        showKey(r12);
        vBox.getChildren().add(new Label(""));

        l11 = invertedXor(r12, f12);
        vBox.getChildren().add(new Label(" -> L11 is:"));
        showKey(l11);


        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 11 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R10 = L11"));
        vBox.getChildren().add(new Label(" R10 is: "));
        r10 = l11;
        showKey(r10);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L10 = R11 INVERTED-XOR functionF(R10, Key11)"));
        char[] f11 = functionF(r10, key11, 11);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L10 = R11 INVERTED-XOR functionF(R10, Key11), where functionF(R10, Key11) is R after Iteration 11"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R11 is:"));
        showKey(r11);
        vBox.getChildren().add(new Label(""));

        l10 = invertedXor(r11, f11);
        vBox.getChildren().add(new Label(" -> L10 is:"));
        showKey(l10);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 10 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R9 = L10"));
        vBox.getChildren().add(new Label(" R9 is: "));
        r9 = l10;
        showKey(r9);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L9 = R10 INVERTED-XOR functionF(R9, Key10)"));
        char[] f10 = functionF(r9, key10, 10);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L9 = R10 INVERTED-XOR functionF(R9, Key10), where functionF(R9, Key10) is R after Iteration 10"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R10 is:"));
        showKey(r10);
        vBox.getChildren().add(new Label(""));

        l9 = invertedXor(r10, f10);
        vBox.getChildren().add(new Label(" -> L9 is:"));
        showKey(l9);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 9 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R8 = L9"));
        vBox.getChildren().add(new Label(" R8 is: "));
        r8 = l9;
        showKey(r8);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L8 = R9 INVERTED-XOR functionF(R8, Key9)"));
        char[] f9 = functionF(r8, key9, 9);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L8 = R9 INVERTED-XOR functionF(R8, Key9), where functionF(R8, Key9) is R after Iteration 9"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R9 is:"));
        showKey(r9);
        vBox.getChildren().add(new Label(""));

        l8 = invertedXor(r9, f9);
        vBox.getChildren().add(new Label(" -> L8 is:"));
        showKey(l8);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 8 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R7 = L8"));
        vBox.getChildren().add(new Label(" R7 is: "));
        r7 = l8;
        showKey(r7);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L7 = R8 INVERTED-XOR functionF(R7, Key8)"));
        char[] f8 = functionF(r7, key8, 8);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L7 = R8 INVERTED-XOR functionF(R7, Key8), where functionF(R7, Key8) is R after Iteration 8"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R8 is:"));
        showKey(r8);
        vBox.getChildren().add(new Label(""));

        l7 = invertedXor(r8, f8);
        vBox.getChildren().add(new Label(" -> L7 is:"));
        showKey(l7);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 7 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R6 = L7"));
        vBox.getChildren().add(new Label(" R6 is: "));
        r6 = l7;
        showKey(r6);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L6 = R7 INVERTED-XOR functionF(R6, Key7)"));
        char[] f7 = functionF(r6, key7, 7);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L6 = R7 INVERTED-XOR functionF(R6, Key7), where functionF(R6, Key7) is R after Iteration 7"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R7 is:"));
        showKey(r7);
        vBox.getChildren().add(new Label(""));

        l6 = invertedXor(r7, f7);
        vBox.getChildren().add(new Label(" -> L6 is:"));
        showKey(l6);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 6 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R5 = L6"));
        vBox.getChildren().add(new Label(" R5 is: "));
        r5 = l6;
        showKey(r5);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L5 = R6 INVERTED-XOR functionF(R5, Key6)"));
        char[] f6 = functionF(r5, key6, 6);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L5 = R6 INVERTED-XOR functionF(R5, Key6), where functionF(R5, Key6) is R after Iteration 6"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R6 is:"));
        showKey(r6);
        vBox.getChildren().add(new Label(""));

        l5 = invertedXor(r6, f6);
        vBox.getChildren().add(new Label(" -> L5 is:"));
        showKey(l5);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 5 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R4 = L5"));
        vBox.getChildren().add(new Label(" R4 is: "));
        r4 = l5;
        showKey(r4);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L4 = R5 INVERTED-XOR functionF(R4, Key5)"));
        char[] f5 = functionF(r4, key5, 5);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L4 = R5 INVERTED-XOR functionF(R4, Key5), where functionF(R4, Key5) is R after Iteration 5"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R5 is:"));
        showKey(r5);
        vBox.getChildren().add(new Label(""));

        l4 = invertedXor(r5, f5);
        vBox.getChildren().add(new Label(" -> L4 is:"));
        showKey(l4);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 4 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R3 = L4"));
        vBox.getChildren().add(new Label(" R3 is: "));
        r3 = l4;
        showKey(r3);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L3 = R4 INVERTED-XOR functionF(R3, Key4)"));
        char[] f4 = functionF(r3, key4, 4);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L3 = R4 INVERTED-XOR functionF(R3, Key4), where functionF(R3, Key4) is R after Iteration 4"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R4 is:"));
        showKey(r4);
        vBox.getChildren().add(new Label(""));

        l3 = invertedXor(r4, f4);
        vBox.getChildren().add(new Label(" -> L3 is:"));
        showKey(l3);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 3 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R2 = L3"));
        vBox.getChildren().add(new Label(" R2 is: "));
        r2 = l3;
        showKey(r2);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L2 = R3 INVERTED-XOR functionF(R2, Key3)"));
        char[] f3 = functionF(r2, key3, 3);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L2 = R3 INVERTED-XOR functionF(R2, Key3), where functionF(R2, Key3) is R after Iteration 3"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R3 is:"));
        showKey(r3);
        vBox.getChildren().add(new Label(""));

        l2 = invertedXor(r3, f3);
        vBox.getChildren().add(new Label(" -> L2 is:"));
        showKey(l2);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 2 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R1 = L2"));
        vBox.getChildren().add(new Label(" R1 is: "));
        r1 = l2;
        showKey(r1);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L1 = R2 INVERTED-XOR functionF(R1, Key2)"));
        char[] f2 = functionF(r1, key2, 2);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L1 = R2 INVERTED-XOR functionF(R1, Key2), where functionF(R1, Key2) is R after Iteration 2"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R2 is:"));
        showKey(r2);
        vBox.getChildren().add(new Label(""));

        l1 = invertedXor(r2, f2);
        vBox.getChildren().add(new Label(" -> L1 is:"));
        showKey(l1);


        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" INVERTED ROUND 1 "));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R0 = L1"));
        vBox.getChildren().add(new Label(" R0 is: "));
        r0 = l1;
        showKey(r0);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" L0 = R1 INVERTED-XOR functionF(R0, Key1)"));
        char[] f1 = functionF(r0, key1, 1);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Now we calculate L0 = R1 INVERTED-XOR functionF(R0, Key1), where functionF(R0, Key1) is R after Iteration 1"));
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" R1 is:"));
        showKey(r1);
        vBox.getChildren().add(new Label(""));


        l0 = invertedXor(r1, f1);
        vBox.getChildren().add(new Label(" -> L0 is:"));
        showKey(l0);

        showAllLRInverted();
    }

    public char[] functionF(char[] r, char[] key, int iterationNr) {

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Calculating function F, for iteration " + iterationNr + " : "));

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" 1.  We calculate E(R" + (iterationNr-1) +"), by applying permutation E to R" + (iterationNr-1) + ". "));
        fillMatrixE();

        char[] er = getER(r);
        vBox.getChildren().add(new Label(""));

        String line = " E(R" + (iterationNr - 1) + ") = ";
        for (int i = 0; i < er.length; i++) {
            line = line + er[i] + " ";
        }
        vBox.getChildren().add(new Label(line));


        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" 2.  We calculate subkey " + iterationNr +" XOR E(R" + (iterationNr-1) + "). "));

        line = " Key " + iterationNr + " = ";
        for (int i = 0; i < key.length; i++) {
            line = line + key[i] + " ";
        }
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        kXORer = xor(er, key);
        line = " Key" + iterationNr + " XOR E(R" + (iterationNr - 1) + ") = ";
        for (int i = 0; i < kXORer.length; i++) {
            line = line + kXORer[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" 3.  We devide Key" + iterationNr + " XOR E(R" + (iterationNr - 1) + ") into b1, b2, b3, b4, b5, b6, b7, b8, each 6-bit long."));
        fillBs();

        vBox.getChildren().add(new Label(" B1 is:"));
        showKey(b1);
        vBox.getChildren().add(new Label(" B2 is:"));
        showKey(b2);
        vBox.getChildren().add(new Label(" B3 is:"));
        showKey(b3);
        vBox.getChildren().add(new Label(" B4 is:"));
        showKey(b4);
        vBox.getChildren().add(new Label(" B5 is:"));
        showKey(b5);
        vBox.getChildren().add(new Label(" B6 is:"));
        showKey(b6);
        vBox.getChildren().add(new Label(" B7 is:"));
        showKey(b7);
        vBox.getChildren().add(new Label(" B8 is:"));
        showKey(b8);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" 4.  For each bn, where 1<=n<=8, we get the number from table S-Box n, where 1<=n<=8, on the row indicated by the number built from the first and last digit of bn, on the column built from the 4 middle bits from bn."));

        fillSBoxes();
        findSBoxResult();
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" 4.2. We transform each Sn(Bn), where 1<=n<=8, into hexadecimal."));
        line = " S1(B1)S2(B2)S3(B3)S4(B4)S5(B5)S6(B6)S7(B7)S8(B8) for Iteration " + iterationNr + " = " + sBox;
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" After S-Boxes Operation, we get: "));
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" 5. Convert S1(B1)S2(B2)S3(B3)S4(B4)S5(B5)S6(B6)S7(B7)S8(B8) into binary."));
        transformSBoxResultToBase2();


        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" 6. The final stage in the calculation of f is to do a permutation P of the S-box output to obtain the final value of f:\n" + "f = P(S1(B1)S2(B2)S3(B3)S4(B4)S5(B5)S6(B6)S7(B7)S8(B8))"));
        fillMatrixP();

        char[] resultCharArray = getResultAfterMatrixP();

        vBox.getChildren().add(new Label(""));
        line = " R after Iteration " + iterationNr + " = ";
        for (int i = 0; i < resultCharArray.length; i++) {
            line = line + resultCharArray[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));
        return resultCharArray;
    }


    public char[] invertedXor(char[] op1, char[] op2){
        char[] result = new char[32];

        for (int i = 0; i < 32; i++) {

            if (op1[i] == '1' && op2[i] == '0'){
                result[i] = '1';
            }else if (op1[i] == '1' && op2[i] == '1'){
                result[i] = '0';
            }else if (op1[i] == '0' && op2[i] == '0'){
                result[i] = '0';
            }else if (op1[i] == '0' && op2[i] == '1'){
                result[i] = '1';
            }
        }

        return result;
    }

    public void showAllLRInverted(){

        showLR(l16, r16, 16);
        showLR(l15, r15, 15);
        showLR(l14, r14, 14);
        showLR(l13, r13, 13);
        showLR(l12, r12, 12);
        showLR(l11, r11, 11);
        showLR(l10, r10, 10);
        showLR(l9, r9, 9);
        showLR(l8, r8, 8);
        showLR(l7, r7, 7);
        showLR(l6, r6, 6);
        showLR(l5, r5, 5);
        showLR(l4, r4, 4);
        showLR(l3, r3, 3);
        showLR(l2, r2, 2);
        showLR(l1, r1, 1);
        showLR(l0, r0, 0);

    }

    public void createIP(){

        messageAfterIP = new char[64];

        int k = 0;
        for (int i = 0; i < l0.length; i++) {
            messageAfterIP[k] = l0[i];
            k++;
        }
        for (int i = 0; i < r0.length; i++) {
            messageAfterIP[k] = r0[i];
            k++;
        }

        showMessageAfterIP();
    }

    public void getMessageBeforeIP(){

        fillIPMatrix();

        char[] tempArray = new char[64];

        int k = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tempArray[matrixIP[i][j] - 1] = messageAfterIP[k];
                k++;
            }
        }


        vBox.getChildren().add(new Label(""));
        String line = " Message in binary before initital permutation: ";
        for (int i = 0; i < tempArray.length; i++) {
            line = line + tempArray[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Finally, we transform the message into hexadecimal."));
        vBox.getChildren().add(new Label(""));
        writeMessageToHexa(tempArray);
    }

    public void writeMessageToHexa(char[] chars){

        result = "";
        String[] strings = new String[16];

        int k=0;
        for (int i = 0; i < chars.length; i=i+4) {
            strings[k] = String.valueOf(chars[i]) + String.valueOf(chars[i+1]) + String.valueOf(chars[i+2]) + String.valueOf(chars[i+3]);
            k++;
        }

        for (String s: strings) {
            for (int i = 0; i < 16; i++) {
                if (s.equals(base2CorrespondantsMatrix[i][0])){
                    result = result + base2CorrespondantsMatrix[i][1];
                }
            }
        }

        printDecryptedMessage();
    }

    public void printDecryptedMessage(){
        vBox.getChildren().add(new Label(""));
        String line = " The decrypted message is: " + result;
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));
        resultTextField.setText(result);
    }

    public void fillMatrixE(){
        MatrixE matrix = new MatrixE();
        matrix.setMatrixE();
        matrixE = matrix.getMatrixE();
        matrixEToString();
    }

    public void matrixEToString(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Bit-Selection table E: "));

        for (int i = 0; i < 7; i++) {
            String line = " ";
            for (int j = 0; j < 6; j++) {
                line = line + matrixE[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }

    }

    public char[] getER(char[] r){
        char[] er = new char[48];

        int k = 0;
        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 6 ; j++) {
                er[k] = r[matrixE[i][j]-1];
                k++;
            }
        }
        return er;
    }

    public char[] xor(char[] er, char[] k){
        char[] result = new char[100];

        for (int i = 0; i < er.length; i++) {
            if (er[i]=='0' && k[i] == '0'){
                result[i] = '0';
            }
            if (er[i]=='1' && k[i]=='1'){
                result[i] = '0';
            }
            if (er[i]=='1' && k[i]=='0'){
                result[i] = '1';
            }
            if (er[i]=='0' && k[i]=='1'){
                result[i] = '1';
            }
        }

        return result;
    }

    public void fillBs(){

        b1[0] = kXORer[0];
        b1[1] = kXORer[1];
        b1[2] = kXORer[2];
        b1[3] = kXORer[3];
        b1[4] = kXORer[4];
        b1[5] = kXORer[5];

        b2[0] = kXORer[6];
        b2[1] = kXORer[7];
        b2[2] = kXORer[8];
        b2[3] = kXORer[9];
        b2[4] = kXORer[10];
        b2[5] = kXORer[11];

        b3[0] = kXORer[12];
        b3[1] = kXORer[13];
        b3[2] = kXORer[14];
        b3[3] = kXORer[15];
        b3[4] = kXORer[16];
        b3[5] = kXORer[17];

        b4[0] = kXORer[18];
        b4[1] = kXORer[19];
        b4[2] = kXORer[20];
        b4[3] = kXORer[21];
        b4[4] = kXORer[22];
        b4[5] = kXORer[23];

        b5[0] = kXORer[24];
        b5[1] = kXORer[25];
        b5[2] = kXORer[26];
        b5[3] = kXORer[27];
        b5[4] = kXORer[28];
        b5[5] = kXORer[29];

        b6[0] = kXORer[30];
        b6[1] = kXORer[31];
        b6[2] = kXORer[32];
        b6[3] = kXORer[33];
        b6[4] = kXORer[34];
        b6[5] = kXORer[35];

        b7[0] = kXORer[36];
        b7[1] = kXORer[37];
        b7[2] = kXORer[38];
        b7[3] = kXORer[39];
        b7[4] = kXORer[40];
        b7[5] = kXORer[41];

        b8[0] = kXORer[42];
        b8[1] = kXORer[43];
        b8[2] = kXORer[44];
        b8[3] = kXORer[45];
        b8[4] = kXORer[46];
        b8[5] = kXORer[47];
    }

    public void fillSBoxes(){
        SBoxes sBoxes = new SBoxes();
        sBoxes.setAllSBoxes();

        sBox1 = sBoxes.getsBox1();
        sBox2 = sBoxes.getsBox2();
        sBox3 = sBoxes.getsBox3();
        sBox4 = sBoxes.getsBox4();
        sBox5 = sBoxes.getsBox5();
        sBox6 = sBoxes.getsBox6();
        sBox7 = sBoxes.getsBox7();
        sBox8 = sBoxes.getsBox8();

        allSBoxesToString();
    }

    public void findSBoxResult(){
        sBox = "";

        int[] sb = getAllSnBn();

        for (int i = 0; i < 8; i++) {

            if (sb[i] == 0){
                sBox = sBox + "0";
            }else if (sb[i] == 1){
                sBox = sBox + "1";
            }else if (sb[i] == 2){
                sBox = sBox + "2";
            }else if (sb[i] == 3){
                sBox = sBox + "3";
            }else if (sb[i] == 4){
                sBox = sBox + "4";
            }else if (sb[i] == 5){
                sBox = sBox + "5";
            }else if (sb[i] == 6){
                sBox = sBox + "6";
            }else if (sb[i] == 7){
                sBox = sBox + "7";
            }else if (sb[i] == 8){
                sBox = sBox + "8";
            }else if (sb[i] == 9){
                sBox = sBox + "9";
            }else if (sb[i] == 10){
                sBox = sBox + "A";
            }else if (sb[i] == 11){
                sBox = sBox + "B";
            }else if (sb[i] == 12){
                sBox = sBox + "C";
            }else if (sb[i] == 13){
                sBox = sBox + "D";
            }else if (sb[i] == 14){
                sBox = sBox + "E";
            }else if (sb[i] == 15){
                sBox = sBox + "F";
            }
        }
    }

    public int[] getAllSnBn(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" 4.1. Replace each bn with it's correspondent in the S-Box n table, where 1<=n<=8."));

        int rowb1 = findRow(b1);
        int columnb1 = findColumn(b1);

        if (findRow(b1) == -1){
            System.out.println("The coresponding row for S1 wasn't found!");
        }

        if (findColumn(b1) == -1){
            System.out.println("The coresponding column for S1 wasn't found!");
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" For b1 we find in S-Box1, on row " + rowb1 + " and on column " + columnb1 + " value: " + sBox1[rowb1][columnb1]));
        int sb1 = sBox1[rowb1][columnb1];

        int rowb2 = findRow(b2);
        int columnb2 = findColumn(b2);

        if (findRow(b2) == -1){
            System.out.println("The coresponding row for S2 wasn't found!");
        }

        if (findColumn(b2) == -1){
            System.out.println("The coresponding column for S2 wasn't found!");
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" For b2 we find in S-Box2, on row " + rowb2 + " and on column " + columnb2 + " value: " + sBox2[rowb2][columnb2]));
        int sb2 = sBox2[rowb2][columnb2];

        int rowb3 = findRow(b3);
        int columnb3 = findColumn(b3);

        if (findRow(b3) == -1){
            System.out.println("The coresponding row for S3 wasn't found!");
        }

        if (findColumn(b3) == -1){
            System.out.println("The coresponding column for S3 wasn't found!");
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" For b3 we find in S-Box3, on row " + rowb3 + " and on column " + columnb3 + " value: " + sBox3[rowb3][columnb3]));
        int sb3 = sBox3[rowb3][columnb3];

        int rowb4 = findRow(b4);
        int columnb4 = findColumn(b4);

        if (findRow(b4) == -1){
            System.out.println("The coresponding row for S4 wasn't found!");
        }

        if (findColumn(b4) == -1){
            System.out.println("The coresponding column for S4 wasn't found!");
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" For b4 we find in S-Box4, on row " + rowb4 + " and on column " + columnb4 + " value: " + sBox4[rowb4][columnb4]));
        int sb4 = sBox4[rowb4][columnb4];

        int rowb5 = findRow(b5);
        int columnb5 = findColumn(b5);

        if (findRow(b5) == -1){
            System.out.println("The coresponding row for S5 wasn't found!");
        }

        if (findColumn(b5) == -1){
            System.out.println("The coresponding column for S5 wasn't found!");
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" For b5 we find in S-Box5, on row " + rowb5 + " and on column " + columnb5 + " value: " + sBox5[rowb5][columnb5]));
        int sb5 = sBox5[rowb5][columnb5];

        int rowb6 = findRow(b6);
        int columnb6 = findColumn(b6);

        if (findRow(b6) == -1){
            System.out.println("The coresponding row for S6 wasn't found!");
        }

        if (findColumn(b6) == -1){
            System.out.println("The coresponding column for S6 wasn't found!");
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" For b6 we find in S-Box6, on row " + rowb6 + " and on column " + columnb6 + " value: " + sBox6[rowb6][columnb6]));
        int sb6 = sBox6[rowb6][columnb6];

        int rowb7 = findRow(b7);
        int columnb7 = findColumn(b7);

        if (findRow(b7) == -1){
            System.out.println("The coresponding row for S7 wasn't found!");
        }

        if (findColumn(b7) == -1){
            System.out.println("The coresponding column for S7 wasn't found!");
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" For b7 we find in S-Box7, on row " + rowb7 + " and on column " + columnb7 + " value: " + sBox7[rowb7][columnb7]));
        int sb7 = sBox7[rowb7][columnb7];

        int rowb8 = findRow(b8);
        int columnb8 = findColumn(b8);

        if (findRow(b8) == -1){
            System.out.println("The coresponding row for S8 wasn't found!");
        }

        if (findColumn(b8) == -1){
            System.out.println("The coresponding column for S8 wasn't found!");
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" For b8 we find in S-Box1, on row " + rowb8 + " and on column " + columnb8 + " value: " + sBox8[rowb8][columnb8]));
        int sb8 = sBox8[rowb8][columnb8];

        int[] sb = new int[8];
        sb[0] = sb1;
        sb[1] = sb2;
        sb[2] = sb3;
        sb[3] = sb4;
        sb[4] = sb5;
        sb[5] = sb6;
        sb[6] = sb7;
        sb[7] = sb8;

        return sb;
    }

    public int findColumn(char[] c){

        String s = String.valueOf(c[1]) + String.valueOf(c[2]) + String.valueOf(c[3]) + String.valueOf(c[4]);

        if (s.equals("0000")){
            return 0;
        }else if (s.equals("0001")){
            return 1;
        }else if (s.equals("0010")){
            return 2;
        }else if (s.equals("0011")){
            return 3;
        }else if (s.equals("0100")){
            return 4;
        }else if (s.equals("0101")){
            return 5;
        }else if (s.equals("0110")){
            return 6;
        }else if (s.equals("0111")){
            return 7;
        }else if (s.equals("1000")){
            return 8;
        }else if (s.equals("1001")){
            return 9;
        }else if (s.equals("1010")){
            return 10;
        }else if (s.equals("1011")){
            return 11;
        }else if (s.equals("1100")){
            return 12;
        }else if (s.equals("1101")){
            return 13;
        }else if (s.equals("1110")){
            return 14;
        }else if (s.equals("1111")) {
            return 15;
        }

        return -1;
    }

    public int findRow(char[] c) {

        if (c[0] == '0' && c[5] == '0') {
            return 0;
        } else if (c[0] == '0' && c[5] == '1') {
            return 1;
        } else if (c[0] == '1' && c[5] == '0') {
            return 2;
        } else if (c[0] == '1' && c[5] == '1') {
            return 3;
        }

        return -1;
    }

    public void transformSBoxResultToBase2() {

        fillBase2CorrespondantsMatrix();


        String sBoxRes = "";
        for (char c : sBox.toCharArray()) {

            for (int j = 0; j < 16; j++) {
                if (String.valueOf(c).equals(base2CorrespondantsMatrix[j][1])) {
                    sBoxRes = sBoxRes + base2CorrespondantsMatrix[j][0];
                }
            }

        }

        sBoxResultBase2 = sBoxRes.toCharArray();
        showSBoxResultBase2();
    }

    public void showSBoxResultBase2(){

        String line = " S1(B1)S2(B2)S3(B3)S4(B4)S5(B5)S6(B6)S7(B7)S8(B8) in base 2 = " ;
        for (int i = 0; i < sBoxResultBase2.length ; i++) {
            line = line + sBoxResultBase2[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
    }

    public void fillMatrixP(){
        MatrixP matrix = new MatrixP();
        matrix.setMatrixP();
        matrixP = matrix.getMatrixP();
        matrixPToString();
    }

    public void matrixPToString(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Permutation table P: "));

        for (int i = 0; i < 8; i++) {
            String line = " ";
            for (int j = 0; j < 4; j++) {
                line = line + matrixP[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public char[] getResultAfterMatrixP(){

        char[] result = new char[32];

        int k = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                result[k] = sBoxResultBase2[matrixP[i][j]-1];
                k++;
            }
        }

        return result;
    }

    public void fillIPMatrix(){

        MatrixIP matrix = new MatrixIP();
        matrix.setMatrixIP();
        matrixIP = matrix.getMatrixIP();
        matrixIPToString();
    }

    public void matrixIPToString(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Permutation table IP (initial permutation): "));
        for (int i = 0; i < 8 ; i++) {
            String line = " ";
            for (int j = 0; j < 8 ; j++) {
                line = line + matrixIP[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }

    }

    public void showMessageAfterIP(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" We obtain the message after the initial permutation."));
        vBox.getChildren().add(new Label(""));

        String line = " IP message is: ";
        for (int i = 0; i < messageAfterIP.length; i++) {
            line = line + messageAfterIP[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
    }

    public void allSBoxesToString(){
        sBox1ToString();
        sBox2ToString();
        sBox3ToString();
        sBox4ToString();
        sBox5ToString();
        sBox6ToString();
        sBox7ToString();
        sBox8ToString();
    }

    public void sBox1ToString(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" S-Box1: "));

        for (int i = 0; i < 4 ; i++) {
            String line = " ";
            for (int j = 0; j < 16; j++) {
                line = line + sBox1[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void sBox2ToString(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" S-Box2: "));

        for (int i = 0; i < 4 ; i++) {
            String line = " ";
            for (int j = 0; j < 16; j++) {
                line = line + sBox2[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void sBox3ToString(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" S-Box3: "));
        for (int i = 0; i < 4 ; i++) {
            String line = " ";
            for (int j = 0; j < 16; j++) {
                line = line + sBox3[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void sBox4ToString(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" S-Box4: "));
        for (int i = 0; i < 4 ; i++) {
            String line = " ";
            for (int j = 0; j < 16; j++) {
                line = line + sBox4[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void sBox5ToString(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" S-Box5: "));
        for (int i = 0; i < 4 ; i++) {
            String line = " ";
            for (int j = 0; j < 16; j++) {
                line = line + sBox5[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void sBox6ToString(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" S-Box6: "));
        for (int i = 0; i < 4 ; i++) {
            String line = " ";
            for (int j = 0; j < 16; j++) {
                line = line + sBox6[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void sBox7ToString(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" S-Box7: "));
        for (int i = 0; i < 4 ; i++) {
            String line = " ";
            for (int j = 0; j < 16; j++) {
                line = line + sBox7[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void sBox8ToString(){

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" S-Box8: "));
        for (int i = 0; i < 4 ; i++) {
            String line = " ";
            for (int j = 0; j < 16; j++) {
                line = line + sBox8[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }









    public void step1() {
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step1: The key is permuted according to the following table, PC-1. Since the first entry in the table is '57', this means that the 57th bit of the original key becomes the first bit of the permuted key K+. The 49th bit of the original key becomes the second bit of the permuted key and so on."));
        fillMatrixPC1();

        fillBitKey();

        createKeyAfterPC1();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step2: Next, split this key into left and right halves, C0 and D0, where each half has 28 bits."));
        createC0andD0();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step3: We now create sixteen blocks Cn and Dn, 1<=n<=16. Each pair of blocks Cn and Dn is formed from the previous pair Cn-1 and Dn-1, using the following schedule of 'left shifts' of the previous block. To do a left shift, move each bit one place to the left, except for the first bit, which is cycled to the end of the block."));
        showNrShifts();
        createAllCnDn();

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step4: We now form the keys Kn, for 1<=n<=16, by applying the following permutation table to each of the concatenated pairs CnDn. Each pair has 56 bits, but PC-2 only uses 48 of these. Therefore, the first bit of Kn is the 14th bit of CnDn, the second bit the 17th, and so on."));
        createAllKeyN();
        showAllKeys();
        vBox.getChildren().add(new Label(""));

    }

    public void createAllKeyN(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 4.1: First we must concatenate the CnDn pairs, for 1<=n<=16."));

        char[] cd1 = createCD(c1, d1);
        char[] cd2 = createCD(c2, d2);
        char[] cd3 = createCD(c3, d3);
        char[] cd4 = createCD(c4, d4);
        char[] cd5 = createCD(c5, d5);
        char[] cd6 = createCD(c6, d6);
        char[] cd7 = createCD(c7, d7);
        char[] cd8 = createCD(c8, d8);
        char[] cd9 = createCD(c9, d9);
        char[] cd10 = createCD(c10, d10);
        char[] cd11 = createCD(c11, d11);
        char[] cd12 = createCD(c12, d12);
        char[] cd13 = createCD(c13, d13);
        char[] cd14 = createCD(c14, d14);
        char[] cd15 = createCD(c15, d15);
        char[] cd16 = createCD(c16, d16);

        showAllConcatenatedCnDn(cd1, cd2, cd3, cd4, cd5, cd6, cd7, cd8, cd9, cd10, cd11, cd12, cd13, cd14, cd15, cd16);


        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 4.2: Now we apply the following permutation to each pair."));
        fillPC2();

        int k = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6 ; j++) {

                key1[k] = cd1[matrixPC2[i][j] - 1];
                key2[k] = cd2[matrixPC2[i][j] - 1];
                key3[k] = cd3[matrixPC2[i][j] - 1];
                key4[k] = cd4[matrixPC2[i][j] - 1];
                key5[k] = cd5[matrixPC2[i][j] - 1];
                key6[k] = cd6[matrixPC2[i][j] - 1];
                key7[k] = cd7[matrixPC2[i][j] - 1];
                key8[k] = cd8[matrixPC2[i][j] - 1];
                key9[k] = cd9[matrixPC2[i][j] - 1];
                key10[k] = cd10[matrixPC2[i][j] - 1];
                key11[k] = cd11[matrixPC2[i][j] - 1];
                key12[k] = cd12[matrixPC2[i][j] - 1];
                key13[k] = cd13[matrixPC2[i][j] - 1];
                key14[k] = cd14[matrixPC2[i][j] - 1];
                key15[k] = cd15[matrixPC2[i][j] - 1];
                key16[k] = cd16[matrixPC2[i][j] - 1];
                k++;
            }
        }

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Step 4.3: After applying the permutation table PC-2 to each pair, we get the following 16 subkeys:"));
        vBox.getChildren().add(new Label(""));
    }

    public void showAllKeys(){
        vBox.getChildren().add(new Label(" Key 1: ")); showKey(key1);
        vBox.getChildren().add(new Label(" Key 2: ")); showKey(key2);
        vBox.getChildren().add(new Label(" Key 3: ")); showKey(key3);
        vBox.getChildren().add(new Label(" Key 4: ")); showKey(key4);
        vBox.getChildren().add(new Label(" Key 5: ")); showKey(key5);
        vBox.getChildren().add(new Label(" Key 6: ")); showKey(key6);
        vBox.getChildren().add(new Label(" Key 7: ")); showKey(key7);
        vBox.getChildren().add(new Label(" Key 8: ")); showKey(key8);
        vBox.getChildren().add(new Label(" Key 9: ")); showKey(key9);
        vBox.getChildren().add(new Label(" Key 10: ")); showKey(key10);
        vBox.getChildren().add(new Label(" Key 11: ")); showKey(key11);
        vBox.getChildren().add(new Label(" Key 12: ")); showKey(key12);
        vBox.getChildren().add(new Label(" Key 13: ")); showKey(key13);
        vBox.getChildren().add(new Label(" Key 14: ")); showKey(key14);
        vBox.getChildren().add(new Label(" Key 15: ")); showKey(key15);
        vBox.getChildren().add(new Label(" Key 16: ")); showKey(key16);
    }

    public void showKey(char[] k){
        String line = " ";
        for (int i = 0; i < k.length ; i++) {
            line = line + k[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
    }

    public char[] createCD(char[] ch1, char[] ch2){
        char[] chRes = new char[56];
        int k = 0;
        for (int i = 0; i < 28 ; i++) {
            chRes[k] = ch1[i];
            k++;
        }
        for (int i = 0; i < 28 ; i++) {
            chRes[k] = ch2[i];
            k++;
        }
        return chRes;
    }

    public void showConcatenatedCnDn(char[] k){
        String line = " ";
        for (int i = 0; i < k.length ; i++) {
            line = line + k[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
    }

    public void showAllConcatenatedCnDn(char[] k1, char[] k2, char[] k3, char[] k4, char[] k5, char[] k6, char[] k7, char[] k8, char[] k9, char[] k10, char[] k11, char[] k12, char[] k13, char[] k14, char[] k15, char[] k16){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C1D1 is: "));
        showConcatenatedCnDn(k1);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C2D2 is: "));
        showConcatenatedCnDn(k2);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C3D3 is: "));
        showConcatenatedCnDn(k3);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C4D4 is: "));
        showConcatenatedCnDn(k4);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C5D5 is: "));
        showConcatenatedCnDn(k5);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C6D6 is: "));
        showConcatenatedCnDn(k6);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C7D7 is: "));
        showConcatenatedCnDn(k7);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C8D8 is: "));
        showConcatenatedCnDn(k8);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C9D9 is: "));
        showConcatenatedCnDn(k9);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C10D10 is: "));
        showConcatenatedCnDn(k10);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C11D11 is: "));
        showConcatenatedCnDn(k11);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C12D12 is: "));
        showConcatenatedCnDn(k12);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C13D13 is: "));
        showConcatenatedCnDn(k13);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C14D14 is: "));
        showConcatenatedCnDn(k14);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C15D15 is: "));
        showConcatenatedCnDn(k15);

        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Concatenated pair C16D16 is: "));
        showConcatenatedCnDn(k16);
    }



    public void createAllCnDn(){

        shiftBits(c0, c1, 1);
        shiftBits(d0, d1, 1);

        shiftBits(c1, c2, 2);
        shiftBits(d1, d2, 2);

        shiftBits(c2, c3, 3);
        shiftBits(d2, d3, 3);

        shiftBits(c3, c4, 4);
        shiftBits(d3, d4, 4);

        shiftBits(c4, c5, 5);
        shiftBits(d4, d5, 5);

        shiftBits(c5, c6, 6);
        shiftBits(d5, d6, 6);

        shiftBits(c6, c7, 7);
        shiftBits(d6, d7, 7);

        shiftBits(c7, c8, 8);
        shiftBits(d7, d8, 8);

        shiftBits(c8, c9, 9);
        shiftBits(d8, d9, 9);

        shiftBits(c9, c10, 10);
        shiftBits(d9, d10, 10);

        shiftBits(c10, c11, 11);
        shiftBits(d10, d11, 11);

        shiftBits(c11, c12, 12);
        shiftBits(d11, d12, 12);

        shiftBits(c12, c13, 13);
        shiftBits(d12, d13, 13);

        shiftBits(c13, c14, 14);
        shiftBits(d13, d14, 14);

        shiftBits(c14, c15, 15);
        shiftBits(d14, d15, 15);

        shiftBits(c15, c16, 16);
        shiftBits(d15, d16, 16);

        showAllCnDn();
    }

    public void shiftBits(char[] init, char[] result, int nrOfIteration ){

        char[] charArray = new char[init.length];
        for (int i = 0; i < init.length ; i++) {
            charArray[i] = init[i];
        }

        int x = nrShifts[nrOfIteration - 1];
        if(x == 1){

            char aux = charArray[0];

            for (int j = 0; j < charArray.length - 1 ; j++) {
                charArray[j] = charArray[j+1];
            }

            charArray[charArray.length - 1] = aux;

        }else if (x == 2){

            char aux = charArray[0];

            for (int j = 0; j < charArray.length - 1 ; j++) {
                charArray[j] = charArray[j+1];
            }

            charArray[charArray.length - 1] = aux;

            aux = charArray[0];

            for (int j = 0; j < charArray.length - 1 ; j++) {
                charArray[j] = charArray[j+1];
            }

            charArray[charArray.length - 1] = aux;
        }

        for (int i = 0; i < charArray.length ; i++) {
            result[i] = charArray[i];
        }

    }

    public void showAllCnDn(){
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C1 is C0 shifted " + nrShifts[0] + " to the left."));
        String line = " C1: ";
        for (int i = 0; i < c1.length; i++) {
            line = line + c1[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D1 is D0 shifted " + nrShifts[0] + " to the left."));
        line = " D1: ";
        for (int i = 0; i < d1.length; i++) {
            line = line + d1[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C2 is C1 shifted " + nrShifts[1] + " to the left."));
        line = " C2: ";
        for (int i = 0; i < c2.length; i++) {
            line = line + c2[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D2 is D1 shifted " + nrShifts[0] + " to the left."));
        line = " D2: ";
        for (int i = 0; i < d2.length; i++) {
            line = line + d2[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C3 is C2 shifted " + nrShifts[2] + " to the left."));
        line = " C3: ";
        for (int i = 0; i < c3.length; i++) {
            line = line + c3[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D3 is D2 shifted " + nrShifts[2] + " to the left."));
        line = " D3: ";
        for (int i = 0; i < d3.length; i++) {
            line = line + d3[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C4 is C3 shifted " + nrShifts[3] + " to the left."));
        line = " C4: ";
        for (int i = 0; i < c4.length; i++) {
            line = line + c4[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D4 is D3 shifted " + nrShifts[3] + " to the left."));
        line = " D4: ";
        for (int i = 0; i < d4.length; i++) {
            line = line + d4[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C5 is C4 shifted " + nrShifts[4] + " to the left."));
        line = " C5: ";
        for (int i = 0; i < c5.length; i++) {
            line = line + c5[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D5 is D4 shifted " + nrShifts[4] + " to the left."));
        line = " D5: ";
        for (int i = 0; i < d5.length; i++) {
            line = line + d5[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C6 is C5 shifted " + nrShifts[5] + " to the left."));
        line = " C6: ";
        for (int i = 0; i < c6.length; i++) {
            line = line + c6[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D6 is D5 shifted " + nrShifts[5] + " to the left."));
        line = " D6: ";
        for (int i = 0; i < d6.length; i++) {
            line = line + d6[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C7 is C6 shifted " + nrShifts[6] + " to the left."));
        line = " C7: ";
        for (int i = 0; i < c7.length; i++) {
            line = line + c7[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D7 is D6 shifted " + nrShifts[6] + " to the left."));
        line = " D7: ";
        for (int i = 0; i < d7.length; i++) {
            line = line + d7[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C8 is C7 shifted " + nrShifts[7] + " to the left."));
        line = " C8: ";
        for (int i = 0; i < c8.length; i++) {
            line = line + c8[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D8 is D7 shifted " + nrShifts[7] + " to the left."));
        line = " D8: ";
        for (int i = 0; i < d8.length; i++) {
            line = line + d8[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C9 is C8 shifted " + nrShifts[8] + " to the left."));
        line = " C9: ";
        for (int i = 0; i < c9.length; i++) {
            line = line + c9[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D9 is D8 shifted " + nrShifts[8] + " to the left."));
        line = " D9: ";
        for (int i = 0; i < d9.length; i++) {
            line = line + d9[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C10 is C9 shifted " + nrShifts[9] + " to the left."));
        line = " C10: ";
        for (int i = 0; i < c10.length; i++) {
            line = line + c10[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D10 is D9 shifted " + nrShifts[9] + " to the left."));
        line = " D10: ";
        for (int i = 0; i < d10.length; i++) {
            line = line + d10[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C11 is C10 shifted " + nrShifts[10] + " to the left."));
        line = " C11: ";
        for (int i = 0; i < c11.length; i++) {
            line = line + c11[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D11 is D10 shifted " + nrShifts[10] + " to the left."));
        line = " D11: ";
        for (int i = 0; i < d11.length; i++) {
            line = line + d11[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C12 is C11 shifted " + nrShifts[11] + " to the left."));
        line = " C12: ";
        for (int i = 0; i < c12.length; i++) {
            line = line + c12[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D12 is D11 shifted " + nrShifts[11] + " to the left."));
        line = " D12: ";
        for (int i = 0; i < d12.length; i++) {
            line = line + d12[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C13 is C12 shifted " + nrShifts[12] + " to the left."));
        line = " C13: ";
        for (int i = 0; i < c13.length; i++) {
            line = line + c13[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D13 is D12 shifted " + nrShifts[12] + " to the left."));
        line = " D13: ";
        for (int i = 0; i < d13.length; i++) {
            line = line + d13[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C14 is C13 shifted " + nrShifts[13] + " to the left."));
        line = " C14: ";
        for (int i = 0; i < c14.length; i++) {
            line = line + c14[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D14 is D13 shifted " + nrShifts[13] + " to the left."));
        line = " D14: ";
        for (int i = 0; i < d14.length; i++) {
            line = line + d14[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C15 is C14 shifted " + nrShifts[14] + " to the left."));
        line = " C15: ";
        for (int i = 0; i < c15.length; i++) {
            line = line + c15[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D15 is D14 shifted " + nrShifts[14] + " to the left."));
        line = " D15: ";
        for (int i = 0; i < d15.length; i++) {
            line = line + d15[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));

        vBox.getChildren().add(new Label(" C16 is C15 shifted " + nrShifts[15] + " to the left."));
        line = " C16: ";
        for (int i = 0; i < c16.length; i++) {
            line = line + c16[i] + " ";
        }
        vBox.getChildren().add(new Label(line));

        vBox.getChildren().add(new Label(" D16 is D15 shifted " + nrShifts[15] + " to the left."));
        line = " D16: ";
        for (int i = 0; i < d16.length; i++) {
            line = line + d16[i] + " ";
        }
        vBox.getChildren().add(new Label(line));
        vBox.getChildren().add(new Label(""));
    }

    public void showNrShifts(){

        vBox.getChildren().add(new Label(""));
        for (int i = 0; i < 16; i++) {
            vBox.getChildren().add(new Label(" For iteration " + (i+1) + " the number of left shifts is: " + nrShifts[i]));
        }
    }

    public void createC0andD0(){
        divideKeyInTwo(c0, d0, keyAfterPC1);
        vBox.getChildren().add(new Label(""));

        String line = "";
        for (int i = 0; i < c0.length ; i++) {
            line = line + c0[i] + " ";
        }
        vBox.getChildren().add(new Label(" C0 = " + line));

        line = "";
        for (int i = 0; i < d0.length ; i++) {
            line = line + d0[i] + " ";
        }
        vBox.getChildren().add(new Label(" D0 = " + line));
    }


    public void divideKeyInTwo(char[] c, char[] d, char[] k){
        for (int i = 0; i < 28 ; i++) {
            c[i] = k[i];
        }

        int i = 0;
        for (int j = 28; j < 56 ; j++) {
            d[i] = k[j];
            i++;
        }
    }


    public void createKeyAfterPC1(){
        int k = 0;

        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 7; j++) {
                keyAfterPC1[k] = bitkey[matrixPC1[i][j] - 1];
                k++;
            }
        }

        showKeyAfterPC1();
    }

    public void showKeyAfterPC1(){
        String line = "";
        for (int i = 0; i < keyAfterPC1.length ; i++) {
            line = line + keyAfterPC1[i] + " ";
        }
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" K+ resulted after PC-1 Matrix is: " + line));
    }

    public void fillBitKey(){

        int i = 0;
        for (String s: keyBase2) {

            for (char c: s.toCharArray()) {
                bitkey[i] = c;
                i++;
            }
        }
        showBitKey();
    }

    public void showBitKey(){
        vBox.getChildren().add(new Label(""));
        String line = "";
        for (int i = 0; i < bitkey.length ; i++) {
            line = line + bitkey[i] + " ";
        }
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Key in binary is: " + line));
    }

    public void fillMatrixPC1(){
        MatrixPC1 matrix = new MatrixPC1();
        matrix.setMatrixPC1();
        matrixPC1 = matrix.getMatrixPC1();
        matrixPC1ToString();
    }

    public void matrixPC1ToString(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Permutation table PC-1: "));

        for (int i = 0; i < 8 ; i++) {
            String line = " ";
            for (int j = 0; j < 7; j++) {
                line = line + matrixPC1[i][j] + "  ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }

    public void fillPC2(){
        MatrixPC2 matrix = new MatrixPC2();
        matrix.setMatrixPC2();
        matrixPC2 = matrix.getMatrixPC2();
        matrixPC2ToString();
    }

    public void matrixPC2ToString(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Permutation table PC-2: "));
        for (int i = 0; i < 8; i++) {
            String line = " ";
            for (int j = 0; j < 6; j++) {
                line = line + matrixPC2[i][j] + " ";
            }
            vBox.getChildren().add(new Label(line));
        }
    }


    public void transformToBase2(){
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label(" Frist we need to convert both the message and the key into base 2."));
        vBox.getChildren().add(new Label(""));

        fillBase2CorrespondantsMatrix();

        for (int i = 0; i < 16 ; i++) {

            for (int j = 0; j < 16 ; j++) {
                if (String.valueOf(initmessage.charAt(i)).equals(base2CorrespondantsMatrix[j][1])){
                    messageBase2[i] = base2CorrespondantsMatrix[j][0];
                }

                if (String.valueOf(initkey.charAt(i)).equals(base2CorrespondantsMatrix[j][1])){
                    keyBase2[i] = base2CorrespondantsMatrix[j][0];
                }
            }

        }

        showMessageBase2();
        showKeyBase2();
    }

    public void showMessageBase2(){
        String line = " ";
        for (String s: messageBase2) {
            line = line + s + " ";
        }
        vBox.getChildren().add(new Label(" Message in base2 is:  " + line));

    }

    public void showKeyBase2(){
        String line = " ";
        for (String s: keyBase2) {
            line = line + s + " ";
        }
        vBox.getChildren().add(new Label(" Key in base2 is:  " + line));

    }

    public void fillBase2CorrespondantsMatrix(){

        Base2Matrix base2Matrix = new Base2Matrix();
        base2Matrix.setBase2CorrespondantsMatrix();
        base2CorrespondantsMatrix = base2Matrix.getBase2CorrespondantsMatrix();
    }
}
