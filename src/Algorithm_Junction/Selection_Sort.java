package Algorithm_Junction;

import java.util.Arrays;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 89, 2, 6, 33, 555555, 6, 6, 6, 777, 5, 2};
Selection_Sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Approach --> Find Minimum and Swap
    private static void Selection_Sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int idx = Get_Min(arr,i);
            swap(arr,idx,i);
        }

    }

    //returns Minimum Idx
    private static int Get_Min(int[] arr, int idx) {
        int n = arr.length;
        int min_idx = idx;
        for (int i = idx + 1; i < n; i++) {
            if (arr[i] < arr[min_idx]) {
                min_idx = i;
            }
        }
        return min_idx;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
