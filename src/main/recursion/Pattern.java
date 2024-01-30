package src.main.recursion;

import java.util.Arrays;

class Pattern {
	public static void main(String[] args) {
		int[] arr = {5, 4, 3, 2, 1};
		selection(arr, arr.length, 0,0);
		System.out.println(Arrays.toString(arr));
	}

	static void sort(int[] arr, int r, int c) {
		if (r == 0) {
			return;
		}

		if (r > c) {
			if (arr[c] > arr[c+1]) {
				swap(arr,c , c + 1);
			}
			sort(arr,r ,c + 1);
		} else {
			sort(arr,r-1,0);
		}

	}

	static void selection(int[] arr, int r, int c, int max) {
		if (r == 0) return;

		if (r > c) {
			if (arr[c] > arr[max]) {
				selection(arr, r, c + 1, c);
			} else {
				selection(arr, r, c + 1, max);
			}
		} else {
			swap(arr, r - 1, max);
			selection(arr, r - 1, 0, 0);
		}
	}

	static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
}
