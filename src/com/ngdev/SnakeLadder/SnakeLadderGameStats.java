package com.ngdev.SnakeLadder;

import com.ngdev.Games.GameState;
import com.ngdev.Games.GameStats;
import com.ngdev.Games.Player;

public class SnakeLadderGameStats implements GameStats {

    Player winner;
    GameState gameState;

    public SnakeLadderGameStats(GameState gameState) {
        this.gameState = gameState;
        winner = null;
    }

    @Override
    public String toString() {
        return "SnakeLadderGameStats{" +
                "winner=" + winner +
                ", gameState=" + gameState +
                '}';
    }

    @Override
    public GameStats getStats() {
        return this;
    }

    @Override
    public Player getWinner() {
        return winner;
    }

    @Override
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
