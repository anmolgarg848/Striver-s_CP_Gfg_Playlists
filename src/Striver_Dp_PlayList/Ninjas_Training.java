package Striver_Dp_PlayList;

import java.util.Arrays;

public class Ninjas_Training {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 5,}, {3, 1, 1}, {30, 3, 36}};
        int days = arr.length;
        System.out.println(Max_Points_rec(arr, days - 1, -1));
        int[][] dp = new int[days][3];
        for (int[] ls : dp) Arrays.fill(ls, -1);
        System.out.println(Max_Points_Top_Down(arr, days - 1, -1, dp));
        for (int[] ls : dp) System.out.println(Arrays.toString(ls));
    }

    private static int Max_Points_rec(int[][] arr, int days, int prev_activity_performed) {
        if (days == -1) return 0;
        int points = 0;
        for (int activity = 0; activity < 3; activity++) {
            if (activity != prev_activity_performed) {
                points = Math.max(points, Max_Points_rec(arr, days - 1, activity) + arr[days][activity]);
            }
        }
        return points;
    }

    private static int Max_Points_Top_Down(int[][] arr, int days, int prev_activity_performed, int[][] dp) {
        if (days == -1) return 0;
        if (prev_activity_performed != -1 && dp[days][prev_activity_performed] != -1)
            return dp[days][prev_activity_performed];
        int points = 0;
        for (int activity = 0; activity < 3; activity++) {
            if (activity != prev_activity_performed) {
                points = Math.max(points, Max_Points_Top_Down(arr, days - 1, activity, dp) + arr[days][activity]);
            }
        }
        if (prev_activity_performed != -1) {
            return dp[days][prev_activity_performed] = points;
        } else {
            return dp[days][0] = points;
        }
    }

    private static int Bu(int[][] arr) {
        int days = arr.length;
        int[][] dp = new int[days][3];

        return 0;
    }
}

