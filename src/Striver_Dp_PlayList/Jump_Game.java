package Striver_Dp_PlayList;

public class Jump_Game {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        int n = arr.length;
//can reach n-1th idx or not
    }

    private static boolean rec(int[] arr, int idx, int n) {
//Base Case
        if (idx == n - 1) return true;
        if (idx >= n) return false;
        boolean reached = false;
        for (int i = 1; i <= arr[idx]; i++) {
            if (i < n) {
                if (rec(arr, idx + i, n)){
                    return  true;
                }
            }
        }
        return reached;
    }
    private static boolean rec(int[] arr, int idx, int n,int[]dp) {
//Base Case
        if (idx == n - 1) return true;
        if (idx >= n) return false;
        if(dp[idx]!=-1)return dp[idx]==1?true:false;
        boolean reached = false;
        for (int i = 1; i <= arr[idx]; i++) {
            if (i < n) {
                if (rec(arr, idx + i, n,dp)){
                    dp[idx]  = 1;
                    return   true;
                }else{
                    dp[idx] = 0;
                }
            }
        }
        // dp[idx]  = 0;
        return reached;
    }
}
