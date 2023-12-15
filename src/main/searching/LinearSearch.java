package src.main.searching;

public class LinearSearch {
    public static void main(String[] args) {

        int[] arr = {1,2,3,7,5,4,23,6,7};
        int num = 5;
        System.out.println("The first occurrence of the number is " + linearSearch(arr,num));
    }

    private static int linearSearch(int[] arr, int num) {

        int i = 0;
        int temp = arr[i];
        while (i < arr.length) {
            if (num == arr[i]) break;

            i++;
        }

        return i;
    }
}
