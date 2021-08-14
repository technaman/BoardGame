package com.ngdev.Games;

public interface GameStats {
    GameStats getStats();
    Player getWinner();
    void setGameState(GameState gameState);
    void setWinner(Player winner);
}
