package com.ngdev.SnakeLadder;

public class RoundRobinTurnTracker implements com.ngdev.Games.TurnTracker {
    private int turn;
    private final int size;

    public RoundRobinTurnTracker(int size) {
        this.size = size;
        turn = 0;
    }

    @Override
    public int getCurrentTurn() {
        return turn;
    }

    @Override
    public int getNext() {
        turn = (turn + 1) % size;
        return turn;
    }
}
