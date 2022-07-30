package Binary_Search;

import java.util.Arrays;

public class first_and_last_pos {
    public static void main(String[] args) {
        //Lower and Upper Bound of an element Using Binary Search
        int[] arr = {5, 7, 7, 8, 8, 10};
        int tar = 8;
        System.out.println(Arrays.toString(searchRange(arr,tar)));

    }

    public static int[] searchRange(int[] arr, int target) {
        int[] res = {-1, -1};
        res[0] = lower_bound(arr, target);
        res[1] = upper_bound(arr, target);
        return res;
    }

    private static int lower_bound(int[] arr, int tar) {
        int i = 0, n = arr.length, j = n - 1;
        int idx = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] == tar) {
                idx = mid;
                j = mid - 1;
            } else if (arr[mid] < tar) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return idx;
    }

    private static int upper_bound(int[] arr, int tar) {
        int i = 0, n = arr.length, j = n - 1;
        int idx = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] == tar) {
                idx = mid;
                i = mid + 1;
            } else if (arr[mid] < tar) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return idx;
    }

}
