/*
        Solution to question 8a here.
 */

import static java.lang.System.out;

public class Q8a {

    public static void main(String[] args) {
        new Q8a().program();
    }

    private void program() {
        A a;
        X x = new X();

        //a = x;        // Compile error
        //x = a;        // Compile error

        a = (A) x;      // No compile error
        x = (X) a;      // No compile error

        /* Classen x implementerar inte A så a kan därför inte vara av klassen X
        *  Att man skriver (A) framför gör att compilatorn släpper igenom det ändå
        * men vid körning kan classerna nu inte vara varandra. Om man skriver
        * "class X implements A finns det en sub-super relation mellan dem
        * och det fungerar därför då vid körning.*/

        //Kodexempel:


    }

    interface A {   // May not change this interface
    }

    class X  {       // May not change this class
    }


}

