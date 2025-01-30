package ex4types;

/*
    Super/sub for generic types
 */
public class T1GenericTypes {

    public static void main(String[] args) {
        new T1GenericTypes().program();
    }

    void program() {

         // Integer NOT <: Double
        Box<Integer> m1 = new Box<>();
        Box<Double> m2 = new Box<>();
        //m1 = m2;                    // No
        //m2 = m1;                    // No
        //m1 = (Box<Integer>) m2;     // No

        // Integer <: Object but Box<Integer> NOT <: Box<Object>
        // I.e. if generic type G with S <: T then G<S> NOT <: G<T>
        //Box<Object> o1 = m1;       // No
        //o1 = (Box<Object>) m1;      // No

        // ------ Object ------------
        // Object is still super type to any type, also generic types

        Object o = m1;         // Just Object
        o = m2;
        m1 = (Box<Integer>) o;

    }

    // ------------- Class -------------------------

    class Box<T> {
       // ...
    }

}
