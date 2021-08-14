package com.ngdev.SnakeLadder;

import com.ngdev.Games.GameElement;

public class SnakeLadderElement implements GameElement {
    private Cell start;
    private Cell end;

    public SnakeLadderElement(Cell start, Cell end) {
        this.start = start;
        this.end = end;
    }
}
