package project.repository;

public class RijndaelSBox {

    private String[][] sBox = new String[16][16];

    public RijndaelSBox(){

    }

    public void setRijndaelSBox(){

        sBox[0][0] = "63";
        sBox[0][1] = "7C";
        sBox[0][2] = "77";
        sBox[0][3] = "7B";
        sBox[0][4] = "F2";
        sBox[0][5] = "6B";
        sBox[0][6] = "6F";
        sBox[0][7] = "C5";
        sBox[0][8] = "30";
        sBox[0][9] = "01";
        sBox[0][10] = "67";
        sBox[0][11] = "2B";
        sBox[0][12] = "FE";
        sBox[0][13] = "D7";
        sBox[0][14] = "AB";
        sBox[0][15] = "76";

        sBox[1][0] = "CA";
        sBox[1][1] = "82";
        sBox[1][2] = "C9";
        sBox[1][3] = "7D";
        sBox[1][4] = "FA";
        sBox[1][5] = "59";
        sBox[1][6] = "47";
        sBox[1][7] = "F0";
        sBox[1][8] = "AD";
        sBox[1][9] = "D4";
        sBox[1][10] = "A2";
        sBox[1][11] = "AF";
        sBox[1][12] = "9C";
        sBox[1][13] = "A4";
        sBox[1][14] = "72";
        sBox[1][15] = "C0";

        sBox[2][0] = "B7";
        sBox[2][1] = "FD";
        sBox[2][2] = "93";
        sBox[2][3] = "26";
        sBox[2][4] = "36";
        sBox[2][5] = "3F";
        sBox[2][6] = "F7";
        sBox[2][7] = "CC";
        sBox[2][8] = "34";
        sBox[2][9] = "A5";
        sBox[2][10] = "E5";
        sBox[2][11] = "F1";
        sBox[2][12] = "71";
        sBox[2][13] = "D8";
        sBox[2][14] = "31";
        sBox[2][15] = "15";

        sBox[3][0] = "04";
        sBox[3][1] = "C7";
        sBox[3][2] = "23";
        sBox[3][3] = "C3";
        sBox[3][4] = "18";
        sBox[3][5] = "96";
        sBox[3][6] = "05";
        sBox[3][7] = "9A";
        sBox[3][8] = "07";
        sBox[3][9] = "12";
        sBox[3][10] = "80";
        sBox[3][11] = "E2";
        sBox[3][12] = "EB";
        sBox[3][13] = "27";
        sBox[3][14] = "B2";
        sBox[3][15] = "75";

        sBox[4][0] = "09";
        sBox[4][1] = "83";
        sBox[4][2] = "2C";
        sBox[4][3] = "1A";
        sBox[4][4] = "1B";
        sBox[4][5] = "6E";
        sBox[4][6] = "5A";
        sBox[4][7] = "A0";
        sBox[4][8] = "52";
        sBox[4][9] = "3B";
        sBox[4][10] = "D6";
        sBox[4][11] = "B3";
        sBox[4][12] = "29";
        sBox[4][13] = "E3";
        sBox[4][14] = "2F";
        sBox[4][15] = "84";

        sBox[5][0] = "53";
        sBox[5][1] = "D1";
        sBox[5][2] = "00";
        sBox[5][3] = "ED";
        sBox[5][4] = "20";
        sBox[5][5] = "FC";
        sBox[5][6] = "B1";
        sBox[5][7] = "5B";
        sBox[5][8] = "6A";
        sBox[5][9] = "CB";
        sBox[5][10] = "BE";
        sBox[5][11] = "39";
        sBox[5][12] = "4A";
        sBox[5][13] = "4C";
        sBox[5][14] = "58";
        sBox[5][15] = "CF";

        sBox[6][0] = "D0";
        sBox[6][1] = "EF";
        sBox[6][2] = "AA";
        sBox[6][3] = "FB";
        sBox[6][4] = "43";
        sBox[6][5] = "4D";
        sBox[6][6] = "33";
        sBox[6][7] = "85";
        sBox[6][8] = "45";
        sBox[6][9] = "F9";
        sBox[6][10] = "02";
        sBox[6][11] = "7F";
        sBox[6][12] = "50";
        sBox[6][13] = "3C";
        sBox[6][14] = "9F";
        sBox[6][15] = "A8";

        sBox[7][0] = "51";
        sBox[7][1] = "A3";
        sBox[7][2] = "40";
        sBox[7][3] = "8F";
        sBox[7][4] = "92";
        sBox[7][5] = "9D";
        sBox[7][6] = "38";
        sBox[7][7] = "F5";
        sBox[7][8] = "BC";
        sBox[7][9] = "B6";
        sBox[7][10] = "DA";
        sBox[7][11] = "21";
        sBox[7][12] = "10";
        sBox[7][13] = "FF";
        sBox[7][14] = "F3";
        sBox[7][15] = "D2";

        sBox[8][0] = "CD";
        sBox[8][1] = "0C";
        sBox[8][2] = "13";
        sBox[8][3] = "EC";
        sBox[8][4] = "5F";
        sBox[8][5] = "97";
        sBox[8][6] = "44";
        sBox[8][7] = "17";
        sBox[8][8] = "C4";
        sBox[8][9] = "A7";
        sBox[8][10] = "7E";
        sBox[8][11] = "3D";
        sBox[8][12] = "64";
        sBox[8][13] = "5D";
        sBox[8][14] = "19";
        sBox[8][15] = "73";

        sBox[9][0] = "60";
        sBox[9][1] = "81";
        sBox[9][2] = "4F";
        sBox[9][3] = "DC";
        sBox[9][4] = "22";
        sBox[9][5] = "2A";
        sBox[9][6] = "90";
        sBox[9][7] = "88";
        sBox[9][8] = "46";
        sBox[9][9] = "EE";
        sBox[9][10] = "B8";
        sBox[9][11] = "14";
        sBox[9][12] = "DE";
        sBox[9][13] = "5E";
        sBox[9][14] = "0B";
        sBox[9][15] = "DB";

        sBox[10][0] = "E0";
        sBox[10][1] = "32";
        sBox[10][2] = "3A";
        sBox[10][3] = "0A";
        sBox[10][4] = "49";
        sBox[10][5] = "06";
        sBox[10][6] = "24";
        sBox[10][7] = "5C";
        sBox[10][8] = "C2";
        sBox[10][9] = "D3";
        sBox[10][10] = "AC";
        sBox[10][11] = "62";
        sBox[10][12] = "91";
        sBox[10][13] = "95";
        sBox[10][14] = "E4";
        sBox[10][15] = "79";

        sBox[11][0] = "E7";
        sBox[11][1] = "C8";
        sBox[11][2] = "37";
        sBox[11][3] = "6D";
        sBox[11][4] = "8D";
        sBox[11][5] = "D5";
        sBox[11][6] = "4E";
        sBox[11][7] = "A9";
        sBox[11][8] = "6C";
        sBox[11][9] = "56";
        sBox[11][10] = "F4";
        sBox[11][11] = "EA";
        sBox[11][12] = "65";
        sBox[11][13] = "7A";
        sBox[11][14] = "AE";
        sBox[11][15] = "08";

        sBox[12][0] = "BA";
        sBox[12][1] = "78";
        sBox[12][2] = "25";
        sBox[12][3] = "2E";
        sBox[12][4] = "1C";
        sBox[12][5] = "A6";
        sBox[12][6] = "B4";
        sBox[12][7] = "C6";
        sBox[12][8] = "E8";
        sBox[12][9] = "DD";
        sBox[12][10] = "74";
        sBox[12][11] = "1F";
        sBox[12][12] = "4B";
        sBox[12][13] = "BD";
        sBox[12][14] = "8B";
        sBox[12][15] = "8A";

        sBox[13][0] = "70";
        sBox[13][1] = "3E";
        sBox[13][2] = "B5";
        sBox[13][3] = "66";
        sBox[13][4] = "48";
        sBox[13][5] = "03";
        sBox[13][6] = "F6";
        sBox[13][7] = "0E";
        sBox[13][8] = "61";
        sBox[13][9] = "35";
        sBox[13][10] = "57";
        sBox[13][11] = "B9";
        sBox[13][12] = "86";
        sBox[13][13] = "C1";
        sBox[13][14] = "1D";
        sBox[13][15] = "9E";

        sBox[14][0] = "E1";
        sBox[14][1] = "F8";
        sBox[14][2] = "98";
        sBox[14][3] = "11";
        sBox[14][4] = "69";
        sBox[14][5] = "D9";
        sBox[14][6] = "8E";
        sBox[14][7] = "94";
        sBox[14][8] = "9B";
        sBox[14][9] = "1E";
        sBox[14][10] = "87";
        sBox[14][11] = "E9";
        sBox[14][12] = "CE";
        sBox[14][13] = "55";
        sBox[14][14] = "28";
        sBox[14][15] = "DF";

        sBox[15][0] = "8C";
        sBox[15][1] = "A1";
        sBox[15][2] = "89";
        sBox[15][3] = "0D";
        sBox[15][4] = "BF";
        sBox[15][5] = "E6";
        sBox[15][6] = "42";
        sBox[15][7] = "68";
        sBox[15][8] = "41";
        sBox[15][9] = "99";
        sBox[15][10] = "2D";
        sBox[15][11] = "0F";
        sBox[15][12] = "B0";
        sBox[15][13] = "54";
        sBox[15][14] = "BB";
        sBox[15][15] = "16";
    }

    public String[][] getsBox() {
        return sBox;
    }

    public void rijndaelSBoxToString(){

        System.out.println();
        System.out.println("Rijndael S-Box: ");
        for (int i = 0; i < 16; i++) {
            String line = "";
            for (int j = 0; j < 16; j++) {
                line = line + sBox[i][j] + " ";
            }
            System.out.println(line);
        }
    }
}
