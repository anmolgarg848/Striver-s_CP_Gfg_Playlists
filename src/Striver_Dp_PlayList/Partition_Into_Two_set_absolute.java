package Striver_Dp_PlayList;

import java.util.Arrays;

public class Partition_Into_Two_set_absolute {
    public static void main(String[] args) {
        //Partition a set into Two Subset such that The Absolute Difference of subset's sum is Minimum
        int[] arr = {1, 2, 3, 4, 5, 8, 9, 6, 23, 10, 85, 0, 0, 0, 0, 8};
        int n = arr.length;
        System.out.println(rec(arr, n - 1, 0, 0));
        int tot = 0;
        for (int ele : arr) tot += ele;
        int[][] dp = new int[n][tot + 1];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        System.out.println(top_down(arr, n - 1, 0, 0, dp));
        System.out.println(Bu(arr,tot));
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
/*
GAAND FAAD APPROACH
tabulation of subset sum signifies -->   target is achievable or not for s1
so s2  = tot_sum-tar;
take minimum of it
 */
    private static int Bu(int[] arr, int tar) {
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
        int min_abs_diff = Integer.MAX_VALUE;
        int tot_sum = tar;
        for (int i = 0; i <= tar; i++) {
            if (dp[n - 1][i]) { //target is Achievable after Partition
                int s1 = i;
                int s2 = tot_sum - s1;
                min_abs_diff = Math.min(min_abs_diff, Math.abs(s2 - s1));
            }
        }
        return min_abs_diff;
    }

}
