package Striver.Module5;

class StringsEasy {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("((()())(()()))"));
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
}