package com.ngdev.Games;

public abstract class Player {
    public abstract Move generateMove();

    public abstract String getName();

    public abstract char getSymbol();
}
