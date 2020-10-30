package top_interview_questions.easy_collection.array;

// 66
public class PlusOne {
    // addition with carry
    // start from the end, if 9 move pointer, if not add 1 and return
    // handle special case of all 9
    public static int[] solution1(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;                // rest elements are 0 by default
        return digits;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 8};
        int[] test2 = {9, 9};

        for (int x : solution1(test2)) {
            System.out.print(x + " ");
        }

    }
}
