package top_interview_questions.easy_collection.string;

import java.util.HashMap;

/* 387
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.*/
public class FirstUniqueChar {
    // keep occurrences in hash map
    public static int solution1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        // build hash map: char - occurrences
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // find the first unique
        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String test1 = "Unique";    // 0
//        System.out.println(test.length());
//        for (int i = 0; i < test.length(); i++) {
//            char c = test.charAt(i);
//            System.out.println(c);
//        }
        System.out.println(solution1(test1));
        String test2 = "aabbccd";   // 6
        System.out.println(solution1(test2));
    }
}
