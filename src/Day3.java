public class Day3 {
    public static void main(String[] args) {
        // String input = "Hi, I'm Avish";
        // System.out.println(reverseStringWordWise(input));

        // String message = "aabbc";
        // System.out.println(encode(message));

        // String pattern = ")((()";
        // System.out.println(minimumParentheses(pattern));

        String s = "0000";
        System.out.println(makeBeautiful(s));
    }

    public static String reverseStringWordWise(String input) {
        String[] str = input.split(" ");
        int len = str.length - 1;
        StringBuilder build = new StringBuilder();
        for (int i = len; i >= 0; i--) {
            if (i != 0) {
                build.append(str[i] + " ");
            } else
                build.append(str[i]);
        }
        return build.toString();
    }

    public static String encode(String message) {
        StringBuilder ans = new StringBuilder();
        int count;
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            count = 1;
            while (i + 1 < message.length() && ch == message.charAt(i + 1)) {
                i++;
                count++;
            }
            ans.append(ch);
            ans.append(count);
        }
        return ans.toString();
    }

    public static int minimumParentheses(String pattern) {
        int opencount = 0;
        int closingcount = 0;
        for (char ch : pattern.toCharArray()) {
            if (ch == '(') {
                opencount++;
            } else if (ch == ')' && opencount > 0) {
                opencount--;

            } else if (ch == ')') {
                closingcount++;
            }
        }
        return opencount + closingcount;
    }

    public static int makeBeautiful(String str) {
        int len = str.length();
        int result1 = 0;
        int result2 = 0;
        char arr1[] = new char[len];
        char arr2[] = new char[len];
        for (int i = 0; i < len; i++) {
            if (i % 2 != 0) {
                arr1[i] = '1';
                arr2[i] = '0';
            } else if (i % 2 == 0) {
                arr1[i] = '0';
                arr2[i] = '1';
            }
            if (str.charAt(i) != arr1[i]) {
                result1++;
            } else if (str.charAt(i) != arr2[i]) {
                result2++;
            }
        }
        return Math.min(result1, result2);
    }
}
