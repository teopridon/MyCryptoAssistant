package project.repository;


public class MatrixPC2 {

    private int[][] matrixPC2 = new int[8][6];

    public void setMatrixPC2(){
        matrixPC2[0][0] = 14;
        matrixPC2[0][1] = 17;
        matrixPC2[0][2] = 11;
        matrixPC2[0][3] = 24;
        matrixPC2[0][4] = 1;
        matrixPC2[0][5] = 5;

        matrixPC2[1][0] = 3;
        matrixPC2[1][1] = 28;
        matrixPC2[1][2] = 15;
        matrixPC2[1][3] = 6;
        matrixPC2[1][4] = 21;
        matrixPC2[1][5] = 10;

        matrixPC2[2][0] = 23;
        matrixPC2[2][1] = 19;
        matrixPC2[2][2] = 12;
        matrixPC2[2][3] = 4;
        matrixPC2[2][4] = 26;
        matrixPC2[2][5] = 8;

        matrixPC2[3][0] = 16;
        matrixPC2[3][1] = 7;
        matrixPC2[3][2] = 27;
        matrixPC2[3][3] = 20;
        matrixPC2[3][4] = 13;
        matrixPC2[3][5] = 2;

        matrixPC2[4][0] = 41;
        matrixPC2[4][1] = 52;
        matrixPC2[4][2] = 31;
        matrixPC2[4][3] = 37;
        matrixPC2[4][4] = 47;
        matrixPC2[4][5] = 55;

        matrixPC2[5][0] = 30;
        matrixPC2[5][1] = 40;
        matrixPC2[5][2] = 51;
        matrixPC2[5][3] = 45;
        matrixPC2[5][4] = 33;
        matrixPC2[5][5] = 48;

        matrixPC2[6][0] = 44;
        matrixPC2[6][1] = 49;
        matrixPC2[6][2] = 39;
        matrixPC2[6][3] = 56;
        matrixPC2[6][4] = 34;
        matrixPC2[6][5] = 53;

        matrixPC2[7][0] = 46;
        matrixPC2[7][1] = 42;
        matrixPC2[7][2] = 50;
        matrixPC2[7][3] = 36;
        matrixPC2[7][4] = 29;
        matrixPC2[7][5] = 32;

    }

    public int[][] getMatrixPC2() {
        return matrixPC2;
    }

    public void matrixPC2ToString(){
        System.out.println();
        System.out.println("Matrix PC-2: ");
        for (int i = 0; i < 8; i++) {
            String line = "";
            for (int j = 0; j < 6; j++) {
                line = line + matrixPC2[i][j] + " ";
            }
            System.out.println(line);
        }
    }
}
