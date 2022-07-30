package Striver_Dp_PlayList;

import java.util.Arrays;

public class Longest_Common_Subsequences {
    public static void main(String[] args) {
        /*Patterns --> Dp on Strings
      Comparison
      match not match
      Longest common
      Replace
         */
        String s1 = "ade";
        String s2 = "dea";
        //Op --> "adb" --> 3 longest common subsequences which maintains Order in both the String
    /*Intuition
        s1(0....2) signifies lcs between idx 0 to 2
        s2(0....2) signifies lcs between idx 0 to 2
     */
        rec("acd", "ced");
        /*Recurence
       if char matches --> Explore Single Path By Moving Both The Indexes
       if char does not  matches --> Explore two  Path By Moving idx1 then idx2  The Indexes
         */
        System.out.println(rec(s1, s2));
        System.out.println(Top_Down(s1, s2));
        System.out.println(Bu(s1, s2));
    }

    private static int rec(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        return helper(s1, s2, n - 1, m - 1);
    }

    //returns length of longest common subsequence in both the Strings
    private static int helper(String s1, String s2, int i, int j) {
//Base Case
        if (i == -1 || j == -1) {//end of the string
            return 0;
        }
        //Case 1---> If Both Index Matches
        int matched = 0, Unmatched = 0;
        if (s1.charAt(i) == s2.charAt(j)) {  //shrink both the strings
            return matched = helper(s1, s2, i - 1, j - 1) + 1;
        } else {
            int unmatched1 = helper(s1, s2, i - 1, j);
            int unmatched2 = helper(s1, s2, i, j - 1);
            return Unmatched = Math.max(unmatched1, unmatched2);
        }
    }

    private static int Top_Down(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        return helper(s1, s2, n - 1, m - 1, dp);
    }

    //Top down
    private static int helper(String s1, String s2, int i, int j, int[][] dp) {
//Base Case
        if (i == -1 || j == -1) {//end of the string
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        //Case 1---> If Both Index Matches
        if (s1.charAt(i) == s2.charAt(j)) {  //shrink both the strings
            return dp[i][j] = helper(s1, s2, i - 1, j - 1, dp) + 1;
        } else {
            int unmatched1 = helper(s1, s2, i - 1, j, dp);
            int unmatched2 = helper(s1, s2, i, j - 1, dp);
            return dp[i][j] = Math.max(unmatched1, unmatched2);
        }
    }

    /*
    Bottoms Up Rules
    1 . Copy The Base Case
    2.  Loops in Opposite Manner
    3. Copy the Recurrence
     */
    private static int Bu(String s1, String s2) {

        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        //seeding
        //Shifting of indx to han
        //-1 refers to 0 idx in dp
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][m] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {  //shrink both the strings
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int unmatched1 = dp[i - 1][j];
                    int unmatched2 = dp[i][j - 1];
                    dp[i][j] = Math.max(unmatched1, unmatched2);
                }
            }
        }
        Print_Lcs(dp,s1,s2);
        return dp[n][m];
    }

    // PRINT LCS --> Approach --> Reverse Traversal of filled dp Array
    private static void Print_Lcs(int[][] dp, String s1, String s2) {
        int n = s1.length(), m = s2.length(), i = n, j = m;
        String ss = "";
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ss = s1.charAt(i - 1)+ss;
                i--;
                j--;
            } else {
                //Move in the direction of getting max
                if (dp[i][j - 1] > dp[i - 1][j]) {
                        j--;
                } else {
                    i--;
                }
            }
        }
        System.out.println(ss);
    }
}
