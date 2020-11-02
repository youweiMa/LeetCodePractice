package top_interview_questions.easy_collection.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// 36
public class ValidSudoku {
    // make 3 collections to count the occurrences in 1 loop
    public static boolean solution1(char[][] board) {
        // count occurrences
        HashMap<Integer, Integer>[] row = new HashMap[9];
        HashMap<Integer, Integer>[] col = new HashMap[9];
        HashMap<Integer, Integer>[] box = new HashMap[9];
        for (int i = 0; i < board.length; i++) {
            row[i] = new HashMap<>();
            col[i] = new HashMap<>();
            box[i] = new HashMap<>();
        }

        // validate
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + (j / 3);      // this computes the box index

                    row[i].put(n, row[i].getOrDefault(n, 0) + 1);
                    col[j].put(n, col[j].getOrDefault(n, 0) + 1);
                    box[box_index].put(n, box[box_index].getOrDefault(n, 0) + 1);

                    // check if count element
                    if (row[i].get(n) > 1 || col[j].get(n) > 1 || box[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // short one-pass
    public static boolean solution2(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // if any difference, count it
                    if (!seen.add(num + " in row " + i) || !seen.add(num + " in col " + j) || !seen.add(num + " in box " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(solution2(board));
    }
}
