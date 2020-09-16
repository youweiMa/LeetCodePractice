package arrays101.f_conclusion;

// can at most flip one 0 (only one zero can be treated as 1)
public class MaxConsecutiveOnesII {
    /*
     * two pointers
     * left: [(1,1,..,1,)0]  <- right
     * right: [(1,...,1)]
     * */
    public static int solution1(int[] nums) {
        int max_len = 0;
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right++;
            if (nums[i] == 0) {
                left = right;
                right = 0;
            }
            max_len = Math.max(max_len, left + right);
        }
        return max_len;
    }

    /*
    * two pointers
    * */
    public static int solution2(int[] nums) {
        int max_len = 0;
        int t = -1;                                     // record 0's index
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                l = t + 1;                              // l: start from last 0; for the first 0 index stays at start point
                t = r;                                  // t: 0's index
            }
            max_len = Math.max(max_len, r - l + 1);
        }
        return max_len;
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 0, 1, 1, 1, 0, 0, 1, 0};        // 6
        System.out.println(solution1(test));
        System.out.println(solution2(test));
    }
}
