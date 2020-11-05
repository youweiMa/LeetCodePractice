package top_interview_questions.easy_collection.string;

/* 28
 * Return the index of the first occurrence of string;
 * Return -1 if is not a part;
 * Return 0 if string is empty.
 * strict match */
public class IndexOfString {
    // sliding window
    public static int solution1(String haystack, String needle) {
        int needle_len = needle.length();
        int haystack_len = haystack.length();

        // early jump out
        if (needle_len == 0) return 0;

        // offset = haystack_len - (needle_len - 1)
        for (int i = 0; i < haystack_len - needle_len + 1; i++) {
            if (haystack.substring(i, i + needle_len).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    // sliding window
    // but not check full substring
    public static int solution2(String haystack, String needle) {
        int l = needle.length();
        int n = haystack.length();
        // early check
        if (l == 0) return 0;

        int pn = 0;                // pointer on haystack
        while (pn < n - l + 1) {         // throw offset for full match
            // find the first match
            while (pn < n - l + 1 && haystack.charAt(pn) != needle.charAt(0)) pn++;
            // till find the first match, start to compute the length of match
            int pl = 0;           // pointer on needle;
            int current_len = 0;
            while (pl < l && pn < n && haystack.charAt(pn) == needle.charAt(pl)) {
                pn++;
                pl++;
                current_len++;
            }
            // if cumulated length equals needle's length, return the start position of pn
            if (current_len == l) return pn - l;
            // otherwise pn back to the next position of the last first match
            pn = pn - current_len + 1;
        }
        // if not find after going over the whole string
        return -1;
    }

    // another elegant sliding window
    public static int solution3(String haystack, String needle){
        for(int i=0;;i++){          // pointer on haystack
            for(int j=0;;j++){      // pointer on needle
                if(j==needle.length()) return i;        // if have gone over needle
                if(i+j==haystack.length()) return -1;   // if no matches
                if(needle.charAt(j) != haystack.charAt(i+j)) break; // compare sequentially
            }
        }
    }

    public static void main(String[] args) {
        String test = "A quick brown fox jumps over the lazy dog.";
        String target = "quick", target1 = "quickly", target2 = " ";

        System.out.println(test.indexOf(target));
        System.out.println(solution3(test, target));
    }
}
