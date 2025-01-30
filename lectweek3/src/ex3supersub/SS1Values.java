package ex3supersub;

import static java.lang.System.out;

/*
       Super/sub type-relation for values (literals)
 */
public class SS1Values {

    public static void main(String[] arg) {
        new SS1Values().program();
    }

    void program() {

        // An expression that compiles (& and ~ are bitwise operators)
        out.println((1 & 2) + 2.0 * 3.0 / ~4);

        // Is it possible to replace any double value with an int value
        // in the (any) expression and it will still compile?
        out.println((1 & 2) + 2.0 * 3 / ~4);    // Replace 3.0. Ok!
        out.println((1 & 2) + 2 * 3.0 / ~4);    // Replace 2.0 Ok!
        // ... answer is : yes!

        // Is it possible to replace any int value with a double and still compile?
        // Answer is : NO! (bitwise operations not allowed for double values)
        //out.println((1.0 & 2) + 2.0 * 3.0 / ~4);   // Replace 1. Compile error
        //out.println((1 & 2) + 2.0 * 3.0 / ~4.0);   // Replace 4. Compile error

        /*
            THE SUPER/SUB RELATION FOR VALUES
            ---------------------------------
            The fact that we can replace double values with int values without
            getting a compile error makes int values a subtype to double values
            Written: int value <: double value
            Also: double values are supertype to int values

            It's always allowed to use a subtype value instead of a supertype. Will never
            cause any type errors because there are more allowed operations for the subtype
            (we can get bad values, but never any illegal operations, no compile error).
            double operations = { +,-,*,/,%, ... }
            int operations    = { +,-,*,/,%, ... ~,^,|,&}

            For primitive types the following super/sub relation is built into Java
            - byte <: short <: char <: int < long <: float <: double
            - boolean has no super/sub relation to any type

        */

        // ---------- Implicit conversion of values ------------
        // Sub type values are always implicitly converted to super type if needed

        out.println(1 + 2.0);   // 1 converted to 1.0 then +
        out.println(3.5 == 2);   // 2 converted to 2.0 then ==


        // ---------- Explicit conversion of values ------------
        // If super sub relation then allowed to cast super type value to sub
        // Using the cast operator ( ... )

        out.println(1 + (int) 2.0);   // Ok. 2.0 to 2 then +
        out.println((int) 3.5 == 2);  // Will lose precision

        // ---------- Non super sub relation values -----------------

        //out.println(true == 2);           // Compile error
        //out.println(true == (boolean) 2);  // Can't cats.



    }

}
