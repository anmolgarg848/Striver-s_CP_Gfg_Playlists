package Striver_Dp_PlayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Longest_Palindromic_subsequence {
    public static void main(String[] args) {
        String s = "bbbab";
        //Output --> bbbb
        System.out.println(longestPalindromeSubseq(s));
    }

    public static int longestPalindromeSubseq(String s) {
        //Approach lcs
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n][n];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        int len = helper(s, rev, n - 1, n - 1, dp);
        return len;
    }


    private static int helper(String s1, String s2, int i, int j, int[][] dp) {
        if (i == -1 || j == -1) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        //Case 1--> Matches
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = helper(s1, s2, i - 1, j - 1, dp) + 1;
        } else {
            return dp[i][j] = Math.max(helper(s1, s2, i, j - 1, dp), helper(s1, s2, i - 1, j, dp));
        }
    }

    private static int helper(String s1, String s2, int i, int j) {
        if (i == -1 || j == -1) return 0;

        //Case 1--> Matches
        if (s1.charAt(i) == s2.charAt(j)) {
            return helper(s1, s2, i - 1, j - 1) + 1;
        } else {
            return Math.max(helper(s1, s2, i, j - 1), helper(s1, s2, i - 1, j));
        }
    }
    //try Bu Approach

    //Print the Longest Palindromic Substring
//already implemented in lcs


}
