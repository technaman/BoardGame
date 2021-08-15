package com.ngdev;

import com.ngdev.Games.Factories.GameFactory;
import com.ngdev.Games.Game;
import com.ngdev.Games.GameController;
import com.ngdev.Games.Player;
import com.ngdev.SnakeLadder.SnakeLadderGame;
import com.ngdev.SnakeLadder.SnakeLadderGameController;
import com.ngdev.SnakeLadder.SnakeLadderPlayer;
import com.ngdev.SnakeLadder.SnakeLadderGameFactory;
import com.ngdev.exceptions.ValidationException;
import com.ngdev.user.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Player> playerList = new ArrayList<>();

        User one = new User("One");
        User two = new User("Two");

        SnakeLadderPlayer snakeLadderPlayer1 = new SnakeLadderPlayer(one, '$');
        SnakeLadderPlayer snakeLadderPlayer2 = new SnakeLadderPlayer(two, '*');

        playerList.add(snakeLadderPlayer1);
        playerList.add(snakeLadderPlayer2);

        GameFactory factory = new SnakeLadderGameFactory();

        Game game;

        try {
            game = factory.getClassicGame(playerList);
            GameController controller = new SnakeLadderGameController((SnakeLadderGame) game);
            controller.startGame();
        } catch (ValidationException e) {
            e.printStackTrace();
        }


    }
}
