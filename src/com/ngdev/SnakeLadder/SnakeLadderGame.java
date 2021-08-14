package com.ngdev.SnakeLadder;

import com.ngdev.Games.*;
import com.ngdev.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderGame implements com.ngdev.Games.Game {

    private final int snakesCount, laddersCount, boardWidth, boardHeight;
    private List<Player> playersList;
    private int playerWithTurn;
    private GameStats gameStats;
    private SnakeLadderBoard board;
    private Map<Player, Cell> playerLocations;
    private ArrayList<SnakeLadderElement> elements;
    private RoundRobinTurnTracker roundRobinTurnTracker;
    private GameState gameState;

    private SnakeLadderGame(Builder builder) {
        this.snakesCount = builder.snakesCount;
        this.laddersCount = builder.laddersCount;
        this.boardWidth = builder.boardWidth;
        this.boardHeight = builder.boardHeight;
        this.playersList = builder.playersList;
        playerWithTurn = 0;
        roundRobinTurnTracker = new RoundRobinTurnTracker(playersList.size());
    }

    @Override
    public GameStats getStats() {
        return null;
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
        this.elements = new ArrayList<SnakeLadderElement>();
        this.playerLocations = new HashMap<>();
        for(Player player: playersList){
            playerLocations.put(player, Cell.getStartingPosition());
        }

        for(int s = 0; s < snakesCount; s++){
            elements.add(SnakeLadderElementFactory.getInstance().getRandomSnake(boardWidth, boardHeight));
        }

        for(int l = 0; l < laddersCount; l++){
            elements.add(SnakeLadderElementFactory.getInstance().getRandomLadder(boardWidth, boardHeight));
        }
        gameState = GameState.IN_PROGRESS;
    }

    @Override
    public boolean isOver() {
        return gameState == GameState.ENDED;
    }

    @Override
    public boolean isMoveValid(Move move) {
        int roll = move.getRoll();
        return (roll > 0 && roll <= 6);
        //TODO: Add a logic for move validation
    }

    @Override
    public void makeMove(Move move) throws ValidationException {
        if(!isMoveValid(move)){
            throw new ValidationException("Move is not valid.");
        }
        System.out.println("Making the move " + move.toString());
        int roll = move.getRoll();
        Player player = getPlayerWithTurn();
        Cell location = playerLocations.get(player);
        int x = ((int)location.getX() + roll)%boardWidth;
        int y = ((int)location.getX() + roll)/boardWidth + (int)location.getY();
        Cell newLocation = new Cell(x, y);
        playerLocations.put(player, newLocation);

        if(checkPlayerAtWinningCell(newLocation)){
            // the current player has won the game!
            gameState = GameState.ENDED;
        } else {
            // make sure that the turn is advanced
            playerWithTurn = roundRobinTurnTracker.getNext();
        }
    }

    private boolean checkPlayerAtWinningCell(Cell newLocation) {
        return (newLocation.getY() == boardHeight - 1 && newLocation.getX() == boardWidth - 1);
    }

    @Override
    public boolean IsDrawn() {
        return false;
    }

    public static class Builder {
        private int snakesCount, laddersCount, boardWidth, boardHeight;
        private List<Player> playersList;

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
            return new SnakeLadderGame(this);
        }
    }
}
