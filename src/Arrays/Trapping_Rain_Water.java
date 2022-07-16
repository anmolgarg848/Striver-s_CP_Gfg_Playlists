package Arrays;

import java.util.Arrays;

public class Trapping_Rain_Water {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//Width of Each Bar is 1
        //Compute How Much Water it Can Trap
        System.out.println(Trapping_Rain_Water(height));
        System.out.println(trap(height));
    }
    //Brute Force
    private static int Trapping_Rain_Water(int[] ht) {
        int tot_bar = ht.length;
        int tot_Water_trapped = 0;

        for (int bar = 0; bar < tot_bar; bar++) {

            int max_Left = Integer.MIN_VALUE;
            for (int i = bar; i < tot_bar; i++) {
                max_Left = Math.max(max_Left, ht[i]);
            }
            int max_right = Integer.MIN_VALUE;
            for (int i = bar; i >= 0; i--) {
                max_right = Math.max(max_right, ht[i]);
            }
            int trapped_water = Math.min(max_Left, max_right) - ht[bar];
            tot_Water_trapped += trapped_water;
        }
        return tot_Water_trapped;
    }

    //    Optimized==> Prefix and suffix sum Approach
    // S.c==>O(N) T.C==>O(n)
    public static int trap(int[] arr) {
        //Approach ==> Prefix and suffix sum
        int[] max_left = new int[arr.length];
        int[] max_right = new int[arr.length];
        //Seeding
        max_left[0] = arr[0];
        max_right[arr.length - 1] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            max_left[i] = Math.max(arr[i], max_left[i - 1]);
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(arr[i], max_right[i + 1]);
        }
        int ans = 0;
//        Use Them
        for (int i = 0; i < arr.length; i++) {
            ans += Math.min(max_right[i], max_left[i]) - arr[i];
        }
        System.out.println(Arrays.toString(max_left));
        System.out.println(Arrays.toString(max_right));
        return ans;
    }

}
