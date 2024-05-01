package com.sst.models;

import com.sst.exceptions.invalidMoveException;
import com.sst.strategies.WinningAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gamestate;
    private Player winner;
    private int nextPlayerMoveIndex;
    private WinningAlgorithm winningAlgorithm;
   public Game(int dimension, List<Player> players){
       this.board=new Board(dimension);
       this.players=players;
       this.moves=new ArrayList<>();
       this.gamestate=GameState.IN_PROGRESS;
       this.winner=null;
       this.nextPlayerMoveIndex=0;
       this.winningAlgorithm=new WinningAlgorithm();
   }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGamestate() {
        return gamestate;
    }

    public void setGamestate(GameState gamestate) {
        this.gamestate = gamestate;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }
    public void printBoard(){
       this.board.printBoard();
    }
    private boolean validateMove(Move move){
       int row=move.getCell().getRow();
       int col=move.getCell().getCol();
       if(row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()){
           return false;
       }
       return board.getBoard().get(row).get(col).getCellstate().equals(CellState.EMPTY);
    }
    public void makeMove(Game game) throws invalidMoveException {
         Player currentplayer=players.get(nextPlayerMoveIndex);
         Move move=currentplayer.Makemove(board);
         //move that current player wants to make
        //game will validate the move before executing
        if(!validateMove(move)){
            //throw an exception
            throw new invalidMoveException("invalid move made by "+currentplayer.getName());
        }
      int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Cell cellToChange=board.getBoard().get(row).get(col);
        //we take this cell here
        cellToChange.setPlayer(currentplayer);
        cellToChange.setCellstate(CellState.FILLED);
        Move finalMove=new Move(cellToChange,currentplayer);
        moves.add(finalMove);
        nextPlayerMoveIndex=(nextPlayerMoveIndex+1)%players.size();
        //check if the current move is the winning move or not
        if(winningAlgorithm.checkWinner(board,finalMove)){
            gamestate=GameState.ENDED;
            winner= currentplayer;
        }
    }
}
