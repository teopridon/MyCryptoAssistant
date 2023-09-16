package project.models;

public class CharAscii {

    private String asciiChar;
    private String hexValue;

    public CharAscii() {
    }

    public CharAscii(String asciiChar, String hexValue) {
        this.asciiChar = asciiChar;
        this.hexValue = hexValue;
    }

    public String getAsciiChar() {
        return asciiChar;
    }

    public void setAsciiChar(String asciiChar) {
        this.asciiChar = asciiChar;
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) {
        this.hexValue = hexValue;
    }

    @Override
    public String toString() {
            return " " + asciiChar + ' ' + '=' + ' ' + hexValue;
    }
}
