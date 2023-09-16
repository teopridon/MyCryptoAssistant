package project.repository;

public class MatrixP {

    private int[][] matrixP = new int[8][4];

    public MatrixP(){

    }

    public void setMatrixP(){
        matrixP[0][0] = 16;
        matrixP[0][1] = 7;
        matrixP[0][2] = 20;
        matrixP[0][3] = 21;

        matrixP[1][0] = 29;
        matrixP[1][1] = 12;
        matrixP[1][2] = 28;
        matrixP[1][3] = 17;

        matrixP[2][0] = 1;
        matrixP[2][1] = 15;
        matrixP[2][2] = 23;
        matrixP[2][3] = 26;

        matrixP[3][0] = 5;
        matrixP[3][1] = 18;
        matrixP[3][2] = 31;
        matrixP[3][3] = 10;

        matrixP[4][0] = 2;
        matrixP[4][1] = 8;
        matrixP[4][2] = 24;
        matrixP[4][3] = 14;

        matrixP[5][0] = 32;
        matrixP[5][1] = 27;
        matrixP[5][2] = 3;
        matrixP[5][3] = 9;

        matrixP[6][0] = 19;
        matrixP[6][1] = 13;
        matrixP[6][2] = 30;
        matrixP[6][3] = 6;

        matrixP[7][0] = 22;
        matrixP[7][1] = 11;
        matrixP[7][2] = 4;
        matrixP[7][3] = 25;
    }

    public int[][] getMatrixP() {
        return matrixP;
    }

    public void matrixPToString(){
        System.out.println();
        System.out.println("Matrix P: ");
        for (int i = 0; i < 8; i++) {
            String line = "";
            for (int j = 0; j < 4; j++) {
                line = line + matrixP[i][j] + " ";
            }
            System.out.println(line);
        }
    }

}
