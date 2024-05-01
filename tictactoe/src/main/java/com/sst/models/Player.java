package com.sst.models;

import java.util.Scanner;

public class Player {


    private String name;
    private Symbol symbol;
    private Playertype playertype;
    private static Scanner scanner=new Scanner(System.in);
    public Player(String name, Symbol symbol, Playertype playertype) {
        this.name = name;
        this.symbol = symbol;
        this.playertype = playertype;
    }
    public Move Makemove(Board board){
        //ask the user where they want to place the symbol
        System.out.println("enter row");
        int row=scanner.nextInt();
        System.out.println("Enter col");
        int col= scanner.nextInt();
        return new Move(new Cell(row,col),this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Playertype getPlayertype() {
        return playertype;
    }

    public void setPlayertype(Playertype playertype) {
        this.playertype = playertype;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Player.scanner = scanner;
    }
}
