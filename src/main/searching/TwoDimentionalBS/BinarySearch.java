package src.main.searching.TwoDimentionalBS;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[][] arr = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,47},
                {33,34,38,50}
        };


        int[] ans = binarySearch(arr,50);

        System.out.println(Arrays.toString(ans));
    }

    private static int[] binarySearch(int[][] arr, int target) {

        int r = 0;
        int c = arr.length - 1;

        while (r < arr.length && c >= 0) {
            if (arr[r][c] == target) return new int[]{r,c};

            if (arr[r][c] < target) r++;
            if (arr[r][c] > target) c--;
        }

        return new int[]{-1,-1};
    }
}
