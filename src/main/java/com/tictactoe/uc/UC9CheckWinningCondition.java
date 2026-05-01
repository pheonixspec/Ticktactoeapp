package com.tictactoe.uc;

public class UC9CheckWinningCondition {
    public static boolean hasWon(char[][] board, char symbol) {
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

    public static void main(String[] args) {
        char[][] board = UC1DisplayBoard.createBoard();
        UC6PlaceMove.placeMove(board, 0, 0, 'X');
        UC6PlaceMove.placeMove(board, 0, 1, 'X');
        UC6PlaceMove.placeMove(board, 0, 2, 'X');
        System.out.println(hasWon(board, 'X'));
    }
}