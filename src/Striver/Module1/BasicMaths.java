package Striver.Module1;

public class BasicMaths {
    public static void main(String[] args) {   
        int N = 329823;
        System.out.println("Number of Digits in N: " + countDigits(N));
    }
    
    static int countDigits(int n) {
        int count = (int) (Math.log10(n) + 1);
        return count;
    }
}
