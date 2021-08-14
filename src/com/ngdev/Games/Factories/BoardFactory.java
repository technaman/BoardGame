package com.ngdev.Games.Factories;

import com.ngdev.Games.Board;
import com.ngdev.Games.Game;

public interface BoardFactory {
    public BoardFactory getInstance();

    public Board getDefaultElement();
}
