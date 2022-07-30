package Algorithm_Junction;

public class Euclid_Algo {
    public static void main(String[] args) {
        //Euclid's Algorithm is Used to Find HCF/GCD of Two Number's
        System.out.println(GCD(120, 300));
        System.out.println(euc(12, 24));
        System.out.println(euc(3, 5));
    }
    //Brute Force
    private static int GCD(int a, int b) {
        int ans = 1;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                ans = i;
            }
        }
        return ans;
    }
    //Euclids Algo
//    Time Complexity: O(Log min(a, b))
//    Auxiliary Space: O(1)
    private static int euc(int a, int b) {
        if (b == 0) return a;
        return euc(b, a % b);
    }
}