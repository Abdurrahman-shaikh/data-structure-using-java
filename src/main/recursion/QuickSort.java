package src.main.recursion;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {

        int s = low;
        int e = high;
        int pivot = s + (e - s) / 2;
        if (low >= high) return;

        while (s <= e) {
            while (arr[s] < arr[pivot]) {
                s++;
            }

            while (arr[e] > arr[pivot]) {
                e--;
            }

            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }

            quickSort(arr,low,e);
            quickSort(arr,s,high);
        }
    }
}
