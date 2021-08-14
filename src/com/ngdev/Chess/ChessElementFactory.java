package com.ngdev.Chess;

import com.ngdev.Games.Factories.GameElementFactory;
import com.ngdev.Games.GameElement;

public class ChessElementFactory implements GameElementFactory {

    private ChessElementFactory INSTANCE;

    public ChessElementFactory getInstance() {
        if(INSTANCE == null){
            synchronized (ChessElementFactory.class){
                if(INSTANCE == null){
                    INSTANCE = new ChessElementFactory();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public ChessElement getDefaultElement() {
        return new ChessElement();
    }

    @Override
    public GameElement getRandomElement(int boardWidth, int boardHeight) {
        return null;
    }

}
