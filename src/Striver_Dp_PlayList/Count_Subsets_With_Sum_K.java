package Striver_Dp_PlayList;

import java.util.Arrays;

public class Count_Subsets_With_Sum_K {
    public static void main(String[] args) {
        int[] arr = {3, 5, 5, 3, 1, 3};
        int k = 10, n = arr.length;
        System.out.println(rec(arr, k, n - 1));
        int[][] dp = new int[n][k + 1];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        System.out.println(Top_Down(arr, k, n - 1, dp));
        System.out.println(Bu(arr, k));
        /*
        To Handle Zeroes Just Add all the Possible subsets from zero
        {0,0}
        int ans*=pow(2,number of zeroes)
         */
    }

    private static int rec(int[] arr, int k, int idx) {
        if (k == 0) {
            return 1;
        }
        if (idx == -1) {
            return 0;
        }
        int np = rec(arr, k, idx - 1);
        int p = 0;
        if (arr[idx] <= k) {
            p = rec(arr, k - arr[idx], idx - 1);
        }
        return np + p;
    }

    //Top Down
    private static int Top_Down(int[] arr, int k, int idx, int[][] dp) {
//        if (k == 0) {
//            return 1;
//        }
//        if (idx == -1) {
//            return 0;
//        }
        //Base Case for consideration of zeroes Internally
        if (idx == 0) {
            //we have two Options Either Take or Not Take both Will not affect k
            if (k == 0 && arr[0] == 0) return 2;
            if (k==0||k==arr[0])return 1;
            return 0;
        }
        if (dp[idx][k] != -1) return dp[idx][k];
        int np = Top_Down(arr, k, idx - 1, dp);
        int p = 0;
        if (arr[idx] <= k) {
            p = Top_Down(arr, k - arr[idx], idx - 1, dp);
        }
        return dp[idx][k] = np + p;
    }

    private static int Bu(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];
        //seeding
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1; //if k is 0 then don't pick any ele
        }
        dp[0][arr[0]] = 1;
        for (int r = 1; r < n; r++) {
            for (int c = 1; c <= k; c++) {
                int np = dp[r - 1][c];
                int p = 0;
                if (arr[r] <= c) {
                    p = dp[r - 1][c - arr[r]];
                }
                dp[r][c] = np + p;
            }
        }
        return dp[n - 1][k];
    }
}
