package fromweek2.funcdecomp.solution;

import static java.lang.System.out;

/*
     Exercising functional decomposition

     Checking unique rows in matrix
 */
public class FD3 {

    public static void main(String[] args) {
        new FD3().program();
    }


    void program() {
        // NOTE: Only positive elements
        // Order of elements in row matters
        int[][] m1 = {
                {7, 1, 3, 6},
                {6, 2, 7, 1},
                {8, 9, 1, 3,},
                {5, 6, 9, 1},
        };
        int[][] m2 = {
                {7, 1, 3, 9},
                {6, 9, 7, 1},
                {7, 1, 3, 9,},  // Duplicate
                {7, 1, 3, 9},   // Duplicate
        };

        // There are four unique rows in m1 (no duplicates)
        out.println(uniqueRows(m1) == 4);
        // There are 2 unique rows in m2 (three duplicates)
        out.println(uniqueRows(m2) == 2);
    }

    int uniqueRows(int[][] m) {
        int count = 0;
        // All elements positive in m, so no problem with 0-rows
        int[][] uniques = new int[m.length][m[0].length];
        for (int row = 0; row < m.length; row++) {
            if (!contains(uniques, m[row])) {
                uniques[row] = m[row];  // Shared reference!
                count++;
            }
        }
        return count;
    }

    // Check if the array of arrays aa contains (by value) array a
    boolean contains(int[][] aa, int[] a) {
        for (int row = 0; row < aa.length; row++) {
            if (equals(aa[row], a)) {
                return true;
            }
        }
        return false;
    }

    // Two rows (arrays) are equals if same length and same element values
    boolean equals(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;

    }

}
