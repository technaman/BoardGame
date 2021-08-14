package com.ngdev.SnakeLadder;

import com.ngdev.Games.GameElement;
import com.ngdev.Games.Factories.GameElementFactory;

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

    public SnakeLadderElement getRandomElement(boolean isSnake) {
        return new SnakeLadderElement(isSnake);
    }

    public SnakeLadderElement getRandomSnake() {
        return getRandomElement(true);
    }

    public SnakeLadderElement getRandomLadder() {
        return getRandomElement(false);
    }
}
