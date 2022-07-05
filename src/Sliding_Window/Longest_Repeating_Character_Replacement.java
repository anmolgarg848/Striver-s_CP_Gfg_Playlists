package Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class Longest_Repeating_Character_Replacement {
    public static void main(String[] args) {
        //https://leetcode.com/problems/longest-repeating-character-replacement/
        //Variation of Maximum Consecutive 1's
        //Approach --> Sliding Window


    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int ans = 0, max_freq_within_frame = 0, letter_to_change = 0;
        int i = 0, j = 0;
        int n = s.length();
        while (j < n) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            //self work for right Pointer
            max_freq_within_frame = Math.max(max_freq_within_frame, map.get(arr[j]));
            letter_to_change = (j - i + 1) - max_freq_within_frame;
            //self work for left Pointer
            if (letter_to_change > k) {
                map.put(arr[i], map.get(arr[i]) - 1);
                i++;
            }
            ans = Math.max(ans, (j - i + 1));
            j++;
        }
        return ans;
    }
}
