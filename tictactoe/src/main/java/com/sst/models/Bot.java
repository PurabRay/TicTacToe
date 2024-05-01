package com.sst.models;

import java.util.List;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, Symbol symbol, Playertype playertype, com.sst.models.BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, playertype);
        this.botDifficultyLevel = botDifficultyLevel;
    }
    @Override
    public Move Makemove(Board board)
    {
        for(List<Cell> row: board.getBoard()){
        for(Cell cell: row){
            if(cell.getCellstate().equals(CellState.EMPTY)){
                return new Move(cell, this);
            }
        }
    }
        return null;
        //because the process of making the move will be the same
        //but here we override that is we change the logic

    }
}
