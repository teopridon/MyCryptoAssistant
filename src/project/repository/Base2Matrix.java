package project.repository;

public class Base2Matrix {

    private String[][] base2CorrespondantsMatrix = new String[16][2];

    public Base2Matrix(){

    }

    public void setBase2CorrespondantsMatrix(){

        base2CorrespondantsMatrix[0][0] = "0000";
        base2CorrespondantsMatrix[0][1] = "0";

        base2CorrespondantsMatrix[1][0] = "0001";
        base2CorrespondantsMatrix[1][1] = "1";

        base2CorrespondantsMatrix[2][0] = "0010";
        base2CorrespondantsMatrix[2][1] = "2";

        base2CorrespondantsMatrix[3][0] = "0011";
        base2CorrespondantsMatrix[3][1] = "3";

        base2CorrespondantsMatrix[4][0] = "0100";
        base2CorrespondantsMatrix[4][1] = "4";

        base2CorrespondantsMatrix[5][0] = "0101";
        base2CorrespondantsMatrix[5][1] = "5";

        base2CorrespondantsMatrix[6][0] = "0110";
        base2CorrespondantsMatrix[6][1] = "6";

        base2CorrespondantsMatrix[7][0] = "0111";
        base2CorrespondantsMatrix[7][1] = "7";

        base2CorrespondantsMatrix[8][0] = "1000";
        base2CorrespondantsMatrix[8][1] = "8";

        base2CorrespondantsMatrix[9][0] = "1001";
        base2CorrespondantsMatrix[9][1] = "9";

        base2CorrespondantsMatrix[10][0] = "1010";
        base2CorrespondantsMatrix[10][1] = "A";

        base2CorrespondantsMatrix[11][0] = "1011";
        base2CorrespondantsMatrix[11][1] = "B";

        base2CorrespondantsMatrix[12][0] = "1100";
        base2CorrespondantsMatrix[12][1] = "C";

        base2CorrespondantsMatrix[13][0] = "1101";
        base2CorrespondantsMatrix[13][1] = "D";

        base2CorrespondantsMatrix[14][0] = "1110";
        base2CorrespondantsMatrix[14][1] = "E";

        base2CorrespondantsMatrix[15][0] = "1111";
        base2CorrespondantsMatrix[15][1] = "F";

    }

    public String[][] getBase2CorrespondantsMatrix() {
        return base2CorrespondantsMatrix;
    }
}
