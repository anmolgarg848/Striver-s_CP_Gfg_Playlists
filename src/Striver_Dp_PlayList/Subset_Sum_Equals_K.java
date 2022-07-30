package Striver_Dp_PlayList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Subset_Sum_Equals_K {
    public static void main(String[] args) {
        /*
        Return True If There Exists Subset sum equals to k In an Array
        Brute Force --> Generate All The Subsequences and Check the sum
        Using --> Recursion || Power Set
         */
        int[] arr = {11, 2, 3, 4};
        int k = 11;
        int n = arr.length;
        System.out.println(rec(arr, k, n - 1));
        int[][] dp = new int[n][k + 1];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        System.out.println(Top_Down(arr, k, n - 1, dp));
        System.out.println(Arrays.toString(dp[n - 1]));
        System.out.println(Bu(arr, k));
    }

    //Approach --> Pick And Not Pick
    private static boolean rec(int[] arr, int k, int idx) {
        if (k == 0) return true;
        if (idx == -1) return false;
        boolean np = rec(arr, k, idx - 1);
        boolean p = rec(arr, k - arr[idx], idx - 1);
        return np || p;
    }

    //Top Down
    private static boolean Top_Down(int[] arr, int k, int idx, int[][] dp) {
        //1  --> True 0 --> False
        if (k == 0) return true;
        if (idx == -1) return false;
        if (dp[idx][k] != -1) {
            return dp[idx][k] == 1 ? true : false;
        }
        boolean np = Top_Down(arr, k, idx - 1, dp);
        boolean p = false;
        if (arr[idx] <= k) { //pick Only when ele is <= cur Target
            p = Top_Down(arr, k - arr[idx], idx - 1, dp);
        }
        dp[idx][k] = (np | p) == true ? 1 : 0;
        return dp[idx][k] >= 1 ? true : false;
    }

    private static boolean Bu(int[] arr, int tar) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][tar + 1];
//seeding
        //if tar is 0 then just Dont select Anything
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;
        for (int r = 1; r < n; r++) {
            for (int t = 1; t <= tar; t++) {
                boolean np = dp[r - 1][t];
                boolean p = false;
                if (arr[r] <= t) { //pick Only when ele is <= cur Target
                    p = dp[r - 1][t - arr[r]];
                }
                dp[r][t] = np | p;
            }
        }
        return dp[n - 1][tar];
    }
}
