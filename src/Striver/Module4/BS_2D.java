package Striver.Module4;

import java.util.Arrays;

public class BS_2D {
    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };
        System.out.println(findRowWithMaxOne(arr));
        int[][] arr2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println(findElement(arr2, 8));
        int[][] arr3 = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        System.out.println(searchElement(arr3, 14));
        int[][] arr4 = { { 10, 20, 15 }, { 21, 30, 14 }, { 7, 16, 32 } };
        System.out.println(Arrays.toString(findPeakGrid(arr4)));
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

    public static boolean searchElement(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;

        int row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (arr[row][col] == target)
                return true;
            else if (arr[row][col] < target)
                row++;
            else
                col--;
        }
        return false;
    }

    public static int[] findPeakGrid(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (j - 1 >= 0) {
                    if (mat[i][j - 1] > mat[i][j]) {
                        continue;
                    }
                }
                if (j + 1 < mat[0].length) {
                    if (mat[i][j + 1] > mat[i][j]) {
                        continue;
                    }
                }
                if (i - 1 >= 0) {
                    if (mat[i - 1][j] > mat[i][j]) {
                        continue;
                    }
                }
                if (i + 1 < mat.length) {
                    if (mat[i + 1][j] > mat[i][j]) {
                        continue;
                    }
                }
                return new int[] { i, j };
            }
        }
        return new int[] { -1, -1 };
    }
}
