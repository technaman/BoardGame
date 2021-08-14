package com.ngdev.SnakeLadder;

import com.ngdev.Games.Cell;

import java.util.List;

public class SnakeLadderBoard implements com.ngdev.Games.Board {
    private List<List<Cell>> cells;
    private int totalCellCount;
    private int filledCellCount;

    @Override
    public List<List<Cell>> getCurrentState() {
        return this.cells;
    }

    @Override
    public boolean isAnyCellEmpty() {
        return filledCellCount != totalCellCount;
    }
}
