package arrays101.e_in_place_operation;

public class SortByParity {
    /*
     * two pointer swap
     * */
    public static int[] sortParity1(int[] arr) {
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] % 2 == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        return arr;
    }

    /*
     * copy even and odd numbers separately into new array
     * */
    public static int[] sortParity2(int[] arr) {
        int[] result = new int[arr.length];
        int t = 0;
        // copy even numbers
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) result[t++] = arr[i];
        }
        // copy odd numbers
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) result[t++] = arr[i];
        }
        return result;
    }

    public static int[] sortParity3(int[] arr) {
        int i = 0;                              // even pointer start
        int j = arr.length - 1;                 // odd pointer start

        while (i < j) {                         // even pointer will never surpass odd pointer
            if (arr[i] % 2 > arr[j] % 2) {      // (1,0) swap; other case pass
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[i] % 2 == 0) i++;        // even++
            if (arr[j] % 2 == 1) j--;        // odd--
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] test = {2, 1, 4, 5, 2, 6};         // 2 4 2 6 1 5

//        int[] result = sortParity1(test);
//        int[] result = sortParity2(test);
        int[] result = sortParity3(test);

        for (int a : result) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
