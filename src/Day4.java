import java.util.Arrays;

public class Day4 {
    public static void main(String[] args) {
        // int[][] mat = {{1,0}, {0,1}};
        // System.out.println(coverageOfMatrix(mat));

        // int[][] matrix = { { 1, 2, 3 }, { 2, 4, 5 }, { 3, 5, 8 } };
        // System.out.println(isMatrixSymmetric(matrix));

        // int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // inplaceRotate(arr, arr.length);
        // System.out.println(Arrays.deepToString(arr));

        // int[][] matrix = { { 1, 0 }, { 2, 7 }, { 3, 0 }, { 4, 8 } };
        // setZeros(matrix);
        // System.out.println(Arrays.deepToString(matrix));

        int[][] matrix = { { 1, 2, 3, 4 }, { 14, 15, 16, 5 }, { 13, 20, 17, 6 }, { 12, 19, 18, 7 }, { 11, 10, 9, 8 } };
        System.out.println(Arrays.deepToString(matrix));
        spiralPrint(matrix);
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

    public static void setZeros(int matrix[][]) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (zeroRows[i] == true || zeroCols[j] == true) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void spiralPrint(int matrix[][]) {
        if (matrix == null || matrix.length == 0)
            return;
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colStart) {
            for (int j = colStart; j <= colEnd; j++) {
                System.out.print(matrix[rowStart][j] + " ");
            }
            for (int k = rowStart + 1; k <= rowEnd; k++) {
                System.out.print(matrix[k][colEnd] + " ");
            }
            for (int l = colEnd - 1; l >= colStart; l--) {
                if (rowStart == rowEnd)
                    break;
                System.out.print(matrix[rowEnd][l] + " ");
            }
            for (int m = rowEnd - 1; m > rowStart; m--) {
                if (colStart == colEnd)
                    break;
                System.out.print(matrix[m][colStart] + " ");
            }
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
    }
}