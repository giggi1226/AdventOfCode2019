import java.lang.reflect.Array;
import java.util.Arrays;

public class AdventOfCode2019_04 {
    public static void main(String []args){

        int count = 0;

        for(int i = 206938; i < 679128; i++){
            if(testNum(i)) count++;
        }
        System.out.println(count);

        count = 0;
        for(int i = 206938; i < 679128; i++){
            if(testNum(i) && testNum2(i)) count++;
        }

        System.out.println(count);
    }

    private static boolean testNum(int n){
        int last = 10;
        boolean adj = false;

        while(n > 0){
            int digit = n % 10;
            if(digit == last) adj = true;
            if(digit > last) return false;
            last = digit;
            n /= 10;
        }
        return adj;
    }

    private static boolean testNum2(int n){
        int last = 10;
        int [] adj = new int[10];

        while(n > 0){
            int digit = n % 10;
            if(digit == last) adj[digit]++;
            last = digit;
            n /= 10;
        }
        for(int d : adj){
            if(d == 1) return true;
        }
        return false;
    }

}
