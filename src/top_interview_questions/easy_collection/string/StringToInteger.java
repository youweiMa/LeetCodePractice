package top_interview_questions.easy_collection.string;

/* 8
 * Implement atoi() which converts a string to an integer.
 * Only accept: first non-whitespace character is +/- or a number.
 * Should be in range of -2^31 ~ 2^31-1. (otherwise return MAX or MIN)
 * Unqualified cases return 0. */
public class StringToInteger {
    public static int solution1(String s){
        // early jump if has no length
        if(s.length() == 0) return 0;

        int len = s.length();
        int i=0;        // pointer
        int sign=1;     // by default is positive
        int result=0;   // append it
        // discard whitespaces in the beginning
        while(i<len && s.charAt(i)==' ') i++;
        // check sign
        if(i<len && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            sign=(s.charAt(i)=='-') ? -1:1;
            i++;
        }
        // build the result
        while(i<len && s.charAt(i)>='0' && s.charAt(i)<='9'){
            // check overflow or underflow
            if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && s.charAt(i)-'0'>7)){
                return (sign==1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // append to result
            result = result * 10 + (s.charAt(i)-'0');
            i++;
        }
        // multiply sign
        return result * sign;
    }

    public static void main(String[] args) {
        String test = "2147483648";
        System.out.println(solution1(test));
    }
}
