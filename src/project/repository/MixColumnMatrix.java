package project.repository;

public class MixColumnMatrix {

    private String[][] mixColumn = new String[4][4];

    public MixColumnMatrix(){

    }

    public void setMixColumn(){

        mixColumn[0][0] = "02";
        mixColumn[0][1] = "03";
        mixColumn[0][2] = "01";
        mixColumn[0][3] = "01";

        mixColumn[1][0] = "01";
        mixColumn[1][1] = "02";
        mixColumn[1][2] = "03";
        mixColumn[1][3] = "01";

        mixColumn[2][0] = "01";
        mixColumn[2][1] = "01";
        mixColumn[2][2] = "02";
        mixColumn[2][3] = "03";

        mixColumn[3][0] = "03";
        mixColumn[3][1] = "01";
        mixColumn[3][2] = "01";
        mixColumn[3][3] = "02";
    }

    public String[][] getMixColumn() {
        return mixColumn;
    }

    public void mixColumnToString(){

        System.out.println();
        System.out.println("Mix Column Matrix: ");

        for (int i = 0; i < 4; i++) {
            String line = "";
            for (int j = 0; j < 4; j++) {
                line = line + mixColumn[i][j] + " ";
            }
            System.out.println(line);
        }
    }
}
