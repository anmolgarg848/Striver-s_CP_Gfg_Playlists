package Striver_Dp_PlayList;

public class Shortest_Common_SuperSequence {
    public static void main(String[] args) {
        //https://leetcode.com/problems/shortest-common-supersequence/
        String s1 = "brute";
        String s2 = "groot";
        //Op--> bgruoote
        //Approach --> longest common subsequence
        scs(s1, s2);
    }

    private static void scs(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        //1 - indexed

        //fill dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //Print scs
        //Traversing dp from last
        String ans = "";
        //Move until  one got Exhausted
        int r = n, c = m;
        while (r > 0 && c > 0) {
            //Case 1 --> Both Matches
            if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                ans = s1.charAt(r - 1) + ans;
                r--;
                c--;
            } else {
                //add char and shrink string from there you get max

                if (dp[r - 1][c] > dp[r][c - 1]) {
                    ans = s1.charAt(r - 1) + ans;
                    r--;
                } else {
                    ans = s2.charAt(c - 1) + ans;
                    c--;
                }
            }
        }
        //rest of the part
        while (r != 0) {
            ans = s1.charAt(r - 1) + ans;
            r--;
        }while (c != 0) {
            ans = s2.charAt(c - 1) + ans;
            c--;
        }
        System.out.println(ans);
    }
}