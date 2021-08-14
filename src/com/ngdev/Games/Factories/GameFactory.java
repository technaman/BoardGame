package com.ngdev.Games.Factories;

import com.ngdev.Games.Game;
import com.ngdev.Games.Player;
import com.ngdev.exceptions.ValidationException;

import java.util.List;

public interface GameFactory {
    public GameFactory getInstance();

    public Game getDefaultElement();

    public Game getClassicGame(List<Player> playerList) throws ValidationException;

}
