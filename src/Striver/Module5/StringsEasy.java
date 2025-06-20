package Striver.Module5;

import java.util.Arrays;

class StringsEasy {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("((()())(()()))"));
        System.out.println(reverseWords("a good   example"));
        System.out.println(largestOddNumber("23953767242388496965328710"));
        String[] arr1 = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(arr1));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(rotateString("defdefdefabcabc", "defdefabcabcdef"));
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static String removeOuterParentheses(String s) { // *
        int len = s.length();
        if (len <= 2)
            return "";
        char[] c = s.toCharArray();
        StringBuilder result = new StringBuilder();
        int flag = 1;

        for (int i = 1; i < len; i++) {
            if (c[i] == '(') {
                flag++;
                if (flag > 1)
                    result.append('(');
            } else {
                if (flag > 1)
                    result.append(')');
                flag--;
            }
        }
        return result.toString();
    }

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] arr = s.trim().split("\\s+");
        for (int i = arr.length - 1; i >= 0; i--) {
            result.append(arr[i]);
            if (i > 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int n = Character.getNumericValue(num.charAt(i));
            if (n % 2 != 0) {
                return num;
            }
            num = num.substring(0, i);
        }
        return "";
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    public static boolean isIsomorphic(String s, String t) { // *
        int map1[] = new int[200];
        int map2[] = new int[200];

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (map1[s.charAt(i)] != map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static boolean rotateString(String s, String goal) {
        int len = s.length();
        StringBuilder result = new StringBuilder();

        if (s.equals(goal)) {
            return true;
        }

        for (int i = 0; i < len - 1; i++) {
            char first = s.charAt(0);
            result.setLength(0);

            for (int j = 1; j < len; j++) {
                result.append(s.charAt(j));
            }
            result.append(first);

            if (goal.equals(result.toString())) {
                return true;
            }
            s = result.toString();
        }
        return false;

        // Better time complexity solution:
        // if(s.length() != goal.length()) return false;
        // return (s+s).contains(goal);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        s = s.toLowerCase();
        t = t.toLowerCase();

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 97]++;
        }

        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 97]--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)
                return false;
        }
        return true;
    }
}