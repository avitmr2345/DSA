public class Day1 {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 6, 8 };
        int n = arr.length;
        System.out.println(findSecondLargest(n, arr));
    }
    
    public static int findSecondLargest(int n, int[] arr) {
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            if (arr[i] > max) {
                smax = max;
                max = arr[i];
            } else if (arr[i] > smax && arr[i] != max) {
                smax = arr[i];
            }
        }
        return smax != Integer.MIN_VALUE ? smax : -1;
    }
}