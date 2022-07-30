package Striver_Dp_PlayList;

public class Jump_Game_II {
    public static void main(String[] args) {
        //reach n-1th in minimum number of Moves
        int[] arr = {2, 3, 1, 1, 4};
//        int[] arr = {2,3,0,1,4};
        int n = arr.length;
        System.out.println(rec(arr, 0, n));
    }

    //returns minimum moves
    private static int rec(int[] arr, int idx, int n) {
        if (idx == n - 1) return 0;
        int min_moves = arr.length;
        for (int i = 1; i <= arr[idx]; i++) {
            min_moves = Math.min(rec(arr, idx + i, n) + 1, min_moves);

        }
        return min_moves;
    }

}
