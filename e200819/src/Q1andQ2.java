/*
        Solution to question 1 o 2 here.
 */

import java.util.Scanner;

import static java.lang.System.*;
import static java.lang.System.in;
import static java.lang.System.out;

public class Q1andQ2 {
    final Scanner sc = new Scanner(in);

    public static void main(String[] args) {
        new Q1andQ2().program();
    }

    private void program() {
        // TODO

        int x1,x2,x3;
        out.println("Första talet: ");
        x1 = sc.nextInt();
        out.println("Andra talet: ");
        x2 = sc.nextInt();
        out.println("Tredje talet: ");
        x3 = sc.nextInt();

        int dif1 = x2-x1;
        int dif2 = x3-x2;
        int dif = dif2 - dif1;
        int x = x3;

        out.print(x1 + ", ");
        out.print(x2 + ", ");
        out.print(x3 + ", ");

        for (int i=1; i<8; i++) {
            dif2 = dif2+dif;
            x = x + dif2;
            out.print(x + ", ");
        }
    }
}

