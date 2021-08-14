package com.ngdev.TicTacToe;


import com.ngdev.Games.Factories.GameElementFactory;
import com.ngdev.Games.GameElement;

public class TicTacToeElementFactory {

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

    public TicTacToeElement getDefaultElement() {
        return new TicTacToeElement();
    }

    public GameElement getRandomElement(int boardWidth, int boardHeight) {
        return null;
    }

}