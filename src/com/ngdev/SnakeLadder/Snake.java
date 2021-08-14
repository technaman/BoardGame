package com.ngdev.SnakeLadder;

public class Snake extends SnakeLadderElement {
    private Cell start, end;

    public Snake(Cell start, Cell end) {
        super(start, end);
        this.start = start;
        this.end = end;
    }

}
