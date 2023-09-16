package project.repository;

public class MatrixIPminus1 {

    private int[][] matrixIPminus1 = new int[8][8];

    public MatrixIPminus1(){

    }

    public void setMatrixIPminus1(){

        matrixIPminus1[0][0] = 40;
        matrixIPminus1[1][0] = 39;
        matrixIPminus1[2][0] = 38;
        matrixIPminus1[3][0] = 37;
        matrixIPminus1[4][0] = 36;
        matrixIPminus1[5][0] = 35;
        matrixIPminus1[6][0] = 34;
        matrixIPminus1[7][0] = 33;

        matrixIPminus1[0][1] = 8;
        matrixIPminus1[1][1] = 7;
        matrixIPminus1[2][1] = 6;
        matrixIPminus1[3][1] = 5;
        matrixIPminus1[4][1] = 4;
        matrixIPminus1[5][1] = 3;
        matrixIPminus1[6][1] = 2;
        matrixIPminus1[7][1] = 1;

        matrixIPminus1[0][2] = 48;
        matrixIPminus1[1][2] = 47;
        matrixIPminus1[2][2] = 46;
        matrixIPminus1[3][2] = 45;
        matrixIPminus1[4][2] = 44;
        matrixIPminus1[5][2] = 43;
        matrixIPminus1[6][2] = 42;
        matrixIPminus1[7][2] = 41;

        matrixIPminus1[0][3] = 16;
        matrixIPminus1[1][3] = 15;
        matrixIPminus1[2][3] = 14;
        matrixIPminus1[3][3] = 13;
        matrixIPminus1[4][3] = 12;
        matrixIPminus1[5][3] = 11;
        matrixIPminus1[6][3] = 10;
        matrixIPminus1[7][3] = 9;

        matrixIPminus1[0][4] = 56;
        matrixIPminus1[1][4] = 55;
        matrixIPminus1[2][4] = 54;
        matrixIPminus1[3][4] = 53;
        matrixIPminus1[4][4] = 52;
        matrixIPminus1[5][4] = 51;
        matrixIPminus1[6][4] = 50;
        matrixIPminus1[7][4] = 49;

        matrixIPminus1[0][5] = 24;
        matrixIPminus1[1][5] = 23;
        matrixIPminus1[2][5] = 22;
        matrixIPminus1[3][5] = 21;
        matrixIPminus1[4][5] = 20;
        matrixIPminus1[5][5] = 19;
        matrixIPminus1[6][5] = 18;
        matrixIPminus1[7][5] = 17;

        matrixIPminus1[0][6] = 64;
        matrixIPminus1[1][6] = 63;
        matrixIPminus1[2][6] = 62;
        matrixIPminus1[3][6] = 61;
        matrixIPminus1[4][6] = 60;
        matrixIPminus1[5][6] = 59;
        matrixIPminus1[6][6] = 58;
        matrixIPminus1[7][6] = 57;

        matrixIPminus1[0][7] = 32;
        matrixIPminus1[1][7] = 31;
        matrixIPminus1[2][7] = 30;
        matrixIPminus1[3][7] = 29;
        matrixIPminus1[4][7] = 28;
        matrixIPminus1[5][7] = 27;
        matrixIPminus1[6][7] = 26;
        matrixIPminus1[7][7] = 25;

    }

    public int[][] getMatrixIPminus1() {
        return matrixIPminus1;
    }

    public void matrixIPminus1ToString(){
        System.out.println();
        System.out.println("Matrix IP^(-1): ");

        for (int i = 0; i < 8; i++) {
            String line = "";
            for (int j = 0; j < 8; j++) {
                line = line + matrixIPminus1[i][j] + " ";
            }
            System.out.println(line);
        }
    }
}
