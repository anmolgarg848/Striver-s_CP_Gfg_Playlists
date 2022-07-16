package Striver_CP.Week1;

public class Max_sum {
    public static void main(String[] args) {
        /*
        Largest Sum of Contiguous sub-array
        Given n and k find the maximum sub-array sum of Size K
         */
        int[] arr = {2, -1, 2, 3,56, -10};
        int n = arr.length;
        int k = 2;
//        System.out.println(Kadanes(arr));
//=========Brute Force Approach ==========
        //Generate All Sub-arrays of Size K --> Take sum of it --> get Max of it
        Gen_SubArrays(arr, k);
        System.out.println(Size_k(arr,k));
        System.out.println(Size_K_Brute(arr,k));
    }
//Brute Force --> Two Pointers
    //T.c--> O(N^2)

    private static int Size_K_Brute(int[]arr,int k){
        int ans = 0;
        int n = arr.length;
        for (int i = 0; i <=n-k; i++) {
            int sum = 0;
            for (int j = i; j <=i+k-1 ; j++) {
                sum+=arr[j];
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
    //Optimized Approach --> Sliding Window / Two Pointers
    //T.c--> O(N)

    private static int Size_k(int[] arr, int k) {
      //Single Pointer Technique --> BackWard Subtract
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans+=arr[i];
        }
        int n = arr.length;
        //Place ith Pointer
        int cur_sum = ans;
        for (int i = k; i <n ; i++) {
         cur_sum+=arr[i]-arr[i-k];
            ans = Math.max(cur_sum,ans);
        }
        return ans;
    }

    //Standard Kadanes Algorithm
    //We can Also Modify this Algorithm to get Maximum In Negative
    private static int Kadanes(int[] arr) {
        //Home Work
        //Max So Far
        int msf = 0;
        int me = 0;

        for (int ele : arr) {
            me += ele;
            if (me > msf) msf = me;
            if (me < 0) me = 0;
        }
        return msf;
    }

    private static void Gen_SubArrays(int[] arr, int k) {
        int max = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
//                for (int l = i; l <= j; l++) {
//                    System.out.print(arr[l] + " ");
//                }
//                System.out.println();
                if ((j - i + 1) == k) {
                    max = Math.max(max, Sum(arr, i, j));
                }
            }

        }
        System.out.println(max);
    }

    private static int Sum(int[] arr, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }
}
