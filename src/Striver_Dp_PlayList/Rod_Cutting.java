package Striver_Dp_PlayList;

public class Rod_Cutting {
    public static void main(String[] args) {
        int n = 5; //rod length
        //1 - indexed
        int[] price = {2, 5, 7, 8, 10};
//cut the rod into pieces
        /*
        for piece of length 1 you will get price  -> 2
        total price for 5 = > 10
        return the maximum price You can get
         */
//cut the rod into 2 or 3 you will get --> 12
//Pattern Detected Unbounded Knapsack Infinite Supply
        System.out.println(rec(price, n, n - 1));
    }

    private static int rec(int[] arr, int tar, int idx) {
//Base Case
        if (idx == 0) {
                return tar * arr[0];//picked
        }
        int np = rec(arr, tar, idx - 1);
        int p = Integer.MIN_VALUE;
        int rodLength = idx+1;
        if (rodLength <= tar) {
            p = rec(arr, tar - (idx+1), idx)+arr[idx];
        }
        return Math.max(np, p);
    }
}
