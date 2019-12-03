import java.util.Arrays;
import java.util.stream.IntStream;

public class AdventOfCode2019_02 {

    public static void main(String[] args) {
        int[] test = {1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 6, 1, 19, 1, 19, 5, 23, 2, 10, 23, 27, 2, 27,
                13, 31, 1, 10, 31, 35, 1, 35, 9, 39, 2, 39, 13, 43, 1, 43, 5, 47, 1, 47, 6, 51, 2, 6, 51, 55, 1, 5,
                55, 59, 2, 9, 59, 63, 2, 6, 63, 67, 1, 13, 67, 71, 1, 9, 71, 75, 2, 13, 75, 79, 1, 79, 10, 83, 2, 83,
                9, 87, 1, 5, 87, 91, 2, 91, 6, 95, 2, 13, 95, 99, 1, 99, 5, 103, 1, 103, 2, 107, 1, 107, 10, 0, 99, 2, 0, 14, 0};

        int [] arr = Arrays.copyOf(test, test.length);

        int res = part1(test,12, 2);
        System.out.println(res);

        int[] array = IntStream.range(0, 100).toArray();
        System.out.println("\n");
        for(int noun = 0; noun < array.length; noun++){
            for(int verb = 0; verb < array.length; verb++){
                res = part1(test, noun, verb);
                test = Arrays.copyOf(arr, arr.length);
                if(res == 19690720){
                    System.out.println(100 * noun + verb);
                }
            }
        }
    }

    private static int part1(int[] arr, int noun, int verb){
        arr[1] = noun;
        arr[2] = verb;
        for(int i = 0; i < arr.length; i = i + 4){
            int position = arr[i + 3];
            if(arr[i] == 1) arr[position] = arr[arr[i + 1]] + arr[arr[i + 2]];
            else if(arr[i] == 2) arr[position] = arr[arr[i + 1]] * arr[arr[i + 2]];
            else if(arr[i] == 99) break;
        }
        return arr[0];
    }
}
