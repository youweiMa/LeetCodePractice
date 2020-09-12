package arrays101.d_searchArray;

import java.util.HashSet;

public class CheckforNumDouble {
    /**
     * for indices i and j, i != j, i,j fall in [0, arr.length-1],
     * whether exist arr[i] == 2 * arr[j]
     * 2 <= arr.length <= 500
     * @param arr - input array
     * @return - if contains N and M such that N = 2 * M
     */
    public static boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : arr) {
            if (set.contains(2 * a) || (a % 2 == 0 && set.contains(a / 2))) {
                return true;
            } else {
                set.add(a);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4};             // true
        int[] test2 = {7, 3, 14, 5};            // true
        int[] test3 = {0, 1};                   // false
        int[] test4 = {1, 3, 5, 7};             // false

        System.out.println(checkIfExist(test1));
        System.out.println(checkIfExist(test2));
        System.out.println(checkIfExist(test3));
        System.out.println(checkIfExist(test4));
    }
}
