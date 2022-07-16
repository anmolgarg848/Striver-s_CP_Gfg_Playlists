package Striver_Dp_PlayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        //https://leetcode.com/problems/triangle/
        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        int n = triangle.length, m = triangle[n - 1].length;
        System.out.println(rec(triangle, 0, 0, n, m));
        int[][] dp = new int[n][m];
        for (int[] ls : dp) Arrays.fill(ls, -1);

        System.out.println(Top_Down(triangle, 0, 0, n, m, dp));
        System.out.println(Bu(triangle));
    }

    //returns Minimum Path sum either i or i+1
    private static int rec(int[][] triangle, int sr, int sc, int er, int ec) {
        //Base Case
        if (sr == er - 1) {
            return triangle[sr][sc];
        }
        if (sr == er || sc == ec) return Integer.MAX_VALUE;

        int J1 = rec(triangle, sr + 1, sc, er, ec) + triangle[sr][sc];
        int J2 = rec(triangle, sr + 1, sc + 1, er, ec) + triangle[sr][sc];
        return Math.min(J1, J2);
    }

    //Top Down
    private static int Top_Down(int[][] triangle, int sr, int sc, int er, int ec, int[][] dp) {
        //Base Case
        if (sr == er - 1) {
            return triangle[sr][sc];
        }
        if (sr == er || sc == ec) return Integer.MAX_VALUE;
        if (dp[sr][sc] != -1) return dp[sr][sc];
        int J1 = Top_Down(triangle, sr + 1, sc, er, ec, dp) + triangle[sr][sc];
        int J2 = Top_Down(triangle, sr + 1, sc + 1, er, ec, dp) + triangle[sr][sc];
        return dp[sr][sc] = Math.min(J1, J2);
    }

    private static int Bu(int[][] triangle) {
        int n = triangle.length, m = triangle[n - 1].length;
        int[][] dp = new int[n][m];
        //seeding
        for (int i = 0; i < m; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }
        for (int r = n - 2; r >= 0; r--) {
            for (int c = r; c >=0; c--) {
                int J1 = dp[r + 1][c] + triangle[r][c];
                int  J2 = dp[r + 1][c + 1] + triangle[r][c];
                dp[r][c] = Math.min(J1, J2);
            }
        }
        return dp[0][0];
    }
}