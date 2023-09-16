package project.repository;

public class MatrixE {

    private int[][] matrixE = new int[8][6];

    public MatrixE(){
    }

    public void setMatrixE(){
        matrixE[0][0] = 32;
        matrixE[0][1] = 1;
        matrixE[0][2] = 2;
        matrixE[0][3] = 3;
        matrixE[0][4] = 4;
        matrixE[0][5] = 5;

        matrixE[1][0] = 4;
        matrixE[1][1] = 5;
        matrixE[1][2] = 6;
        matrixE[1][3] = 7;
        matrixE[1][4] = 8;
        matrixE[1][5] = 9;

        matrixE[2][0] = 8;
        matrixE[2][1] = 9;
        matrixE[2][2] = 10;
        matrixE[2][3] = 11;
        matrixE[2][4] = 12;
        matrixE[2][5] = 13;

        matrixE[3][0] = 12;
        matrixE[3][1] = 13;
        matrixE[3][2] = 14;
        matrixE[3][3] = 15;
        matrixE[3][4] = 16;
        matrixE[3][5] = 17;

        matrixE[4][0] = 16;
        matrixE[4][1] = 17;
        matrixE[4][2] = 18;
        matrixE[4][3] = 19;
        matrixE[4][4] = 20;
        matrixE[4][5] = 21;

        matrixE[5][0] = 20;
        matrixE[5][1] = 21;
        matrixE[5][2] = 22;
        matrixE[5][3] = 23;
        matrixE[5][4] = 24;
        matrixE[5][5] = 25;

        matrixE[6][0] = 24;
        matrixE[6][1] = 25;
        matrixE[6][2] = 26;
        matrixE[6][3] = 27;
        matrixE[6][4] = 28;
        matrixE[6][5] = 29;

        matrixE[7][0] = 28;
        matrixE[7][1] = 29;
        matrixE[7][2] = 30;
        matrixE[7][3] = 31;
        matrixE[7][4] = 32;
        matrixE[7][5] = 1;

    }

    public int[][] getMatrixE(){
        return matrixE;
    }

    public void matrixEToString(){

        System.out.println();
        System.out.println("Matrix E: ");
        for (int i = 0; i < 7; i++) {
            String line = "";
            for (int j = 0; j < 6; j++) {
                line = line + matrixE[i][j] + " ";
            }
            System.out.println(line);
        }

    }
}
