package Algorithm_Junction;

import java.util.Arrays;

public class Dutch_flag {
    public static void main(String[] args) {
        //Sort 0 1 2 in linear Time Complexity
        int[] arr = {0, 0, 1, 2, 0, 1, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Approach Partitioning
    private static void sort(int[] arr) {
        int i = 0, n = arr.length, mid = 0, j = n - 1;
        while (mid <= j) {
            if (arr[mid] == 0) {
                swap(arr,i,mid);
                i++;mid++;
            } else if (arr[mid] == 1) {
                    mid++;
            } else {
                swap(arr,mid,j);
                j--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
