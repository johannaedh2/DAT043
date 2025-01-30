package ex3supersub;

import java.util.Random;

import static java.lang.System.out;

/*
    We know that int values <: double values.
    How about int and double variables?
 */
public class SS2Variables {

    public static void main(String[] arg) {
        new SS2Variables().program();
    }

    final Random rand = new Random();

    void program() {
        int i = 2;
        double d = 2.0;

        // An expression with variables that compiles
        out.println((1 & i) + d * 3.0 / ~4);

        // When variable used in expression it represents a value
        // So replace super variable with sub variable is allowed,
        // but not the reverse (as before)
        out.println((1 & i) + i * 3.0 / ~4);      // Replace d, Ok!
        //out.println((1 & d) + d * 3 / ~4);      // Replace i, NO!

        // BUT! A variable has more roles. When on the left side of an assignment
        // it does not represent a value. It represents a location!

        // An assignment that compiles (d to the left).
        d = (1 & i) + d * 3.0 / ~4;

        // Try to replace with sub to the left
        //i = (1 & i) + d * 3.0 / ~4;     // Compile error

        // An assignment that compiles (i to the left).
        i = 1 / 2 + 3 * 4;

        // Try to replace with super to the left
        d = 1 / 2 + 3 * 4;     // Ok!

        /*
            THE SUPER/SUB RELATION FOR VARIABLES
            ------------------------------------
            On the right side we can replace super with sub but on the left
            side we can't. On the left side we can replace sub with super.

            Super sub type relation requires replacement in any position in any
            expression. This is impossible to achieve with variables (because
            a variable has different roles).

        */
        /*
            SUPER/SUB VARIABLES AND VALUES
            ------------------------------
            There is no super sub relation for variables but we can state some
            fundamental observation: For assignments the following must hold
            during compilation:

            super = sub        i.e. a variable of super type may store a value of subtype
            sub = (sub) super  a value of supertype may be cast to fit a variable of sub type

         */
        // ------ Implicit conversions --------------------
        // If super/sub relation there will be implicit conversions if needed (as before)

        d = 4;     // 4 -> 4.0 then stored
        d = i;
        char ch = 'A';
        i = ch;
        d = ch;     // Transitive

        //---- Explicit conversion  ------
        // If super/sub relation explicit conversions (cast) are allowed (as before)

        d = 2.5;
        i = (int) d;           // d = 2.5 -> 2 store in i (precision lost)
        //(double) i = 4.5;    // Values casted NOT variables

        // ---------- Non super sub relation variables  -----------------

        //boolean b = 2;           // Compile error
        //int j = (int) true;      // Can't cast.


        /*
            VARIABLE TYPE DEFINES OPERATIONS
            --------------------
            NOTE: The type of the variable will decide which operations are
            allowed (by the compiler) in the statements following the declaration.
            Example:

            int i = 4;
            int j = ~i;       // ~ ok for int.
            double d = i;     // super = sub
            out.println(~d);  // Compile error. super = sub removes operations

        */

    }
}
