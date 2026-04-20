package com.tictactoe.uc;

import java.util.Random;

public class UC2TossAndSymbols {
    public static class TossResult {
        public final String firstPlayer;
        public final char userSymbol;
        public final char computerSymbol;

        public TossResult(String firstPlayer, char userSymbol, char computerSymbol) {
            this.firstPlayer = firstPlayer;
            this.userSymbol = userSymbol;
            this.computerSymbol = computerSymbol;
        }
    }

    public static TossResult toss() {
        Random random = new Random();
        boolean userFirst = random.nextBoolean();
        if (userFirst) {
            return new TossResult("User", 'X', 'O');
        }
        return new TossResult("Computer", 'O', 'X');
    }

    public static void main(String[] args) {
        TossResult result = toss();
        System.out.println("First Player: " + result.firstPlayer);
        System.out.println("User Symbol: " + result.userSymbol);
        System.out.println("Computer Symbol: " + result.computerSymbol);
    }
}
