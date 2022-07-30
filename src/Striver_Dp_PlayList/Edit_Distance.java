package Striver_Dp_PlayList;

import java.util.*;

public class Edit_Distance {
    public static void main(String[] args) {
        /*
        Insert
        remove
        replace
       */
        String s = "ab";
        int n = s.length();
        String t = "a";
        int m = t.length();
        System.out.println(ed(s, t, n - 1, m - 1));
    }

    private static int ed(String s, String t, int i, int j) {
        if (j == -1) {
            return i + 1; //t gets exhausted
        }
        if (i == -1) {
            return j + 1; //s gets exhausted
        }
        if (s.charAt(i) == t.charAt(j)) {
            return ed(s, t, i - 1, j - 1);
        } else {
            int insert = ed(s, t, i, j - 1) + 1;
            int remove = ed(s, t, i - 1, j) + 1;
            int replace = ed(s, t, i - 1, j - 1) + 1;
            return Math.min(Math.min(insert, remove), replace);
        }

    }

    private static int ed(String s, String t, int i, int j, int[][] dp) {
        if (j == -1) {
            //ops required to delete from s
            return i + 1; //t gets exhausted
        }
        if (i == -1) {
//            ops required to insert in s from t
            return j + 1; //s gets exhausted
        }
        if (dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = ed(s, t, i - 1, j - 1, dp);
        } else {
            int insert = ed(s, t, i, j - 1, dp) + 1;
            int remove = ed(s, t, i - 1, j, dp) + 1;
            int replace = ed(s, t, i - 1, j - 1, dp) + 1;
            return dp[i][j] = Math.min(Math.min(insert, remove), replace);
        }

    }

}


