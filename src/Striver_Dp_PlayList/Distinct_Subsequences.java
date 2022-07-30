package Striver_Dp_PlayList;

import java.util.Arrays;

public class Distinct_Subsequences {
    public static void main(String[] args) {
//        pattern String Matching
        //cnt Number of Distinct Subsequences in s
        String s = "babgbag";
        String t = "bag";
    /*Intuition
    Have to follow different Methadologies of comparing
     */
        int n = s.length(), m = t.length();
        System.out.println(dist(s, t, n - 1, m - 1));
        int[][] dp = new int[n][m];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        System.out.println(dist(s, t, n - 1, m - 1, dp));
//        System.out.println(Arrays.toString(dp[n-1]));
        System.out.println(Bu(s,t));
    }

    private static int dist(String s, String t, int i, int j) {
        //Base Case
        if (j == -1) {
            return 1;
        }
        if (i == -1) {
            return 0;
        }
        //Case 1 --> If Matches
        if (s.charAt(i) == t.charAt(j)) {
            int pick = dist(s, t, i - 1, j - 1);
            int noTpiCk = dist(s, t, i - 1, j);
            return pick + noTpiCk;
        } else {
            return dist(s, t, i - 1, j);
        }

    }

    private static int dist(String s, String t, int i, int j, int[][] dp) {
        //Base Case
        if (j == -1) {
            return 1;
        }
        if (i == -1) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];
        //Case 1 --> If Matches
        if (s.charAt(i) == t.charAt(j)) {
            int pick = dist(s, t, i - 1, j - 1);
            int noTpiCk = dist(s, t, i - 1, j);
            return dp[i][j] = pick + noTpiCk;
        } else {
            return dp[i][j] = dist(s, t, i - 1, j);
        }

    }

    private static int Bu(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        //shifting dp to handle base case as -1
        for (int r = 0; r <=n; r++) {
            dp[r][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    int pick = dp[i - 1][j - 1];
                    int noTpiCk = dp[i - 1][j];
                    dp[i][j] = pick + noTpiCk;
                } else {
                    dp[i][j] = dp[i - 1][j ];
                }
            }
        }
        System.out.println(Arrays.toString(dp[n-1]));
        return dp[n][m];
    }
}