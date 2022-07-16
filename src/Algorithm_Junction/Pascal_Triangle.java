package Algorithm_Junction;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle {
    public static void main(String[] args) {
//In Pascal Triangle each number is the sum of two numbers directly Above it
        int rows = 5;
        Pascal(rows);
    }

    private static void Pascal(int rows) {
        List<Integer> prev = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(prev.get(j) + prev.get(j - 1));
                }
            }
            System.out.println(cur);
            prev = cur;
        }
    }
}
