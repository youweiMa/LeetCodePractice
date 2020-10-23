package top_interview_questions.easy_collection.array;

// 189
public class RotateArray {
    // brute-force
    // rotate 1 slot for k times
    public static void solution1(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k % nums.length; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    // use additional array
    // copy to (i+k)%len
    public static void solution2(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[(i + k) % len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }
    }

    // replace in cycle of subgroups
    public static void solution3(int[] nums, int k) {
        k %= nums.length;
        int count = 0;          // count if all numbers have moved
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int previous = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = previous;
                previous = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    // reverse array by part
    public static void solution4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    // reverse all by exchange start and end
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4};

//        solution1(test, 3);
//        solution2(test, 3);
//        solution3(test, 3);
        solution4(test, 3);
        
        for (int i : test) {
            System.out.print(i + " ");
        }
    }
}
