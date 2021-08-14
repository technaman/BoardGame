package com.ngdev.SnakeLadder;

import com.ngdev.Games.Factories.GameElementFactory;
import com.ngdev.Games.GameElement;

public class SnakeLadderElementFactory implements GameElementFactory {
    private static SnakeLadderElementFactory INSTANCE;

    private SnakeLadderElementFactory() {
    }

    public static SnakeLadderElementFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (SnakeLadderElementFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SnakeLadderElementFactory();
                }
            }
        }
        return INSTANCE;
    }

    public GameElement getDefaultElement() {
        return null;
    }

    @Override
    public SnakeLadderElement getRandomElement(int boardWidth, int boardHeight) {
        Cell start = Utils.generateRandomCellPosition(boardWidth, boardHeight);
        Cell end = Utils.generateRandomCellPosition(boardWidth, boardHeight);
        return new SnakeLadderElement(start, end);
    }

    public SnakeLadderElement getRandomSnake(int boardWidth, int boardHeight) {
        return getRandomElement(boardWidth, boardHeight);
    }

    public SnakeLadderElement getRandomLadder(int boardWidth, int boardHeight) {
        return getRandomElement(boardWidth, boardHeight);
    }
}
