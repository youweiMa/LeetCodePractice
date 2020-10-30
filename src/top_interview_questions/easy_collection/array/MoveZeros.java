package top_interview_questions.easy_collection.array;

// 283
public class MoveZeros {
    // keep original order of non-zero elements
    // keep number of zeros
    // combine together
    public static void solution1(int[] nums) {
        int len = nums.length;

        // count number of zeros
        int num_of_zero = 0;
        for (int a : nums) {
            if (a == 0) num_of_zero++;
        }

        // copy all non-zero elements to new array
        int[] result = new int[len];
        int k = 0;
        for (int a : nums) {
            if (a != 0) {
                result[k++] = a;
            }
        }

        // copy zeros
        // default value is 0, so no need to do it

        // overwrite original array
        for (int i = 0; i < len; i++) {
            nums[i] = result[i];
        }
    }

    // two pointer exchange (both pass, or always exchange 0 with a non-zero element)
    // i: next non-zero index
    // j: next non-zero element
    public static void solution2(int[] nums) {
        int i = 0, temp;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }

    // find all non-zeros and move them to the right places
    public static void solution3(int[] nums) {
        int len = nums.length;
        int last_non_zero = 0;
        // copy non-zeros to the right places first
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[last_non_zero] = nums[i];
                last_non_zero++;
            }
        }
        // then fill rest of array with zero
        for (int i = last_non_zero; i < len; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 0, 3, 0, 12};

        solution3(test);
        for (int x : test) {
            System.out.print(x + " ");
        }
    }
}
