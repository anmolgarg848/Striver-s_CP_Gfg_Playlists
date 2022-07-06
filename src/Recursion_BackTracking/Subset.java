package Recursion_BackTracking;

public class Subset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ss(arr, 0, "");
        System.out.println("===============================");
        Power_set(arr);
        System.out.println("===============================");
        ss_k(arr,0,5,"");
    }

    //Recursive Approach--> Pick and Not Pick
    private static void ss(int[] arr, int idx, String ans) {
        if (idx == arr.length) {
            System.out.println(ans);
            return;
        }
        ss(arr, idx + 1, ans + arr[idx]);
        ss(arr, idx + 1, ans);
    }

    //Power set Approach--> Binary
    private static void Power_set(int[] arr) {
        //Pick Not Pick Based On binary of a number
        int n = arr.length;
        int tot = (int) Math.pow(2, n);
        for (int i = 0; i < tot; i++) {
            String ans = "";
            for (int j = 0; j < n; j++) {
                //bit is set then pick
                if ((i & (1 << j)) > 0) {
                    ans += arr[j];
                }
            }
            System.out.println(ans);
        }
    }

    //Print Subset Whose Sum is k
    private static void ss_k(int[] arr, int idx, int k, String ans) {
        if (k == 0) {
            System.out.println(ans);
            return;
        }
        if (idx == arr.length) {
            return;
        }
        ss_k(arr, idx + 1, k - arr[idx], ans + arr[idx]);
        ss_k(arr, idx + 1, k, ans);
    }


}
