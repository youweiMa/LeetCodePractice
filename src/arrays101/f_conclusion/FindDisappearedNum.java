package arrays101.f_conclusion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// 448
public class FindDisappearedNum {
    /*
     * use additional collection to count appearance
     * */
    public static List<Integer> solution1(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();    // can use Set here because no concern of occurrence
        for (int a : nums) {
            map.put(a, true);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {            // for [1, n],
            if (!map.containsKey(i)) {                      // find if any one missing in Map's keys
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> solution2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int newIdx = Math.abs(nums[i]) - 1;              // index presented by element, use absolute value in case negative
            if (nums[newIdx] > 0) nums[newIdx] *= -1;          // if element at new index is not signed, do it
        }
        List<Integer> result = new LinkedList<>();          // faster than ArrayList
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0)
                result.add(i);                  // if corresponding element is not signed, it means disappear
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {3, 3, 2, 1, 4, 5, 6, 4};          // [7, 8]
        System.out.println(solution1(test));
        System.out.println(solution2(test));
    }
}
