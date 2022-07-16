package Striver_Dp_PlayList;

import java.util.Arrays;

public class Falling_Path {
    public static void main(String[] args) {
     /*Path Patterns
     fixed starting --> fixed ending
     fixed starting  --> Variable ending
     variable starting  -->  Variable ending
      */
        //Minimum and Maximum Path sum
/*Problem
Starting Point --> Any cell in First Row
Starting Point --> Any cell in Last Row
Directions  ---> Just Below , Diagonally Left , Diagonally Right
 */

        //When The Unformity is Not There U can Apply Something as Greedy
        int[][] arr = {{1, 2, 10, 4},
                {1, 3, 200, 2000},
                {1, 1, 20, 2},
                {1, 2, 2, 1}};
        int n = arr.length, m = arr[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(rec(arr, 0, i, n, m), ans);
        }
        System.out.println(ans);
        //==================== Top Down ====================
        int[][] dp = new int[n][m];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(Top_Down(arr, 0, i, n, m, dp), ans);
        }
        System.out.println(ans);
        System.out.println(Bu(arr));
    }

    //returns Maximum Path sum
    private static int rec(int[][] arr, int sr, int sc, int er, int ec) {
//Base Case
        if (sr == er || sc < 0 || sc == ec) return Integer.MAX_VALUE;
        if (sr == er - 1) {
            return arr[sr][sc];
        }
        //Moves
        int down = rec(arr, sr + 1, sc, er, ec) + arr[sr][sc];
        int left_diag = rec(arr, sr + 1, sc + 1, er, ec) + arr[sr][sc];
        int right_diag = rec(arr, sr + 1, sc - 1, er, ec) + arr[sr][sc];
        return Math.max(Math.max(down, left_diag), right_diag);
    }

    //Top Down
    private static int Top_Down(int[][] arr, int sr, int sc, int er, int ec, int[][] dp) {
//Base Case
        if (sr == er || sc < 0 || sc == ec) return Integer.MAX_VALUE;
        if (sr == er - 1) {
            return arr[sr][sc];
        }
        if (dp[sr][sc] != -1) return dp[sr][sc];
        //Moves
        int down = rec(arr, sr + 1, sc, er, ec) + arr[sr][sc];
        int left_diag = rec(arr, sr + 1, sc + 1, er, ec) + arr[sr][sc];
        int right_diag = rec(arr, sr + 1, sc - 1, er, ec) + arr[sr][sc];
        return dp[sr][sc] = Math.max(Math.max(down, left_diag), right_diag);
    }

    private static int Bu(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int[][] dp = new int[n][m];
        int ans = Integer.MIN_VALUE;
        //seeding
        for (int i = 0; i < n; i++) {
//            dp[0][i] = arr[0][i];
            dp[n - 1][i] = arr[n - 1][i];
        }

        for (int sr = n - 2; sr >= 0; sr--) {
            for (int sc = m - 1; sc >= 0; sc--) {
                int down = dp[sr + 1][sc] + arr[sr][sc];
                int left_diag = Integer.MIN_VALUE;
                if ((sc + 1) < m) {
                    left_diag = dp[sr + 1][sc+1] + arr[sr][sc];
                }
                int right_diag = Integer.MIN_VALUE;
                if ((sc - 1) > 0) {
                    right_diag = dp[sr + 1][sc - 1] + arr[sr][sc];
                }
                 dp[sr][sc] = Math.max(Math.max(down, left_diag), right_diag);
            }
        }
        for (int i = 0; i < m; i++) {
            ans = Math.max(dp[0][i],ans);
        }
        return ans;
    }
}
