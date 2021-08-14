package com.ngdev.SnakeLadder;

import com.ngdev.Games.Move;

public class SnakeLadderMove implements Move {
    private int roll;

    public SnakeLadderMove(int roll) {
        this.roll = roll;
    }

    public int getRoll() {
        return this.roll;
    }

    @Override
    public String toString() {
        return "SnakeLadderMove{" +
                "roll=" + roll +
                '}';
    }
}
