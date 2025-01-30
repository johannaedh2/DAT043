package ex3supersub;

import java.util.Random;

/*
     Type Object is super typ to any reference type

     Nameless null type is sub type to any reference
     type (contains the single value null)

 */
public class SS5Object {

    public static void main(String[] args) {
        new SS5Object().program();
    }

    void program() {

        // ----- Object super type to any -------

        Object o;
        o = "Any";                // super = sub
        o = new Dog();            // super = sub
        o = WeekDay.MON;          // super = sub
        o = new int[]{1, 2, 3};   // super = sub
        o = 4;           // Will box to Integer, so a reference type

        // Aside (just for intellectual fun)
        // Variable of type Object will reference object of type Class :-)
        o = o.getClass();

        // ---------- Pitfalls (casting) -------------
        // Dog <: Object and Player <: Object

        Object object = new Dog();     // super = sub
        Dog dog = (Dog) object;        // sub = (sub) super, OK

        Player player = (Player) object;   // sub = (sub) super BUT runtime exception!

        /*
             CASTING OF REFERENCE TYPES
             --------------------------
             Casting may lead to runtime errors (ClassCastException)
             When casting we take the responsibility, we turn off
             the type checker (in the compiler). It's out fault!
             Casting is always dangerous, avoid!
         */
        /*
            SUPER/SUB VARIABLES AND VALUES
            ------------------------------
            The following must hold during execution else ClassCastException

            super = sub        i.e. a variable of super type may store a value of subtype

         */

        //--------- null ----------------
        // Null n;           // Bad, no null type, type is nameless

        o = null;            // super = sub
        int[] a = null;      // super = sub
        String s = null;
        WeekDay w = null;
        Dog d = null;
        //int i = null;    // i not reference type

        // ------------- NullPointerException --------------------

        // Can't do (dereference) anything with the null value
        //a[0]++;       // NullPointerException (NPE)
        //s.length();   // NPE
        //w.ordinal();  // NPE

        // Always careful with null. Avoid if possible

        /*
            VARIABLE TYPE DEFINES OPERATIONS
            -------------------
            As before: Declared variable type governs which operations allowed
         */
        dog = new Dog();
        dog.age++;

        o = dog;         // super = sub
        //o.age++;       // No age for type Object!

        /*
            COMPILER CAN'T SEE VALUES
            ----------------------------
            Values are runtime!
         */
        // Whats is the value (object references) of o?? Don't know, but type ok
        o = getAny();
    }

    // ----------- Types ----------------

    enum WeekDay {
        MON, TUE, WED, THU, FRI;
    }

    class Player {
        String name;
        int age;
    }

    class Dog {
        String name;
        int age;
    }

    // ----------------- Methods --------------------

    // Don't know what object we'll get (silly method)
    Object getAny() {
        int i = new Random().nextInt(3);
        if (i == 0) {
            return new Player();  // Return sub type of return type, ok
        } else if (i == 1) {
            return new Dog();     // Return sub type ok
        } else {
            return WeekDay.MON;   // Return sub type ok
        }
    }
}
