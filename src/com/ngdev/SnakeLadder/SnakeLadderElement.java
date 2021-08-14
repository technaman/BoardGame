package com.ngdev.SnakeLadder;

import com.ngdev.Games.GameElement;

public class SnakeLadderElement implements GameElement {

    private boolean isSnake;

    public SnakeLadderElement(boolean isSnake) {
        this.isSnake = isSnake;
    }

    public boolean isSnake() {
        return isSnake;
    }

    public boolean isLadder(){
        return !isSnake;
    }
}
