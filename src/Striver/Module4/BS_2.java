package Striver.Module4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BS_2 {
    public static void main(String[] args) {
        System.out.println(findSquareRoot(28));
        System.out.println(findNthRoot(27, 3));
        System.out.println(eatBananas(new int[] { 7, 15, 6, 3 }, 8));
        System.out.println(makeBouquets(new int[] { 7, 7, 7, 7, 13, 11, 12, 7 }, 2, 3) + " days");
        System.out.println(findSmallestDivisor(new int[] { 1, 2, 3, 4, 5 }, 9));
        System.out.println(shipPackages(new int[] { 5, 4, 5, 2, 3, 4, 5, 6 }, 5) + " is the least weight capacity");
        System.out.println(findKthMissingNumber(new int[] { 4, 7, 9, 10 }, 4));
        System.out.println(aggressiveCows(new int[] { 0, 3, 4, 7, 10, 9 }, 4));
        System.out.println(findPages(new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24)), 5, 4));
        System.out.println(findMinimizedLargestSum(new int[] { 1, 2, 3, 4, 5 }, 3));
        System.out.println(paintersPartition(new int[] { 10, 20, 30, 40 }, 2));
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

    public static int shipPackages(int[] arr, int days) {
        int s = Integer.MIN_VALUE, e = 0;
        for (int i = 0; i < arr.length; i++) {
            e += arr[i];
            if (arr[i] > s) {
                s = arr[i];
            }
        }

        if (days == 1)
            return e;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int load = 0;
            int completedDays = 1;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] + load > mid) {
                    completedDays++;
                    load = arr[i];
                } else {
                    load += arr[i];
                }
            }

            if (completedDays <= days) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    public static int findKthMissingNumber(int[] arr, int k) { // #
        int s = 0, e = arr.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return k + e + 1;
    }

    public static boolean canWePlace(int[] stalls, int dist, int cows) {
        int cntCows = 1;
        int lastPlacedCow = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlacedCow >= dist) {
                cntCows++;
                lastPlacedCow = stalls[i];
            }
            if (cntCows >= cows)
                return true;
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) { // #
        Arrays.sort(stalls);

        int low = 1, high = stalls[stalls.length - 1] - stalls[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, mid, k) == true) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return high;
    }

    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                pagesStudent += arr.get(i);
            } else {
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) { // #
        if (m > n)
            return -1;

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countPartitions(int[] arr, int maxSum) {
        int partitions = 1;
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= maxSum) {
                sum += arr[i];
            } else {
                partitions++;
                sum = arr[i];
            }
        }
        return partitions;
    }

    public static int findMinimizedLargestSum(int[] arr, int k) {
        int low = arr[0];
        int high = 0;
        for (int i = 0; i < arr.length; i++) {
            low = Math.max(arr[i], low);
            high += arr[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = countPartitions(arr, mid);
            if (partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countPainters(int[] arr, int time) {
        int painters = 1;
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= time) {
                sum += arr[i];
            } else {
                painters++;
                sum = arr[i];
            }
        }
        return painters;
    }

    public static int paintersPartition(int[] arr, int k) {
        int low = arr[0];
        int high = 0;
        for (int i = 0; i < arr.length; i++) {
            low = Math.max(arr[i], low);
            high += arr[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int painters = countPainters(arr, mid);
            if (painters > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
