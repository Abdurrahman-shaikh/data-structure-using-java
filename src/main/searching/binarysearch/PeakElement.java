package src.main.searching.binarysearch;

public class PeakElement {

    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 9, 13, 22, 24, 26, 28, 35, 43, 43};
        int[] arr = {1,2,3,4,5,6,7,4,3,2};
        boolean isAscending = arr[0] < arr[arr.length-1];

        System.out.println(binarySearch(arr, 13, isAscending));
    }

    private static int binarySearch(int[] arr, int target, boolean isAscending) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) return mid;

            if (isAscending) {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
