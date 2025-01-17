package Striver.Module4;

public class BS_1D {
    public static void main(String[] args) {
        System.out.println(lowerBound(new int[] { 3, 9, 34, 39, 43, 94, 99 }, 40));
        System.out.println(upperBound(new int[] { 3, 5, 8, 9, 15, 19 }, 7));
    }

    public static int lowerBound(int[] arr, int x) {
        if (x > arr[arr.length - 1]) {
            return arr.length;
        }
        int index = -1;
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;

            if (x <= arr[mid]) {
                index = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return index;
    }

    public static int upperBound(int[] arr, int x) {
        int index = arr.length;

        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;

            if (x >= arr[mid]) {
                index = mid + 1;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return index;
    }
}
