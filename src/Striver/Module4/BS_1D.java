package Striver.Module4;

public class BS_1D {
    public static void main(String[] args) {
        System.out.println(lowerBound(new int[] { 3, 9, 34, 39, 43, 94, 99 }, 40));
        System.out.println(upperBound(new int[] { 3, 5, 8, 9, 15, 19 }, 7));
        System.out.println(searchInsert(new int[] { 1, 2, 4, 7 }, 6));
        findFloor(new int[] { 3, 4, 4, 7, 8, 10 }, 5);
        System.out.println(lastOccurrence(new int[] { 3, 4, 13, 13, 13, 20, 40 }, 13));
        System.out.println(countOccurrence(new int[] { 2, 2, 3, 3, 3, 3, 4 }, 1));
        System.out.println(searchElementRotatedArray(new int[] { 4, 5, 6, 7, 0, 1, 2, 3 }, 0));
        System.out.println(searchElementRotatedArray2(new int[] { 3, 1, 2, 3, 3, 3, 3 }, 2));
        System.out.println(minElementRotatedArray(new int[] { 4, 5, 6, 7, 0, 1, 2, 3 }));
        System.out.println(findRotatedArrayNumber(new int[] { 4, 5, 6, 7, 0, 1, 2, 3 }));
        System.out.println(findSingleElement(new int[] { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 }));
        System.out.println(peakElement(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 5, 1 }));
    }

    public static int lowerBound(int[] arr, int x) {
        if (x > arr[arr.length - 1]) {
            return arr.length;
        }
        int index = -1;
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;

            if (x <= arr[mid]) {
                index = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return index;
    }

    public static int upperBound(int[] arr, int x) {
        int index = arr.length;

        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;

            if (x >= arr[mid]) {
                index = mid + 1;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return index;
    }

    public static int searchInsert(int[] arr, int x) {
        int index = arr.length;

        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;

            if (x == arr[mid]) {
                return mid;
            } else if (x > arr[mid]) {
                s = mid + 1;
            } else {
                index = mid;
                e = mid - 1;
            }
        }
        return index;
    }

    public static void findFloor(int[] arr, int x) {
        int floor = -1;
        int ceiling = -1;
        int s = 0, e = arr.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (x == arr[mid]) {
                floor = arr[mid];
                ceiling = arr[mid];
                break;
            } else if (x > arr[mid]) {
                floor = arr[mid];
                s = mid + 1;
            } else {
                ceiling = arr[mid];
                e = mid - 1;
            }
        }
        System.out.println(floor + " " + ceiling);
    }

    public static int lastOccurrence(int[] arr, int target) {
        int index = -1;
        int s = 0, e = arr.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (target == arr[mid]) {
                index = mid;
                s = mid + 1;
            } else if (target > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return index;
    }

    public static int countOccurrence(int[] arr, int x) {
        int first = -1, last = -1;
        int s = 0, e = arr.length - 1;

        // finding first occurence
        while (s <= e) {
            int mid = (s + e) / 2;

            if (x == arr[mid]) {
                first = mid;
                e = mid - 1;
            } else if (x > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        if (first == -1)
            return 0;

        // finding last occurrence
        s = 0;
        e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;

            if (x == arr[mid]) {
                last = mid;
                s = mid + 1;
            } else if (x > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return (last - first + 1);
    }

    public static int searchElementRotatedArray(int[] arr, int target) {
        int s = 0, e = arr.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (arr[s] <= arr[mid]) {
                if (target >= arr[s] && target <= arr[mid])
                    e = mid - 1;
                else
                    s = mid + 1;
            } else {
                if (target >= arr[mid] && target <= arr[e])
                    s = mid + 1;
                else
                    e = mid - 1;
            }
        }
        return -1;
    }

    public static boolean searchElementRotatedArray2(int[] arr, int target) {
        int s = 0, e = arr.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (target == arr[mid]) {
                return true;
            }

            if (arr[s] == arr[mid] && arr[mid] == arr[e]) {
                s++;
                e--;
                continue;
            }

            if (arr[s] <= arr[mid]) {
                if (target >= arr[s] && target <= arr[mid])
                    e = mid - 1;
                else
                    s = mid + 1;
            } else {
                if (target >= arr[mid] && target <= arr[e])
                    s = mid + 1;
                else
                    e = mid - 1;
            }
        }
        return false;
    }

    public static int minElementRotatedArray(int[] arr) {
        int s = 0, e = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (arr[s] <= arr[e]) {
                if (arr[s] < min)
                    min = arr[s];
                break;
            }

            if (arr[s] <= arr[mid]) {
                if (arr[s] < min)
                    min = arr[s];
                s = mid + 1;
            } else {
                if (arr[mid] < min)
                    min = arr[mid];
                e = mid - 1;
            }
        }
        return min;
    }

    public static int findRotatedArrayNumber(int[] arr) {
        int s = 0, e = arr.length - 1;
        int index = -1;

        if (arr.length == 0 || arr[s] <= arr[e]) {
            return index;
        }

        while (s <= e) {
            int mid = (s + e) / 2;

            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                index = mid + 1;
                return index;
            } else if (arr[s] <= arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return index;
    }

    public static int findSingleElement(int[] arr) {
        int s = 0, e = arr.length - 1;
        int index = -1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (mid % 2 != 0) {
                if (mid > 0 && arr[mid - 1] == arr[mid]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else {
                if (mid < arr.length - 1 && arr[mid] == arr[mid + 1]) {
                    s = mid + 2;
                } else {
                    index = mid;
                    e = mid - 1;
                }
            }
        }
        return arr[index];
    }

    public static int peakElement(int[] arr) {

        if (arr.length == 1)
            return 0;
        if (arr[0] > arr[1])
            return 0;
        if (arr[arr.length - 1] > arr[arr.length - 2])
            return arr.length - 1;

        int s = 1, e = arr.length - 2;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid - 1]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
}
