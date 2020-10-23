package top_interview_questions.easy_collection.array;

import java.util.*;

public class SingleNumber {
    // non-duplicate array list
    // leave only the single number in the end
    public static int solution1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            if (!list.contains(x)) {
                list.add(x);
            } else {
                list.remove(new Integer(x));
            }
        }
        return list.get(0);
    }

    // HashMap K-V pairs
    public static int solution2(int[] nums) {
        HashMap<Integer, Integer> hash_table = new HashMap<>();
        // record element and times of appearance
        for (int i : nums) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        // find that with only one occurrence
        for (int i : nums) {
            if (hash_table.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }

    // 2(a+b+c)-(a+a+b+b+c)=c
    // 2(sumOfSet) - (sumOfNum) = single
    public static int solution3(int[] nums) {
        int sumOfSet = 0, sumOfNum = 0;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (!set.contains(x)) {
                set.add(x);
                sumOfSet += x;
            }
            sumOfNum += x;
        }
        return 2 * (sumOfSet) - sumOfNum;
    }

    // 0^a=a, a^a=0, a^a^b=b
    public static int solution4(int[] nums) {
        int a = 0;
        for (int x : nums) {
            a ^= x;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] test = {4, 1, 2, 1, 2};

        System.out.println(solution4(test));
    }
}
