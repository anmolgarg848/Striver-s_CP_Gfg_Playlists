package Algorithm_Junction;

public class Kadanes_Algo {
    public static void main(String[] args) {
//        Total Sub-arrays  = n(n+1)/2

        //Maximum circular sum
        int[] arr = {-1, -3, -5, -2, -9};
//        System.out.println(Kadanes_Algo(arr));
        System.out.println(Kadanes_Algo1(arr));
    }

    //Standard Algo --> Only For Positives
    private static int Kadanes_Algo(int[] arr) {
        int max_so_far = 0, max_cur = 0;
        for (int ele : arr) {
            max_cur += ele;
            max_so_far = Math.max(max_so_far, max_cur);
            if (max_cur < 0) max_cur = 0;
        }
        return max_so_far;
    }

    //Handles -ve Max sum also
    private static int Kadanes_Algo1(int[] arr) {
        int max_so_far = arr[0], max_cur = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            max_cur += arr[i];
            max_so_far = Math.max(max_cur, max_so_far);
            if (max_cur < 0) max_cur = 0;
        }

        return max_so_far;
    }

    private static int Kadanes_Circular(int[] arr) {
        int n = arr.length;
        //Try Later

        return 0;
    }

}
