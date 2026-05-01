package com.tictactoe.uc;

public class UC6PlaceMove {
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public static void main(String[] args) {
        char[][] board = UC1DisplayBoard.createBoard();
        placeMove(board, 1, 1, 'X');
        UC1DisplayBoard.printBoard(board);
    }
}