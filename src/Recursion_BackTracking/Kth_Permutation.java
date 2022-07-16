package Recursion_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Kth_Permutation {
    public static void main(String[] args) {
        //https://leetcode.com/problems/permutation-sequence/


        /*
        Brute Force --> Add All Permutation in a List  and Return K-1th
         */
        System.out.println(getPermutation(4, 9));
    }

    /*
    //Optimized Approach --> Jump  In Range
    ALGORITHM
    (1,2,3,4) , k = 16
    total perm = n!;
     1  + (2,3,4) = 3!   range  0 - 5
     2  + (1,3,4) = 3!    6 - 11
     3 + (1,2,4) = 3!     12 - 17   //K lies here
     4   + (1,2,3) = 3!   18 - 23
       tot =     6 permutations

//get digit   ==>  k/range contains digits  ==> 16/6 = 2 = > arr[2] = 3 //fix 3

16%6 = 4  means find the 4th sequence among these 6 sequence starts from dig  3
Question Boils down to -->
[1,2,4] , k  = 4
1 + (2,4) = 2! = range 0 - 1
2 + (1,4) = 2! = 2 - 3
4 + (1,2) =  2! = 3 - 4  //k lies here
tot perm = 6
fix 4 --> [3 , 4 , ,]
4/2 = 2 = arr[2] = 4
so on until all places filled ............
     */
    //Iterative
    //T.C--> O(N^2)
    //S.C--> O(N)
    public static String getPermutation_optimized(int n, int k) {
        String ans = "";
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            //we want n!
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        k -= 1; //0 based Indexing
        while (true) {
            ans += numbers.get(k / fact);
            numbers.remove(k / fact);
            if (numbers.size() == 0) break;
            k %= fact;
            fact /= numbers.size();
        }

        return ans;
    }

    public static String getPermutation(int n, int k) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        List<String> ls = new ArrayList<>();
        Gen_Perm(arr, new boolean[n + 1], 1, "", ls);
        System.out.println(ls);
        return ls.get(k - 1);
    }

    //T.C--> N!*N  + N FOR SORTING
    //Using Recursive Approach --> Boolean
    private static List<String> Gen_Perm(int[] arr, boolean[] vis, int idx, String ans, List<String> ls) {
        if (idx == arr.length) {
            ls.add(ans);
            return ls;
        }
        for (int i = 1; i < arr.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                Gen_Perm(arr, vis, idx + 1, ans + arr[i], ls);//Moving idx Bcoz all place Must be arranged
                vis[i] = false;
            }

        }
        return ls;
    }
}
