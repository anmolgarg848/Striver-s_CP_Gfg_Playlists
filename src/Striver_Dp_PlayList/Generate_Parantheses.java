package Striver_Dp_PlayList;

public class Generate_Parantheses {
    public static void main(String[] args) {
        int n = 6;//op--> 4
        System.out.println(rec(n, 0, 0, "", n));
    }

    //returns Cnt of balanced parantheses generated
    private static int rec(int n, int op, int cl, String par, int tot) {
        if (n == 0 && op == cl) {
            System.out.println(par);
            return 1;
        }
        if (op > tot / 2 || cl > tot / 2 || cl > op) {
            return 0;
        }
        int ob = rec(n - 1, op+1, cl, par + "(", tot);
        int cb = rec(n - 1, op, cl+1, par + ")", tot);
return ob+cl;
    }

}
