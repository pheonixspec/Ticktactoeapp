package com.tictactoe.uc;

public class UC8ContinuousTurnBasedGameLoop {
    public static String switchPlayer(String currentPlayer) {
        return currentPlayer.equals("User") ? "Computer" : "User";
    }

    public static void main(String[] args) {
        String currentPlayer = "User";
        currentPlayer = switchPlayer(currentPlayer);
        System.out.println("Next player: " + currentPlayer);
    }
}