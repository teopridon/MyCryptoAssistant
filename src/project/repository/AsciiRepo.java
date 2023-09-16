package project.repository;

import project.models.CharAscii;

import java.util.ArrayList;
import java.util.List;

public class AsciiRepo {

    private List<CharAscii> asciiMatrix = new ArrayList<>();

    public CharAscii findOne(String textVal) {
        for (CharAscii asc:asciiMatrix) {
            if (asc.getAsciiChar().equals(textVal)){
                return asc;
            }
        }
        System.out.println("Character not found in the Ascii Table!");
        return null;
    }

    public CharAscii findOneByHexaValue(String hexaVal){
        for (CharAscii asc: asciiMatrix){
            if (asc.getHexValue().equals(hexaVal)){
                return asc;
            }
        }

        System.out.println("Hexa value not found in the Ascii Table!");
        return null;
    }

    public List<CharAscii> findAll() {
        return asciiMatrix;
    }


    public CharAscii save(CharAscii asc) {
        if(asc == null){
            System.out.println("A null character can't be saved in the Ascii Table.");
            return null;
        }
        for (CharAscii c:asciiMatrix) {
            if(c.equals(asc)){
                System.out.println("The character you are trying to save is already saved in the Ascii Table!");
                return null;
            }
        }
        asciiMatrix.add(asc);
        return asc;
    }

    @Override
    public String toString() {
        String res = " ";
        for (CharAscii c: asciiMatrix) {
            res = res + c.toString() + '\n';
        }
        return res;
    }
}
