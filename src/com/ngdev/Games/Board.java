package com.ngdev.Games;

import java.util.List;

public interface Board {
    List<List<Cell>> getCurrentState();
    boolean isAnyCellEmpty();
}
