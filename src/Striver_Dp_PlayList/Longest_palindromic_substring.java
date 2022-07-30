package Striver_Dp_PlayList;

public class Longest_palindromic_substring {
    public static void main(String[] args) {
        String s = "abcdefaabaa";
        String rev = new StringBuilder(s).reverse().toString();
        System.out.println(Bu(s,rev));
        //Just fill the dp as per LCS and Take max of it and follows Consecutive Path to Print that String
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
        int r = 0, c = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {  //shrink both the strings
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        r = i;
                        c = j;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(r + " " + c);
        String ans = "";
        int cnt = max;
        while (r > 0 && c > 0 && cnt > 0) {
            ans = s1.charAt(r - 1) + ans;
            r--;
            c--;
            cnt--;
        }
        System.out.println(ans);
        return max;
    }

}
