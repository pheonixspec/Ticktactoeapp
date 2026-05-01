package com.tictactoe.uc;

public class UC10DetectDrawCondition {
    public static boolean isDraw(char[][] board) {
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
        char[][] board = {
                {'X', 'O', 'X'},
                {'X', 'O', 'O'},
                {'O', 'X', 'X'}
        };
        System.out.println(isDraw(board));
    }
}