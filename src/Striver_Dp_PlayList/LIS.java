package Striver_Dp_PlayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS {
    public static void main(String[] args) {
        //Longest Increasing Subsequence
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
//        int[] arr = {1, 2, 3};
        //   [ 2 3 7 101] ,[ 2 3 7 18 ] length --> 4
        //{8 , 8 ,8, 8}  length = 1
        int n = arr.length;
        System.out.println(Lis_BF(arr, n, 0, new ArrayList<>()));
        System.out.println(LIS(arr, 0, -1));
        int[][] dp = new int[n][n + 1];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        System.out.println(LIS_MEMO(arr, 0, -1, dp));
    }

    /*Brute Force
    Generate All Subsequences
    store and check for longest Length
     */
    private static int Lis_BF(int[] arr, int n, int idx, List<Integer> ls) {
//Base case
        if (idx == n) {

            if (Is_Inc(ls)) {
//                System.out.println(ls);
                return ls.size();
            }
            return 0;
        }

        ls.add(arr[idx]);
        //Pick
        int p = Lis_BF(arr, n, idx + 1, ls);
        //Back Tracking
        ls.remove(ls.size() - 1);
        //Not Pick
        int np = Lis_BF(arr, n, idx + 1, ls);

        return Math.max(p, np);
    }

    private static boolean Is_Inc(List<Integer> ls) {
        int n = ls.size();
        for (int i = 0; i < n - 1; i++) {
            if (ls.get(i) >= ls.get(i + 1)) {
                return false;
            }
        }


        return true;
    }

    //Optimized --> Dynamic Programming
    /*Algo
    rules--> To get Recurrence Relation
    1. Express EveryThing In terms of Index
    2.  Explore all ---> Either Pick or Not pick
    3.  Take Max Of Pick & Not Pick

    Intuition --> Length of the LIS starting from ith idx Whose Previous_idx Picked is jth

     */

    private static int LIS(int[] arr, int idx, int prev_idx) {
//Base Case
        if (idx == arr.length) {
            return 0;
        }
        int not_pick = LIS(arr, idx + 1, prev_idx);
        int pick = 0;
        if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {
            pick = LIS(arr, idx + 1, idx) + 1;
        }
        return Math.max(not_pick, pick);
    }
    //Top down  / Memoization
    //to settle -1 using Co-Ordinate Change


    //T.C--> O(N*N)  A.S --> O(N)  S.C --> O(N*N)
    private static int LIS_MEMO(int[] arr, int idx, int prev_idx, int[][] dp) {
//Base Case
        if (idx == arr.length) {
            return 0;
        }
        if (dp[idx][prev_idx + 1] != -1) return dp[idx][prev_idx + 1];

        int not_pick = LIS_MEMO(arr, idx + 1, prev_idx, dp);
        int pick = 0;
        if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {
            pick = LIS_MEMO(arr, idx + 1, idx, dp) + 1;
        }
        return dp[idx][prev_idx + 1] = Math.max(not_pick, pick);
    }

    //Bottoms Up
    private static int Lis_BU(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n + 1];
        int len = 0;

        for (int i = 0; i < n; i++) {

            //Try


        }
        return len;
    }



}
