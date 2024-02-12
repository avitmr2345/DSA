import java.util.Scanner;
import java.util.ArrayList;

public class Day1 {
    public static void main(String[] args) {
        // int[] arr = { 2, 4, 5, 6, 8 };
        // int n = arr.length;
        // System.out.println(findSecondLargest(n, arr));

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        if (k > n) {
            k %= n;
        }
        System.out.println(rotateArray(arr, n, k).toString());
        scanner.close();
    }

    public static int findSecondLargest(int n, int[] arr) {
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            if (arr[i] > max) {
                smax = max;
                max = arr[i];
            } else if (arr[i] > smax && arr[i] != max) {
                smax = arr[i];
            }
        }
        return smax != Integer.MIN_VALUE ? smax : -1;
    }

    public static ArrayList<Integer> rotateArray(int[] arr, int n, int k) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = k; i < n; i++) {
            a.add(arr[i]);
        }
        for (int i = n - k, j = 0; i < n; i++, j++) {
            a.add(arr[j]);
        }
        return a;
    }
}