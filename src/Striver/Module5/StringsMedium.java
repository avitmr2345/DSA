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
        System.out.println(myAtoi("  0000000000012345678"));
        System.out.println(longestPalindrome("abba"));
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

    public static int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        s = s.trim();

        if (s.isEmpty())
            return 0;

        if (s.charAt(0) == '-') {
            sb.append(s.charAt(0));
            index = 1;
        } else if (s.charAt(0) == '+') {
            index = 1;
        }

        for (int i = index; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                if (sb.length() == 1 && sb.charAt(0) == '-') {
                    continue;
                } else if (sb.length() == 0) {
                    continue;
                } else {
                    sb.append(ch);
                }
            } else if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                break;
            }
        }

        String numStr = sb.toString();
        if (numStr.equals("-") || numStr.isEmpty()) {
            return 0;
        }

        String maxIntStr = String.valueOf(Integer.MAX_VALUE);
        String minIntStr = String.valueOf(Integer.MIN_VALUE);

        if (numStr.charAt(0) == '-') {
            if (numStr.length() > minIntStr.length() ||
                    (numStr.length() == minIntStr.length() && numStr.compareTo(minIntStr) > 0)) {
                return Integer.MIN_VALUE;
            }
        } else {
            if (numStr.length() > maxIntStr.length() ||
                    (numStr.length() == maxIntStr.length() && numStr.compareTo(maxIntStr) > 0)) {
                return Integer.MAX_VALUE;
            }
        }
        return Integer.parseInt(numStr);
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);

            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }
            if (even.length() > maxStr.length()) {
                maxStr = even;
            }
        }

        return maxStr;
    }

    private static String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
