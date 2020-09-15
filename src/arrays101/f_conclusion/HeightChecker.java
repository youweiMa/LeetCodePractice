package arrays101.f_conclusion;

import java.util.Arrays;

// 1051
public class HeightChecker {
    /*
     * copy, sort and compare
     * */
    public static int solution1(int[] nums) {
        int len = nums.length;
        // copy array
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = nums[i];
        }
        // sort new array
        Arrays.sort(result);
        // compare with original array
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (result[i] != nums[i]) {
                count++;
            }
        }
        return count;
    }

    /*
     * compare height with index
     * */
    public static int solution2(int[] nums) {
        int[] index = new int[101];             // problem restriction: height between 1 and 100
        for (int a : nums) {                        // for each height corresponding index, index++
            index[a]++;
        }
        int result = 0;
        int t = 0;                              // index to be compared
        for (int i = 0; i < nums.length; i++) {
            while (index[t] == 0) t++;             // means this height has been counted out
            if (t != nums[i]) result++;
            index[t]--;                         // count in this index - 1
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 3, 4, 2, 1, 5};           // 1 1 1 2 3 4 5, should return 4

        System.out.println(solution1(test));
        System.out.println(solution2(test));
    }
}
