package Striver_Dp_PlayList;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        // 0  1  1  2 3  5  8 13 21  . .  . .
        int n = 21;
        System.out.println(rec(n));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(Top_Down(n, dp));
        System.out.println(Bu(n));
    }

    //Recursive Approach --> Contains OverLapping Sub-Problems
    private static int rec(int n) {
        if (n < 2) return n;
        return rec(n - 1) + rec(n - 2);
    }

    //Top Down
    private static int Top_Down(int n, int[] dp) {
        if (n < 2) return n;
        //Use
        if (dp[n] != -1) return dp[n];
        //Memoize
        return dp[n] = Top_Down(n - 1, dp) + Top_Down(n - 2, dp);
    }

    //Bottoms Up
    private static int Bu(int n) {
        int[] dp = new int[n + 1];
        //seeding
        dp[1] = 1;
        for (int i = 2; i <=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
