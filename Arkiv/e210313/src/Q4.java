/*
        Solution to question 4 here.
 */


import java.util.Arrays;

import static java.lang.System.out;

public class Q4 {

    public static void main(String[] args) {
        new Q4().program();
    }

    private void program() {
        int[][] m1 = {
                {1, 4, 7, 5},
                {2, 1, 5, 3},
                {1, 3, 2, 9},
                {7, 5, 6, 8},
        };

        int[][] m2 = {
                {3, 4, 1},
                {2, 7, 5},
                {4, 1, 7}
        };

        dumpMatrix(getMatrix(m1));
        dumpMatrix(getMatrix(m2));

    }


    // TODO


     void dumpMatrix(int[][] m) {
        for (int row = 0; row < m.length; row++) {
            out.println(Arrays.toString(m[row]));
        }
    }

    //Tar in en matris
    int[][] getMatrix(int[][] m) {
        int antal = (m.length*(m.length-1))/2;
        int rows = antal/m[0].length;
        int[][] newM = new int[rows][m[0].length];

        int n=1;
        int a=0;

        for (int row=0; row<newM.length; row++) {
            for (int col=0; col<newM[0].length; col++) {
                newM[row+a][col] = count(m,row+n,m[row][col]);

            }
            a++;
            n++;
        }

        return newM;
    }

    //Jämför alla tal i en rad med en nästa rad som ska kollas
    int count(int[][] m,int row,int x) {
        for (int i=0; i<m[0].length; i++) {
            if (contains(m[row],x)) {
                return x;
            }
        }
        return 0;
    }


    //Kollar om ett tal finns i en rad
    boolean contains(int[] arr, int n) {
        for (int i : arr) {
            if (i == n) {
                return true;
            }
        }return false;
    }


}

