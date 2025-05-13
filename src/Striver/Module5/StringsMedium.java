package Striver.Module5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringsMedium {

    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static String frequencySort(String s) { // *
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> chars = new ArrayList<>(map.keySet());
        Collections.sort(chars, (a, b) -> (map.get(b) - map.get(a)));

        StringBuilder sb = new StringBuilder();
        for (Object c : chars) {
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static int maxDepth(String s) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                ans -= map.get(s.charAt(i));
            } else {
                ans += map.get(s.charAt(i));
            }
        }
        return ans;
    }
}
