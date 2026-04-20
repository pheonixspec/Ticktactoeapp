package com.tictactoe;

import java.util.Random;
import java.util.Scanner;

import com.tictactoe.uc.UC1DisplayBoard;
import com.tictactoe.uc.UC2TossAndSymbols;
import com.tictactoe.uc.UC3ReadUserSlot;
import com.tictactoe.uc.UC4SlotToIndex;
import com.tictactoe.uc.UC5ValidateMove;

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

        while (true) {
            if (currentPlayer.equals("User")) {
                userMove();
            } else {
                computerMove();
            }

            UC1DisplayBoard.printBoard(board);

            char currentSymbol = currentPlayer.equals("User") ? userSymbol : computerSymbol;
            if (hasWinner(currentSymbol)) {
                System.out.println(currentPlayer + " wins");
                break;
            }

            if (isBoardFull()) {
                System.out.println("Draw");
                break;
            }

            currentPlayer = currentPlayer.equals("User") ? "Computer" : "User";
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

            board[row][col] = userSymbol;
            return;
        }
    }

    private void computerMove() {
        while (true) {
            int slot = random.nextInt(9) + 1;
            int[] index = UC4SlotToIndex.toIndex(slot);
            int row = index[0];
            int col = index[1];

            if (UC5ValidateMove.isValidMove(board, row, col)) {
                board[row][col] = computerSymbol;
                System.out.println("Computer chose slot: " + slot);
                return;
            }
        }
    }

    private boolean hasWinner(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }

        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
                || (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new TicTacToeGame().play();
    }
}
