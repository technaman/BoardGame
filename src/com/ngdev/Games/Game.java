package com.ngdev.Games;

import com.ngdev.exceptions.ValidationException;

import java.util.List;

public interface Game {
    GameStats getStats();
    List<Player> getPlayers();

    Player getPlayerWithTurn();

    void initialize();

    boolean isOver();

    boolean isMoveValid(Move move) throws InvalidLocationException;

    void makeMove(Move move) throws ValidationException;

    boolean IsDrawn();

    public static class Builder {}
}
