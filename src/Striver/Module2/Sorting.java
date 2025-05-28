package Striver.Module2;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 1, 2, 3 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            int last = arr.length - i - 1;

            // find max element and after put it to last index
            for (int j = 0; j <= last; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }

            int temp = arr[max];
            arr[max] = arr[last];
            arr[last] = temp;
        }
    }
}
