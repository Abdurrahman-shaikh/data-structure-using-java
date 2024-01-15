public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 76, 4, 3, 2, 1, 4, 6};
        MergeSort mergeSort = new MergeSort();
        int[] sortedArray = mergeSort.mergeSort(arr);

        // Print the sorted array
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }

    public int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);

        return arr;
    }

    private void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}


