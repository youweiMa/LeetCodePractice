package arrays101.b_insertToArray;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int lastIndex = arr.length - 1;

        // find sections to be reserved
        for (int left = 0; left <= lastIndex - possibleDups; left++) {
            if (arr[left] == 0) {
                // edge case
                if (left == lastIndex - possibleDups) {
                    arr[lastIndex] = 0;
                    lastIndex--;
                    break;
                }
                possibleDups++;
            }
        }

        // copy from end to start
        for (int right = lastIndex - possibleDups; right >= 0; right--) {
            if (arr[right] == 0) {
                arr[right + possibleDups] = 0;
                possibleDups--;
                arr[right + possibleDups] = 0;
            } else {
                arr[right + possibleDups] = arr[right];
            }
        }
    }

    public static void main(String[] args) {
        DuplicateZeros test = new DuplicateZeros();
        int[] nums = {1, 2, 0, 0, 3, 4, 0};         // expected: {1,2,0,0,0,0,3}
        test.duplicateZeros(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
