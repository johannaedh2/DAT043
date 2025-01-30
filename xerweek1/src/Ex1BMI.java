import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.lang.Math.*;

/*
 *
 * Program to calculate a persons BMI
 * See https://en.wikipedia.org/wiki/Body_mass_index
 *
 * Formula is: bmi = weight / height²     (kg/m²)
 *
 * See:
 * - ex1basics
 * - B6Slope in particular.
 */
public class Ex1BMI {

    // Don't care about this, must be there, start coding at program
    public static void main(String[] args) {
        new Ex1BMI().program();
    }

    // This connects our program to the keyboard
    final Scanner sc = new Scanner(in);
    //import static  java.lang.Math.*;


    void program() {
        // Write your code here

        // --- Input ---------

        double w;
        double h;

        out.println("Vikt: ");
        w = sc.nextDouble();

        out.println("Längd: ");
        h = sc.nextDouble();

        // --- Process --------

        double bmi;
        double x = pow(h,2);
        bmi = w/x;

        // --- Output ---------
        out.println("BMI = " + bmi );
    }

}
