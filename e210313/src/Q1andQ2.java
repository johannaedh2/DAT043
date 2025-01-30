/*
        Solution to question 1 o 2 here.
 */

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Q1andQ2 {
    final Scanner sc = new Scanner(in);

    public static void main(String[] args) {
        new Q1andQ2().program();
    }

    private void program() {

        int size;
        out.println("Antal räkningar: ");
        size = sc.nextInt();
        out.println("Mata in alla anta chips: ");
        int[] chips = new int[size];

        for (int i=0; i<size; i++) {
            chips[i] = sc.nextInt();
        }

        int higher = 0;
        for (int j=0; j<size-1; j++) {
            if (chips[j] < chips[j+1]) {
                higher++;
            }
        }

        out.println("Beviserligen minsta antal köpta påsar: " + higher );
    }





}

