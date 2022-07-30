package Striver_Dp_PlayList;

public class Longest_Common_Substring {
    public static void main(String[] args) {
        //Approach --> Just Maintain the Flow of Consecutive Nature
        //Diagonals in dp refers to the consecutive elements
        String s1 = "adeghig";
        String s2 = "dghigea";
        System.out.println(Bu(s1, s2));
        int n = s1.length(), m = s2.length();
        System.out.println(rec(s1, s2, n - 1, m - 1));
    }

    private static int rec(String s1, String s2, int i, int j) {
//Base Case
        if (i == -1 || j == -1) return 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            return rec(s1, s2, i - 1, j - 1) + 1;
        } else {
            return 0;
        }

    }

    private static int Bu(String s1, String s2) {
        int n = s1.length(), m = s2.length(), max = 0;
        int[][] dp = new int[n + 1][m + 1];
        //seeding
        //Shifting of indx to han
        //-1 refers to 0 idx in dp
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][m] = 0;
        }
        int r = 0, c = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {  //shrink both the strings
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        r = i;
                        c = j;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(r + " " + c);
        String ans = "";
        int cnt = max;
        while (r > 0 && c > 0 && cnt > 0) {
            ans = s1.charAt(r - 1) + ans;
            r--;
            c--;
            cnt--;
        }
        System.out.println(ans);
        return max;
    }


}