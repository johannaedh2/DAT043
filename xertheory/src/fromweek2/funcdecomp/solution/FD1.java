package fromweek2.funcdecomp.solution;

import static java.lang.System.out;

/*
      Exercising functional decomposition

      Sum of pairs with components from two matrices
*/
public class FD1 {

    public static void main(String[] args) {
        new FD1().program();
    }

    void program() {
        int[][] m1 = {
                {1, 1, 3},
                {1, 2, 2},
                {1, 0, 3},
        };
        int[][] m2 = {
                {0, 1, 3},
                {1, 3, 2},
                {0, 1, 2},
        };

        // There are 2 pairs (x,y) with x from m1 and y from m2 that
        // sums to 0
        out.println(countPairs(m1, m2, 0) == 2);
        // There are 8 pairs (x,y) with x from m1 and y from m2 that
        // sums to 5
        out.println(countPairs(m1, m2, 5) == 8);

    }

    // ------- Use functional decomposition --------------------------


    int countPairs(int[][] m1, int[][] m2, int sum) {
        int count = 0;
        for (int row = 0; row < m1.length; row++) {
            for (int col = 0; col < m1[row].length; col++) {
                count += countForElement(m1[row][col], m2, sum);
            }
        }
        return count;
    }

    int countForElement(int value, int[][] m, int sum) {
        int count = 0;
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[row].length; col++) {
                if (value + m[row][col] == sum) {
                    count++;
                }
            }
        }
        return count;
    }

}
