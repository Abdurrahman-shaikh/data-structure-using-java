package src.main.searching;

public class BinarySearch {

    public static void main(String[] args) {

        boolean isAscending = false;
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 9, 13, 22, 24, 26, 28, 35, 43, 43};
        int[] arr = {16,13,11,10,9,7};
        int num = 13;
        if (arr[0] < arr[arr.length - 1]) isAscending = true;

        System.out.println(binarySearch(arr, num, isAscending));
    }

    private static int binarySearch(int[] arr, int target, boolean isAscending) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) return mid;

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
