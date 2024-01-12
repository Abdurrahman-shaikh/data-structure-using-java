package src.main.searching.binarysearch;

public class RotatedBinarySearch {

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 1, 2, 3, 4};
        System.out.println(helper(arr, 7));
    }

    static int helper(int[] arr, int target) {
        int pivot = findPivot(arr);
        System.out.println(pivot);
        if (pivot == -1) {
            return search(arr, target, 0, arr.length - 1);
        } else if (arr[0] <= target && target <= arr[pivot]) {
            return search(arr, target, 0, pivot);
        } else {
            return search(arr, target, pivot + 1, arr.length - 1);
        }
    }

    static int search(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) return mid;
            if (mid > start && arr[mid] < arr[mid - 1]) return mid - 1;

            if (arr[mid] < arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
