package src.main.searching.binarysearch;

public class Floor {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 9, 13, 22, 24, 26, 28, 35, 43, 43};
        System.out.println(floorOfNum(arr,10));
    }

    private static int floorOfNum(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}
