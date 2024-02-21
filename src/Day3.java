public class Day3 {
    public static void main(String[] args) {
        // String input = "Hi, I'm Avish";
        // System.out.println(reverseStringWordWise(input));

        // String message = "aabbc";
        // System.out.println(encode(message));

        // String pattern = ")((()";
        // System.out.println(minimumParentheses(pattern));

        // String s = "0000";
        // System.out.println(makeBeautiful(s));

        String number = "1221";
        System.out.println(nextLargestPalindrome(number, number.length()));
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

    public static String nextLargestPalindrome(String number, int length) {

        char s[] = number.toCharArray();

        // Initializing carry to keep track of the carry forward at the time of
        // addition.
        int carry = 1, temp;

        // Loop to add 1 to the number represented by string S.

        for (int i = length - 1; i >= 0; i--) {
            if ((s[i] - 48) + carry <= 9) {
                s[i] = (char) ((s[i] - 48) + carry + 48);
                carry = 0;
            }

            else {
                temp = (s[i] - 48 + carry) % 10;
                s[i] = (char) (temp + 48);

                carry = 1;
            }

        }

        if (carry != 0) {

            String str = "";
            for (char c : s)
                str += c;
            str = (char) (carry + 48) + str;

            s = str.toCharArray();
        }

        int i = 0, j = s.length - 1, pos = 0;
        boolean conditionViolated = false;

        // Converting string s to a palindrome.
        while (i <= j) {
            if (s[i] < s[j]) {
                s[j] = s[i];
                pos = i;
                conditionViolated = true;
            }

            else if (s[i] > s[j]) {
                s[j] = s[i];
                conditionViolated = false;
            }

            else if (conditionViolated && s[i] != '9') {
                pos = i;
            }

            i++;
            j--;
        }

        // Checking if the condition is violated or not.
        // Finding the smallest palindrome strictly greater than the input number.
        if (conditionViolated) {

            s[pos]++;
            s[s.length - 1 - pos] = s[pos];

            for (int k = pos + 1; k <= (s.length - 1) / 2; k++) {
                s[s.length - 1 - k] = s[k] = '0';
            }

        }
        number = new String(s);

        return number;
    }
}
