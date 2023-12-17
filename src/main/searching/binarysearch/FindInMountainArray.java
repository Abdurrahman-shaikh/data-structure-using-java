package src.main.searching.binarysearch;

public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakElement(mountainArr);

        int ascendingResult = binarySearch(mountainArr, 0, peak, target, true);

        if (ascendingResult != -1) {
            return ascendingResult;
        }

        return binarySearch(mountainArr, peak + 1, mountainArr.length() - 1, target, false);
    }

    public static int peakElement(MountainArray arr) {
        int start = 0;
        int end = arr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) > arr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static int binarySearch(MountainArray arr, int start, int end, int target, boolean asc) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) == target) {
                return mid;
            }

            if (asc) {
                if (arr.get(mid) < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr.get(mid) > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Example usage for testing
        int[] arrayValues = {1, 2, 3, 4, 5, 3, 1};
        MountainArray mountainArray = new ExampleMountainArray(arrayValues);

        FindInMountainArray solution = new FindInMountainArray();
        int target = 3;
        int result = solution.findInMountainArray(target, mountainArray);

        System.out.println("Target " + target + " found at index: " + result);
    }
}

class ExampleMountainArray implements MountainArray {
    private final int[] ARRAY;

    public ExampleMountainArray(int[] ARRAY) {
        this.ARRAY = ARRAY;
    }

    @Override
    public int get(int index) {
        return ARRAY[index];
    }

    @Override
    public int length() {
        return ARRAY.length;
    }
}

