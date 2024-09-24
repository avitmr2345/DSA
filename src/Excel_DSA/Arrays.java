package Excel_DSA;

public class Arrays {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 6, 8 };
        System.out.println(findSecondLargest(arr, arr.length));
    }

    public static int findSecondLargest(int[] arr, int n) {
        int largest = Integer.MIN_VALUE;
        int second_largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                second_largest = largest;
                largest = arr[i];
            } else if (arr[i] > second_largest && arr[i] != largest) {
                second_largest = arr[i];
            }
        }
        return (second_largest != Integer.MIN_VALUE) ? second_largest : -1;
    }
}