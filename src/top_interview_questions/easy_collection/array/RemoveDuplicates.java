package top_interview_questions.easy_collection.array;

public class RemoveDuplicates {
    // sbm (solved by myself)
    public static int solution1(int[] nums) {
        int len = nums.length;
        int i = 0;
        for (int j = 1; j < len; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 2, 2, 3, 3};
        int len = solution1(test);
        for (int i = 0; i < len; i++) {
            System.out.print(test[i] + " ");
        }
    }
}
