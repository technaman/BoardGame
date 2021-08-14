package com.ngdev.SnakeLadder;

import com.ngdev.user.User;
import com.ngdev.Games.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnakeLadderPlayer extends Player {
    private User user;
    private String symbol;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public SnakeLadderPlayer(User user, String symbol) {
        this.user = user;
        this.symbol = symbol;
    }

    @Override
    public SnakeLadderMove generateMove() {
        int diceRoll = 0;
        try {
            System.out.println("Dear " + user.getName() + ". Please roll the dice.");
            diceRoll = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(this.toString() + " and I rolled a " + diceRoll);
        return new SnakeLadderMove(diceRoll);
    }

    @Override
    public String toString() {
        return "hi, I'm " + user.getName();
    }
}
