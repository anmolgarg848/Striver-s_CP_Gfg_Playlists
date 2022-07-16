package Striver_Dp_PlayList;

import java.util.Arrays;

public class Climbing_Stairs {
    public static void main(String[] args) {
//Return Number of Distinct Ways to reach nth stair you can either Climb  1 or 2 step
        int n = 26;
        System.out.println(rec(n));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(Top_Down(n, dp));
        System.out.println(Bu(n));
    }

    private static int rec(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) return 0;
        return rec(n - 1) + rec(n - 2);
    }

    private static int Top_Down(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];
        return dp[n] = Top_Down(n - 1, dp) + Top_Down(n - 2, dp);
    }

    private static int Bu(int n) {
        int[] dp = new int[n + 1];
        //seeding
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
