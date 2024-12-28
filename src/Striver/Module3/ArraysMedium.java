package Striver.Module3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        int[] arr4 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("The maximum subarray sum is: " + maxSubarraySum(arr4, arr4.length));
        int[] profit = { 7, 1, 5, 3, 6, 4 };
        maxProfit(profit);
        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(1, 2, -4, -5));
        System.out.println(rearrangeBySign(arr5));
        List<Integer> arr6 = Arrays.asList(new Integer[] { 1, 3, 2 });
        System.out.println(nextGreaterPermutation(arr6));
        int[] arr7 = { 10, 22, 12, 3, 0, 6 };
        ArrayList<Integer> ans = printLeaders(arr7, arr7.length);
        Collections.sort(ans, Collections.reverseOrder());
        System.out.println(ans);
        int[] arr8 = { 100, 200, 1, 2, 3, 4 };
        System.out.println(longestSuccessiveElements(arr8));
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        ArrayList<ArrayList<Integer>> result = zeroMatrix(matrix, matrix.size(), matrix.get(0).size());
        System.out.println(result);
        int arr9[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(arr9);
        System.out.println(Arrays.deepToString(arr9));
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

    public static long maxSubarraySum(int[] arr, int n) {
        // Kadane's Algorithm
        long max = Long.MIN_VALUE;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        if (max < 0)
            max = 0;

        return max;
    }

    public static void maxProfit(int[] arr) {
        int profitMax = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            profitMax = Math.max(profitMax, arr[i] - minPrice);
        }
        System.out.println("The max profit will be: " + profitMax);
    }

    public static ArrayList<Integer> rearrangeBySign(ArrayList<Integer> A) {
        int posIndex = 0, negIndex = 1;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(A.size(), 0));

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < 0) {
                ans.set(negIndex, A.get(i));
                negIndex += 2;
            } else {
                ans.set(posIndex, A.get(i));
                posIndex += 2;
            }
        }
        return ans;
    }

    public static List<Integer> nextGreaterPermutation(List<Integer> arr) {
        int ind = -1;
        for (int i = arr.size() - 2; i >= 0; i--) {
            if (arr.get(i) < arr.get(i + 1)) {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            Collections.reverse(arr);
            return arr;
        }

        for (int i = arr.size() - 1; i > ind; i--) {
            if (arr.get(i) > arr.get(ind)) {
                int tmp = arr.get(i);
                arr.set(i, arr.get(ind));
                arr.set(ind, tmp);
                break;
            }
        }

        List<Integer> sublist = arr.subList(ind + 1, arr.size());
        Collections.reverse(sublist);

        return arr;
    }

    public static ArrayList<Integer> printLeaders(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max = arr[n - 1];
        ans.add(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--)
            if (arr[i] > max) {
                ans.add(arr[i]);
                max = arr[i];
            }
        return ans;
    }

    public static int longestSuccessiveElements(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        for (int it : set) {
            if (!set.contains(it - 1)) {
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x++;
                    cnt++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}