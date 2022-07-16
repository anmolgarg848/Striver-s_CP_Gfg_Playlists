package Striver_Dp_PlayList;

import java.util.Arrays;

public class Grid_Unique_Paths_II {
    public static void main(String[] args) {
        //With Obstacles

        int[][] grid = {{1, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int n = grid.length;
        int m = grid[0].length;
        System.out.println(rec(grid, n - 1, m - 1));
        int[][] dp = new int[n][m];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        System.out.println(Top_Down(grid, n - 1, m - 1, dp));
    }

    private static int rec(int[][] grid, int n, int m) {
        if (n == 0 && m == 0) {
            return 1;
        }
        if (n < 0 || m < 0 || grid[n][m] == 1 || grid[0][0] == 1) {
            return 0;
        }
        int up = rec(grid, n - 1, m);
        int right = rec(grid, n, m - 1);
        return up + right;
    }

    private static int Top_Down(int[][] grid, int n, int m, int[][] dp) {
        if (n == 0 && m == 0) {
            return 1;
        }
        if (n < 0 || m < 0 || grid[n][m] == 1 || grid[0][0] == 1) {
            return 0;
        }
        if (dp[n][m] != -1) return dp[n][m];
        int up = Top_Down(grid, n - 1, m, dp);
        int right = Top_Down(grid, n, m - 1, dp);
        return dp[n][m] = up + right;
    }

    private static int Bu(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
//Write Your Logic Here


        return dp[n - 1][m - 1];
    }
}
