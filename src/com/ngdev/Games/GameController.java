package com.ngdev.Games;

public interface GameController {
    void startGame();

    private void initializeBoard(){};
    void addPlayer(Player player);
    void removePlayer(Player player);


}
