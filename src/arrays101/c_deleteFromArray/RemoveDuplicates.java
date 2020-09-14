package arrays101.c_deleteFromArray;

// Sorted duplicate array
public class RemoveDuplicates {
    /*
     * two pointers,
     * compare slow pointer and fast pointer, copy different fast to slow
     * return slow pointer
     * in-place
     * */
    public int removeDuplicates1(int[] arr) {
        int i = 0;                                          // slow pointer
        for (int j = 1; j < arr.length; j++) {              // fast pointer
            if (arr[i] != arr[j]) arr[++i] = arr[j];        // copy unique number to position pointed by slow pointer
        }
        return i + 1;                                       // return modified array length
    }

    /*
     * iterate from penult,
     * compare it with next position,
     * if identical, delete the first one of rest
     * in-place
     * */
    public int removeDuplicates2(int[] arr) {
        int len = arr.length;
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] == arr[i + 1]) {
                for (int j = i + 1; j < len; j++) {
                    arr[j - 1] = arr[j];
                }
                len--;
            }
        }
        return len;
    }

    /*
     * copy and return new array
     * find length at first
     * */
    public int[] removeDuplicates3(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        // first round determine the length of new array
        int unique_num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i - 1] != arr[i]) {
                unique_num++;
            }
        }
        // copy to new array
        int[] result = new int[unique_num];
        int t = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i - 1] != arr[i]) {
                result[t] = arr[i];
                t++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveDuplicates test = new RemoveDuplicates();

        // method 1
        int[] target1 = {1, 1, 2, 2, 3, 3, 4, 4};
        for (int i = 0; i < target1.length; i++) {
            System.out.print(target1[i] + " ");
        }
        System.out.println();

        int result1 = test.removeDuplicates1(target1);
        System.out.println(result1);                     // length of modified array
        for (int i = 0; i < result1; i++) {
            System.out.print(target1[i] + " ");
        }
        System.out.println();

        // method 2
        int[] target2 = {1, 1, 2, 2, 3, 3, 4, 4};
        for (int i = 0; i < target2.length; i++) {
            System.out.print(target2[i] + " ");
        }
        System.out.println();

        int result2 = test.removeDuplicates2(target2);
        System.out.println(result2);                     // length of modified array
        for (int i = 0; i < result2; i++) {
            System.out.print(target2[i] + " ");
        }
        System.out.println();

        // method 3
        int[] target3 = {1, 1, 2, 2, 3, 3, 4, 4};
        int[] result3 = test.removeDuplicates3(target3);
        for (int i = 0; i < result3.length; i++) {
            System.out.print(result3[i] + " ");
        }
        System.out.println();
    }
}
