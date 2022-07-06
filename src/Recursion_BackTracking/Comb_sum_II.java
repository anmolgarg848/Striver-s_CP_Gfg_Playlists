package Recursion_BackTracking;

import java.util.Arrays;

public class Comb_sum_II {
    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        int tar = 6;

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Comb_Sum_II(arr, tar, 0, "");
    }

    private static void Comb_Sum_II(int[] arr, int tar, int idx, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return;
        }
        if (tar < 1 || idx == arr.length) {
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (i != idx && arr[i] == arr[i - 1]) {
                //i == idx means considering element first time
                continue;
            } else {
                //Can  Pick Only Single time
                Comb_Sum_II(arr, tar - arr[i], i+1, ans + arr[i]);
            }
        }

    }
}
