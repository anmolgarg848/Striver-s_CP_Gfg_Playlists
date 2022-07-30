package Striver_Dp_PlayList;

import java.util.Arrays;

public class Delete_earn {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2};
        int n = arr.length;
        Arrays.sort(arr);
        int ans = rec(arr, n - 1, -1);
        System.out.println(ans);
    }

    //Approach Pick Not Pick
    private static int rec(int[] arr, int idx, int prev) {
        if (idx == -1) {
            return 0;
        }
        int np = rec(arr, idx - 1, prev);
        int p = 0;
        if (prev + 1 != arr[idx] && prev - 1 != arr[idx]) {//Pick Only when
            p = rec(arr, idx - 1, arr[idx]) + arr[idx];
        }

        return Math.max(p, np);
    }
}