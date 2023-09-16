package project.repository;

public class MatrixPC1 {

    private int[][] matrixPC1 = new int[8][7];

    public MatrixPC1(){

    }

    public void setMatrixPC1(){
        matrixPC1[0][0] = 57;
        matrixPC1[0][1] = 49;
        matrixPC1[0][2] = 41;
        matrixPC1[0][3] = 33;
        matrixPC1[0][4] = 25;
        matrixPC1[0][5] = 17;
        matrixPC1[0][6] = 9;


        matrixPC1[1][0] = 1;
        matrixPC1[1][1] = 58;
        matrixPC1[1][2] = 50;
        matrixPC1[1][3] = 42;
        matrixPC1[1][4] = 34;
        matrixPC1[1][5] = 26;
        matrixPC1[1][6] = 18;


        matrixPC1[2][0] = 10;
        matrixPC1[2][1] = 2;
        matrixPC1[2][2] = 59;
        matrixPC1[2][3] = 51;
        matrixPC1[2][4] = 43;
        matrixPC1[2][5] = 35;
        matrixPC1[2][6] = 27;


        matrixPC1[3][0] = 19;
        matrixPC1[3][1] = 11;
        matrixPC1[3][2] = 3;
        matrixPC1[3][3] = 60;
        matrixPC1[3][4] = 52;
        matrixPC1[3][5] = 44;
        matrixPC1[3][6] = 36;


        matrixPC1[4][0] = 63;
        matrixPC1[4][1] = 55;
        matrixPC1[4][2] = 47;
        matrixPC1[4][3] = 39;
        matrixPC1[4][4] = 31;
        matrixPC1[4][5] = 23;
        matrixPC1[4][6] = 15;


        matrixPC1[5][0] = 7;
        matrixPC1[5][1] = 62;
        matrixPC1[5][2] = 54;
        matrixPC1[5][3] = 46;
        matrixPC1[5][4] = 38;
        matrixPC1[5][5] = 30;
        matrixPC1[5][6] = 22;


        matrixPC1[6][0] = 14;
        matrixPC1[6][1] = 6;
        matrixPC1[6][2] = 61;
        matrixPC1[6][3] = 53;
        matrixPC1[6][4] = 45;
        matrixPC1[6][5] = 37;
        matrixPC1[6][6] = 29;


        matrixPC1[7][0] = 21;
        matrixPC1[7][1] = 13;
        matrixPC1[7][2] = 5;
        matrixPC1[7][3] = 28;
        matrixPC1[7][4] = 20;
        matrixPC1[7][5] = 12;
        matrixPC1[7][6] = 4;

    }

    public int[][] getMatrixPC1() {
        return matrixPC1;
    }

    public void matrixPC1ToString(){
        System.out.println();
        System.out.println("Matrix PC-1: ");

        for (int i = 0; i < 8 ; i++) {
            String line = "";
            for (int j = 0; j < 7; j++) {
                line = line + matrixPC1[i][j] + " ";
            }
            System.out.println(line);
        }
    }
}
