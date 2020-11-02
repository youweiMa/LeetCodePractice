package top_interview_questions.easy_collection.string;

// 344
public class ReverseString {
    //DIY
    public static void solution(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }
    }

    // two pointer
    public static void solution1(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] test = {'h', 'e', 'l', 'l', 'o', 'w'};
        System.out.println(test);
        solution1(test);
        System.out.println(test);
    }
}
