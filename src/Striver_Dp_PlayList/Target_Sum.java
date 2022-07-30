package Striver_Dp_PlayList;

import java.util.Arrays;

public class Target_Sum {
    public static void main(String[] args) {
        //How Many Ways You can Assign Signs Such That you achieve a Given Target
        int[] arr = {1, 1, 1, 1, 1};
        int tar = 3;
        int n = arr.length;
//either +ve or -ve
  /*
  Boils Down to s1 - s2 = Diff
  cnt partition with Given Diff
   */
        int tot = 0;
        for (int ele : arr) tot += ele;
        int[][] dp = new int[n][tot+2];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        System.out.println(Bu(arr,(tot-tar)/2));
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
