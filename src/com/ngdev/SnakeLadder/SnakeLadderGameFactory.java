package com.ngdev.SnakeLadder;

import com.ngdev.Games.Game;
import com.ngdev.Games.Player;
import com.ngdev.Games.Factories.GameFactory;
import com.ngdev.exceptions.ValidationException;

import java.util.List;

public class SnakeLadderGameFactory implements GameFactory {

    private SnakeLadderGameFactory INSTANCE;

    @Override
    public SnakeLadderGameFactory getInstance() {
        if(INSTANCE == null){
            synchronized (SnakeLadderGameFactory.class){
                if(INSTANCE == null){
                    INSTANCE = new SnakeLadderGameFactory();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Game getDefaultElement() {
        return null;
    }

    @Override
    public Game getClassicGame(List<Player> playerList)  {
        try {
            return new SnakeLadderGame.Builder()
                    .setSnakesCount(7)
                    .setLaddersCount(6)
                    .setBoardHeight(10)
                    .setBoardWidth(10)
                    .setPlayersList(playerList)
                    .build();
        } catch (ValidationException e) {
            System.out.println("Board Size is invalid. Please try again.");
            e.printStackTrace();
        }
        return null;
    }
}
