package Recursion_BackTracking;

import java.util.Arrays;

public class Subsets_II {


    public static void main(String[] args) {
        //May Contains Duplicates But subsets Must be Unique


        int[] arr = {1, 2, 2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        ss(arr, 0, "");
    }

    //    Approach --> Condition Looping Approach
    private static void ss(int[] arr, int idx, String ans) {
            System.out.println(ans);
        for (int i = idx; i < arr.length; i++) {
            if (i!=idx&&arr[i]==arr[i-1]){
                continue;
            }else {
                ss(arr, i+1, ans+arr[i]);
            }
        }


    }
}
