package Striver_Dp_PlayList;

import java.util.Arrays;

public class House_Robber_I {
    public static void main(String[] args) {
        //Maximum sum of Non Adjacent elements
//        int[] arr = {2, 7, 9, 3, 1}; //Op--> 12--> 1 + 9 + 2
        int[] arr = {100, 2, 4, 200, 6};
//        int[] arr = {200, 500, 1000, 9, 6000};
        int n = arr.length;
        System.out.println(rec(arr, n - 1));
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(Top_Down(arr, n - 1, dp));

    }

    //Approach --> Pick , Not Pick
    private static int rec(int[] arr, int idx) {
        if (idx < 0) return 0;
        int not_pick = rec(arr, idx - 1);
        int pick = 0;
        pick = rec(arr, idx - 2) + arr[idx];
        return Math.max(pick, not_pick);
    }

    private static int Top_Down(int[] arr, int idx, int[] dp) {
        if (idx < 0) return 0;

        if (dp[idx] != -1) return dp[idx];
        int not_pick = Top_Down(arr, idx - 1, dp);
        int pick = 0;
        pick = Top_Down(arr, idx - 2, dp) + arr[idx];
        return dp[idx] = Math.max(pick, not_pick);
    }

    private static int Bu(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        //MAy be Later
        return dp[n - 1];
    }
}
