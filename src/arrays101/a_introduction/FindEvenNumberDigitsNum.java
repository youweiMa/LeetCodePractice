package arrays101.a_introduction;

public class FindEvenNumberDigitsNum {
    public static int findEvenNumDigits1(int[] arr) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                arr[i] = (int) arr[i] / 10;
                count++;
            }
            if (count % 2 == 0) result++;
            count = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {12, 234, 3456, 45657};

        System.out.println(findEvenNumDigits1(test1));   // 2
    }
}
