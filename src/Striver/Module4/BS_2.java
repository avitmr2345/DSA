package Striver.Module4;

public class BS_2 {
    public static void main(String[] args) {
        System.out.println(findSquareRoot(28));
        System.out.println(findNthRoot(27, 3));
        System.out.println(eatBananas(new int[] { 7, 15, 6, 3 }, 8));
        System.out.println(makeBouquets(new int[] { 7, 7, 7, 7, 13, 11, 12, 7 }, 2, 3) + " days");
        System.out.println(findSmallestDivisor(new int[] { 1, 2, 3, 4, 5 }, 9));
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

    public static int eatBananas(int[] arr, int hours) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int s = 1, e = max;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int totalHours = 0;

            for (int i = 0; i < arr.length; i++) {
                totalHours += Math.ceil((double) arr[i] / (double) mid);
            }

            if (totalHours <= hours) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    public static int makeBouquets(int[] arr, int bouquets, int roses) {
        if (arr.length < bouquets * roses)
            return -1;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int s = min, e = max;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int count = 0;
            int completedBouquets = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= mid) {
                    count++;
                } else
                    count = 0;

                if (count == roses) {
                    completedBouquets++;
                    count = 0;
                }
            }

            if (completedBouquets == bouquets) {
                return mid;
            } else if (completedBouquets < bouquets) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public static int findSmallestDivisor(int[] arr, int limit) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int s = 1, e = max;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int count = 0;

            for (int i = 0; i < arr.length; i++) {
                count += Math.ceil((double) arr[i] / (double) mid);
            }

            if (count <= limit) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}
