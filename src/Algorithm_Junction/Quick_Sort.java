package Algorithm_Junction;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Quick_Sort {

    public static void main(String[] args) {
//        Approach --> Pivot idx --> Its an Recursion Based Sorting Algorithm Which Just Place Elements In its
//        Correct Position

        int[] arr = {50, 40, -90, 80, -110};
//        QuickSort(arr, 0, arr.length - 1);
        QuickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }




    //Taking Pivot as An Median
    private static void QuickSort(int[] arr, int left, int right) {
        //Base Case
        if (left >= right) return;
        int start = left;
        int end = right;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];
        while (start <= end) {
            //Move While Comparing
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        //Recursion Calls for Two Half's
        QuickSort(arr, left, end);
        QuickSort(arr, start, right);
    }

    //QuickSort Using Partitioning Algorithm
    private static void QuickSort2(int[]arr,int lo,int hi){
     //Base Case
        if (lo>=hi)return;
        int pvt = arr[hi];
        int pvt_idx = Partition(arr,pvt);
        QuickSort2(arr, lo, pvt_idx-1);
        QuickSort2(arr, pvt_idx, hi);
    }
    //return Pivot / partition index
    private static int Partition(int[] arr, int pvt) {
        int i = 0, j = 0;
        int n = arr.length;
        while (i < n) {
            //i smaller elements ko peeche bhejta rhega
            if (arr[i] <= pvt) {
                swap(arr, i++, j++);
            } else {
                i++;
            }

        }
        return j - 1;
    }
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
