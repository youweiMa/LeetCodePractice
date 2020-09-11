package arrays101.a_introduction;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes1(int[] arr){
        int count = 0;
        int max = 0;
        for(int i = 0; i<arr.length;i++){
            if(arr[i]==1){
                count++;
            }else{
                if(count>max){
                    max = count;
                }
                count=0;
            }
        }
        if(count>max) max = count;
        return max;
    }

    public static void main(String[] args) {
        int[] test1 = {1,1,0,1,1,1};
        int[] test2 = {0};
        int[] test3 = {0,0,0,1};
        int[] test4 = {1};

        System.out.println(findMaxConsecutiveOnes1(test1));     // 3
        System.out.println(findMaxConsecutiveOnes1(test2));     // 0
        System.out.println(findMaxConsecutiveOnes1(test3));     // 1
        System.out.println(findMaxConsecutiveOnes1(test4));     // 1
    }
}
