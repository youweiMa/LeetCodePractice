package arrays101.d_searchArray;

/**
 * valid: 1 2 3 2 1
 */
public class ValidMountainArray {
    // one pass up and down
    public static boolean validMountain1(int[] arr) {
        int move = 0;
        int len = arr.length;

        // going up
        while (move + 1 < len && arr[move] < arr[move + 1]) {
            move++;
        }

        // reach peak, and check if it is start or end
        if (move == 0 || move == len - 1) {
            return false;
        }

        // going down
        while (move + 1 < len && arr[move] > arr[move + 1]) {
            move++;
        }

        return move == len - 1;
    }

    // two pointers from left and right
    public static boolean validMountain2(int[] arr) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;

        // going from left
        while (left < len - 1) {
            if (arr[left] > arr[left + 1]) {
                break;
            }
            left++;
        }

        // going from right
        while (right > 0) {
            if (arr[right] >= arr[right - 1]) {
                break;
            }
            right--;
        }

        // if left meets right at peak
        // and not at first or last index
        if (left == right && left > 0 && right < len - 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 3, 2, 1};          // true
        int[] test2 = {4, 3, 2, 1, 2, 3, 4};          // false

        System.out.println(validMountain1(test1));
        System.out.println(validMountain1(test2));

        System.out.println(validMountain2(test1));
        System.out.println(validMountain2(test2));
    }
}
