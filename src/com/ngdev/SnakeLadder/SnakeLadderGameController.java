package com.ngdev.SnakeLadder;

import com.ngdev.Games.InvalidLocationException;
import com.ngdev.Games.Move;
import com.ngdev.Games.Player;
import com.ngdev.Games.GameController;
import com.ngdev.exceptions.ValidationException;

public class SnakeLadderGameController implements GameController {

    private SnakeLadderGame game;

    public SnakeLadderGameController(SnakeLadderGame game) {
        this.game = game;
    }

    @Override
    public void startGame() {
        game.initialize();
        System.out.println("Snake Ladder game started!");
        while(!game.isOver()){
            Player player = game.getPlayerWithTurn();
            Move move = player.generateMove();

            while (true) {
                try {
                    if (!!game.isMoveValid(move)) break;
                } catch (InvalidLocationException e) {
                    System.out.println(e.getMessage());
                    break;
                }
                System.out.println("Invalid Move. Please try again.");
                move = player.generateMove();
            }

            try {
                game.makeMove(move);
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
        }

        if(game.IsDrawn()){
            System.out.println("Game was a draw");
        } else {
            System.out.println("Game won: " + game.getStats().toString());
        }

    }

    @Override
    public void addPlayer(Player player) {

    }

    @Override
    public void removePlayer(Player player) {

    }
}
