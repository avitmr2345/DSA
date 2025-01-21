package Striver.Module4;

public class BS_2 {
    public static void main(String[] args) {
        System.out.println(findSquareRoot(28));

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
}
