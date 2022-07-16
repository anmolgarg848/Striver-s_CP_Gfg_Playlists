package Striver_Dp_PlayList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Nth_Tribonacci {
    public static void main(String[] args) {
//https://leetcode.com/problems/n-th-tribonacci-number/

        // 0  1 1  2  4  7  .  .  .
        int n = 25;
        System.out.println(rec(n));
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(Top_Down(n,dp));
    }

    private static int rec(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) return 1;
        return rec(n - 1) + rec(n - 2) + rec(n - 3);
    }

    private static int Top_Down(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) return 1;
        if (dp[n] != -1) return dp[n];
        return dp[n] = Top_Down(n - 1, dp) + Top_Down(n - 2, dp) + Top_Down(n - 3, dp);
    }
}

