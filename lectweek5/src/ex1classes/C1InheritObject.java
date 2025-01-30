package ex1classes;


import static java.lang.System.out;

/*
    The supertype of any type, Object is implemented
    by the Java class Object.

    Any own class in Java will inherit all the methods in Object
    That's why we may handle any object as an object of type Object,
    the methods are there!
    (as stated: any class is sub type to Object).

 */
public class C1InheritObject {

    public static void main(String[] args) {
        new C1InheritObject().program();
    }

    void program() {
        MyOwnClass m = new MyOwnClass();

        // No methods in MyOwnClass but able to call
        // many methods anyway.
        // Q: Why???
        // A: Because the methods inherited from Object inherited

        out.println(m.toString());
        out.println(m.getClass());   // Get class used to create this object
        out.println(m.equals("abc"));
        out.println(m.equals(5));
        out.println(m.hashCode());
        // Etc.

    }

    class MyOwnClass{
        // No methods here!!!
    }
}



