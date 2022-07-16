package Recursion_BackTracking;

import java.util.Arrays;

public class N_Queen {
    public static void main(String[] args) {
// Place N queens in N*N matrix /board such that No two Queens Can Kill Each Other
        int N = 9;
        char[][] board = new char[N][N];
        for (char[] ls : board) {
            Arrays.fill(ls, '.'); //Represents all cells are Empty
        }

        System.out.println(N_Queen(board, 0, N));
    }


    /*Points
    Placing Queens Row Wise Vertically Not Horizontally
    single row and col can have single Queen
     */

    private static int N_Queen(char[][] board, int col, int n) {
        if (col == n) {
            //means all Queens are Placed
            //Col is Only Moving after Placing Queen
            for (char[] ls : board) {
                System.out.println(Arrays.toString(ls));
            }

            System.out.println("=======================");
            return 1;
        }
        int cnt = 0;
        for (int ro = 0; ro < n; ro++) {
            if (isSafe(board, ro, col)) {
                //Place Queen
                board[ro][col] = 'Q';
                //Go and PLace Other Queens
                cnt += N_Queen(board, col + 1, n);
                //BackTrack
                board[ro][col] = '.';
            }
        }
        return cnt;
    }

    private static boolean isSafe(char[][] board, int r, int c) {
//As Queen can Kill in All 8  directions
        //But as per the Direction we are Filling Board from L-->R AND UP--> DOWN
        //we need to check Only

        //Upper Left Diagonal
        int uld_r = r, uld_c = c;
        while (uld_r >= 0 && uld_c >= 0) {
            if (board[uld_r][uld_c] == 'Q') return false;
            uld_c--;
            uld_r--;
        }

        //Lower left Diagonal
        int lld_r = r, lld_c = c;
        while (lld_r < board.length && lld_c >= 0) {
            if (board[lld_r][lld_c] == 'Q') return false;
            lld_c--;
            lld_r++;
        }
        //Left Row
        int lr_r = r, lc_c = c;
        while (lc_c >= 0) {
            if (board[lr_r][lc_c] == 'Q') return false;
            lc_c--;
        }
        return true;
    }
}
