public class Day3 {
    public static void main(String[] args) {
        String input = "Hi, I'm Avish";
        System.out.println(reverseStringWordWise(input));
    }
    public static String reverseStringWordWise(String input) {
        String[] str = input.split(" ");
        int len = str.length-1;
        StringBuilder build = new StringBuilder();
        for(int i = len; i >=0; i--){
            if(i != 0){
                build.append(str[i] + " ");
            }
            else build.append(str[i]);
        }
        return build.toString();
    }
}
