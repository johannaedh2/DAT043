package ex5classes;
import static java.lang.System.out;


/*
    A constructor is a special method used to initialize objects
    Constructor is only called during object creation (instantiation)

 */
public class C2Constructor {
    public static void main(String[] args) {
        new C2Constructor().program();
    }

    void program() {
        // Instantiate and initialize
        Dog d1 = new Dog("Fido", 23);  // Use constructor to initialize
        out.println(d1.name + " " + d1.age);

        int[] arr;
        boolean[] barr;
        Dog[] dArr = {new Dog("a", 1), new Dog("b", 2)};

        out.println(dArr[0].name);

    }

    // --- A class declaration -----

    class Dog {
        // Two instance variables
        String name;
        int age;

        // A constructor, called automatically directly after
        // object created. Will set values for instance variables
        // More to come.
        public Dog(String n, int a) {
            name = n;
            age = a;
        }
    }

}
