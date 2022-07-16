package Arrays;

public class Arrays_Product_Except_Self {
    public static void main(String[] args) {
         int[]arr  = {10, 3, 5, 6, 2};
//         prod  = {180, 600, 360, 300, 900};

//        Without Using Divisor Operator
    bf(arr);
    }
    //Optimized
    private static void Opt(int[]arr){
        int n = arr.length;
//left and right product --> Prefix Suffix Approach

    }

    //Brute Force
    private static void bf(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            int prod = 1;
            for (int j = 0; j < arr.length; j++) {
                if (j!=i){
                    prod*=arr[j];
                }
            }
            System.out.print(prod+" ");
        }
        System.out.println();
    }
}
