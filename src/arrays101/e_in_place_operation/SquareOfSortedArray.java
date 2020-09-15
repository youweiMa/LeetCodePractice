package arrays101.e_in_place_operation;

import java.util.Arrays;

// 977
public class SquareOfSortedArray {
    /*
     * regular self multiply and sort
     * */
    public static int[] squareSorted1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /*
    * two pointers another implementation
    * largest to smallest
    * */
    public static int[] squareSorted2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i = 0;
        int j = n - 1;
        for (int t = n - 1; t >= 0; t--) {                  // from the largest to smallest, follows the pattern of two pointers moving
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[t] = nums[i] * nums[i];
                i++;
            } else {
                result[t] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {-4, -1, 0, 2, 5};         // 0 1 4 16 25

//        int[] result = squareSorted1(test);
        int[] result = squareSorted2(test);

        for (int a : result) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
