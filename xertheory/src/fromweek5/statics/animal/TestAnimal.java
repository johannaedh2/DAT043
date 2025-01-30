package fromweek5.statics.animal;

/*
    What will be printed? Why?
 */
public class TestAnimal {

    public static void main(String[] args) {
        Animal myAnimal = new Cat();
        myAnimal.testInstanceMethod();
        myAnimal.testClassMethod();
        myAnimal = null;
        myAnimal.testClassMethod();
    }
}
