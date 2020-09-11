package arrays101.c_deleteFromArray;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates test = new RemoveDuplicates();

        int[] target = {1,1,2,2,3,3,4,4};
        for(int i = 0; i < target.length; i++){
            System.out.print(target[i] + " ");
        }
        System.out.println();

        int result = test.removeDuplicates(target);
        System.out.println(result);

        for(int i = 0; i < result; i++){
            System.out.print(target[i] + " ");
        }
    }

    public int removeDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++){
            if(arr[i] != arr[j]) arr[++i] = arr[j];
        }
        return i+1;
    }
}
