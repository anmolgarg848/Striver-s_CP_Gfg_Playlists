package Striver_Dp_PlayList;

public class SubseQuence {

    public static void main(String[] args) {
        //Generate All the Subsequences ---> Contiguous ans Maintains Order
        int[] arr = {1, 2, 3};
//        total === 2^n
//Approach --> Power Set  , Pick and Non Pick (Recursion )
//        Gen_ss(arr, 0, "");
    Power_Set(arr);
    }

    //Pick and not pick T.c - -> O(2^n)
    private static void Gen_ss(int[] arr, int idx, String ans) {
        if (idx == arr.length) {
            System.out.println(ans);
            return;
        }

        //Pick
        Gen_ss(arr, idx + 1, ans + arr[idx] + " ");
        //Not Pick
        Gen_ss(arr, idx + 1, ans);
    }

    /*
    Power set is an Algorithm To generate Subsequences
    Based On Bit Manipulation Of Numbers By converting Them In Binary
     */
    //Time Complexity --> O(2^n * n )
    //Approach 2 --> Power Set
    private static void Power_Set(int[] arr) {
        int n = arr.length;
        //Outer Loop ->  0  to (2^n) - 1 Times
        for (int i = 0; i < (int)Math.pow(2,n); i++) {
            String ss = "";
            //Inner Loop --> Binary
            for (int j = 0; j < n; j++) {
             //check if ith Bit is Set or Not
                if ((i&(1<<j))!=0){
                    ss+=arr[j];
                }
            }
            System.out.println(ss);
        }
    }
/*Algorithm Pre-Requisite

Check if ith bit Of any Given Number is Set Or Not
5 - - >    1 0 1
Just Put  & 1 0 0     at ith Digit and Others As 0  Then Do & of it
          - -- - - - -
Then Number Get After & must be Non-Zero  .
Use Left shift Operator  1<<i(position)  to set 1 at ith bit
(n(1<<i))!=0 Then Bit is set else Not set
 */


}
