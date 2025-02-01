package Striver.Module4;

public class BS_2D {
    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };
        System.out.println(findRowWithMaxOne(arr));
        int[][] arr2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println(findElement(arr2, 8));
    }

    public static int findRowWithMaxOne(int[][] arr) {
        int max = 0;
        int row = -1;

        for (int i = 0; i < arr.length; i++) {
            int count = arr.length - BS_1D.lowerBound(arr[i], 1);
            if (count > max) {
                max = count;
                row = i;
            }
        }
        return row;
    }

    public static boolean findElement(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;

        int s = 0, e = n * m - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            int row = mid / m, col = mid % m;

            if (arr[row][col] == target) {
                return true;
            } else if (arr[row][col] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return false;
    }
}
