package Striver_Dp_PlayList;

import java.util.*;

public class Minimum_Path_sum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int n = grid.length;
        int m = grid[0].length;
        System.out.println(rec(grid, n - 1, m - 1));
        int[][] dp = new int[n][m];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        System.out.println(Top_Down(grid, n - 1, m - 1, dp));
        System.out.println(Bu(grid));
    }

    //Greedy Fails Bcoz of Uniformity Not Present In Data
    private static int rec(int[][] grid, int n, int m) {
        if (n == 0 && m == 0) {
            return grid[n][m];
        }
        if (n < 0 || m < 0) {
            return 10001;
        }
        int up = rec(grid, n - 1, m) + grid[n][m];
        int left = rec(grid, n, m - 1) + grid[n][m];

        return Math.min(up, left);
    }
    //Top - down Approach

    private static int Top_Down(int[][] grid, int n, int m, int[][] dp) {
        if (n == 0 && m == 0) {
            return grid[n][m];
        }
        if (n < 0 || m < 0) {
            return 100001;
        }
        if (dp[n][m] != -1) return dp[n][m];
        int up = Top_Down(grid, n - 1, m, dp) + grid[n][m];
        int left = Top_Down(grid, n, m - 1, dp) + grid[n][m];

        return dp[n][m] = Math.min(up, left);
    }

    private static int Bu(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = grid[0][0];
                } else {
                    int up = 10001, left = 10001;
                    if (row  > 0){
                        up = dp[row - 1][col] + grid[row][col];
                    }
                    if (col > 0) {
                        left = dp[row][col - 1] + grid[row][col];
                    }
                    dp[row][col] = Math.min(up, left);
                }
            }

        }
        return dp[n - 1][m - 1];
    }
}
