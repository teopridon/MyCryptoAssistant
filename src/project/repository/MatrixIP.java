package project.repository;


public class MatrixIP {

    private int[][] matrixIP = new int[8][8];

    public MatrixIP(){

    }

    public void setMatrixIP(){

        matrixIP[0][0] = 58;
        matrixIP[0][1] = 50;
        matrixIP[0][2] = 42;
        matrixIP[0][3] = 34;
        matrixIP[0][4] = 26;
        matrixIP[0][5] = 18;
        matrixIP[0][6] = 10;
        matrixIP[0][7] = 2;

        matrixIP[1][0] = 60;
        matrixIP[1][1] = 52;
        matrixIP[1][2] = 44;
        matrixIP[1][3] = 36;
        matrixIP[1][4] = 28;
        matrixIP[1][5] = 20;
        matrixIP[1][6] = 12;
        matrixIP[1][7] = 4;

        matrixIP[2][0] = 62;
        matrixIP[2][1] = 54;
        matrixIP[2][2] = 46;
        matrixIP[2][3] = 38;
        matrixIP[2][4] = 30;
        matrixIP[2][5] = 22;
        matrixIP[2][6] = 14;
        matrixIP[2][7] = 6;

        matrixIP[3][0] = 64;
        matrixIP[3][1] = 56;
        matrixIP[3][2] = 48;
        matrixIP[3][3] = 40;
        matrixIP[3][4] = 32;
        matrixIP[3][5] = 24;
        matrixIP[3][6] = 16;
        matrixIP[3][7] = 8;

        matrixIP[4][0] = 57;
        matrixIP[4][1] = 49;
        matrixIP[4][2] = 41;
        matrixIP[4][3] = 33;
        matrixIP[4][4] = 25;
        matrixIP[4][5] = 17;
        matrixIP[4][6] = 9;
        matrixIP[4][7] = 1;

        matrixIP[5][0] = 59;
        matrixIP[5][1] = 51;
        matrixIP[5][2] = 43;
        matrixIP[5][3] = 35;
        matrixIP[5][4] = 27;
        matrixIP[5][5] = 19;
        matrixIP[5][6] = 11;
        matrixIP[5][7] = 3;

        matrixIP[6][0] = 61;
        matrixIP[6][1] = 53;
        matrixIP[6][2] = 45;
        matrixIP[6][3] = 37;
        matrixIP[6][4] = 29;
        matrixIP[6][5] = 21;
        matrixIP[6][6] = 13;
        matrixIP[6][7] = 5;

        matrixIP[7][0] = 63;
        matrixIP[7][1] = 55;
        matrixIP[7][2] = 47;
        matrixIP[7][3] = 39;
        matrixIP[7][4] = 31;
        matrixIP[7][5] = 23;
        matrixIP[7][6] = 15;
        matrixIP[7][7] = 7;

    }

    public int[][] getMatrixIP() {
        return matrixIP;
    }

    public void matrixIPToString(){
        System.out.println();
        System.out.println("IP Matrix: ");
        for (int i = 0; i < 8 ; i++) {
            String line = "";
            for (int j = 0; j < 8 ; j++) {
                line = line + matrixIP[i][j] + " ";
            }
            System.out.println(line);
        }

    }
}
