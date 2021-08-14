package com.ngdev.SnakeLadder;

public class Utils {
    public static Cell generateRandomCellPosition(int boardWidth, int boardHeight){
        int x = (int) (Math.random() * boardWidth);
        int y = (int) (Math.random() * boardHeight);
        return new Cell(x, y);
    }

    public static int rollDice() {
        return (int)Math.random()*6;
    }
}
