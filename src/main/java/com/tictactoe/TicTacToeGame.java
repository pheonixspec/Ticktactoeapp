package com.tictactoe;

import java.util.Random;
import java.util.Scanner;

import com.tictactoe.uc.UC1DisplayBoard;
import com.tictactoe.uc.UC2TossAndSymbols;
import com.tictactoe.uc.UC3ReadUserSlot;
import com.tictactoe.uc.UC4SlotToIndex;
import com.tictactoe.uc.UC5ValidateMove;
import com.tictactoe.uc.UC6PlaceMove;
import com.tictactoe.uc.UC7ComputerMakesRandomMove;
import com.tictactoe.uc.UC8ContinuousTurnBasedGameLoop;
import com.tictactoe.uc.UC9CheckWinningCondition;
import com.tictactoe.uc.UC10DetectDrawCondition;

public class TicTacToeGame {
    private final char[][] board;
    private final Scanner scanner;
    private final Random random;
    private final char userSymbol;
    private final char computerSymbol;
    private String currentPlayer;

    public TicTacToeGame() {
        this.board = UC1DisplayBoard.createBoard();
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        UC2TossAndSymbols.TossResult tossResult = UC2TossAndSymbols.toss();
        this.currentPlayer = tossResult.firstPlayer;
        this.userSymbol = tossResult.userSymbol;
        this.computerSymbol = tossResult.computerSymbol;
    }

    public void play() {
        System.out.println("First Player: " + currentPlayer);
        System.out.println("User Symbol: " + userSymbol + " | Computer Symbol: " + computerSymbol);
        UC1DisplayBoard.printBoard(board);

        boolean gameOver = false;
        while (!gameOver) {
            if (currentPlayer.equals("User")) {
                userMove();
            } else {
                computerMove();
            }

            UC1DisplayBoard.printBoard(board);

            char currentSymbol = currentPlayer.equals("User") ? userSymbol : computerSymbol;
            if (UC9CheckWinningCondition.hasWon(board, currentSymbol)) {
                System.out.println(currentPlayer + " wins");
                gameOver = true;
                continue;
            }

            if (UC10DetectDrawCondition.isDraw(board)) {
                System.out.println("Draw");
                gameOver = true;
                continue;
            }

            currentPlayer = UC8ContinuousTurnBasedGameLoop.switchPlayer(currentPlayer);
        }
    }

    private void userMove() {
        while (true) {
            System.out.print("Enter slot (1-9): ");
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Invalid input");
                continue;
            }

            int slot = UC3ReadUserSlot.readSlot(scanner);
            if (slot < 1 || slot > 9) {
                System.out.println("Slot must be between 1 and 9");
                continue;
            }

            int[] index = UC4SlotToIndex.toIndex(slot);
            int row = index[0];
            int col = index[1];

            if (!UC5ValidateMove.isValidMove(board, row, col)) {
                System.out.println("Cell is not available");
                continue;
            }

            UC6PlaceMove.placeMove(board, row, col, userSymbol);
            return;
        }
    }

    private void computerMove() {
        int slot = UC7ComputerMakesRandomMove.makeRandomValidMove(board, random, computerSymbol);
        System.out.println("Computer chose slot: " + slot);
    }

    public static void main(String[] args) {
        new TicTacToeGame().play();
    }
}
