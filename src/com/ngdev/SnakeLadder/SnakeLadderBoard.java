package com.ngdev.SnakeLadder;

import com.ngdev.Games.Cell;
import com.ngdev.Games.InvalidLocationException;
import com.ngdev.Games.Player;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class SnakeLadderBoard implements com.ngdev.Games.Board {
    private int boardWidth;
    private int boardHeight;
    private final int totalCells;

    private Map<SnakeLadderCell, SnakeLadderElement> startingLocation;
    private Map<SnakeLadderElement, SnakeLadderCell> destination;

    public SnakeLadderBoard(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        startingLocation = new HashMap<>();
        destination = new HashMap<>();
        totalCells = boardHeight * boardWidth;
    }

    public void addGameElements(List<SnakeLadderElement> elements) {
        for (SnakeLadderElement element : elements) {
            SnakeLadderCell start = generateRandomCellPosition();
            while(start.getY() == boardHeight){
                start = generateRandomLowerCellPosition(start);
            }
            SnakeLadderCell end = generateRandomHigherCellPosition(start);
            while (end.getY() == 1) {
                end = generateRandomHigherCellPosition(start);
            }

            //TODO: add validations for cell already occupied
            if (element.isSnake()) {
                startingLocation.put(end, element);
                destination.put(element, start);
                System.out.println("Snake added at cell#" + getCellNumber(end) + " to cell#" + getCellNumber(start));
            } else {
                startingLocation.put(start, element);
                destination.put(element, end);
                System.out.println("Ladder added at cell#" + getCellNumber(start) + " to cell#" + getCellNumber(end));
            }
        }
    }

    public SnakeLadderCell getDestination(SnakeLadderCell cell) {
        SnakeLadderElement element = startingLocation.get(cell);
        return destination.get(element);
    }

    public boolean hasSnake(SnakeLadderCell cell) {
        boolean hasSnake = startingLocation.containsKey(cell) && startingLocation.get(cell).isSnake();
        return hasSnake;
    }

    public boolean foundLadder(SnakeLadderCell cell) {
        boolean foundLadder = startingLocation.containsKey(cell) && startingLocation.get(cell).isLadder();
        return foundLadder;
    }

    public int getCellNumber(Cell cell) {
        return (int) ((cell.getY()-1) * boardWidth + cell.getX());
    }

    public boolean checkPlayerAtWinningCell(SnakeLadderCell newLocation) {
        return getCellNumber(newLocation) == boardHeight * boardWidth;
    }

    public void checkLocationOutOfBounds(SnakeLadderCell currentLocation, int roll) throws InvalidLocationException {
        SnakeLadderCell newLocation = getNewLocation(currentLocation, roll);
        if (getCellNumber(newLocation) > boardHeight * boardHeight) {
            throw new InvalidLocationException("Invalid Move. Location out of board.");
        }
    }

    public SnakeLadderCell getNewLocation(SnakeLadderCell currentLocation, int roll) {
        int x = ((int) currentLocation.getX() + roll) % boardWidth;
        int y = ((int) currentLocation.getX() + roll) / boardWidth + (int) currentLocation.getY();
        return new SnakeLadderCell(x, y);
    }

    public SnakeLadderCell generateRandomLowerCellPosition(SnakeLadderCell cell) {
        SnakeLadderCell newLocation = generateRandomCellPosition();
        if (getCellNumber(newLocation) >= getCellNumber(cell)) {
            newLocation = new SnakeLadderCell((int) (newLocation.getX() - cell.getX()),
                    (int) (newLocation.getY() - cell.getY()));
        }
        if (getCellNumber(newLocation) < 0) {
            return generateRandomLowerCellPosition(cell);
        }
        return newLocation;
    }

    public SnakeLadderCell generateRandomHigherCellPosition(SnakeLadderCell cell) {
        SnakeLadderCell newLocation = generateRandomCellPosition();
        if (getCellNumber(newLocation) <= getCellNumber(cell))
            newLocation = new SnakeLadderCell((int) (newLocation.getX() + cell.getX()),
                    (int) (newLocation.getY() + cell.getY()));

        if (getCellNumber(newLocation) > totalCells) {
            return generateRandomHigherCellPosition(cell);
        }
        return newLocation;
    }


    public SnakeLadderCell generateRandomCellPosition() {
        int x = (int) (Math.random() * boardWidth);
        int y = (int) (Math.random() * boardHeight);
        return new SnakeLadderCell(x, y);
    }

    public void printBoard(){
        System.out.println("Snakes & Ladders Board");
        String divider = "_".repeat(boardWidth * boardWidth/2);
        for(int row = boardHeight; row >= 1; row--){
            System.out.println(divider);
            String boardRow = "";
            for(int col = boardWidth; col >=1; col--){
                SnakeLadderCell cell = new SnakeLadderCell(col, row);
                String printValue = "" + getCellNumber(cell);
                if(foundLadder(cell)) {
                    printValue += 'L';
                }
                if(hasSnake(cell)) {
                    printValue += 'S';
                }
                int paddingValue = 5 - printValue.length();
                printValue += " ".repeat(paddingValue);

                if(row%2 == 0) {
                    boardRow += printValue;
                } else {
                    boardRow = printValue + boardRow;
                }
            }
            System.out.println(boardRow);
        }
        System.out.println(divider);
    }
}
