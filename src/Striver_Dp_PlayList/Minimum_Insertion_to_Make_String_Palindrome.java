package Striver_Dp_PlayList;

public class Minimum_Insertion_to_Make_String_Palindrome {
    public static void main(String[] args) {
        /*INTUITION
        Just reverse and add Gives Maximum insertion as n
        Minimize it --> Insert In Middle of Longest Palindromic sequence

         */
    }

    public int minInsertions(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int len = Bu(s, rev);
      return   n - len;
    }

    private static int Bu(String s1, String s2) {
        int n = s1.length(), m = s2.length(), max = 0;
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
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return max;
    }

}
