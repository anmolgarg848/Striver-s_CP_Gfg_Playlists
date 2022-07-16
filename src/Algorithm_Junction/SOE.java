package Algorithm_Junction;

import java.util.Arrays;

public class SOE {
    public static void main(String[] args) {
        //Sieve Of Eratosthenes  --> Algorithm To Solve Prime Number Problems Easily
//        System.out.println(isPrime(17));
        //Given a number n, print all primes smaller than or equal to n. It is also given that n is a small number.
        Print_Prime(25);
        System.out.println();
        SOE(25);
    }
//Time Complexity: O(n*log(log(n)))
//Auxiliary Space: O(n)
    private static void SOE(int n) {
        boolean[] check = new boolean[n + 1];
        Arrays.fill(check, true);
        check[0] = false;
        check[1] = false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (check[i]) {
                for (int j = i+1; j <=n ; j++) {
                    if (j%i==0){
                        check[j] = false;
                    }
                }
            }
        }
        for (int i = 0; i <=n; i++) {
            if (check[i]){
                System.out.print(i+" ");
            }
        }
    }
    //Brute Force
    private static void Print_Prime(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }

    }

    //Brute Force
    private static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


}
