package Recursion_BackTracking;

public class Combination {
    public static void main(String[] args) {
        //Formulae -->  nCr
        //nCr*r! = nPr
        //nPr = n!/(n-r)!
        int[] arr = {2, 3, 6, 7};
        int tar = 7;
        Combinations(4, 1, 2, "");
        System.out.println("=================");
        Combination_Sum(arr, 0, tar, "");
    }

    //standard Combinations
    private static void Combinations(int n, int start, int places, String ans) {
        if (places == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = start; i <= n; i++) {
            Combinations(n, i + 1, places - 1, ans + i);
        }
    }

    //Same Approach Used for Coin Change Problems
    //Can Pick Coin  Multiple Times
    private static void Combination_Sum(int[] arr, int idx, int target, String ans) {
        if (target == 0) {
            System.out.println(ans);
            return;
        }
        if (target < 1 || idx == arr.length) {
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            //Can  Pick Only Multiple time
            Combination_Sum(arr, i, target - arr[i], ans + arr[i]);
        }

    }


}
