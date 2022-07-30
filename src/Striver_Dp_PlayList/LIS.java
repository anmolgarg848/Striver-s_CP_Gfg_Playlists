package Striver_Dp_PlayList;

import java.util.*;

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
        System.out.println(Lis_BU(arr));
        System.out.println(Lis_so(arr));
        System.out.println(lis_sumeet_sir(arr));
        Print_Lis(arr);
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
        int[][] dp = new int[n + 1][n + 1];
        for (int idx = n - 1; idx >= 0; idx--) {
            //previous index cannot beyond cur index
            for (int prev_idx = idx - 1; prev_idx >= -1; prev_idx--) {//shifting to handle -1
                int not_pick = dp[idx + 1][prev_idx + 1];
                int pick = 0;
                if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {
                    pick = dp[idx + 1][idx + 1] + 1; //second parameter goes into the  + 1 state
                }
                dp[idx][prev_idx + 1] = Math.max(not_pick, pick);
            }
        }
        return dp[0][-1 + 1];
    }

    //space optimization
    private static int Lis_so(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n + 1];
        int[] cur = new int[n + 1];
        for (int idx = n - 1; idx >= 0; idx--) {
            //previous index cannot beyond cur index
            for (int prev_idx = idx - 1; prev_idx >= -1; prev_idx--) {//shifting to handle -1
                int not_pick = prev[idx + 1];
                int pick = 0;
                if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {
                    pick = prev[idx + 1] + 1; //second parameter goes into the  + 1 state
                }
                cur[prev_idx + 1] = Math.max(not_pick, pick);
            }
            prev = cur;
        }
        return prev[-1 + 1];
    }

    //Printing LIS
//================================= Sumeet sir ===========================
    private static int lis_sumeet_sir(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        //nth idx will store overall max
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] += max + 1;
            dp[n] = Math.max(dp[n], dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

   static class Pair {
        int idx, val, len;
        String Path;

        Pair(int idx, int val, int len, String path) {
            this.idx = idx;
            this.val = val;
            this.len = len;
            this.Path = path;
        }
    }

    //To Trace Back or to print the lis this solution must be required
    //Using lazer Guided missile Approach
    private static void Print_Lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] += max + 1;
            //Overall max
            dp[n] = Math.max(dp[n], dp[i]);
        }
        System.out.println(Arrays.toString(dp)); //Overall max length of lis
        System.out.println("Lis Overall Max Length is -> " + dp[n]);
        //Printing Lis Using BFS Approach
        Queue<Pair> pq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (dp[i] == dp[n]) {
                pq.add(new Pair(i, arr[i], dp[i], arr[i] + ""));
            }
        }

        while (!pq.isEmpty()) {
            Pair rmv = pq.poll();
            if (rmv.len==1){
                System.out.println(rmv.Path);
            }
            for (int i = 0; i < rmv.idx; i++) {
                if (arr[i] < rmv.val && rmv.len - 1 == dp[i]) {
                    pq.add(new Pair(i, arr[i], dp[i], arr[i]+"->" +rmv.Path ));
                }
            }
        }
    }
}
