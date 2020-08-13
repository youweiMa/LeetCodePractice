package arrays101.insertIntoArray;

public class DuplicateZeros {
    public static void main(String[] args) {
        DuplicateZeros test = new DuplicateZeros();
        int[] target = {1, 2, 0, 0, 3, 4, 0};
        test.duplicateZeros(target);
        for (int i : target) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("expected: 1 2 0 0 0 0 3");
    }

    public void duplicateZeros(int[] arr) {
        int possible_dups = 0;
        int last_index = arr.length - 1;
        for (int left = 0; left <= last_index - possible_dups; left++) {
            if (arr[left] == 0) {
                if (left == last_index - possible_dups) {
                    arr[last_index] = 0;
                    last_index--;
                    break;
                }
                possible_dups++;
            }
        }
        for (int right = last_index - possible_dups; right >= 0; right--) {
            if (arr[right] == 0) {
                arr[right + possible_dups] = 0;
                possible_dups--;
                arr[right + possible_dups] = 0;
            } else {
                arr[right + possible_dups] = arr[right];
            }
        }
    }
}
