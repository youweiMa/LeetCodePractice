package arrays101.e_in_place_operation;

public class SquareEvenPosition {
    /*
     * Copy to new array and return the new one
     * */
    public static int[] squareEven1(int[] arr) {
        if (arr == null) return null;

        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                copy[i] = arr[i] * arr[i];
            } else {
                copy[i] = arr[i];
            }
        }
        return copy;
    }

    /*
    * Square in-place
    * */
    public static int[] squareEven2(int[] arr) {
        if (arr == null) return null;

        for(int i = 0; i < arr.length; i++){
            if(i%2==0){
                arr[i] *= arr[i];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] test1 = {-1, 3, 4, 0, 2, -5};       // 1 3 16 0 4 -5

        int[] result = squareEven1(test1);
        for (int a : result) {
            System.out.print(a + " ");
        }

        System.out.println();

        squareEven2(test1);
        for (int a : test1) {
            System.out.print(a + " ");
        }
    }
}
