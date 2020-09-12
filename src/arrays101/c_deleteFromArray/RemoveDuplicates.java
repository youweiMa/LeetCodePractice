package arrays101.c_deleteFromArray;

public class RemoveDuplicates {
    // two pointers
    public int removeDuplicates(int[] arr) {
        int i = 0;                                      // slow pointer
        for (int j = 1; j < arr.length; j++){           // fast pointer
            if(arr[i] != arr[j]) arr[++i] = arr[j];     // copy unique number to position pointed by slow pointer
        }
        return i+1;                                     // return modified array length
    }

    public static void main(String[] args) {
        RemoveDuplicates test = new RemoveDuplicates();

        int[] target = {1,1,2,2,3,3,4,4};
        for(int i = 0; i < target.length; i++){
            System.out.print(target[i] + " ");
        }
        System.out.println();

        int result = test.removeDuplicates(target);
        System.out.println(result);                     // length of modified array
        for(int i = 0; i < result; i++){
            System.out.print(target[i] + " ");
        }
    }
}
