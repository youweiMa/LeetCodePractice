package arrays101.e_in_place_operation;

public class MoveZeros {
    /*
     * copy non-zero value at first to a new array
     * fill the rest up with 0
     * */
    public static void moveZeros1(int[] arr) {
        int[] result = new int[arr.length];
        int t = 0;

        // copy non-zero value
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                result[t++] = arr[i];
            }
        }
        // fill 0
        for (int i = t; i < result.length; i++) {
            result[i] = 0;
        }

        // copy to arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }

    /*
     * no need to copy, just in-place
     * */
    public static void moveZeros2(int[] nums) {
        int non_i = 0;
        // append non-zero values
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[non_i] = nums[i];
                non_i++;
            }
        }
        // fill remaining array with 0
        for (int i = non_i; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /*
     * two pointer
     * swap slow pointer and next non-zero value
     * */
    public static void moveZeros3(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {0, 0, 1, 0, 3, 0, 2};         // 1 3 2 0 0 0 0

//        moveZeros1(test);
//        moveZeros2(test);
        moveZeros3(test);

        for (int a : test) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
