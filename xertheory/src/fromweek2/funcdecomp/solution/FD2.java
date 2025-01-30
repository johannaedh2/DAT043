package fromweek2.funcdecomp.solution;

import java.util.Arrays;

import static java.lang.System.out;

/*
     Exercising functional decomposition

     Find all elements common to all rows in matrix
 */
public class FD2 {

    public static void main(String[] args) {
        new FD2().program();
    }

    void program() {
        int[][] m1 = {
                {7, 1, 3, 6},
                {6, 2, 7, 1},
                {8, 9, 1, 3},
                {5, 6, 9, 1},
        };
        int[][] m2 = {
                {7, 1, 3, 9},
                {6, 9, 7, 1},
                {7, 9, 1, 3},
                {5, 7, 9, 1},
        };

        // There is one element common to all rows in m1
        out.println(Arrays.toString(getCommonRowElements(m1)).equals("[1]"));
        // There is three element common to all rows in m2
        out.println(Arrays.toString(getCommonRowElements(m2)).equals("[7, 1, 9]"));
    }

    // Get all elements present on all rows
    int[] getCommonRowElements(int[][] matrix) {
        int[] res = new int[matrix.length];
        int[] firstRow = matrix[0];
        int k = 0;
        for (int col = 0; col < matrix.length; col++) {
            if (isInAllRows(firstRow[col], matrix)) {
                res[k] = firstRow[col];
                k++;
            }
        }
        int[] cut = new int[k];       // Remove 0's
        for (int i = 0; i < k; i++) {
            cut[i] = res[i];
        }
        return cut;
    }

    // Is value n in all rows? n is value matrix are the rows to check
    boolean isInAllRows(int n, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (!isInRow(n, matrix[row])) {
                return false;
            }
        }
        return true;
    }

    // Is value n in this row? n is value and row is row in matrix
    boolean isInRow(int n, int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == n) {
                return true;
            }
        }
        return false;
    }
}
