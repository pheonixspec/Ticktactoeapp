package com.tictactoe.uc;

import java.util.Random;

public class UC7ComputerMakesRandomMove {
    public static int makeRandomValidMove(char[][] board, Random random, char symbol) {
        while (true) {
            int slot = random.nextInt(9) + 1;
            int[] index = UC4SlotToIndex.toIndex(slot);
            int row = index[0];
            int col = index[1];

            if (UC5ValidateMove.isValidMove(board, row, col)) {
                UC6PlaceMove.placeMove(board, row, col, symbol);
                return slot;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = UC1DisplayBoard.createBoard();
        Random random = new Random();
        int slot = makeRandomValidMove(board, random, 'O');
        System.out.println("Computer chose slot: " + slot);
        UC1DisplayBoard.printBoard(board);
    }
}