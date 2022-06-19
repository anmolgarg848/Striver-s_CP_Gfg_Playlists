package Striver_CP.Week1;

import java.util.Arrays;

public class Sum_Array {
    public static void main(String[] args) {
        /*
        Given an Array increase it from idx l to r by  x
         */
        int[] arr = {2, 3, 2, 3, 5};
        //Queries --> 0 3 2    2 4 3   1 2 1
//        sum_Arr(arr, 0, 3, 2);
//        sum_Arr(arr, 2, 4, 3);
//        sum_Arr(arr, 1, 2, 1);
//        System.out.println(Arrays.toString(arr));
//=============Scan_Line Algorithm =================
        int n = arr.length;
        //Step 1 --> Take an prefix sum array of n+1 size
        int[] pre_sum_arr = new int[n + 1];
        //Call Scan_Line Algorithm Function
        Scan_Line_Algorithm(arr, pre_sum_arr, 0, 3, 2);
        Scan_Line_Algorithm(arr, pre_sum_arr, 2, 4, 3);
        Scan_Line_Algorithm(arr, pre_sum_arr, 1, 2, 1);

//        System.out.println(Arrays.toString(pre_sum_arr));
//Step 3 ==> run loop with Marathon Variable
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=pre_sum_arr[i];
            arr[i]+=sum;
        }
        System.out.println(Arrays.toString(arr));
    }

    //Brute Force
    private static void sum_Arr(int[] arr, int l, int r, int x) {
        for (int i = l; i <= r; i++) {
            arr[i] += x;
        }
    }

    //Time Complexity --> O(N),S.c --> O (N)

    //Optimized ---> SCANLINE ALGORITHM
    private static void Scan_Line_Algorithm(int[] arr, int[] pre_sum_arr, int l, int r, int x) {
        //Step 2 --> Increase  L Position By x  and   Decrease  R Position by x
        pre_sum_arr[l] += x;
        pre_sum_arr[r + 1] -= x;
    }



}
