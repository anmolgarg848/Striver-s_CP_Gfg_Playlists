package Striver_Dp_PlayList;

import java.util.Arrays;

public class Partition_Into_Two_set_absolute {
    public static void main(String[] args) {
        //Partition a set into Two Subset such that The Absolute Difference of subset's sum is Minimum
        int[] arr = {1, 2, 3, 4, 5, -8, 9, 6, 23, 10, 85, 0, 0, 0, 0, -8};
        int n = arr.length;
        System.out.println(rec(arr, n - 1, 0, 0));
        int tot = 0;
        for (int ele : arr) tot += ele;
        int[][] dp = new int[n][tot + 1];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        System.out.println(top_down(arr, n - 1, 0, 0, dp));

    }

    //returns Minimum Absolute sum
    private static int rec(int[] arr, int idx, int sum1, int sum2) {
        if (idx == -1) {
            return Math.abs(sum1 - sum2);
        }
        int s1 = rec(arr, idx - 1, sum1 + arr[idx], sum2);
        int s2 = rec(arr, idx - 1, sum1, sum2 + arr[idx]);
        return Math.min(s1, s2);
    }

    //returns Minimum Absolute sum
    private static int top_down(int[] arr, int idx, int sum1, int sum2, int[][] dp) {
        if (idx == -1) {
            return Math.abs(sum1 - sum2);
        }
        if (dp[idx][sum1] != -1) return dp[idx][sum1];
        int s1 = rec(arr, idx - 1, sum1 + arr[idx], sum2);
        int s2 = rec(arr, idx - 1, sum1, sum2 + arr[idx]);
        return dp[idx][sum1] = Math.min(s1, s2);
    }
//===================================== Striver's Approach  ===============================



}
