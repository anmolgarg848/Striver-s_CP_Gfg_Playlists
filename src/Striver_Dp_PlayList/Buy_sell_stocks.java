package Striver_Dp_PlayList;

public class Buy_sell_stocks {
    public static void main(String[] args) {
        //single Transaction allowed
        int[] arr = {7, 1, 5, 3, 6, 4};
        int n = arr.length;
//        System.out.println(maxProfit(arr));
        //Multiple Transaction allowed

    }

    public static int maxProfit(int[] arr) {
        int n = arr.length;
        int buy = arr[0], prft = 0;
        for (int i = 1; i < n; i++) {
            int cost = arr[i] - buy;
            prft = Math.max(prft, cost);
            buy = Math.min(buy, arr[i]);
        }
        return prft;
    }

    //Buy and sell stocks II --> Multiple Transaction allowed
    public static int maxProfit(int[] arr, int idx, boolean can_buy) {
//Base Case
        if (idx == arr.length) return 0;
        if (can_buy) {//allowed to buy
            //again two options whether buy this or do not buy this
            //buying
            int prft1 = maxProfit(arr, idx + 1, false) - arr[idx];
            //not buying
            int prft2 = maxProfit(arr, idx + 1, true);
            return Math.max(prft1, prft2);
        } else {//can only sell
            //selling
            int prft3 = maxProfit(arr, idx + 1, true) + arr[idx];
            //not selling
            int prft4 = maxProfit(arr, idx + 1, false);
            return Math.max(prft3, prft4);
        }

    }

    //top_down
    //Buy and sell stocks II --> Multiple Transaction allowed
    public static int maxProfit(int[] arr, int idx, int can_buy, int[][] dp) {
//Base Case
        if (idx == arr.length) return 0;
        if (dp[idx][can_buy] != -1) return dp[idx][can_buy];
        if (can_buy == 0) {//allowed to buy
            //again two options whether buy this or do not buy this
            //buying
            int prft1 = maxProfit(arr, idx + 1, 1, dp) - arr[idx];
            //not buying
            int prft2 = maxProfit(arr, idx + 1, 0, dp);
            return dp[idx][can_buy] = Math.max(prft1, prft2);
        } else {//can only sell
            //selling
            int prft3 = maxProfit(arr, idx + 1, 0, dp) + arr[idx];
            //not selling
            int prft4 = maxProfit(arr, idx + 1, 1, dp);
            return dp[idx][can_buy] = Math.max(prft3, prft4);
        }

    }

    private static int Bu(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {//allowed to buy
                    //again two options whether buy this or do not buy this
                    //buying
                    int prft1 = dp[i + 1][1] - arr[i];
                    //not buying
                    int prft2 = dp[i + 1][0];
                    dp[i][j] = Math.max(prft1, prft2);
                } else {//can only sell
                    //selling
                    int prft3 = dp[i + 1][0] + arr[i];
                    //not selling
                    int prft4 = dp[i + 1][1];
                    dp[i][j] = Math.max(prft3, prft4);
                }
            }
        }

        return dp[0][1];
    }

    //Buy and sell stocks III --> Atmost Two  Transaction allowed
     /*
        3 - D Dp Used to memoize as having three changing Parameters
        */
    private static int maxProfit_III(int[] arr, int idx, int tran, int can_buy) {
//Base Case
        if (idx == arr.length || tran <= 0) return 0;
        if (can_buy == 0) {//allowed to buy
            //buy or may not buy
            return Math.max(maxProfit_III(arr, idx + 1, tran, 1) - arr[idx], maxProfit_III(arr, idx + 1, tran,
                    0));
        } else {
//sell or may not sell
            return Math.max(maxProfit_III(arr, idx + 1, tran - 1, 0) + arr[idx], maxProfit_III(arr, idx + 1, tran,
                    1));
        }
    }

    //Buy and sell stocks IV --> Atmost k  Transaction allowed
    private static int maxProfit_IV(int[] arr, int idx, int K_tran, int can_buy) {
 /*
        3 - D Dp Used to memoize as having three changing Parameters
        */
//just use k as an Arguement

        return 0;
    }

    //buy stocks with cooldown --> After you sell your stock, you cannot buy stock on the next day.
    public int maxProfit_cool(int[] arr, int idx, int can_buy) {
        if (idx == arr.length) {
            return 0;
        }
        if (can_buy == 0) {
            return Math.max(maxProfit_cool(arr, idx + 1, 1) - arr[idx], maxProfit_cool(arr, idx + 1, 0));
        } else { //sell
            return Math.max(maxProfit_cool(arr, idx + 2, 0) + arr[idx], maxProfit_cool(arr, idx + 1, 1));
        }

    }

    //Best Time to Buy and Sell Stock with Transaction Fee
    public int maxProfit_fee(int[]arr, int fee,int idx,int can_buy) {
        if (idx == arr.length) {
            return 0;
        }
        if (can_buy == 0) {
            return Math.max(maxProfit_fee(arr, fee,idx+1 ,1) - arr[idx], maxProfit_fee(arr, fee,idx+1 ,0));
        } else { //sell
            return Math.max(maxProfit_fee(arr, fee,idx+1 ,0) + arr[idx]-fee, maxProfit_fee(arr, fee,idx+1 ,1));
        }
    }

}
