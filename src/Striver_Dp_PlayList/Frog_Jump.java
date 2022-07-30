package Striver_Dp_PlayList;

import java.util.Arrays;

public class Frog_Jump {
    public static void main(String[] args) {
        //return the Minimum Total Energy used By the Frog to reach the nth stair
        // either 1 or 2 steps Jump
        //energy = |prev_jump - next _jump |

        int[] arr = {10, 20, 30, 10}; //Output ==> 20
//        int[] arr = {30, 10, 60, 10, 60, 50};
        int n = arr.length;
        System.out.println(rec(arr, n - 1));
        int[] dp = new int[n ];
        Arrays.fill(dp, -1);
        System.out.println(Top_Down(arr, n - 1, dp));
        System.out.println(Bu(arr));
    }

    //Approach Try All Possible ways --> Recursion
    private static int rec(int[] arr, int idx) {
        //Base Case
        if (idx == 0) return 0;//costing to reach 0 -> 0 is zero
        int jump1 = rec(arr, idx - 1) + Math.abs(arr[idx] - arr[idx - 1]);
        int jump2 = Integer.MAX_VALUE;
        if (idx > 1) {
            jump2 = rec(arr, idx - 2) + Math.abs(arr[idx] - arr[idx - 2]);
        }
        return Math.min(jump1, jump2);
    }

    private static int Top_Down(int[] arr, int idx, int[] dp) {
        //Base Case
        if (idx == 0) return 0;//costing to reach 0 -> 0 is zero
        if (dp[idx] != -1) return dp[idx];
        int jump1 = Top_Down(arr, idx - 1, dp) + Math.abs(arr[idx] - arr[idx - 1]);
        int jump2 = Integer.MAX_VALUE;
        if (idx > 1) {
            jump2 = Top_Down(arr, idx - 2, dp) + Math.abs(arr[idx] - arr[idx - 2]);
        }
        return dp[idx] = Math.min(jump1, jump2);
    }

    private static int Bu(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n ];

        for (int i = 1; i < n; i++) {
            int j1 = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int j2 = Integer.MAX_VALUE;
            if (i > 1) {
                j2 = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }
            dp[i] = Math.min(j1, j2);
        }

        return dp[n-1];
    }


}
