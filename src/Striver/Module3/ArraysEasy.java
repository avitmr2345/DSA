package Striver.Module3;

public class ArraysEasy {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7, 7, 5 };
        SecondLargestSecondSmallest(arr);
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
}