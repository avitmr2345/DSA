package Striver.Module3;

import java.util.ArrayList;

public class ArraysEasy {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7, 7, 5 };
        SecondLargestSecondSmallest(arr);
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] arr2 = { 2, 3, 4, 4, 5, 11, 12 };
        System.out.println(Union(arr1, arr2, arr1.length, arr2.length));
    }

    public static void SecondLargestSecondSmallest(int[] arr) {
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

    public static ArrayList<Integer> Union(int[] arr1, int[] arr2, int n, int m) {
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
}