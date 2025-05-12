package Striver.Module5;

class StringsEasy {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("((()())(()()))"));
        System.out.println(reverseWords("a good   example"));
        System.out.println(largestOddNumber("23953767242388496965328710"));
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
        for (int i = num.length() - 1; i > 0; i--) {
            int n = Character.getNumericValue(num.charAt(i));
            if (n % 2 != 0) {
                return num;
            }
            num = num.substring(0, i);
        }
        return "";
    }
}