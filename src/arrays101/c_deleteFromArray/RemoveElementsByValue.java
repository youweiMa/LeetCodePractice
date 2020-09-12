package arrays101.c_deleteFromArray;

public class RemoveElementsByValue {
    /**
     * two pointers, copy and increase length
     * @param nums - array passed by reference, which means the modification will be known after method calling
     * @param val - target number to be removed
     * @return - new length of array
     */
    public static int removeElement1(int[] nums, int val){
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    /**
     * two pointers, swap with last element and decrease length
     */
    public static int removeElement2(int[] nums, int val){
        int i = 0;
        int len = nums.length;
        while(i < len){
            if(nums[i]==val){
                nums[i]=nums[len-1];
                len--;
            }else{
                i++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] test = {1,1,2,4,5,7,8};
        int target = 5;

//        int len = removeElement1(test, target);
        int len = removeElement2(test, target);

        System.out.println("returned length: " + len);
        for(int i = 0; i < len; i++){
            System.out.print(test[i] + " ");
        }
    }
}
