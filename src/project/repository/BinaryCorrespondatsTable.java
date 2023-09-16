package project.repository;

public class BinaryCorrespondatsTable {

    private String[][] binaryTable = new String[16][2];

    public BinaryCorrespondatsTable(){

    }

    public void setBinaryTable(){

        binaryTable[0][0] = "0";
        binaryTable[0][1] = "0000";

        binaryTable[1][0] = "1";
        binaryTable[1][1] = "0001";

        binaryTable[2][0] = "2";
        binaryTable[2][1] = "0010";

        binaryTable[3][0] = "3";
        binaryTable[3][1] = "0011";

        binaryTable[4][0] = "4";
        binaryTable[4][1] = "0100";

        binaryTable[5][0] = "5";
        binaryTable[5][1] = "0101";

        binaryTable[6][0] = "6";
        binaryTable[6][1] = "0110";

        binaryTable[7][0] = "7";
        binaryTable[7][1] = "0111";

        binaryTable[8][0] = "8";
        binaryTable[8][1] = "1000";

        binaryTable[9][0] = "9";
        binaryTable[9][1] = "1001";

        binaryTable[10][0] = "A";
        binaryTable[10][1] = "1010";

        binaryTable[11][0] = "B";
        binaryTable[11][1] = "1011";

        binaryTable[12][0] = "C";
        binaryTable[12][1] = "1100";

        binaryTable[13][0] = "D";
        binaryTable[13][1] = "1101";

        binaryTable[14][0] = "E";
        binaryTable[14][1] = "1110";

        binaryTable[15][0] = "F";
        binaryTable[15][1] = "1111";

    }

    public String[][] getBinaryTable() {
        return binaryTable;
    }

    public void binaryTableToString(){
        System.out.println();
        System.out.println("Binary Correspondants Table: ");

        for (int i = 0; i < 16; i++) {
            String line = "";
            for (int j = 0; j < 2; j++) {
                line = line + binaryTable[i][j] + " ";
            }
            System.out.println(line);
        }
        System.out.println();
    }
}
