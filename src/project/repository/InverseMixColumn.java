package project.repository;

public class InverseMixColumn {

    private String[][] inverseMixColumn = new String[4][4];

    public InverseMixColumn(){
    }

    public void setInverseMixColumn(){
        inverseMixColumn[0][0] = "14";
        inverseMixColumn[0][1] = "11";
        inverseMixColumn[0][2] = "13";
        inverseMixColumn[0][3] = "09";

        inverseMixColumn[1][0] = "09";
        inverseMixColumn[1][1] = "14";
        inverseMixColumn[1][2] = "11";
        inverseMixColumn[1][3] = "13";

        inverseMixColumn[2][0] = "13";
        inverseMixColumn[2][1] = "09";
        inverseMixColumn[2][2] = "14";
        inverseMixColumn[2][3] = "11";

        inverseMixColumn[3][0] = "11";
        inverseMixColumn[3][1] = "13";
        inverseMixColumn[3][2] = "09";
        inverseMixColumn[3][3] = "14";
    }

    public String[][] getInverseMixColumn() {
        return inverseMixColumn;
    }

    public void inverseMixColumnToString(){

        System.out.println();
        System.out.println("Inverse Mix Column: ");
        for (int i = 0; i < 4; i++) {
            String line = "";
            for (int j = 0; j < 4; j++) {
                line = line + inverseMixColumn[i][j] + " ";
            }
            System.out.println(line);
        }
    }
}
