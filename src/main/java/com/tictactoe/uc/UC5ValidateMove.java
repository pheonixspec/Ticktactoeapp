package com.tictactoe.uc;

public class UC5ValidateMove {
    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        return board[row][col] == '-';
    }

    public static void main(String[] args) {
        char[][] board = UC1DisplayBoard.createBoard();
        System.out.println(isValidMove(board, 1, 1));
    }
}
