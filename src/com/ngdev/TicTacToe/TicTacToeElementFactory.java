package com.ngdev.TicTacToe;


import com.ngdev.Games.Factories.GameElementFactory;
import com.ngdev.Games.GameElement;

public class TicTacToeElementFactory implements GameElementFactory {

    private static TicTacToeElementFactory INSTANCE;

    public static TicTacToeElementFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (TicTacToeElementFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TicTacToeElementFactory();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public TicTacToeElement getDefaultElement() {
        return new TicTacToeElement();
    }

    @Override
    public GameElement getRandomElement(int boardWidth, int boardHeight) {
        return null;
    }

}