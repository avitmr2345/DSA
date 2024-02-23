import java.util.Arrays;

public class Day4 {
    public static void main(String[] args) {
        // int[][] mat = {{1,0}, {0,1}};
        // System.out.println(coverageOfMatrix(mat));

        // int[][] matrix = { { 1, 2, 3 }, { 2, 4, 5 }, { 3, 5, 8 } };
        // System.out.println(isMatrixSymmetric(matrix));

        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        inplaceRotate(arr, arr.length);
        System.out.println(Arrays.deepToString(arr));
    }

    public static Integer coverageOfMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        Integer ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    if (i - 1 >= 0 && mat[i - 1][j] == 1)
                        ans++;
                    if (i + 1 < row && mat[i + 1][j] == 1)
                        ans++;
                    if (j - 1 >= 0 && mat[i][j - 1] == 1)
                        ans++;
                    if (j + 1 < col && mat[i][j + 1] == 1)
                        ans++;
                }
            }
        }
        return ans;
    }

    public static boolean isMatrixSymmetric(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void inplaceRotate(int[][] arr, int n) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
        }
        for (int i = 0; i < arr[0].length; i++) {

            for (int j = 0, k = arr[0].length - 1; j < k; j++, k--) {
                int temp = arr[j][i];
                arr[j][i] = arr[k][i];
                arr[k][i] = temp;
            }
        }
    }
}