package Striver.Module3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ArraysMedium {
    public static void main(String args[]) {
        int[] arr = { 2, 6, 5, 8, 11 };
        int target = 14;
        System.out.println(Arrays.toString(twoSum(arr, target)));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(new Integer[] { 0, 2, 1, 2, 0, 1 }));
        sortArray(arr2);
        System.out.println(arr2);
        int[] arr3 = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println("The majority element is: " + majorityElement(arr3));
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

    public static void sortArray(ArrayList<Integer> arr) {
        // using Dutch National Flag algorithm
        int low = 0, mid = 0, high = arr.size() - 1;

        while (mid <= high) {
            if (arr.get(mid) == 0) {
                // swapping arr[low] and arr[mid]
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);

                low++;
                mid++;

            } else if (arr.get(mid) == 1) {
                mid++;

            } else {
                // swapping arr[mid] and arr[high]
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);

                high--;
            }
        }
    }

    public static int majorityElement(int[] arr) {
        // Moore’s Voting Algorithm
        int count = 0;
        int element = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                count = 1;
                element = arr[i];
            } else if (element == arr[i])
                count++;
            else
                count--;
        }

        // checking if the stored element is the majority element
        int count1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element)
                count1++;
        }

        if (count1 > (arr.length / 2))
            return element;

        return -1;
    }
}