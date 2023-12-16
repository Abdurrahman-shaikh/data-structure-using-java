package src.main.searching.binarysearch;

public class FirstAndLastPosition {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,4,4,4,4,4,4,4,4, 5, 6, 7, 9, 13, 22, 24, 26, 28, 35, 43, 43};
        System.out.println(firstOcc(arr,4));
    }

    private static int firstOcc(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        int tracker = 0;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (arr[mid] == target) {
                tracker = mid;
            }
            if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return tracker;
    }
}
