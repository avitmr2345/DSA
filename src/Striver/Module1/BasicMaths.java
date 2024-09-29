package Striver.Module1;

import java.util.ArrayList;

public class BasicMaths {
    public static void main(String[] args) {
        int N = 329823;
        System.out.println("Number of Digits in N: " + countDigits(N));
        System.out.println("The reverse number is: " + reverseNum(N));
        palindromeCheck(4554);
        System.out.println(findGCD(20, 15));
        System.out.println(armstrongNumber(371));
        System.out.println(findDivisors(36));
        System.out.println(checkPrime(36));
    }

    static int countDigits(int n) {
        int count = (int) (Math.log10(n) + 1);
        return count;
    }

    static int reverseNum(int n) {
        int reversedNum = 0;
        int lastDigit = 0;
        while (n > 0) {
            lastDigit = n % 10;
            reversedNum = (reversedNum * 10) + lastDigit;
            n = n / 10;
        }
        return reversedNum;
    }

    static void palindromeCheck(int n) {
        int reversedNum = reverseNum(n);
        if (n == reversedNum) {
            System.out.println(n + " is a palindrome");
        } else
            System.out.println(n + " is not a palindrome");
    }

    public static int findGCD(int a, int b) {
        while (a > 0 && b > 0) {
            // subtract b from a and update a
            if (a > b) {
                a = a % b;
            }
            // subtract a from b and update b
            else {
                b = b % a;
            }
        }
        if (a == 0) {
            return b;
        }
        return a;
    }

    static boolean armstrongNumber(int n) {
        int power = String.valueOf(n).length();
        int orig_num = n;
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans += Math.pow(rem, power);
            n /= 10;
        }

        return orig_num == ans ? true : false;
    }

    public static ArrayList<Integer> findDivisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<>();
        int sqrtN = (int) Math.sqrt(n);

        for (int i = 1; i <= sqrtN; ++i) {
            if (n % i == 0) {
                divisors.add(i);

                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        return divisors;
    }

    static boolean checkPrime(int n) {
        int count = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;

                if (i != n / i) {
                    count++;
                }
            }
        }
        return count == 2 ? true : false;
    }
}
