package Algorithm_Junction;

import java.util.*;

public class Merge_Sort {
    public static void main(String[] args) throws Exception {
        int[] arr = {5, 5, 8, 1, 0, 10, 30, 9000,88,-23};

        System.out.println(Arrays.toString(Merge_Sort(arr,0, arr.length-1)));
    }

    //Merge Two Sorted Arrays
    private static int[] merge_two(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int i = 0, j = 0, k = 0;
        int[] res = new int[n + m];
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                res[k] = arr1[i];
                i++;
                k++;
            } else {
                res[k] = arr2[j];
                j++;
                k++;
            }
        }
        while (i < n) {
            res[k++] = arr1[i++];
        }
        while (j < m) {
            res[k++] = arr2[j++];
        }
        return res;
    }

    private static int[] Merge_Sort(int[] arr, int start, int end) {
        //Base Case
        if (start >= end) {
            int[] base = {arr[start]};
            return base;
        }
        int mid = start + (end - start) / 2;
        int[] fp = Merge_Sort(arr, start, mid);
        int[] sp = Merge_Sort(arr, mid + 1, end);

        return merge_two(fp, sp);
    }
}
