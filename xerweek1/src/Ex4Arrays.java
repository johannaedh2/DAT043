import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * Program to exercise arrays
 *
 * See:
 * - ex3arraysfor
 * - Check AF6AritmSeries
 */
public class Ex4Arrays {

    public static void main(String[] args) {
        new Ex4Arrays().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        int[] arr = {0, 0, 0, 0, 0};  // or new int[5]

        out.print("Input 5 integers (space between, then enter) > ");

        for (int i=0; i<arr.length; i++) {
            arr[i]=sc.nextInt();
        }

        out.println("Array is " + Arrays.toString(arr));

        out.print("Input a value to find > ");

        int n;
        int index=0;
        n = sc.nextInt();

        for (int j=0; j < arr.length; j++) {
            if (arr[j]==n)
                break;
            else
                index ++;
        }

        out.print("Value " + n + " is at index " + index);
    }
}
