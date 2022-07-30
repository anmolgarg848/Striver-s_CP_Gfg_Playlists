package Striver_Dp_PlayList;

public class WildCard_Matching {
    public static void main(String[] args) {
        String s = "aa";
        int n = s.length();
        String p = "*";
        int m = p.length();
        System.out.println(isMatch(s, p, n - 1, m - 1));
    }

    public static boolean isMatch(String s, String p, int i, int j) { //code failed at 1681 / 1900
        //pending --> will do  it later
        //Base Case
        if (i == -1 && j == -1) return true;
        if (i == -1 || j == -1) return false;


        //Case 1--> Both Matches
        boolean matched = false, unmatched = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return matched = isMatch(s, p, i - 1, j - 1);
        } else {//Not Matches

            if (p.charAt(j) != '*') {
                return false;
            } else {
                //Try all Possible ways to handle  *
                // * as empty means 0 length
                // * as empty means 1 length
                // * as empty means 2 length . . . . . ans so on
                for (int k = 0; k <= i+1; k++) {
                    unmatched = isMatch(s, p, i - k, j - 1);
                    if (unmatched) break;
                }
            }
        }
        return matched || unmatched;
    }
}
