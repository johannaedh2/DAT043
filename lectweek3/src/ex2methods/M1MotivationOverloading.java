package ex2methods;

import static java.lang.System.out;

/*
    If doing the same operation (method) with different parameter lists
    (types, number of params), tiresome to have to invent new names
    (not needed, more to come ...).

 */
public class M1MotivationOverloading {

    public static void main(String[] args) {
        new M1MotivationOverloading().program();
    }

    void program() {

        out.println(absInt(1));      // Tiresome ...
        //out.println(absInt(1.0));
        out.println(absDouble(1.0));  // ... and here
        //out.println(absFloat(5.0));
        out.println(absFloat(5));     // .. and here

    }

    // -------- Methods ----------------------
    // Forced to use different names because different parameter types
    // (but not really ... upcoming "overloading")

    int absInt(int i) {
        return i < 0 ? -i : i;  // An if-expression (i.e. a value)
        /*
            The above same effect as if this statement (statement = no value)

            if( i < 0){
               return -i;
            } else {
               return i;
            }

         */
    }

    double absDouble(double i) {
        return i < 0 ? -i : i;
    }

    float absFloat(float i) {
        return i < 0 ? -i : i;
    }


}

