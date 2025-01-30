package ex1classes.c2person;

import java.util.Objects;

/*
    The concept of a Person as a Java class

    This shows the standard implementation of a Java class
    - The class in it's own java-file with same name (Person.java)
    - Usage of public, private to hide data/methods (or the class)
    - Instance variables
    - On or more constructors
    - Methods using the data in the class
    - Setter/getters .. if really needed! Avoid to expose/manipulate
    data from outside the object
    - The "standard" methods inherited from object but replaced (overridden)
    with own versions: toString, equals/hashCode.

 */
// Class declaration. Class is public so possible to use anywhere in program
public class Person {

    // Private variables, no one outside this class (file) can access
    private final String name;
    private int age;
    private double income;

    // -------------- Constructors -----------------

    public Person(String name, int age, double income) {
        this.name = name;
        this.age = age;
        this.income = income;
    }

    // Overloaded constructor (for convenience, possibly don't know age, income)
    public Person(String name) {
        this(name, 0, 0);
        // Person(name, 0 , 0);    // Can't do like below (must use in conjunction with new)
    }

    // ------------ Setters/Getters (if needed!) ------------
    // Must use methods to access/modify private variables

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    // --------- Methods --------------------

    // Method here because it uses age (instance variable)
    public boolean isRetired(int retireAge) {
        return age >= retireAge;
    }

    // -------- The standard methods ----------------
    // NOTE : All of them can be Generated by IntelliJ, right click > Generate ...

    /*
        OVERRIDING (more to come)
        ----------
        The toString method is inherited from Object but doesn't
        fit our needs (hard to read output). Better make our own version
        of the method. This is called *overriding*.
        When calling toString on a Person object our method will
        be executed (not the inherited method).
        For this to work the method heads (first line) must be identical
        (Remember: toString implicit called for + and println())
     */

    // @Override is an annotation telling the compiler that
    // we have our own version of this method. Will
    // check that method heads are identical (else compile error)
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", income=" + income +
                '}';
    }

    // Own version of inherited equals()
    // This is one way to implement equality between objects (by value)
    // (the inherited method uses equals by reference i.e. identity)
    // If not adding this method, objects in Collections will not be found (by value)!
    // Here equals by name better use some unique id.
    @Override
    public boolean equals(Object other) {
        if (this == other) {   // Identity!
            return true;
        }
        // Compare to null always false. Compare to object
        // of other class also false (here). This is same-type-equals
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        // Knows object is of same class (type).
        Person person = (Person) other;
        return name.equals(person.name); // Equals if names equals (dubious)
    }

    // If implementing own equals you should add this method too
    // This will give the object a fairly unique id number "the hash code"
    // If not implemented, objects in Maps will not be found (if object is used as the key)
    // Don't need to understand the details, will be covered in later courses.
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }



}


