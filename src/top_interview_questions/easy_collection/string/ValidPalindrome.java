package top_interview_questions.easy_collection.string;

/* 125
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases. */
public class ValidPalindrome {
    // reverse and compare
    // "12321" == "12321"
    public static boolean solution1(String s) {
        StringBuilder builder = new StringBuilder();
        // append alphanumeric characters in lower case
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                builder.append(Character.toLowerCase(ch));
            }
        }
        // build filtered string and its reversed version
        String filtered = builder.toString();
        String reversed = builder.reverse().toString();
        return filtered.equals(reversed);
    }

    // two-pointer from side to middle
    public static boolean solution2(String s) {
        // set two pointers, loop until left and right meets
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            // ignore non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            // check if left equals to right
            if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "12321";
        String test2 = "If, and you, oydnafi.";

        System.out.println(solution2(test1));
        System.out.println(solution2(test2));
    }
}
