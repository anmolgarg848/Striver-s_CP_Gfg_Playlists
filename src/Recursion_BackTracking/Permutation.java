package Recursion_BackTracking;

import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        int n = arr.length;
        //Total Perm = n!
        Perm(arr, new boolean[n], 0, "");
    Perm1(arr,0);
    }
//T.C--> N!*N
    //    Approach -->Boolean , Intuition-->  pehle a , then b , then c
    private static void Perm(int[] arr, boolean[] check, int idx, String ans) {
        if (idx == arr.length) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!check[i]) {
                check[i] = true;
                Perm(arr, check, idx + 1, ans + arr[i]);
                check[i] = false;
            }
        }

    }

    //Approach 2---. Swap Approach Intuition --> Swap  1 with 1, 1 with 2 ,1 with 3
    private static void Perm1(int[] arr, int idx) {
        if (idx == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, i,idx);
            Perm1(arr, idx+1);
            swap(arr, i,idx);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
