package Algorithm_Junction;

import java.util.Arrays;

public class Bubble_Sort {
    public static void main(String[] args) {

int[]arr = {10,20,5,6,8,1,3,0,5,6,9,2222};
//Bubble sort
    Bubble_Sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void Bubble_Sort(int[]arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j <n-1-i ; j++) {
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
private static void  swap(int[]arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
}
}
