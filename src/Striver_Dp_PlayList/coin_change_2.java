package Striver_Dp_PlayList;

public class coin_change_2 {
    public static void main(String[] args) {
        //cnt All possible Ways To Make Change with Infinite supply
        int[] arr = {1, 2, 3};
        int tar = 6,n = arr.length;
        System.out.println(rec(arr,tar,n-1));
    }

    private static int rec(int[] arr, int tar, int idx) {
//Base Case
        if (idx == 0) {
            if (tar % arr[0] == 0) return 1;//picked
            //not picked
            return 0;
        }
        int np = rec(arr, tar, idx - 1);
        int p = 0;
        if (arr[idx] <= tar) {
            p = rec(arr, tar - arr[idx], idx);
        }
        return np + p;
    }
}
