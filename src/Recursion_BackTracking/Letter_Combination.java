package Recursion_BackTracking;

import java.util.HashMap;
import java.util.Map;

public class Letter_Combination {

    public static void main(String[] args) {
        //Input: digits = "23"
        //Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Letter_Comb("23","");

    }

    private static void Letter_Comb(String str, String ans) {
        if (str == "") {
            System.out.println(ans);
            return;
        }
        char dig = str.charAt(0);
        String ss = str.substring(1);
        String letters = get(dig);
        int n = letters.length();
        for (int ch = 0; ch < n; ch++) {
            Letter_Comb(ss, ans + letters.charAt(ch));
        }
    }

    private static String get(char dig) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map.get(dig);
    }

}
