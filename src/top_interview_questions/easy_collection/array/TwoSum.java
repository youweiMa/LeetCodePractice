package top_interview_questions.easy_collection.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1
public class TwoSum {
    //DIY
    // brute-force, somehow optimize
    public static int[] solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    nums[0] = i;
                    nums[1] = j;
                    return Arrays.copyOfRange(nums, 0, 2);
                }
            }
        }
        // return an empty array
        return Arrays.copyOfRange(nums, 0, 0);
    }

    // brute-force
    public static int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // two-pass hashmap, to save search time
    public static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // move to hashmap
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // for each element, find it's complement
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // one element cannot be used twice
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("no solution");
    }

    // one-pass hashmap solution
    // put while check backward
    public static int[] solution3(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[] {i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no solution");
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 5};
        int target = 8;

        int[] result = solution3(test, target);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
