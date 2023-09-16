package project.repository;

public class XorMatrix {

    private String[][] xorTable = new String[16][16];

    public XorMatrix(){

    }

    public void setXorTable(){

        xorTable[0][0] = "0";
        xorTable[0][1] = "1";
        xorTable[0][2] = "2";
        xorTable[0][3] = "3";
        xorTable[0][4] = "4";
        xorTable[0][5] = "5";
        xorTable[0][6] = "6";
        xorTable[0][7] = "7";
        xorTable[0][8] = "8";
        xorTable[0][9] = "9";
        xorTable[0][10] = "A";
        xorTable[0][11] = "B";
        xorTable[0][12] = "C";
        xorTable[0][13] = "D";
        xorTable[0][14] = "E";
        xorTable[0][15] = "F";

        xorTable[1][0] = "1";
        xorTable[1][1] = "0";
        xorTable[1][2] = "3";
        xorTable[1][3] = "2";
        xorTable[1][4] = "5";
        xorTable[1][5] = "4";
        xorTable[1][6] = "7";
        xorTable[1][7] = "6";
        xorTable[1][8] = "9";
        xorTable[1][9] = "8";
        xorTable[1][10] = "B";
        xorTable[1][11] = "A";
        xorTable[1][12] = "D";
        xorTable[1][13] = "C";
        xorTable[1][14] = "F";
        xorTable[1][15] = "E";

        xorTable[2][0] = "2";
        xorTable[2][1] = "3";
        xorTable[2][2] = "0";
        xorTable[2][3] = "1";
        xorTable[2][4] = "6";
        xorTable[2][5] = "7";
        xorTable[2][6] = "4";
        xorTable[2][7] = "5";
        xorTable[2][8] = "A";
        xorTable[2][9] = "B";
        xorTable[2][10] = "8";
        xorTable[2][11] = "9";
        xorTable[2][12] = "E";
        xorTable[2][13] = "F";
        xorTable[2][14] = "C";
        xorTable[2][15] = "D";

        xorTable[3][0] = "3";
        xorTable[3][1] = "2";
        xorTable[3][2] = "1";
        xorTable[3][3] = "0";
        xorTable[3][4] = "7";
        xorTable[3][5] = "6";
        xorTable[3][6] = "5";
        xorTable[3][7] = "4";
        xorTable[3][8] = "B";
        xorTable[3][9] = "A";
        xorTable[3][10] = "9";
        xorTable[3][11] = "8";
        xorTable[3][12] = "F";
        xorTable[3][13] = "E";
        xorTable[3][14] = "D";
        xorTable[3][15] = "C";

        xorTable[4][0] = "4";
        xorTable[4][1] = "5";
        xorTable[4][2] = "6";
        xorTable[4][3] = "7";
        xorTable[4][4] = "0";
        xorTable[4][5] = "1";
        xorTable[4][6] = "2";
        xorTable[4][7] = "3";
        xorTable[4][8] = "C";
        xorTable[4][9] = "D";
        xorTable[4][10] = "E";
        xorTable[4][11] = "F";
        xorTable[4][12] = "8";
        xorTable[4][13] = "9";
        xorTable[4][14] = "A";
        xorTable[4][15] = "B";

        xorTable[5][0] = "5";
        xorTable[5][1] = "4";
        xorTable[5][2] = "7";
        xorTable[5][3] = "6";
        xorTable[5][4] = "1";
        xorTable[5][5] = "0";
        xorTable[5][6] = "3";
        xorTable[5][7] = "2";
        xorTable[5][8] = "D";
        xorTable[5][9] = "C";
        xorTable[5][10] = "F";
        xorTable[5][11] = "E";
        xorTable[5][12] = "9";
        xorTable[5][13] = "8";
        xorTable[5][14] = "B";
        xorTable[5][15] = "A";

        xorTable[6][0] = "6";
        xorTable[6][1] = "7";
        xorTable[6][2] = "4";
        xorTable[6][3] = "5";
        xorTable[6][4] = "2";
        xorTable[6][5] = "3";
        xorTable[6][6] = "0";
        xorTable[6][7] = "1";
        xorTable[6][8] = "E";
        xorTable[6][9] = "F";
        xorTable[6][10] = "C";
        xorTable[6][11] = "D";
        xorTable[6][12] = "A";
        xorTable[6][13] = "B";
        xorTable[6][14] = "8";
        xorTable[6][15] = "9";

        xorTable[7][0] = "7";
        xorTable[7][1] = "6";
        xorTable[7][2] = "5";
        xorTable[7][3] = "4";
        xorTable[7][4] = "3";
        xorTable[7][5] = "2";
        xorTable[7][6] = "1";
        xorTable[7][7] = "0";
        xorTable[7][8] = "F";
        xorTable[7][9] = "E";
        xorTable[7][10] = "D";
        xorTable[7][11] = "C";
        xorTable[7][12] = "B";
        xorTable[7][13] = "A";
        xorTable[7][14] = "9";
        xorTable[7][15] = "8";

        xorTable[8][0] = "8";
        xorTable[8][1] = "9";
        xorTable[8][2] = "A";
        xorTable[8][3] = "B";
        xorTable[8][4] = "C";
        xorTable[8][5] = "D";
        xorTable[8][6] = "E";
        xorTable[8][7] = "F";
        xorTable[8][8] = "0";
        xorTable[8][9] = "1";
        xorTable[8][10] = "2";
        xorTable[8][11] = "3";
        xorTable[8][12] = "4";
        xorTable[8][13] = "5";
        xorTable[8][14] = "6";
        xorTable[8][15] = "7";

        xorTable[9][0] = "9";
        xorTable[9][1] = "8";
        xorTable[9][2] = "B";
        xorTable[9][3] = "A";
        xorTable[9][4] = "D";
        xorTable[9][5] = "C";
        xorTable[9][6] = "F";
        xorTable[9][7] = "E";
        xorTable[9][8] = "1";
        xorTable[9][9] = "0";
        xorTable[9][10] = "3";
        xorTable[9][11] = "2";
        xorTable[9][12] = "5";
        xorTable[9][13] = "4";
        xorTable[9][14] = "7";
        xorTable[9][15] = "6";

        xorTable[10][0] = "A";
        xorTable[10][1] = "B";
        xorTable[10][2] = "8";
        xorTable[10][3] = "9";
        xorTable[10][4] = "E";
        xorTable[10][5] = "F";
        xorTable[10][6] = "C";
        xorTable[10][7] = "D";
        xorTable[10][8] = "2";
        xorTable[10][9] = "3";
        xorTable[10][10] = "0";
        xorTable[10][11] = "1";
        xorTable[10][12] = "6";
        xorTable[10][13] = "7";
        xorTable[10][14] = "4";
        xorTable[10][15] = "5";

        xorTable[11][0] = "B";
        xorTable[11][1] = "A";
        xorTable[11][2] = "9";
        xorTable[11][3] = "8";
        xorTable[11][4] = "F";
        xorTable[11][5] = "E";
        xorTable[11][6] = "D";
        xorTable[11][7] = "C";
        xorTable[11][8] = "3";
        xorTable[11][9] = "2";
        xorTable[11][10] = "1";
        xorTable[11][11] = "0";
        xorTable[11][12] = "7";
        xorTable[11][13] = "6";
        xorTable[11][14] = "5";
        xorTable[11][15] = "4";

        xorTable[12][0] = "C";
        xorTable[12][1] = "D";
        xorTable[12][2] = "E";
        xorTable[12][3] = "F";
        xorTable[12][4] = "8";
        xorTable[12][5] = "9";
        xorTable[12][6] = "A";
        xorTable[12][7] = "B";
        xorTable[12][8] = "4";
        xorTable[12][9] = "5";
        xorTable[12][10] = "6";
        xorTable[12][11] = "7";
        xorTable[12][12] = "0";
        xorTable[12][13] = "1";
        xorTable[12][14] = "2";
        xorTable[12][15] = "3";

        xorTable[13][0] = "D";
        xorTable[13][1] = "C";
        xorTable[13][2] = "F";
        xorTable[13][3] = "E";
        xorTable[13][4] = "9";
        xorTable[13][5] = "8";
        xorTable[13][6] = "B";
        xorTable[13][7] = "A";
        xorTable[13][8] = "5";
        xorTable[13][9] = "4";
        xorTable[13][10] = "7";
        xorTable[13][11] = "6";
        xorTable[13][12] = "1";
        xorTable[13][13] = "0";
        xorTable[13][14] = "3";
        xorTable[13][15] = "2";

        xorTable[14][0] = "E";
        xorTable[14][1] = "F";
        xorTable[14][2] = "C";
        xorTable[14][3] = "D";
        xorTable[14][4] = "A";
        xorTable[14][5] = "B";
        xorTable[14][6] = "8";
        xorTable[14][7] = "9";
        xorTable[14][8] = "6";
        xorTable[14][9] = "7";
        xorTable[14][10] = "4";
        xorTable[14][11] = "5";
        xorTable[14][12] = "2";
        xorTable[14][13] = "3";
        xorTable[14][14] = "0";
        xorTable[14][15] = "1";

        xorTable[15][0] = "F";
        xorTable[15][1] = "E";
        xorTable[15][2] = "D";
        xorTable[15][3] = "C";
        xorTable[15][4] = "B";
        xorTable[15][5] = "A";
        xorTable[15][6] = "9";
        xorTable[15][7] = "8";
        xorTable[15][8] = "7";
        xorTable[15][9] = "6";
        xorTable[15][10] = "5";
        xorTable[15][11] = "4";
        xorTable[15][12] = "3";
        xorTable[15][13] = "2";
        xorTable[15][14] = "1";
        xorTable[15][15] = "0";
    }

    public String[][] getXorTable() {
        return xorTable;
    }

    public void xorTableToString(){

        System.out.println();
        System.out.println("Xor Matrix for hexa: ");
        for (int i = 0; i < 16; i++) {
            String line = "";
            for (int j = 0; j < 16; j++) {
                line = line + xorTable[i][j] + " ";
            }
            System.out.println(line);
        }
        System.out.println();
    }
}
