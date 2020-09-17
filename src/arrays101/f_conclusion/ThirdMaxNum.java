package arrays101.f_conclusion;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// 414
public class ThirdMaxNum {
    /*
     * Set keeps unique value (not sorted)
     * remove max value twice
     * */
    public static int solution1(int[] nums) {
        Set<Integer> numSet = new HashSet<>();      // keep unique numbers
        for (int a : nums) {
            numSet.add(a);
        }
//        System.out.println(numSet);
        int max = Collections.max(numSet);          // the largest number in set
        if (numSet.size() < 3) {
            return max;                             // if size less than 3, there will be no third maximum number
        } else {
            numSet.remove(max);                     // remove max
            int max_2 = Collections.max(numSet);
            numSet.remove(max_2);                   // remove second max
            int max_3 = Collections.max(numSet);
            return max_3;                           // only third max left over
        }
    }

    /*
     * Set keeps the largest 3 numbers
     * remove the smallest as pointer traveling
     * */
    public static int solution2(int[] nums) {
        Set<Integer> maxSet = new HashSet<>();
        for (int a : nums) {
            maxSet.add(a);
            if (maxSet.size() > 3) {                        // if more than 3 values,
                maxSet.remove(Collections.min(maxSet));     // remove the smallest one
            }
        }
        if (maxSet.size() == 3) {
            return Collections.min(maxSet);
        } else {
            return Collections.max(maxSet);
        }
    }

    public static void main(String[] args) {
        int[] test1 = {1, 3, 4, 2, 5, 1, 3, 7};      // expected: 4
        System.out.println(solution1(test1));
        System.out.println(solution2(test1));

        int[] test2 = {1, 1, 1, 2};                  // expected: 2
        System.out.println(solution1(test2));
        System.out.println(solution2(test2));
    }
}
