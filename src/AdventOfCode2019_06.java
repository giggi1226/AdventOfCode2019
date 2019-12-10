import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class AdventOfCode2019_06 {
    static Map<String, Node> orbits = new HashMap<>();
    public static void main(String[] args) throws IOException {
        List<String> arr = new ArrayList<>();

        File file = new File("src/input.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            arr.add(sc.nextLine());
        }
        System.out.println(arr.size());

        for(int i = 0; i < arr.size(); i++){
            String [] current = arr.get(i).split("\\)");
            if(!orbits.containsKey(current[0])){
                orbits.put(current[0], new Node());
            }
            if(!orbits.containsKey(current[1])){
                orbits.put(current[1], new Node());
            }
            orbits.get(current[0]).children.add(current[1]);
            orbits.get(current[1]).parent = current[0];
        }
        int sum = getOrbitsCount("COM", 0);
        System.out.println(sum);

        LinkedList<String> list1 = getParents("YOU", new LinkedList<>());
        LinkedList<String> list2 = getParents("SAN", new LinkedList<>());
        while (list1.getFirst().equals(list2.getFirst())){
            list1.removeFirst();
            list2.removeFirst();
        }
        System.out.println(list1.size() + list2.size());

    }

    static LinkedList<String> getParents (String node, LinkedList<String> list){
        String parent = orbits.get(node).parent;
        if (parent != null) {
            list.addFirst(parent);
            return getParents(parent, list);
        }
        return list;
    }

    private static int getOrbitsCount(String node, int result){
        int sum = result;
        List<String> children = orbits.get(node).children;
        for(String child : children){
            sum += getOrbitsCount(child, result + 1);
        }
        return sum;
    }
}

class Node{
    String parent;
    List<String> children = new ArrayList<>();
}
