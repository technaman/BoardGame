package com.ngdev.Games.Factories;

import com.ngdev.Games.GameElement;

public interface GameElementFactory {

    static GameElementFactory getInstance() {
        return null;
    }

    GameElement getDefaultElement();

}
