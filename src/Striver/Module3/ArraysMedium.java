package Striver.Module3;

import java.util.Arrays;
import java.util.HashMap;

public class ArraysMedium {
    public static void main(String args[]) {
        int[] arr = { 2, 6, 5, 8, 11 };
        int target = 14;
        System.out.println(Arrays.toString(twoSum(arr, target)));

    }

    public static int[] twoSum(int[] arr, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int moreNeeded = target - num;
            if (map.containsKey(moreNeeded)) {
                ans[0] = map.get(moreNeeded);
                ans[1] = i;
                return ans;
            }
            map.put(arr[i], i);
        }
        return ans;

        // two pointers approach
        // Arrays.sort(arr);
        // int left = 0, right = arr.length - 1;
        // while (left < right) {
        // int sum = arr[left] + arr[right];
        // if (sum == target) {
        // return "YES";
        // } else if (sum < target)
        // left++;
        // else
        // right--;
        // }                                                                                                                                        
        // return "NO";
    }

}