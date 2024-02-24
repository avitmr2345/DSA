import java.util.ArrayList;
import java.util.HashSet;

public class Day5 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(2);
        System.out.println(minElementsToRemove(arr));
    }

    public static int minElementsToRemove(ArrayList<Integer> arr) {
        if (arr.size() == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            set.add(arr.get(i));
        }
        return arr.size() - set.size();
    }
}
