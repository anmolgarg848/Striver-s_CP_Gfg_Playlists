package Striver_Dp_PlayList;

import java.util.Arrays;

public class Partition_Equal_Subset_Sum {
    public static void main(String[] args) {
        //https://leetcode.com/problems/partition-equal-subset-sum/
        int[] arr = {0, 2, 3, 5};
        int n = arr.length;
        if (n % 2 == 1) return; //As Odd length can not be Divisible
        System.out.println(canPartition(arr));
        int tot_sum = 0;
        for (int ele : arr) tot_sum += ele;
        int[][] dp = new int[n][tot_sum + 1];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        System.out.println(Top_Down(arr, tot_sum, 0, n - 1, dp));
        System.out.println(Bu(arr,tot_sum/2));
    }

    public static boolean canPartition(int[] arr) {
        int n = arr.length;
        return helper(arr, 0, 0, n - 1);
    }

    //Approach Pick Not Pick
    private static boolean helper(int[] arr, int sum1, int sum2, int idx) {
        if ((sum1 == sum2) && idx == -1) return true;
        if (idx == -1) return false;
        boolean s1 = helper(arr, sum1 + arr[idx], sum2, idx - 1);
        boolean s2 = helper(arr, sum1, sum2 + arr[idx], idx - 1);

        return s1 || s2;
    }

    //Approach Pick Not Pick
    private static boolean Top_Down(int[] arr, int tot_sum, int sum, int idx, int[][] dp) {
        if (( sum == tot_sum/2) && idx == -1) return true;
        if (idx == -1) return false;
        if (dp[idx][sum] != -1) return dp[idx][sum] == 1 ? true : false;
        boolean np = Top_Down(arr, tot_sum, sum, idx - 1, dp);
        boolean p = Top_Down(arr, tot_sum, sum + arr[idx], idx - 1, dp);
        dp[idx][sum] = (np || p) == true ? 1 : 0;
        return np || p;
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
