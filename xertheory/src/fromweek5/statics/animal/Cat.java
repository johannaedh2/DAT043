package fromweek5.statics.animal;


import static java.lang.System.out;

// See TestAnimal
public class Cat extends Animal {

    public static void testClassMethod() {
        out.println("The class method" + " in Cat.");
    }

    public void testInstanceMethod() {
        out.println("The instance method" + " in Cat.");
    }


}
