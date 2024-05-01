package com.sst;

import com.sst.Controller.GameController;
import com.sst.models.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  //interacts like a client
    public static void main(String[] args){
      Scanner scanner=new Scanner(System.in);
      GameController gamecontroller=new GameController();

      new Player("Purab",new Symbol('X'), Playertype.HUMAN, BotDifficultyLevel.EASY);
      BotDifficultyLevel botDifficultylevel;
      new Bot("Scaler",new Symbol('0'),Playertype.BOT,botDifficultylevel.EASY);

      Game game=gamecontroller.startGame(dimension,players);
      while(game.getGamestate().equals(GameState.IN_PROGRESS)){
        //gamecontroller.printBoard(game);
        gamecontroller.makeMove();

      }
      if (!GameController.checkState(game).equals(GameState.ENDED)) {
        game.setGamestate(GameState.DRAW);
        System.out.println("Game DRAW");
      } else {
        GameController.printBoard(game);
        System.out.println("Player " + GameController.getWinner(game).getName() + " is the winner");
      }
    }

}