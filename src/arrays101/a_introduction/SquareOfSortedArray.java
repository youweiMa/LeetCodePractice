package arrays101.a_introduction;

import java.util.Arrays;

public class SquareOfSortedArray {
    public static int[] sortedSquares1(int[] arr) {
        int[] arrSqr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrSqr[i] = arr[i] * arr[i];
        }
        Arrays.sort(arrSqr);
        return arrSqr;
    }

    // two pointer
    // i -> first positive number
    // j -> last non-positive number
    public static int[] sortedSquares2(int[] arr) {
        int[] arrSqr = new int[arr.length];
        int i = 0;

        // find index of i and j;
        while (i < arr.length && arr[i] <= 0) {
            i++;
        }
        int j = i - 1;

        // start comparing and inserting
        int idx = 0;
        while (i < arr.length && j >= 0) {
            if (arr[i] * arr[i] < arr[j] * arr[j]) {
                arrSqr[idx++] = arr[i] * arr[i];
                i++;
            } else {
                arrSqr[idx++] = arr[j] * arr[j];
                j--;
            }
        }

        // add rest of numbers
        while (i < arr.length) {
            arrSqr[idx++] = arr[i] * arr[i];
            i++;
        }
        while (j >= 0) {
            arrSqr[idx++] = arr[j] * arr[j];
            j--;
        }

        return arrSqr;
    }

    public static void main(String[] args) {
        int[] test = {-4, -2, 0, 3, 5};            // 0 4 9 16 25

        int[] result1 = sortedSquares1(test);
        for (int i : result1) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[] result2 = sortedSquares2(test);
        for (int i : result2) {
            System.out.print(i + " ");
        }
    }
}
