package com.ngdev.SnakeLadder;

import com.ngdev.Games.Cell;

public class SnakeLadderCell extends Cell {

    public SnakeLadderCell(int x, int y) {
        super(x, y);
    }

    public static SnakeLadderCell getStartingPosition() {
        return new SnakeLadderCell(0, 1);
    }

    @Override
    public com.ngdev.Games.Cell getLocation() {
        return this;
    }

    @Override
    public String toString() {
        return "SnakeLadderCell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
