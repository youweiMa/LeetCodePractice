package top_interview_questions.easy_collection.string;

// 7
public class ReverseInteger {
    // pop and push digits
    // check before overflow
    public static int solution1(int x) {
        int reverse_int = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // check INTMAX/INTMIN
            // -2147483648 ~ 2147483647
            if (reverse_int > Integer.MAX_VALUE / 10 || (reverse_int == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (reverse_int < Integer.MIN_VALUE / 10 || (reverse_int == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            reverse_int = reverse_int * 10 + pop;
        }
        return reverse_int;
    }

    public static void main(String[] args) {
        int test = 123123;
        System.out.println(solution1(test));
    }
}
