import java.util.Arrays;

public class AdventOfCode2019_01 {

        public static void main(String[] args) {
            int [] arr = { 50572, 126330, 143503, 136703, 56987, 96737, 140243, 94427, 84262, 149323, 87398, 132344, 72187,
                    90878, 72897, 101305, 129483, 101148, 66349, 76719, 86437, 84937, 73911, 141051, 61464, 85350, 81774,
                    129191, 130129, 118366, 125825, 61781, 98459, 69024, 75886, 119434, 108929, 117387, 149625, 79378,
                    102582, 102368, 117177, 132105, 137278, 149187, 136653, 70074, 115885, 73901, 81922, 133232, 112929,
                    80009, 116895, 61248, 140251, 98003, 109610, 132775, 55781, 110809, 109799, 125071, 71734, 104973,
                    75610, 148974, 144173, 89235, 89438, 64901, 142674, 105446, 55287, 64438, 82269, 99903, 97079, 72708,
                    108177, 130830, 50393, 141354, 123264, 116302, 51119, 127287, 137515, 109285, 110750, 93770, 54926,
                    57131, 136897, 97693, 135531, 122858, 112089, 98599 };

            int total = Arrays.stream(arr).map(mod -> (int) (Math.floor(mod / 3) - 2)).sum();
            System.out.println(total);

            int extrafuel = Arrays.stream(arr).map(mod -> {
                int fuelForModule = (int) (Math.floor(mod / 3) - 2);
                int totalMod = 0;
                while(fuelForModule > 0){
                    totalMod += fuelForModule;
                    fuelForModule = (int) (Math.floor(fuelForModule / 3) - 2);
                }
                return totalMod;
            }).sum();

            System.out.println(extrafuel);
        }
}
