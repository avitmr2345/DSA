package Striver.Module4;

public class BS_2D {
    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };
        System.out.println(findRowWithMaxOne(arr));
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
}
