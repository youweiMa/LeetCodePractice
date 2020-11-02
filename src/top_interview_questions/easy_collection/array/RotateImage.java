package top_interview_questions.easy_collection.array;

// 48
public class RotateImage {
    // transpose and reverse each row
    public static void solution1(int[][] matrix) {
        int len = matrix.length;
        // transpose
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // reverse
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = temp;
            }
        }
    }

    // rotate four rectangles
    // NOT UNDERSTAND
    public static void solution2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2 + n % 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int[] temp = new int[4];
                int row = i;
                int col = j;
                // locate original position
                for (int k = 0; k < 4; k++) {
                    temp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
                // move to new position
                for (int k = 0; k < 4; k++) {
                    matrix[row][col] = temp[(k + 3) % 4];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(test);

        solution2(test);
        printMatrix(test);

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
