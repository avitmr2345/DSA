package Striver.Module4;

public class BS_2 {
    public static void main(String[] args) {
        System.out.println(findSquareRoot(28));
        System.out.println(findNthRoot(27, 3));
    }

    public static long findSquareRoot(long n) {
        long s = 1, e = n;
        long ans = -1;

        while (s <= e) {
            long mid = s + (e - s) / 2;

            if (mid * mid <= n) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    public static int power(int mid, int pow, int n) {
        long ans = 1;
        for (int i = 1; i <= pow; i++) {
            ans = ans * mid;
        }
        if (ans > n)
            return 2;
        if (ans == n)
            return 1;
        return 0;
    }

    public static int findNthRoot(int n, int pow) {
        int s = 1, e = n;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int multiplication = power(mid, pow, n);

            if (multiplication == 1) {
                return mid;
            } else if (multiplication == 0) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
}
