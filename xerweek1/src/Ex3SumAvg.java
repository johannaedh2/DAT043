import java.util.Scanner;

import static java.lang.System.*;;

/*
 * Program to calculate sum and average for non-negative integers
 *
 * See:
 * - ex2ifwhile
 * - IW5LoopAndAHalf in particular.
 *
 */
public class Ex3SumAvg {

    public static void main(String[] args) {
        new Ex3SumAvg().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // Write your code here

        double sum = 0;
        double add = 0;
        int antal = 0;
        double average;

        // -- Input (and bookkeeping)

        out.println("Mata in siffror. Avsluta genom att mata in ett negativt tal: ");

        while (add >= 0)
        {
            add = sc.nextDouble();
            sum = sum + add;
            antal = antal + 1;
        }

        // -- Process---

        sum = sum - add;
        antal = antal - 1;
        average = sum/antal;

        // -- Output ----
        out.println("Sum = " + sum );
        out.println("Average = " + average );
    }

}
