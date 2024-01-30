package src.main.recursion;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
//        int[] ans = Sorting.merge1(arr);
//        System.out.println(Arrays.toString(ans));
        merge(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] mergeSort(int[] arr) {

        if (arr.length == 1) return arr;

        int mid = arr.length/2;

        int[] first = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] second = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return sort(arr,0, mid,arr.length);
    }

    private static int[] sort(int[] arr, int start, int mid, int end) {

        int[] mix = new int[end - start];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < start && j < end) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < start) {
            mix[k] = arr[i];
            k++;
            i++;
        }
        while (j < end) {
            mix[k] = arr[j];
            k++;
            j++;
        }

        return mix;
    }

    static int[] merge1(int[] arr) {

        if (arr.length == 1) return arr;
        int mid = arr.length/2;

        int[] left = merge1(Arrays.copyOfRange(arr,0,mid));
        int[] right = merge1(Arrays.copyOfRange(arr,mid,arr.length));

        return bSort(left, right);
    }

    private static int[] bSort(int[] left, int[] right) {

        int[] mix = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                mix[k] = left[i];
                i++;
            } else {
                mix[k] = right[j];
                j++;
            }

            k++;
        }

        while (i < left.length) {
            mix[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            mix[k] = right[j];
            j++;
        }

        return mix;
    }

    static void merge(int[] arr, int s, int e) {
        if (e - s == 1) return;

        int mid = s + (e - s) / 2;

        merge(arr,s,mid);
        merge(arr,mid,e);

        placeSort(arr,s,e,mid);
    }

    private static void placeSort(int[] arr, int s, int e, int mid) {

        int i = s;
        int j = mid;
        int k = 0;
        int[] mix = new int[e-s];

        while (i < mid && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }
}
