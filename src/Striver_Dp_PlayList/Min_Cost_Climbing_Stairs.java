package Striver_Dp_PlayList;

import java.util.Arrays;

public class Min_Cost_Climbing_Stairs {
    public static void main(String[] args) {
/*
Either 1 or 2 Step
 */
        int[] arr = {10, 15, 20};
//        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int n = arr.length;
        int ans = Math.min(rec(arr, n - 1), rec(arr, n - 2));
        System.out.println(ans);
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int a = Top_Down(arr, n - 1, dp);
        Arrays.fill(dp, -1);
        int b = Top_Down(arr, n - 2, dp);
        System.out.println(Math.min(a, b));

    }

    private static int rec(int[] arr, int idx) {
        if (idx == 0) return arr[idx];
        if (idx < 0) return 0;//reached
        int j1 = rec(arr, idx - 1) + arr[idx];
        int j2 = Integer.MAX_VALUE;
        if (idx > 0) {
            j2 = rec(arr, idx - 2) + arr[idx];
        }
        return Math.min(j1, j2);
    }

    private static int Top_Down(int[] arr, int idx, int[] dp) {
        if (idx == 0) return arr[idx];
        if (idx < 0) return 0;//reached
        if (dp[idx] != -1) return dp[idx];
        int j1 = rec(arr, idx - 1) + arr[idx];
        int j2 = Integer.MAX_VALUE;
        if (idx > 0) {
            j2 = rec(arr, idx - 2) + arr[idx];
        }
        return dp[idx] = Math.min(j1, j2);
    }

    private static int Bu(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        //Write Your Code Here --> Try It By Your Self
        return dp[n-1];
    }

}
