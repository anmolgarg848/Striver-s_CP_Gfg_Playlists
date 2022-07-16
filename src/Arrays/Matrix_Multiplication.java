package Arrays;

import java.util.Arrays;

public class Matrix_Multiplication {
    public static void main(String[] args) {
        //Given two matrices, the task to multiply them. Matrices can either be square or rectangular.
        int[][] arr1 = {{1, 1},
                {2, 2},
                {3, 3}};
        int[][] arr2 = {{1, 1, 1},
                {2, 2, 2}};

        mat_multi(arr1, arr2);
    }

    private static void mat_multi(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int r2 = arr2.length;
        int c1 = arr1[0].length;
        int c2 = arr2[0].length;
        int[][] res = new int[r1][c2];
        //logic
        //Approach Column then row
        for (int i = 0; i < r1; i++) { //for all rows of arr1
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c2; k++) {
                    res[i][j] += arr2[i][k] * arr1[k][i];
                }
            }
        }
        for (int[] ls : res) System.out.println(Arrays.toString(ls));
    }
}
