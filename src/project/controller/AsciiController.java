package project.controller;


import project.models.CharAscii;
import project.repository.AsciiRepo;

import java.util.List;

public class AsciiController {

    private AsciiRepo asciiMatrix;

    public AsciiController() {
    }

    public AsciiController(AsciiRepo asciiMatrix) {
        this.asciiMatrix = asciiMatrix;
    }

    public CharAscii findAsciiChar(String s) {
        return asciiMatrix.findOne(s);
    }

    public CharAscii findAsciiTextValue(String s){
        return asciiMatrix.findOneByHexaValue(s);
    }

    public List<CharAscii> findAll(){
        return asciiMatrix.findAll();
    }

    public CharAscii save(CharAscii c){
        return asciiMatrix.save(c);
    }

    @Override
    public String toString() {
        return asciiMatrix.toString();
    }
}
