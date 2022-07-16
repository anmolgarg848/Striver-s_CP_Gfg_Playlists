package Striver_Dp_PlayList;

import java.util.Arrays;

public class House_Robber_II {
    public static void main(String[] args) {
//Houses are arranged in circular Manner
        int[] arr = {200, 500, 1000, 9, 1000};
        int n = arr.length;
        //edge case
        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }
        int a = rec(arr, n - 1, 1);
        int b = rec(arr, n - 2, 0);
        System.out.println(Math.max(a, b));
    }

    //Approach --> Pick , Not Pick
    private static int rec(int[] arr, int start_idx, int end_idx) {
        //Base Case
        if (start_idx < end_idx) {
            return 0;
        }
        //Not pick
        int np = rec(arr, start_idx - 1,end_idx);
        int pick = rec(arr, start_idx - 2,end_idx) + arr[start_idx];
        return Math.max(np, pick);
    }

}
