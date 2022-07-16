package Input_SHortCut;
import java.util.*;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String str = "1-3,9#2 6    87";
        //to split with - Put Hyphen at last
        String[]arr = str.split("[@ # , -]");
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));

        //trim_function
        System.out.println(Integer.parseInt("  9  ".trim()));

//Parsing String into List
        List<Integer>ls = new ArrayList<>();
        for (String s:arr){
            String ss=  s.trim();
            if (ss!="")
            ls.add(Integer.parseInt(ss));
        }
        System.out.println(ls);





    }



}
