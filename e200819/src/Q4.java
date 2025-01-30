/*
        Solution to question 4 here.
 */

import static java.lang.System.*;

public class Q4 {

    public static void main(String[] args) {
        new Q4().program();
    }

    private void program() {

        int[][] m = {
                {0, 1, 0, 3},
                {2, 0, 2, 1},
                {1, 0, 3, 1},
                {0, 2, 0, 2}
        };

        out.println(smallestMatrixWithSum(m, 3));
        out.println(smallestMatrixWithSum(m, 6));
        out.println(smallestMatrixWithSum(m, 11));
        out.println(smallestMatrixWithSum(m, 8));

    }


    // TODO

    int smallestMatrixWithSum(int[][] matrix,int sum) {
        for (int i=1; i<= matrix.length; i++) {
            if (isSize(matrix,i,sum)) {
                return i;
            }
        }
        return -1;
    }

    boolean isSize(int[][] m,int size,int sum) {
        for (int row=0; row<m.length - size + 1; row++) {
            for (int col=0; col<m[0].length - size + 1; col++) {
                if (sum == addNeighbours(m,row,col,size)) {
                    return true;
                }
            }
        }
        return false;
    }

    int addNeighbours(int[][] m,int row,int col,int size) {
        int sum = 0;
        for (int i=row; i<row+size; i++) {
            for (int j=col; j<col+size; j++) {
                sum = sum + m[i][j];
            }
        }
        return sum;
    }

}

