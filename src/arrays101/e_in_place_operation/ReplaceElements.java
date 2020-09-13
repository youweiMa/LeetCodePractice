package arrays101.e_in_place_operation;

public class ReplaceElements {
    /*
    * iterate from end to start,
    * firstly max = -1, assigned to end
    * find max sequentially backward
    * YOU NEED TO VISUALIZE THE NATURAL ORDER OF LOGIC FIRST
    * */
    public static int[] replaceElement(int[] arr) {
        int max = -1;
        int temp = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp = arr[i];
            arr[i] = max;
            if (max < temp) {
                max = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] test = {18, 23, 5, 5, 4, 6, 1};         // 23 6 6 6 6 1 -1
        replaceElement(test);
        for(int a : test){
            System.out.print(a + " ");
        }
    }
}
