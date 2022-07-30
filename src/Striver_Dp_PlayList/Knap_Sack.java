package Striver_Dp_PlayList;

import java.util.Arrays;

public class Knap_Sack {
    public static void main(String[] args) {
        int n = 3;
        int[] wt = {3, 8, 5};
        int[] val = {100, 1100, 600};
        int Bag_Capacity = 8;
        System.out.println(Knap_Sack(n - 1, Bag_Capacity, wt, val));
        //return the Maximum val the Thief can took
        int[][] dp = new int[n][Bag_Capacity + 1];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        System.out.println(Knap_Sack(n - 1, Bag_Capacity, wt, val, dp));
        System.out.println(Bu(n,Bag_Capacity,wt,val));
    }

    //Time complexity --> 2^n
    //Recursion Call Meaning --> Till that idx what is the maximum val you can get with that  bag_capacity
    //Approach --> Can Pick or Not Pick
    private static int Knap_Sack(int tot_items, int Bag_capacity, int[] wt, int[] val) {
        //Base Case

        if (tot_items == 0) {
            if (Bag_capacity >= wt[0]) {
                return val[0];
            }
            return 0;
        }
        int np = Knap_Sack(tot_items - 1, Bag_capacity, wt, val);
        int p = Integer.MIN_VALUE;
        //Pick Only When
        if (Bag_capacity >= wt[tot_items]) {
            p = Knap_Sack(tot_items - 1, Bag_capacity - wt[tot_items], wt, val) + val[tot_items];
        }
        return Math.max(p, np);
    }

    // ========= Top Down ====================
    private static int Knap_Sack(int tot_items, int Bag_capacity, int[] wt, int[] val, int[][] dp) {
        //Base Case

        if (tot_items == 0) {
            if (Bag_capacity >= wt[0]) {
                return val[0];
            }
            return 0;
        }
        if (dp[tot_items][Bag_capacity] != -1) return dp[tot_items][Bag_capacity];
        int np = Knap_Sack(tot_items - 1, Bag_capacity, wt, val, dp);
        int p = Integer.MIN_VALUE;
        //Pick Only When
        if (Bag_capacity >= wt[tot_items]) {
            p = Knap_Sack(tot_items - 1, Bag_capacity - wt[tot_items], wt, val, dp) + val[tot_items];
        }
        return dp[tot_items][Bag_capacity] = Math.max(p, np);
    }

    private static int Bu(int n, int Bag_Capacity, int[] wt, int[] val) {
        int[][] dp = new int[n][Bag_Capacity + 1];
        //seeding
        for (int i = 0; i <= Bag_Capacity; i++) {
            if (i >= wt[0]) {
                dp[0][i] = val[0];
            }
        }
        for (int items = 1; items < n; items++) {
            for (int capacity = 0; capacity <= Bag_Capacity; capacity++) {
                int np = dp[items - 1][capacity];
                int p = Integer.MIN_VALUE;
                //Pick Only When
                if (capacity >= wt[items]) {
                    p = dp[items - 1][capacity - wt[items]] + val[items];
                }
                dp[items][capacity] = Math.max(p, np);
            }
        }
        return dp[n - 1][Bag_Capacity];
    }
}