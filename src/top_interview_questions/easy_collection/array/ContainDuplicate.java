package top_interview_questions.easy_collection.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 217
public class ContainDuplicate {
    // DIY
    // time limit exceeded
    public static boolean containsDuplicate(int[] nums) {
        // for each nums[i], compare with the rest elements
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    // naive linear search
    // time limit exceeded
    public static boolean solution1(int[] nums) {
        // for each nums[i], compare with previous i-1 elements
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    // search sorted array
    public static boolean solution2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            // only compare between the element and its neighbor
            // immediately jump out if any identical was found
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    // search with HashSet
    public static boolean solution3(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 3, 4, 5};
        int[] test2 = {1, 2, 3};

        System.out.println(solution3(test));
        System.out.println(solution3(test2));
    }
}
