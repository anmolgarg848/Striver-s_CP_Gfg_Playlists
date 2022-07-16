package Striver_Dp_PlayList;

import java.util.Arrays;

public class Grid_Unique_Paths {
    public static void main(String[] args) {
        int n = 3, m = 7;
        System.out.println(rec(n - 1, m - 1));
        int[][] dp = new int[n][m];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        System.out.println(Top_Down(n - 1, m - 1, dp));
//        System.out.println(Arrays.toString(dp[n-1]));
        System.out.println(Bu(n,m));
    }

    private static int rec(int n, int m) {
        if (n == 0 && m == 0) {
            return 1;
        }
        if (n < 0 || m < 0) return 0;

        int up = rec(n - 1, m);
        int left = rec(n, m - 1);
        return up + left;
    }

    private static int Top_Down(int n, int m, int[][] dp) {
        if (n == 0 && m == 0) {
            return 1;
        }
        if (n < 0 || m < 0) return 0;
        if (dp[n][m] != -1) return dp[n][m];
        int up = Top_Down(n - 1, m, dp);
        int left = Top_Down(n, m - 1, dp);
        return dp[n][m] = up + left;
    }

    private static int Bu(int n, int m) {
        int[][] dp = new int[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (row == 0 && col == 0) {
                    dp[0][0] = 1;
                } else {
                    int up = 0, left = 0;
                    if (row > 0) {
                        up = dp[row - 1][col];
                    }
                    if (col > 0) {
                        left = dp[row][col - 1];
                    }
                    dp[row][col] = up + left;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}