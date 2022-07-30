package Matrix;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Print {
    public static void main(String[] args) {
        //Wave Print
        //Upper Lower Half Of the Triangle of the Matrix
        //Diagonal traversal
         /*
         3sum
         lps
    All Indices
    last occurence
    generate valid parantheses
    coin Toss Not Printing Consecutive Heads
    print Counting Lexicographically
    why strings are Immutable
    Jumping Numbers --> Are Those Numbers Whose Consecutive Difference is 1
    next Permutation
    Longest even lenght ss
    Word Search
    sequential digits
    Letter Tile Possibilities
    Count Numbers With Unique Digits --> 357 leetcode
    Longest K unique ss
    Tower of Hanoi
    Consecutive char
     */

        int l = 1, r = (int)1e4,mod = (int)1e9+7;
        int cnt = 0;
        //36
        for (int x = l; x <= r; x++) {
            for (int y = x + 1; y <= r; y++) {
                if (check(x, y)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt%mod);

    }

    private static boolean check(int x, int y) {
        if (get_dig_sum(x) == get_dig_sum(y)) return false;
        return true;
    }

    private static int get_dig_sum(int n) {
        int sum = 0;
        while (n != 0) {
            int dig = n % 10;
            n /= 10;
            sum += dig;
        }
        return sum;
    }
}
