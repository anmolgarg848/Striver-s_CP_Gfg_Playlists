package Recursion_BackTracking;

public class Palindrome_Partitioning {
    public static void main(String[] args) {
//Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
        pp("aab","",0);
    }

    private static void pp(String s,String ans,int idx) {
        if (idx == s.length()) {
            System.out.println(ans);
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            String part = s.substring(idx,i+1);
//            System.out.println(part);
            if (isPal(part)){
                pp(s,ans+part+" - ",i+1); //Increasing i bcoz i is Moving
            }
        }
    }

    private static boolean isPal(String s) {
        int i = 0, n = s.length(), j = n - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
