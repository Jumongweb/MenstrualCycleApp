package ticTacToe;
public enum Positions {

    X("X"),
    O("O"),
    EMPTY(" ");

    private final String value;

    Positions(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}