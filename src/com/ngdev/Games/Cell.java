package com.ngdev.Games;

import java.awt.*;

public abstract class Cell extends Point {

    public abstract Cell getLocation();

    public Cell(int x, int y) {
        super(x, y);
    }

}
