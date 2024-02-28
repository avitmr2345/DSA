import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Day5 {
    public static void main(String[] args) {
        // ArrayList<Integer> arr = new ArrayList<>();
        // arr.add(1);
        // arr.add(2);
        // arr.add(1);
        // arr.add(2);
        // System.out.println(minElementsToRemove(arr));

        // System.out.println(firstNonRepeatingCharacter("aDcadhc"));

        // ArrayList<Integer> arr = new ArrayList<>();
        // arr.add(1);
        // arr.add(-1);
        // arr.add(4);
        // arr.add(2);
        // arr.add(-2);
        // System.out.println(LongestSubsetWithZeroSum(arr));

        // ArrayList<Integer> arr = new ArrayList<>();
        // arr.add(5);
        // arr.add(0);
        // arr.add(2);
        // arr.add(3);
        // arr.add(1);
        // System.out.println(subArrayCount(arr, 5));

        ArrayList<String> inputStr = new ArrayList<>();
        inputStr.add("abab");
        inputStr.add("baba");
        inputStr.add("aabb");
        inputStr.add("abbc");
        System.out.println(getGroupedAnagrams(inputStr, inputStr.size()));
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

    public static char firstNonRepeatingCharacter(String str) {
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int number = hashmap.getOrDefault(ch, 0);
            hashmap.put(ch, number + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hashmap.get(ch).intValue() == 1) {
                return ch;
            }
        }
        return str.charAt(0);
    }

    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum = sum + arr.get(i);
            if (map.containsKey(sum)) {
                max = Math.max(max, (i - map.get(sum)));
            } else if (sum == 0) {
                max = i + 1;
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }

    public static int subArrayCount(ArrayList<Integer> arr, int k) {
        HashMap<Long, Integer> hmap = new HashMap<>();
        int ans = 0;
        long sum = 0;
        hmap.put(sum, 1);
        for (int i = 0; i < arr.size(); i++) {
            sum = sum + arr.get(i);
            long rem = sum % k;
            if (rem < 0) {
                rem += k;
            }
            if (hmap.containsKey(rem)) {
                ans = ans + hmap.get(rem);
                hmap.put(rem, hmap.get(rem) + 1);
            } else {
                hmap.put(rem, 1);
            }
        }
        return ans;
    }

    public static ArrayList<ArrayList<String>> getGroupedAnagrams(ArrayList<String> inputStr, int n) {
        if (inputStr.size() == 0) {
            return new ArrayList<>();
        }
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String i : inputStr) {
            char[] chars = i.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(i);
        }
        return new ArrayList<>(map.values());
    }
}
