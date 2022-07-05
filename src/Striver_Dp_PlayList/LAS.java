package Striver_Dp_PlayList;

public class LAS {
    public static void main(String[] args) {
        //Longest Alternating Sub-Sequence
        //https://leetcode.com/problems/wiggle-subsequence/
        int[] arr = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int n = arr.length;
        System.out.println(wiggleMaxLength(arr));
    }

    //Approach --> Increasing Decreasing
    public static int wiggleMaxLength(int[] arr) {
        int n = arr.length, inc = 1, dec = 1;
        for (int i = 0; i < n - 1; i++) {
            //case 1 --> Inc
            if (arr[i] < arr[i + 1]) {
                inc = dec + 1;
            }
            //case 2 --> Dec
            if (arr[i] > arr[i + 1]) {
                dec = inc + 1;
            }
        }
        return Math.max(inc, dec);
    }
    //https://leetcode.com/problems/maximum-alternating-subsequence-sum/
    //DP [4,2,5,3]   [5,6,7,8]
    public long maxAlternatingSum(int[] arr, int idx, int even_odd) { //Recursive Approach --> Pick and Not Pick
        if (idx == arr.length) {
            return 0;
        }
        long np = maxAlternatingSum(arr, idx + 1, even_odd);
        long p = 0;
        if (even_odd == -1 || even_odd == 0) {
            //even
            p = maxAlternatingSum(arr, idx + 1, 1) + arr[idx];
        }
        if (even_odd == -1 || even_odd == 1) {
            //odd
            p = maxAlternatingSum(arr, idx + 1, 0) - arr[idx];
        }

        return Math.max(p, np);
    }
    //Memoization ---> Top Down
    public long maxAlternatingSum(int[] arr, int idx, int even_odd,long[][]dp) {
        if (idx == arr.length) {
            return 0;
        }
        if(dp[idx][even_odd+1]!=-1)return dp[idx][even_odd+1];
        long np = maxAlternatingSum(arr, idx + 1, even_odd,dp);
        long p = 0;
        if (even_odd == -1 || even_odd == 0) {
            //even
            p = maxAlternatingSum(arr, idx + 1, 1,dp) + arr[idx];
        }
        if ( even_odd == 1) {
            //odd
            p = maxAlternatingSum(arr, idx + 1, 0,dp) - arr[idx];
        }

        return dp[idx][even_odd+1] =  Math.max(p, np);
    }
}
