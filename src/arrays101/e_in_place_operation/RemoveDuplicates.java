package arrays101.e_in_place_operation;

/*
 * This is the same problem in c_deleteFromArray.
 * Rewrite two-pointer method
 * */
public class RemoveDuplicates {
    public static int removeDuplicate(int[] arr) {
        int writepointer = 1;
        for (int readpointer = 1; readpointer < arr.length; readpointer++) {
            if (arr[readpointer] != arr[readpointer - 1]) {
                arr[writepointer] = arr[readpointer];
                writepointer++;
            }
        }
        return writepointer;
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 1, 3, 4, 5, 5};
        int len = removeDuplicate(test);
        for (int i = 0; i < len; i++) {
            System.out.print(test[i] + " ");
        }
    }
}
