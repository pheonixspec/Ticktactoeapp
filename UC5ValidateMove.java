public class UC5ValidateMove {
    public static char[][] createBoard() {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        return board;
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        return board[row][col] == '-';
    }

    public static void main(String[] args) {
        char[][] board = createBoard();
        System.out.println(isValidMove(board, 1, 1));
    }
}
