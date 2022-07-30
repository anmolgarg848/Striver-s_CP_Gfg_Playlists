package Striver_Dp_PlayList;

public class Convert_Strings {
    public static void main(String[] args) {
        //Minimum Number of Operations required to convert String 1 --> String 2
        //You can Perform --> delete in str1 or
        // Insert in str2

        String s1 = "horse";
        String s2 = "ros";
//Always Possible --> Just Delete Everything in s1 and Insert in s2
        //max Operations --> n(deletion) + m(insertion)
        int n = s1.length();
        int m = s2.length();
        int lcs = Bu(s1, s2);
        int deletions = n-lcs;
        int insertions = m-lcs;
        int ops_required = deletions+insertions;
        System.out.println(ops_required);

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
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {  //shrink both the strings
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return max;
    }

}
