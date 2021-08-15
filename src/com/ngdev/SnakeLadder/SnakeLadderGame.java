package com.ngdev.SnakeLadder;

import com.ngdev.Games.*;
import com.ngdev.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderGame implements com.ngdev.Games.Game {

    private final int snakesCount, laddersCount;
    private List<Player> playersList;
    private int playerWithTurn;
    private SnakeLadderGameStats gameStats;
    private SnakeLadderBoard board;
    private ArrayList<SnakeLadderElement> elements;
    private RoundRobinTurnTracker roundRobinTurnTracker;
    private GameState gameState;

    private SnakeLadderGame(Builder builder) {
        this.snakesCount = builder.snakesCount;
        this.laddersCount = builder.laddersCount;
        this.board = builder.board;
        this.playersList = builder.playersList;
        playerWithTurn = 0;
        roundRobinTurnTracker = new RoundRobinTurnTracker(playersList.size());
    }

    @Override
    public GameStats getStats() {
        return gameStats;
    }

    @Override
    public List<Player> getPlayers() {
        return null;
    }

    @Override
    public Player getPlayerWithTurn() {
        return playersList.get(playerWithTurn);
    }

    @Override
    public void initialize() {
        System.out.println("Initializing Classic Snake Ladder Game. Please Wait !");
        this.elements = new ArrayList<>();

        for(int s = 0; s < snakesCount; s++){
            elements.add(SnakeLadderElementFactory.getInstance().getRandomSnake());
        }
        for(int l = 0; l < laddersCount; l++){
            elements.add(SnakeLadderElementFactory.getInstance().getRandomLadder());
        }

        board.addGameElements(elements);
        board.initPlayerLocations(playersList);

        gameState = GameState.IN_PROGRESS;
        gameStats = new SnakeLadderGameStats(gameState);

        board.printBoard();
    }

    @Override
    public boolean isOver() {
        return gameState == GameState.ENDED;
    }

    @Override
    public boolean isMoveValid(Move move) throws InvalidLocationException {
        int roll = move.getRoll();
        if (roll < 1 || roll > 6) return false;

        board.checkLocationOutOfBounds(board.getPlayerLocation(getPlayerWithTurn()), roll);

        return true;
    }

    @Override
    public void makeMove(Move move) throws ValidationException {
        try {
            if(!isMoveValid(move)){
                throw new ValidationException("Invalid dice roll. Please try again.");
            }
        } catch (ValidationException e) {
            playerWithTurn = roundRobinTurnTracker.getNext();
            throw e;
        }
        int roll = move.getRoll();
        Player player = getPlayerWithTurn();
        SnakeLadderCell newLocation = board.getNewLocation(player, roll);

        if(board.hasSnake(newLocation)){
            System.out.println("Bit by snake at cell#:" + board.getCellNumber(newLocation));
            newLocation = board.getDestination(newLocation);
        }
        if(board.foundLadder(newLocation)) {
            System.out.println("Found a ladder at cell#:" + board.getCellNumber(newLocation));
            newLocation = board.getDestination(newLocation);
        }

        board.updatePlayerLocation(player, newLocation);

        board.printBoard();
        System.out.println("Player " + player.getName() + " moved to cell# " + board.getCellNumber(newLocation));

        if(checkPlayerAtWinningCell(newLocation)){
            // the current player has won the game!
            gameStats.setWinner(player);
            gameState = GameState.ENDED;
            gameStats.setGameState(gameState);
        } else {
            // make sure that the turn is advanced
            playerWithTurn = roundRobinTurnTracker.getNext();
        }
    }

    private boolean checkPlayerAtWinningCell(SnakeLadderCell newLocation) {
        return board.checkPlayerAtWinningCell(newLocation);
    }

    @Override
    public boolean IsDrawn() {
        return false;

        //TODO: add a draw logic
    }

    public static class Builder {
        private int snakesCount, laddersCount, boardWidth, boardHeight;
        private List<Player> playersList;
        private SnakeLadderBoard board;

        public Builder(){}

        public Builder setSnakesCount(int snakesCount) {
            this.snakesCount = snakesCount;
            return this;
        }

        public Builder setLaddersCount(int laddersCount) {
            this.laddersCount = laddersCount;
            return this;
        }

        public Builder setBoardWidth(int boardWidth) {
            this.boardWidth = boardWidth;
            return this;
        }

        public Builder setBoardHeight(int boardHeight) {
            this.boardHeight = boardHeight;
            return this;
        }

        public Builder setPlayersList(List<Player> playersList) {
            this.playersList = playersList;
            return this;
        }

        public SnakeLadderGame build() throws ValidationException {
            if(playersList.size() < 2) {
                throw new ValidationException("Minimum two players are required");
            }
            if(boardWidth < 3 || boardHeight < 3){
                throw new InvalidBoardSizeException("Board Size should be at least 3 * 3");
            }

            this.board = new SnakeLadderBoard(boardWidth, boardHeight);

            return new SnakeLadderGame(this);
        }
    }
}
