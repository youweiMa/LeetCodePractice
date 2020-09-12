package arrays101.b_insertToArray;

import java.util.Arrays;

// merge array 2 into array 1
/*
 * Size: nums1: m, nums2: n
 * Length: nums1: m+n, nums2: n
 * */
public class MergeSortedArray {
    public static void mergeArray1(int[] nums1, int[] nums2, int m, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * Two pointers, both start from 0
     *
     * @param nums1 - array to be merged in
     * @param nums2 - array to merge
     * @param m     - actual size of nums1
     * @param n     - actual size of nums2
     */
    public static void mergeArray2(int[] nums1, int[] nums2, int m, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int p1 = 0;     // nums1_copy
        int p2 = 0;     // nums2
        int t = 0;      // nums1
        while (p1 < m && p2 < n) {
            if (nums1_copy[p1] < nums2[p2]) {
                nums1[t++] = nums1_copy[p1++];
            } else {
                nums1[t++] = nums2[p2++];
            }
        }

        // copy rest positions
        while (p1 < m) {
            nums1[t++] = nums1_copy[p1++];
        }
        while (p2 < n) {
            nums1[t++] = nums2[p2++];
        }
    }

    /**
     * Two pointers, both start from the end
     * @param nums1
     * @param nums2
     * @param m
     * @param n
     */
    public static void mergeArray3(int[] nums1, int[] nums2, int m, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int t = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[t--] = nums2[p2--];
            } else {
                nums1[t--] = nums1[p1--];
            }
        }

        // if there are rest in nums2, copy to nums1
        // leave rest in nums1 aside
        while (p2 >= 0) {
            nums1[t--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 3, 4};

//        mergeArray1(a, b, 3, 3);
//        mergeArray2(a, b, 3, 3);
        mergeArray3(a, b, 3, 3);

        System.out.println("Expected: 1 2 2 3 3 4");
        for (int a_item : a) {
            System.out.print(a_item + " ");
        }
    }
}
