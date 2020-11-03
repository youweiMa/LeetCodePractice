package top_interview_questions.easy_collection.string;

import java.util.Arrays;

/* 242
 * Given two strings s and t , write a function to determine if t is an anagram of s.*/
public class ValidAnagram {
    // character array comparison
    public static boolean solution1(String s, String t) {
        // early return if not equal length
        if (s.length() != t.length()) return false;
        // turn String to character array
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        // sort array
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    // counter table
    // char1 - char2 = some value
    // appear in a +1, appear in b -1, find if all characters are counted as 0
    public static boolean solution2(String s, String t) {
        // early return not equal length
        if (s.length() != t.length()) return false;
        // create alphabet table
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {        // count size on each one is fine
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        // check zero for all 26 characters
        for (int alpha : counter) {
            if (alpha != 0) return false;
        }
        return true;
    }

    // another counter table
    // find negative count
    public static boolean solution3(String s, String t) {
        // early return
        if (s.length() != t.length()) return false;
        // create table
        int[] counter = new int[26];
        // first one increment
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        // second one decrement and immediately jump out if any negatives was found
        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i) - 'a']--;
            if (counter[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "anagram";
        String b = "nagaram";
        System.out.println(solution3(a, b));
    }
}
