package Striver_Dp_PlayList;

public class Count_Partition_With_Given_Diff {
    public static void main(String[] args) {
        /*Condition
        s1>=s2  , s1-s2 = diff
        s1>s2 so it can be s1 = tot_sum-s2;
         */
        int[] arr = {5, 2, 6, 4};
        int n = arr.length;
        int diff = 3;
        int tot_sum = 0;
        for (int ele : arr) tot_sum += ele;
        //Boils Down  to cnt of  subset sum  with Modified Target
            int tar = (tot_sum-diff)/2;//s1>s2 so it can be s1 = tot_sum-s2;
        System.out.println(Bu(arr,tar));
        /*Variation 2 Given
        s1 - s2  = diff
        s1 + s2 = tot_sm
        s1 = tot_sum - s2;

        s1 = (tot_sum-diff)/2

         */
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