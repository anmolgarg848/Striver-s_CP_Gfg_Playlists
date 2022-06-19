package Striver_CP.Week1;

import java.util.Arrays;
import java.util.Scanner;

public class CSUMQ_II {
    static Scanner sc = new Scanner(System.in);
    //Optimized Approach
    public static void main(String[] args) {
        //Prefix Sum Approach  on 2-D Matrix
        //Taking Input Into 2D Matrix
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                mat[r][c] = sc.nextInt();
            }
        }
        Print_2DArray(mat);
        int[][] arr = {{2, 3, 1, 4}, {1, 2, 3, 2}, {2, 1, 3, 2}, {3, 1, 1, 1}};
        System.out.println(PreFix_Sum2d(arr, 1, 2, 3, 3));
        Print_2DArray(arr);
    }
    //Brute Force
    private static int PreFix_Sum2d(int[][] arr, int r1, int c1, int r2, int c2) {
        //Run loop
        int sum = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
    private static int Optimized_Approach(int[][]arr){
       //Approach --> Each Cell Contains the sum of whole upper Rectangle
        //Deduced Formulae-->   Didn't Understand Try Again


        return 0;
    }
    private static void Print_2DArray(int[][] arr) {
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}