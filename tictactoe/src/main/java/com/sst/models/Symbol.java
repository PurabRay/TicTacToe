package com.sst.models;

public class Symbol {
    private char aChar;
    public char getaChar(){
        return aChar;
    }
    public void getaChar(char aChar){
        this.aChar=aChar;
    }

    public Symbol(char aChar) {
        this.aChar = aChar;
    }
}
