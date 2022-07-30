package Striver_Dp_PlayList;

import java.util.Arrays;

public class Minimum_Coins {
    public static void main(String[] args) {
        //Given an array(types of coins) returns the Count of Minimum Number of Coins Required to Form The Particular
        // Target
        //Infinite supply
        int[] arr = {1, 2, 3,4,4};
        int tar = 7;
        int n = arr.length;
        System.out.println(rec(arr, tar, n - 1));
        int[][] dp = new int[n][tar + 1];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        System.out.println(Top_Down(arr, tar, n - 1, dp));
        System.out.println(Bu(arr,tar));
    }

    private static int rec(int[] coins, int tar, int idx) {
        if (idx == 0) {
            if (tar % coins[0] == 0) {
                return tar / coins[0]; //pick
            }
            return Integer.MAX_VALUE;
        }
        int np = rec(coins, tar, idx - 1);
        int p = Integer.MAX_VALUE;
        if (coins[idx] <= tar) {
            p = rec(coins, tar - coins[idx], idx) + 1;
        }
        return Math.min(p, np);
    }

    private static int Top_Down(int[] coins, int tar, int idx, int[][] dp) {
        if (idx == 0) {
            if (tar % coins[0] == 0) {
                return tar / coins[0]; //pick
            }
            return Integer.MAX_VALUE;
        }
        if (dp[idx][tar] != -1) return dp[idx][tar];
        int np = Top_Down(coins, tar, idx - 1, dp);
        int p = Integer.MAX_VALUE;
        if (coins[idx] <= tar) {
            p = Top_Down(coins, tar - coins[idx], idx, dp) + 1;
        }
        return dp[idx][tar] = Math.min(p, np);
    }

    private static int Bu(int[] coins, int tar) {
        int n = coins.length;
        int[][] dp = new int[n][tar + 1];
//seeding
        for (int t = 0; t <= tar; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = t / coins[0];
            }
        }
        for (int r = 1; r < n; r++) {
            for (int t = 0; t <= tar; t++) {
                int np = dp[r - 1][t];
                int p = Integer.MAX_VALUE;
                if (coins[r] <= t) {
                    p = dp[r][t - coins[r]] + 1;
                }
                dp[r][t] = Math.min(p, np);
            }
        }
        return dp[n - 1][tar];
    }
}
