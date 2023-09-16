package project.repository;

public class SBoxes {

    private int[][] sBox1 = new int[4][16];
    private int[][] sBox2 = new int[4][16];
    private int[][] sBox3 = new int[4][16];
    private int[][] sBox4 = new int[4][16];
    private int[][] sBox5 = new int[4][16];
    private int[][] sBox6 = new int[4][16];
    private int[][] sBox7 = new int[4][16];
    private int[][] sBox8 = new int[4][16];

    public SBoxes(){

    }

    public void setAllSBoxes(){
        setSBox1();
        setSBox2();
        setSBox3();
        setSBox4();
        setSBox5();
        setSBox6();
        setSBox7();
        setSBox8();
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


    public void setSBox1(){

        sBox1[0][0] = 14;
        sBox1[1][0] = 0;
        sBox1[2][0] = 4;
        sBox1[3][0] = 15;

        sBox1[0][1] = 4;
        sBox1[1][1] = 15;
        sBox1[2][1] = 1;
        sBox1[3][1] = 12;

        sBox1[0][2] = 13;
        sBox1[1][2] = 7;
        sBox1[2][2] = 14;
        sBox1[3][2] = 8;

        sBox1[0][3] = 1;
        sBox1[1][3] = 4;
        sBox1[2][3] = 8;
        sBox1[3][3] = 2;

        sBox1[0][4] = 2;
        sBox1[1][4] = 14;
        sBox1[2][4] = 13;
        sBox1[3][4] = 4;

        sBox1[0][5] = 15;
        sBox1[1][5] = 2;
        sBox1[2][5] = 6;
        sBox1[3][5] = 9;

        sBox1[0][6] = 11;
        sBox1[1][6] = 13;
        sBox1[2][6] = 2;
        sBox1[3][6] = 1;

        sBox1[0][7] = 8;
        sBox1[1][7] = 1;
        sBox1[2][7] = 11;
        sBox1[3][7] = 7;

        sBox1[0][8] = 3;
        sBox1[1][8] = 10;
        sBox1[2][8] = 15;
        sBox1[3][8] = 5;

        sBox1[0][9] = 10;
        sBox1[1][9] = 6;
        sBox1[2][9] = 12;
        sBox1[3][9] = 11;

        sBox1[0][10] = 6;
        sBox1[1][10] = 12;
        sBox1[2][10] = 9;
        sBox1[3][10] = 3;

        sBox1[0][11] = 12;
        sBox1[1][11] = 11;
        sBox1[2][11] = 7;
        sBox1[3][11] = 14;

        sBox1[0][12] = 5;
        sBox1[1][12] = 9;
        sBox1[2][12] = 3;
        sBox1[3][12] = 10;

        sBox1[0][13] = 9;
        sBox1[1][13] = 5;
        sBox1[2][13] = 10;
        sBox1[3][13] = 0;

        sBox1[0][14] = 0;
        sBox1[1][14] = 3;
        sBox1[2][14] = 5;
        sBox1[3][14] = 6;

        sBox1[0][15] = 7;
        sBox1[1][15] = 8;
        sBox1[2][15] = 0;
        sBox1[3][15] = 13;

    }


    public void setSBox2(){

        sBox2[0][0] = 15;
        sBox2[1][0] = 3;
        sBox2[2][0] = 0;
        sBox2[3][0] = 13;

        sBox2[0][1] = 1;
        sBox2[1][1] = 13;
        sBox2[2][1] = 14;
        sBox2[3][1] = 8;

        sBox2[0][2] = 8;
        sBox2[1][2] = 4;
        sBox2[2][2] = 7;
        sBox2[3][2] = 10;

        sBox2[0][3] = 14;
        sBox2[1][3] = 7;
        sBox2[2][3] = 11;
        sBox2[3][3] = 1;

        sBox2[0][4] = 6;
        sBox2[1][4] = 15;
        sBox2[2][4] = 10;
        sBox2[3][4] = 3;

        sBox2[0][5] = 11;
        sBox2[1][5] = 2;
        sBox2[2][5] = 4;
        sBox2[3][5] = 15;

        sBox2[0][6] = 3;
        sBox2[1][6] = 8;
        sBox2[2][6] = 13;
        sBox2[3][6] = 4;

        sBox2[0][7] = 4;
        sBox2[1][7] = 14;
        sBox2[2][7] = 1;
        sBox2[3][7] = 2;

        sBox2[0][8] = 9;
        sBox2[1][8] = 12;
        sBox2[2][8] = 5;
        sBox2[3][8] = 11;

        sBox2[0][9] = 7;
        sBox2[1][9] = 0;
        sBox2[2][9] = 8;
        sBox2[3][9] = 6;

        sBox2[0][10] = 2;
        sBox2[1][10] = 1;
        sBox2[2][10] = 12;
        sBox2[3][10] = 7;

        sBox2[0][11] = 13;
        sBox2[1][11] = 10;
        sBox2[2][11] = 6;
        sBox2[3][11] = 12;

        sBox2[0][12] = 12;
        sBox2[1][12] = 6;
        sBox2[2][12] = 9;
        sBox2[3][12] = 0;

        sBox2[0][13] = 0;
        sBox2[1][13] = 9;
        sBox2[2][13] = 3;
        sBox2[3][13] = 5;

        sBox2[0][14] = 5;
        sBox2[1][14] = 11;
        sBox2[2][14] = 2;
        sBox2[3][14] = 14;

        sBox2[0][15] = 10;
        sBox2[1][15] = 5;
        sBox2[2][15] = 15;
        sBox2[3][15] = 9;
    }

    public void setSBox3(){
        sBox3[0][0] = 10;
        sBox3[1][0] = 13;
        sBox3[2][0] = 13;
        sBox3[3][0] = 1;

        sBox3[0][1] = 0;
        sBox3[1][1] = 7;
        sBox3[2][1] = 6;
        sBox3[3][1] = 10;

        sBox3[0][2] = 9;
        sBox3[1][2] = 0;
        sBox3[2][2] = 4;
        sBox3[3][2] = 13;

        sBox3[0][3] = 14;
        sBox3[1][3] = 9;
        sBox3[2][3] = 9;
        sBox3[3][3] = 0;

        sBox3[0][4] = 6;
        sBox3[1][4] = 3;
        sBox3[2][4] = 8;
        sBox3[3][4] = 6;

        sBox3[0][5] = 3;
        sBox3[1][5] = 4;
        sBox3[2][5] = 15;
        sBox3[3][5] = 9;

        sBox3[0][6] = 15;
        sBox3[1][6] = 6;
        sBox3[2][6] = 3;
        sBox3[3][6] = 8;

        sBox3[0][7] = 5;
        sBox3[1][7] = 10;
        sBox3[2][7] = 0;
        sBox3[3][7] = 7;

        sBox3[0][8] = 1;
        sBox3[1][8] = 2;
        sBox3[2][8] = 11;
        sBox3[3][8] = 4;

        sBox3[0][9] = 13;
        sBox3[1][9] = 8;
        sBox3[2][9] = 1;
        sBox3[3][9] = 15;

        sBox3[0][10] = 12;
        sBox3[1][10] = 5;
        sBox3[2][10] = 2;
        sBox3[3][10] = 14;

        sBox3[0][11] = 7;
        sBox3[1][11] = 14;
        sBox3[2][11] = 12;
        sBox3[3][11] = 3;

        sBox3[0][12] = 11;
        sBox3[1][12] = 12;
        sBox3[2][12] = 5;
        sBox3[3][12] = 11;

        sBox3[0][13] = 4;
        sBox3[1][13] = 11;
        sBox3[2][13] = 10;
        sBox3[3][13] = 5;

        sBox3[0][14] = 2;
        sBox3[1][14] = 15;
        sBox3[2][14] = 14;
        sBox3[3][14] = 2;

        sBox3[0][15] = 8;
        sBox3[1][15] = 1;
        sBox3[2][15] = 7;
        sBox3[3][15] = 12;
    }

    public void setSBox4(){
        sBox4[0][0] = 7;
        sBox4[1][0] = 13;
        sBox4[2][0] = 10;
        sBox4[3][0] = 3;

        sBox4[0][1] = 13;
        sBox4[1][1] = 8;
        sBox4[2][1] = 6;
        sBox4[3][1] = 15;

        sBox4[0][2] = 14;
        sBox4[1][2] = 11;
        sBox4[2][2] = 9;
        sBox4[3][2] = 0;

        sBox4[0][3] = 3;
        sBox4[1][3] = 5;
        sBox4[2][3] = 0;
        sBox4[3][3] = 6;

        sBox4[0][4] = 0;
        sBox4[1][4] = 6;
        sBox4[2][4] = 12;
        sBox4[3][4] = 10;

        sBox4[0][5] = 6;
        sBox4[1][5] = 15;
        sBox4[2][5] = 11;
        sBox4[3][5] = 1;

        sBox4[0][6] = 9;
        sBox4[1][6] = 0;
        sBox4[2][6] = 7;
        sBox4[3][6] = 13;

        sBox4[0][7] = 10;
        sBox4[1][7] = 3;
        sBox4[2][7] = 13;
        sBox4[3][7] = 8;

        sBox4[0][8] = 1;
        sBox4[1][8] = 4;
        sBox4[2][8] = 15;
        sBox4[3][8] = 9;

        sBox4[0][9] = 2;
        sBox4[1][9] = 7;
        sBox4[2][9] = 1;
        sBox4[3][9] = 4;

        sBox4[0][10] = 8;
        sBox4[1][10] = 2;
        sBox4[2][10] = 3;
        sBox4[3][10] = 5;

        sBox4[0][11] = 5;
        sBox4[1][11] = 12;
        sBox4[2][11] = 14;
        sBox4[3][11] = 11;

        sBox4[0][12] = 11;
        sBox4[1][12] = 1;
        sBox4[2][12] = 5;
        sBox4[3][12] = 12;

        sBox4[0][13] = 12;
        sBox4[1][13] = 10;
        sBox4[2][13] = 2;
        sBox4[3][13] = 7;

        sBox4[0][14] = 4;
        sBox4[1][14] = 14;
        sBox4[2][14] = 8;
        sBox4[3][14] = 2;

        sBox4[0][15] = 15;
        sBox4[1][15] = 9;
        sBox4[2][15] = 4;
        sBox4[3][15] = 14;
    }

    public void setSBox5(){
        sBox5[0][0] = 2;
        sBox5[1][0] = 14;
        sBox5[2][0] = 4;
        sBox5[3][0] = 11;

        sBox5[0][1] = 12;
        sBox5[1][1] = 11;
        sBox5[2][1] = 2;
        sBox5[3][1] = 8;

        sBox5[0][2] = 4;
        sBox5[1][2] = 2;
        sBox5[2][2] = 1;
        sBox5[3][2] = 12;

        sBox5[0][3] = 1;
        sBox5[1][3] = 12;
        sBox5[2][3] = 11;
        sBox5[3][3] = 7;

        sBox5[0][4] = 7;
        sBox5[1][4] = 4;
        sBox5[2][4] = 10;
        sBox5[3][4] = 1;

        sBox5[0][5] = 10;
        sBox5[1][5] = 7;
        sBox5[2][5] = 13;
        sBox5[3][5] = 14;

        sBox5[0][6] = 11;
        sBox5[1][6] = 13;
        sBox5[2][6] = 7;
        sBox5[3][6] = 2;

        sBox5[0][7] = 6;
        sBox5[1][7] = 1;
        sBox5[2][7] = 8;
        sBox5[3][7] = 13;

        sBox5[0][8] = 8;
        sBox5[1][8] = 5;
        sBox5[2][8] = 15;
        sBox5[3][8] = 6;

        sBox5[0][9] = 5;
        sBox5[1][9] = 0;
        sBox5[2][9] = 9;
        sBox5[3][9] = 15;

        sBox5[0][10] = 3;
        sBox5[1][10] = 15;
        sBox5[2][10] = 12;
        sBox5[3][10] = 0;

        sBox5[0][11] = 15;
        sBox5[1][11] = 10;
        sBox5[2][11] = 5;
        sBox5[3][11] = 9;

        sBox5[0][12] = 13;
        sBox5[1][12] = 3;
        sBox5[2][12] = 6;
        sBox5[3][12] = 10;

        sBox5[0][13] = 0;
        sBox5[1][13] = 9;
        sBox5[2][13] = 3;
        sBox5[3][13] = 4;

        sBox5[0][14] = 14;
        sBox5[1][14] = 8;
        sBox5[2][14] = 0;
        sBox5[3][14] = 5;

        sBox5[0][15] = 9;
        sBox5[1][15] = 6;
        sBox5[2][15] = 14;
        sBox5[3][15] = 3;
    }

    public void setSBox6(){
        sBox6[0][0] = 12;
        sBox6[1][0] = 10;
        sBox6[2][0] = 9;
        sBox6[3][0] = 4;

        sBox6[0][1] = 1;
        sBox6[1][1] = 15;
        sBox6[2][1] = 14;
        sBox6[3][1] = 3;

        sBox6[0][2] = 10;
        sBox6[1][2] = 4;
        sBox6[2][2] = 15;
        sBox6[3][2] = 2;

        sBox6[0][3] = 15;
        sBox6[1][3] = 2;
        sBox6[2][3] = 5;
        sBox6[3][3] = 12;

        sBox6[0][4] = 9;
        sBox6[1][4] = 7;
        sBox6[2][4] = 2;
        sBox6[3][4] = 9;

        sBox6[0][5] = 2;
        sBox6[1][5] = 12;
        sBox6[2][5] = 8;
        sBox6[3][5] = 5;

        sBox6[0][6] = 6;
        sBox6[1][6] = 9;
        sBox6[2][6] = 12;
        sBox6[3][6] = 15;

        sBox6[0][7] = 8;
        sBox6[1][7] = 5;
        sBox6[2][7] = 3;
        sBox6[3][7] = 10;

        sBox6[0][8] = 0;
        sBox6[1][8] = 6;
        sBox6[2][8] = 7;
        sBox6[3][8] = 11;

        sBox6[0][9] = 13;
        sBox6[1][9] = 1;
        sBox6[2][9] = 0;
        sBox6[3][9] = 14;

        sBox6[0][10] = 3;
        sBox6[1][10] = 13;
        sBox6[2][10] = 4;
        sBox6[3][10] = 1;

        sBox6[0][11] = 4;
        sBox6[1][11] = 14;
        sBox6[2][11] = 10;
        sBox6[3][11] = 7;

        sBox6[0][12] = 14;
        sBox6[1][12] = 0;
        sBox6[2][12] = 1;
        sBox6[3][12] = 6;

        sBox6[0][13] = 7;
        sBox6[1][13] = 11;
        sBox6[2][13] = 13;
        sBox6[3][13] = 0;

        sBox6[0][14] = 5;
        sBox6[1][14] = 3;
        sBox6[2][14] = 11;
        sBox6[3][14] = 8;

        sBox6[0][15] = 11;
        sBox6[1][15] = 8;
        sBox6[2][15] = 6;
        sBox6[3][15] = 13;
    }

    public void setSBox7(){
        sBox7[0][0] = 4;
        sBox7[1][0] = 13;
        sBox7[2][0] = 1;
        sBox7[3][0] = 6;

        sBox7[0][1] = 11;
        sBox7[1][1] = 0;
        sBox7[2][1] = 4;
        sBox7[3][1] = 11;

        sBox7[0][2] = 2;
        sBox7[1][2] = 11;
        sBox7[2][2] = 11;
        sBox7[3][2] = 13;

        sBox7[0][3] = 14;
        sBox7[1][3] = 7;
        sBox7[2][3] = 13;
        sBox7[3][3] = 8;

        sBox7[0][4] = 15;
        sBox7[1][4] = 4;
        sBox7[2][4] = 12;
        sBox7[3][4] = 1;

        sBox7[0][5] = 0;
        sBox7[1][5] = 9;
        sBox7[2][5] = 3;
        sBox7[3][5] = 4;

        sBox7[0][6] = 8;
        sBox7[1][6] = 1;
        sBox7[2][6] = 7;
        sBox7[3][6] = 10;

        sBox7[0][7] = 13;
        sBox7[1][7] = 10;
        sBox7[2][7] = 14;
        sBox7[3][7] = 7;

        sBox7[0][8] = 3;
        sBox7[1][8] = 14;
        sBox7[2][8] = 10;
        sBox7[3][8] = 9;

        sBox7[0][9] = 12;
        sBox7[1][9] = 3;
        sBox7[2][9] = 15;
        sBox7[3][9] = 5;

        sBox7[0][10] = 9;
        sBox7[1][10] = 5;
        sBox7[2][10] = 6;
        sBox7[3][10] = 0;

        sBox7[0][11] = 7;
        sBox7[1][11] = 12;
        sBox7[2][11] = 8;
        sBox7[3][11] = 15;

        sBox7[0][12] = 5;
        sBox7[1][12] = 2;
        sBox7[2][12] = 0;
        sBox7[3][12] = 14;

        sBox7[0][13] = 10;
        sBox7[1][13] = 15;
        sBox7[2][13] = 5;
        sBox7[3][13] = 2;

        sBox7[0][14] = 6;
        sBox7[1][14] = 8;
        sBox7[2][14] = 9;
        sBox7[3][14] = 3;

        sBox7[0][15] = 1;
        sBox7[1][15] = 6;
        sBox7[2][15] = 2;
        sBox7[3][15] = 12;
    }

    public void setSBox8(){
        sBox8[0][0] = 13;
        sBox8[1][0] = 1;
        sBox8[2][0] = 7;
        sBox8[3][0] = 2;

        sBox8[0][1] = 2;
        sBox8[1][1] = 15;
        sBox8[2][1] = 11;
        sBox8[3][1] = 1;

        sBox8[0][2] = 8;
        sBox8[1][2] = 13;
        sBox8[2][2] = 4;
        sBox8[3][2] = 14;

        sBox8[0][3] = 4;
        sBox8[1][3] = 8;
        sBox8[2][3] = 1;
        sBox8[3][3] = 7;

        sBox8[0][4] = 6;
        sBox8[1][4] = 10;
        sBox8[2][4] = 9;
        sBox8[3][4] = 4;

        sBox8[0][5] = 15;
        sBox8[1][5] = 3;
        sBox8[2][5] = 12;
        sBox8[3][5] = 10;

        sBox8[0][6] = 11;
        sBox8[1][6] = 7;
        sBox8[2][6] = 14;
        sBox8[3][6] = 8;

        sBox8[0][7] = 1;
        sBox8[1][7] = 4;
        sBox8[2][7] = 2;
        sBox8[3][7] = 13;

        sBox8[0][8] = 10;
        sBox8[1][8] = 12;
        sBox8[2][8] = 0;
        sBox8[3][8] = 15;

        sBox8[0][9] = 9;
        sBox8[1][9] = 5;
        sBox8[2][9] = 6;
        sBox8[3][9] = 12;

        sBox8[0][10] = 3;
        sBox8[1][10] = 6;
        sBox8[2][10] = 10;
        sBox8[3][10] = 9;

        sBox8[0][11] = 14;
        sBox8[1][11] = 11;
        sBox8[2][11] = 13;
        sBox8[3][11] = 0;

        sBox8[0][12] = 5;
        sBox8[1][12] = 0;
        sBox8[2][12] = 15;
        sBox8[3][12] = 3;

        sBox8[0][13] = 0;
        sBox8[1][13] = 14;
        sBox8[2][13] = 3;
        sBox8[3][13] = 5;

        sBox8[0][14] = 12;
        sBox8[1][14] = 9;
        sBox8[2][14] = 5;
        sBox8[3][14] = 6;

        sBox8[0][15] = 7;
        sBox8[1][15] = 2;
        sBox8[2][15] = 8;
        sBox8[3][15] = 11;
    }

    public int[][] getsBox1() {
        return sBox1;
    }

    public int[][] getsBox2() {
        return sBox2;
    }

    public int[][] getsBox3() {
        return sBox3;
    }

    public int[][] getsBox4() {
        return sBox4;
    }

    public int[][] getsBox5() {
        return sBox5;
    }

    public int[][] getsBox6() {
        return sBox6;
    }

    public int[][] getsBox7() {
        return sBox7;
    }

    public int[][] getsBox8() {
        return sBox8;
    }

    public void sBox1ToString(){

        System.out.println();
        System.out.println("S-Box1: ");
        for (int i = 0; i < 4 ; i++) {
            String line = "";
            for (int j = 0; j < 16; j++) {
                line = line + sBox1[i][j] + " ";
            }
            System.out.println(line);
        }
    }

    public void sBox2ToString(){

        System.out.println();
        System.out.println("S-Box2: ");
        for (int i = 0; i < 4 ; i++) {
            String line = "";
            for (int j = 0; j < 16; j++) {
                line = line + sBox2[i][j] + " ";
            }
            System.out.println(line);
        }
    }

    public void sBox3ToString(){

        System.out.println();
        System.out.println("S-Box3: ");
        for (int i = 0; i < 4 ; i++) {
            String line = "";
            for (int j = 0; j < 16; j++) {
                line = line + sBox3[i][j] + " ";
            }
            System.out.println(line);
        }
    }

    public void sBox4ToString(){

        System.out.println();
        System.out.println("S-Box4: ");
        for (int i = 0; i < 4 ; i++) {
            String line = "";
            for (int j = 0; j < 16; j++) {
                line = line + sBox4[i][j] + " ";
            }
            System.out.println(line);
        }
    }

    public void sBox5ToString(){

        System.out.println();
        System.out.println("S-Box5: ");
        for (int i = 0; i < 4 ; i++) {
            String line = "";
            for (int j = 0; j < 16; j++) {
                line = line + sBox5[i][j] + " ";
            }
            System.out.println(line);
        }
    }

    public void sBox6ToString(){

        System.out.println();
        System.out.println("S-Box6: ");
        for (int i = 0; i < 4 ; i++) {
            String line = "";
            for (int j = 0; j < 16; j++) {
                line = line + sBox6[i][j] + " ";
            }
            System.out.println(line);
        }
    }

    public void sBox7ToString(){

        System.out.println();
        System.out.println("S-Box7: ");
        for (int i = 0; i < 4 ; i++) {
            String line = "";
            for (int j = 0; j < 16; j++) {
                line = line + sBox7[i][j] + " ";
            }
            System.out.println(line);
        }
    }

    public void sBox8ToString(){

        System.out.println();
        System.out.println("S-Box8: ");
        for (int i = 0; i < 4 ; i++) {
            String line = "";
            for (int j = 0; j < 16; j++) {
                line = line + sBox8[i][j] + " ";
            }
            System.out.println(line);
        }
    }
}
