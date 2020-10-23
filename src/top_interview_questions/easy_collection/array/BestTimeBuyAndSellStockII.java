package top_interview_questions.easy_collection.array;
// 122
public class BestTimeBuyAndSellStockII {

    // brute force
    // * not understand *
    public static int solution1(int[] nums) {
        return calculate(nums, 0);
    }

    // calculate each pair of possible buying and selling days
    public static int calculate(int[] nums, int s) {
        if (s >= nums.length) return 0;
        int max = 0;
        for (int start = s; start < nums.length; start++) {
            int max_profit = 0;
            for (int i = start + 1; i < nums.length; i++) {
                if (nums[start] < nums[i]) {
                    int profit = calculate(nums, i + 1) + (nums[i] - nums[start]);
                    if (profit > max_profit) max_profit = profit;
                }
            }
            if (max_profit > max) max = max_profit;
        }
        return max;
    }

    // find consecutive valley and peak
    public static int solution2(int[] prices) {
        int max_profit = 0;
        int i = 0;        // start
        int valley, peak = prices[0];

        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] < prices[i + 1]) i++;
            peak = prices[i];
            max_profit += peak - valley;
        }

        return max_profit;
    }

    // add all consecutive (peak-valley)
    public static int solution3(int[] prices) {
        int max_profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                max_profit += prices[i + 1] - prices[i];
            }
        }
        return max_profit;
    }

    // another solution3
    public static int solution4(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};           // expect: 7 (4+3)

        System.out.println(solution1(prices));
        System.out.println(solution2(prices));
        System.out.println(solution3(prices));
        System.out.println(solution4(prices));
    }

}
