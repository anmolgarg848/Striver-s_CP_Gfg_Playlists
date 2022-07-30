package Striver_Dp_PlayList;

public class UnBounded_KnapSack {
    public static void main(String[] args) {
        int n = 3;
        int[] wt = {3, 7, 5};
        int[] val = {12, 1100, 1000};
        int Bag_Capacity = 10;
        //there is Infinite suppply #No Bound
        System.out.println(rec(n - 1, wt, Bag_Capacity, val));
        System.out.println(Bu(n,Bag_Capacity,wt,val));
    }

    //returns maximum value thief can steal
    private static int rec(int n, int[] wt, int capacity, int[] val) {
//Base Case
        if (n == 0) {
            //two ways -- > Can Steal or Cannot
            if (wt[0] <= capacity) {
                return (capacity / wt[0]) * val[0];
            }
            return 0;
        }
        int notSteal = rec(n - 1, wt, capacity, val);
        int steal = Integer.MIN_VALUE;
        if (wt[n] <= capacity) {
            steal = rec(n, wt, capacity - wt[n], val) + val[n];
        }
        return Math.max(steal, notSteal);
    }
    private static int Bu(int n, int Bag_Capacity, int[] wt, int[] val) {
        int[][] dp = new int[n][Bag_Capacity + 1];
        //seeding
        for (int i = 0; i <= Bag_Capacity; i++) {
            if (i >= wt[0]) {
                dp[0][i] = (i/wt[0])*val[0];
            }
        }
        for (int items = 1; items < n; items++) {
            for (int capacity = 0; capacity <= Bag_Capacity; capacity++) {
                int np = dp[items - 1][capacity];
                int p = Integer.MIN_VALUE;
                //Pick Only When
                if (capacity >= wt[items]) {
                    p = dp[items][capacity - wt[items]] + val[items];
                }
                dp[items][capacity] = Math.max(p, np);
            }
        }
        return dp[n - 1][Bag_Capacity];
    }
}
