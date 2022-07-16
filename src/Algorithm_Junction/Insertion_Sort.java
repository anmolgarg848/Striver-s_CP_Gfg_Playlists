package Algorithm_Junction;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Insertion_Sort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 8, 1, 26, 5,8,-1,20,-55555};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Approach --> Compare and Put in a Sorted Array
    private static void sort(int[] arr) {
        int n = arr.length;
        int i = 1;
        while (i < n) {
            int j = i - 1;
            int key = i;
            while (j >= 0 && arr[key] < arr[j]) {
                int tmp = arr[key];
                arr[key] = arr[j];
                arr[j] = tmp;
                j--;
                key--;
            }
            i++;
            j = i - 1;
        }
    }
}
