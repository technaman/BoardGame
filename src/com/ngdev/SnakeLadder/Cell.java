package com.ngdev.SnakeLadder;

public class Cell extends com.ngdev.Games.Cell {

    public Cell(int x, int y) {
        super(x, y);
    }

    public static Cell getStartingPosition() {
        return new Cell(0, 0);
    }

    @Override
    public com.ngdev.Games.Cell getLocation() {
        return this;
    }
}
