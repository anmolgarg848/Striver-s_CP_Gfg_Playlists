package Striver_Dp_PlayList;

import java.util.*;

public class Largest_Divisible_Subset {
    public static void main(String[] args) {
        //subset Does Not Follows Relative  Order
        int[] arr = {1, 16, 7, 8, 4};
//        int[] arr = {1, 2, 3};
        Arrays.sort(arr);//sorting is must to ensure all are divisible by themselves
        int n = arr.length;
        System.out.println(lds(arr, 0, -1));
        System.out.println( bfs(arr));
    }

    //recursive Approach
    //returns Maximum lds  length
    private static int lds(int[] arr, int idx, int prev_idx) {
        if (idx == arr.length) {
            return 0;
        }
        int np = lds(arr, idx + 1, prev_idx);
        int p = 0;
        if (prev_idx == -1 || arr[prev_idx] % arr[idx] == 0 || arr[idx] % arr[prev_idx] == 0) {
            p = lds(arr, idx + 1, idx) + 1;
        }
        return Math.max(p, np);
    }

    static class Pair {
        int idx;
        int val;
        int len;
        List<Integer> res;

        Pair(int idx, int val, int len, List<Integer> res) {
            this.idx = idx;
            this.val = val;
            this.len = len;
            this.res = res;
        }
    }

    //Sumeet Sir's laser guided missile Approach or bfs to print
    private static List<Integer> bfs(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int OverAll_MAX = 1;
        int max_idx = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 || arr[j] % arr[i] == 0) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] += max;
            if (OverAll_MAX < dp[i]) {
                max_idx = i;
                OverAll_MAX = dp[i];
            }
        }
//        System.out.println(OverAll_MAX);
        //Printing lds Using bfs
        Queue<Pair> pq = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();
        ls.add(arr[max_idx]);
        pq.add(new Pair(max_idx, arr[max_idx], dp[max_idx], ls));
        while (!pq.isEmpty()) {
            Pair rmv = pq.poll();
            if (rmv.len == 1) {
                Collections.reverse(rmv.res);
                return rmv.res;
            }
            //put Children in queue
            for (int i = 0; i < rmv.idx; i++) {
                if ((rmv.len - 1 == dp[i]) && (arr[i] % arr[rmv.idx] == 0 || arr[rmv.idx] % arr[i] == 0)) {
                    List<Integer> cur = new ArrayList<>(rmv.res);
                    cur.add(arr[i]);
                    pq.add(new Pair(i,arr[i],dp[i],cur ));
                }
            }
        }
        return new ArrayList<>();
    }
}