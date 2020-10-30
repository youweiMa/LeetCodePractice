package top_interview_questions.easy_collection.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 350
// Intersection with duplicates
/* Wise ideas:
1. What if the given array is already sorted? How would you optimize your algorithm?

We can use either Approach 2 or Approach 3, dropping the sort of course. It will give us linear time and constant memory complexity.

2. What if nums1's size is small compared to nums2's size? Which algorithm is better?

Approach 1 is a good choice here as we use a hash map for the smaller array.

3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

If nums1 fits into the memory, we can use Approach 1 to collect counts for nums1 into a hash map. Then, we can sequentially load and process nums2.

If neither of the arrays fit into the memory, we can apply some partial processing strategies:

Split the numeric range into subranges that fits into the memory. Modify Approach 1 to collect counts only within a given subrange, and call the method multiple times (for each subrange).

Use an external sort for both arrays. Modify Approach 2 to load and process arrays sequentially.
* */
public class IntersectionOfArrays {
    //DIY
    // remove the counted element in one collection
    public static int[] solution(int[] nums1, int[] nums2) {
//        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

//        for(int a:nums1) list1.add(a);
        for (int b : nums2) list2.add(b);

        for (int a : nums1) {
            if (list2.contains(a)) {
                temp.add(a);
                list2.remove((Integer) a);
            }
        }

        int[] result = new int[temp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    // keep track with HashMap, update changes by counting
    public static int[] solution1(int[] nums1, int[] nums2) {
        // copy the shorter array to hashmap, save time
        if (nums1.length > nums2.length) {
            return solution1(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // keep track of occurrences in the shorter array
        for (int a : nums1) map.put(a, map.getOrDefault(a, 0) + 1);
        int i = 0;                              // set pointer to the start of the shorter array
        for (int b : nums2) {
            int count = map.getOrDefault(b, 0);
            if (count > 0) {
                nums1[i++] = b;                 // overwrite the shorter array
                map.put(b, count - 1);          // update occurrences, minus 1 to the qualified element
            }
        }
        // copy only range in the shorter array from 0 to i
        return Arrays.copyOfRange(nums1, 0, i);
    }

    public static int[] solution2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;      // pointer of nums1, pointer of nums2, pointer of result (overwrite nums1)
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k] = nums1[i];
                k++;
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        int[] test1 = {3, 1, 2};
        int[] test2 = {1, 1};

        int[] result = solution2(test1, test2);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
