package Algorithm_Junction;

import java.util.Arrays;

public class Quick_Select {
    public static void main(String[] args) {
        /*
        Quick Select Algorithm is Identical to Quick sort In which We Recurse Only One Side of the whichever
        Partition Contains Kth Largest / smallest element
         */

        int[] arr = {3,2,3,1,2,4,5,5,6};

        int k = 4;
        int n = arr.length;
        int idx = n-k ;
        System.out.println(Quick_select(arr,0,n-1,idx));
    }

    //Standard Quick Select  Algorithm --> For Kth Smallest element in an Array
    private static int  Quick_select(int[] arr, int lo, int hi, int kth) {
//select pivot
        int pivot = arr[hi];
        //partition and get pvt idx
        int pvt_idx = Partition(arr, pivot,lo,hi);

        if (kth < pvt_idx) {
            //Left Half
          return   Quick_select(arr, lo, pvt_idx-1, kth);
        } else if (kth > pvt_idx) {
            //right Half
           return Quick_select(arr,  pvt_idx+1,hi, kth);

        } else {
//            System.out.println(arr[pvt_idx] + "   - - -- -");
            return arr[pvt_idx];
        }

    }

    //Standard Quick Sort Algorithm
    private static void QuickSort(int[] arr, int lo, int hi) {
        //Base Case
        if (lo >= hi) return;
        //Placing Pointers
        int s = lo, e = hi;
        //Choosing Pivot idx as mid
        int mid = s + (e - s) / 2;
        //Pivot element
        int pvt = arr[mid];
        //Partitioning On the Basis of Pivot
        while (s <= e) {
            while (arr[s] < pvt) s++;
            while (arr[e] > pvt) e--;
            if (s <= e) {
                swap(arr, s, e);
                s++;
                e--;
            }
        }

        //Recursive Calls On  Two Half's
        QuickSort(arr, s, hi);
        QuickSort(arr, lo, e);

    }

    //return Pivot / partition index
    private static int Partition(int[] arr, int pvt,int lo,int hi) {
        int i = lo, j = lo;
        int n = arr.length;
        while (i <=hi) {
            if (arr[i] <= pvt) {
                swap(arr, i++, j++);
            } else {
                i++;
            }

        }
        return j - 1;
    }

    private static int Kth_Largest(int[] arr, int k) {
//Just do n-k
        return 0;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
