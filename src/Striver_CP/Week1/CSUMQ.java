package Striver_CP.Week1;

import java.util.Scanner;

public class CSUMQ {
    public static void main(String[] args) {
        /*
        https://www.spoj.com/problems/CSUMQ/
        A spoj Problem Based On Prefix Sum Algorithm From Striver's CP Sheet
         */

/*
Input:
3
1 4 1
3
1 1
1 2
0 2
Output:
4
5
6
 */
        Scanner sc = new Scanner(System.in);
//Brute Force ---> Simply Run Loop EveryTime
// Prefix Sum Approach
//Taking Input
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] prefix_sum = new int[n];
        int cur_sum = 0;
        for (int i = 0; i < n; i++) {
            cur_sum += arr[i];
            prefix_sum[i] = cur_sum;
        }
        int queries = sc.nextInt();
        while (queries-- > 0) {
            //Logic
            int ith_idx = sc.nextInt();
            int jth_idx = sc.nextInt();
            if (ith_idx <= 0) {
                System.out.println(prefix_sum[jth_idx]);
            } else {
                System.out.println(prefix_sum[jth_idx] - prefix_sum[ith_idx - 1]);
            }

        }
    }

}
