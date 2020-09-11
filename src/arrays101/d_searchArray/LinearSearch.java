package arrays101.d_searchArray;

public class LinearSearch {
    public static boolean linearSearch(int[] array, int target) {
        if (array.length == 0 || array == null) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(linearSearch(list, 4));
    }
}
