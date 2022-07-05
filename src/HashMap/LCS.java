package HashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LCS {
    public static void main(String[] args) {
        //Longest Consecutive Sequence
//https://leetcode.com/problems/longest-consecutive-sequence/
        int[] arr = {100, 4, 200, 1, 3, 2};


    }

    //Brute Force -> Sorting
    public int longestConsecutive_bf(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        //edge case
        if (n == 0 || n == 1) return n;

        int len = 1;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] + 1 == arr[i + 1]) {
                len++;
            } else if (arr[i] == arr[i + 1]) {
                //skip
            } else {
                //break the chain
                len = 1;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }

    //Optimized --> Using Set / Map
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        //edge case
        if (n == 0 || n == 1) return n;
        int len = 0;
        int ans = 0;
        Set<Integer> st = new HashSet<>();
        for (int ele : arr) st.add(ele);
        for (int ele : arr) {
            if (st.contains(ele - 1)) {
                // Skip ele ==>  Look for head
            } else {
                int num = ele;
                while (st.contains(num)) {
                    len++;
                    num++;
                }
            }
            ans = Math.max(ans, len);
            len = 0;
        }
        return ans;
    }

}
