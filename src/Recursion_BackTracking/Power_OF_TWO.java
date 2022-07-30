package Recursion_BackTracking;

import java.util.*;

public class Power_OF_TWO { //Power_OF_THREE Power_OF_Four
    public static void main(String[] args) {
//https://leetcode.com/problems/power-of-two/

//Given n is Power of Two Or Not ?
        System.out.println(Pow_fn(3,3));
     }

    //T.c --> O(n)
    //Brute Force
    public boolean isPowerOfTwo(int n) {
        int cur = 1;
        while (cur <= n) {

            if (cur == n) return true;
            cur *= 2;
        }

        return false;
    }

    // Modulo Approach
    //T.C--> O(log n)
    private static boolean isPowerOf2(int n) {
        if (n == 1) return true;
        if (n < 1 || n % 2 != 0) return false;
        return isPowerOf2(n / 2);
    }

    //Divide and Conquer
    private static int Pow_fn(int x, int y) {
        if (y == 0) return 1;
        if (y == 1) return x;
//Calculate ele Once And Use it Multiple Times
        int ele = Pow_fn(x, y / 2);
        if (y % 2 == 0) {
            //even
            return ele * ele;
        } else {
            //odd
            return ele * ele * x;
        }

    }
}
