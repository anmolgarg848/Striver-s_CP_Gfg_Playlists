package Recursion_BackTracking;

public class Knight_Tour_Problem {
    public static void main(String[] args) {
        // Count Number of ways to Place K Knights on  M*N Board so that they Don't Kill Each Other
        int n = 3, m = 3, k = 5;
        boolean[][] board = new boolean[n][m];
        System.out.println(K_Knights(board, k, n, m, 0, 0));
    }

    static int a = 0;

    //returns Count
    private static int K_Knights(boolean[][] board, int k, int n, int m, int col, int sr) {
        //Base Case
        if (k == 0) {
            return 1;
        }
        if (col == m) {
            col = 0;
            return 0;
        }
        int cnt = 0;
        for (int r = sr; r < n; r++) {
            if (isSafe(board, r, col)) {

                board[r][col] = true;
                cnt += K_Knights(board, k - 1, n, m, col + 1, sr);
                board[r][col] = false;
            }
        }
        return cnt;
    }

    private static boolean isSafe(boolean[][] board, int r, int c) {
        int m = board.length;
        int n = board[0].length;
        if ((r + 2) < m && (c - 1) >= 0 && board[r + 2][c - 1] == true) {
            return false;
        }
        if ((r - 2) >= 0 && (c - 1) >= 0 && board[r - 2][c - 1] == true) {
            return false;
        }
        if ((r + 2) < m && (c + 1) < n && board[r + 2][c + 1] == true) {
            return false;
        }
        if ((r - 2) >= 0 && (c + 1) < n && board[r - 2][c + 1] == true) {
            return false;
        }
        if ((r + 1) < m && (c + 2) < n && board[r + 1][c + 2] == true) {
            return false;
        }
        if ((r - 1) >= 0 && (c + 2) < n && board[r - 1][c + 2] == true) {
            return false;
        }
        if ((r + 1) < m && (c - 2) >= 0 && board[r + 1][c - 2] == true) {
            return false;
        }
        if ((r - 1) >= 0 && (c - 2) >= 0 && board[r - 1][c - 2] == true) {
            return false;
        }


        return true;
    }
}