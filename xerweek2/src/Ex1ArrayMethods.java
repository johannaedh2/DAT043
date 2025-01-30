import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import static java.lang.System.out;

import static java.lang.StrictMath.round;

/*
 *  Methods with array params and/or return value. Implement methods.
 *
 *  See:
 *  ex2references
 *  ex3methods
 *  ex4algorithms
 *  - in particular A1BasicAlgs
 */
public class Ex1ArrayMethods {

    public static void main(String[] args) {
        new Ex1ArrayMethods().program();
    }

    final static Random rand = new Random();

    void program() {
        int[] arr = {1, 2, 2, 5, 3, 2, 4, 2, 7};  // Hard coded test data

        // Uncomment one at a time and implement

        // Count occurrences of some element in arr
        out.println(count(arr, 2) == 4);      // There are four 2's
        out.println(count(arr, 7) == 1);

        // Generate array with 100 elements with 25% distribution of -1's and 1's (remaining will be 0)
        int[] arr1 = generateDistribution(100, 0.25, 0.25);

        out.println(count(arr1, -1) == 25);
        out.println(count(arr1, 0) == 50);

        // Generate array with 14 elements with 40% 1's and 30% -1's
        int[] arr2 = generateDistribution(14, 0.4, 0.3);
        out.println(count(arr2, 1) == 6);
        out.println(count(arr2, -1) == 4);


        for (int i = 0; i < 10; i++) {
            // Random reordering of arr, have to check by inspecting output
            shuffle(arr);

            out.println(Arrays.toString(arr)); // Does it look random?

        }
    }


    // Math.ceil
    // Math.round


    // ---- Write methods below this ------------

   int[] generateDistribution(int a,double b,double c) {
        int[] list = new int[a];
        int x1 = (int) Math.round(a*b);
        int x2 = (int) Math.round(a*c);
        for (int i=0; i<x1; i++) {
            list[i] = 1;
        }
        for (int j=x1; j<x1+x2; j++) {
            list[j] = -1;
        }
        for (int k=x2+x1; k<a; k++) {
            list[k] = 0;
        }

        shuffle(list);
        return list;
    }

    void shuffle(int[] arr) {
        for (int i=arr.length; i>1; i--) {
            int j = rand.nextInt(i);
            int tmp = arr[j];
            arr[j] = arr[i-1];
            arr[i-1] = tmp;
        }
    }

    int count(int[] arr, int x) {
        int y = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == x) {
                y++;
            }
        }
        return y;
    }

}
