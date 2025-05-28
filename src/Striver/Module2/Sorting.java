package Striver.Module2;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 4, 1, 2 };
        // selectionSort(arr);
        // bubbleSort(arr);
        insertionSort(arr);
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

    public static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;

            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {

                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }

            }
        }
    }
}
