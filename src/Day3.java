public class Day3 {
    public static void main(String[] args) {
        // String input = "Hi, I'm Avish";
        // System.out.println(reverseStringWordWise(input));
        
        String message = "aabbc";
        System.out.println(encode(message));
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
    public static String encode(String message) {
		StringBuilder ans = new StringBuilder();
		int count;
		for(int i=0;i<message.length();i++){
			char ch = message.charAt(i);
			count = 1;
			while(i+1<message.length() && ch==message.charAt(i+1)){
				i++;
				count++;
			}
			ans.append(ch);
			ans.append(count);
		}
		return ans.toString();
	}
}
