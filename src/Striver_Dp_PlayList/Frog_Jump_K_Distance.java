package Striver_Dp_PlayList;

import java.util.Arrays;

public class Frog_Jump_K_Distance {
    public static void main(String[] args) {
//Its a Follow Up Of Frog Jump Problem
        // u can Jump till Kth Idx
//        int[] arr = {10, 20, 30, 10}; //Output ==> 20
        int[] arr = {30, 10, 60, 10, 60, 50};
        int n = arr.length;
        int k = 2;
        System.out.println(rec(arr, k, n - 1));
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(Top_Down(arr, k, n - 1, dp));

    }

    private static int rec(int[] arr, int k, int idx) {
        if (idx == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if ((idx - i) >= 0) {
                min = Math.min(min, rec(arr, k, idx - i) + Math.abs(arr[idx] - arr[idx - i]));
            }
        }
        return min;
    }

    private static int Top_Down(int[] arr, int k, int idx, int[] dp) {
        if (idx == 0) {
            return 0;
        }
        if (dp[idx] != -1) return dp[idx];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if ((idx - i) >= 0) {
                min = Math.min(min, Top_Down(arr, k, idx - i, dp) + Math.abs(arr[idx] - arr[idx - i]));
                dp[idx] = min;
            }
        }
        return dp[idx];
    }

    //Bottoms Up  Approach
    private static int Bu(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        //Try Later #Phir Kabhi
        return dp[n];
    }

}
