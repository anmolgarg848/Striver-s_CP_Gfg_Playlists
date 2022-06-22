package Algorithm_Junction;

import java.util.Arrays;

public class Partition {
    public static void main(String[] args) {
        //Array Partitioning Algorithm
//        Partition an Array On the Basis Of Pivot element

        int[] arr = {7, 9, 4, 8, 3, 6, 2, 1};
        int n = arr.length;
Partition(arr,5);
        System.out.println(Arrays.toString(arr));
    }

    //return Pivot / partition index
    private static int Partition(int[] arr, int pvt) {
        int i = 0, j = 0;
        int n = arr.length;
        while (i < n) {
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
