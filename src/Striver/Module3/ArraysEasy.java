package Striver.Module3;

import java.util.ArrayList;

public class ArraysEasy {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7, 7, 5 };
        secondLargestSecondSmallest(arr);
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] arr2 = { 2, 3, 4, 4, 5, 11, 12 };
        System.out.println(union(arr1, arr2, arr1.length, arr2.length));
        int[] arr3 = { 1, 2, 3 };
        missingNumber(arr3, 4);
        int[] arr4 = { 1, 1, 0, 1, 1, 1 };
        System.out.println("The max consecutive count is: " + maxConsecutive(arr4));
    }

    public static void secondLargestSecondSmallest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;

        if (arr.length < 2) {
            System.out.print("-1 -1");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                smin = min;
                min = arr[i];
            } else if (arr[i] != min && arr[i] < smin) {
                smin = arr[i];
            }
            // for smax and max
            if (arr[i] > max) {
                smax = max;
                max = arr[i];
            } else if (arr[i] != max && arr[i] > smax) {
                smax = arr[i];
            }

        }
        if (smax == Integer.MIN_VALUE)
            System.out.println("-1");
        else
            System.out.println("Second max is: " + smax);

        if (smin == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println("Second smallest is: " + smin);
    }

    public static ArrayList<Integer> union(int[] arr1, int[] arr2, int n, int m) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> unionArr = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != arr1[i])
                    unionArr.add(arr1[i]);
                i++;
            } else {
                if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != arr2[j])
                    unionArr.add(arr2[j]);
                j++;
            }
        }

        for (int x = i; x < n; x++) {
            if (!unionArr.contains(arr1[x])) {
                unionArr.add(arr1[x]);
            }
        }

        for (int y = j; y < m; y++) {
            if (!unionArr.contains(arr2[y])) {
                unionArr.add(arr2[y]);
            }
        }
        return unionArr;
    }

    public static void missingNumber(int[] arr, int N) {

        int s1 = (N * (N + 1)) / 2;

        int s2 = 0;
        for (int i = 0; i < N - 1; i++) {
            s2 += arr[i];
        }

        System.out.println("The missing number is: " + (s1 - s2));
    }

    public static int maxConsecutive(int[] arr) {
        int max = 0;
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}