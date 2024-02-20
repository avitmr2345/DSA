public class Day2 {
    public static void main(String[] args) {
        // int[] arr = {8,4,2};
        // System.out.println(isPossibleToMakeAscending(arr));

        // int[] arr = {1,7,3,6,5,6};
        // System.out.println(arrayEquilibriumIndex(arr));

        int[] arr = {0,1,2,3,4,5,6};
        System.out.println(firstMissing(arr, arr.length));

    }

    public static boolean isPossibleToMakeAscending(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length && count <= 1; i++) {
            if (arr[i - 1] > arr[i]) {
                count++;
                if (i - 2 < 0 || arr[i - 2] <= arr[i]) {
                    arr[i - 1] = arr[i];
                } else {
                    arr[i] = arr[i - 1];
                }
            }
        }
        return count <= 1;
    }

    public static int arrayEquilibriumIndex(int[] arr) {
        int rightsum = 0;
        for (int i : arr)
            rightsum += i;

        int leftsum = 0;
        for (int i = 0; i < arr.length; i++) {
            rightsum -= arr[i];
            if (leftsum == rightsum)
                return i;
            leftsum += arr[i];
        }
        return -1;
    }

    public static int firstMissing(int[] arr, int n) {
        int i = 0;
        while (i < n) {
            while (arr[i] != i) {
                if (arr[i] < 0 || arr[i] >= n || arr[arr[i]] == arr[i])
                    break;
                int temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
            }
            i++;
        }
        for (int j = 1; j < n; j++) {
            if (arr[j] != j) {
                return j;
            }
        }
        if (arr[0] == n)
            return n + 1;

        return n;
    }
}
