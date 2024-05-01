package com.sst.Controller;

import com.sst.models.Game;
import com.sst.models.GameState;
import com.sst.models.Player;

import java.util.List;

public class GameController {


    //TODO exception part
    public Game startGame(int dimension, List<Player> players){
        return new Game(dimension, players);
    }
    //validate if two players have the same symbol or not
    public void makeMove(Game game){
        game.makeMove(game);
    }
    public GameState checkstate(Game game){
        return game.getGamestate();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
    public void printBoard(Game game){

         game.printBoard();
    }
}
