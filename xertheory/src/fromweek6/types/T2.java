package fromweek6.types;

import static java.lang.System.out;


/*
         What compiles (and not), any runtime errors?
         If ok what will be printed? Try to predict then uncomment.
 */
public class T2 {

    public static void main(String[] args) {
        new T2().program();
    }

    private void program() {
        /*
        B b = new B();// a)
        b.doA();

        IA a = new X();// b)
        a.doA();

        C c = new B(); // c)
        c.doC();

        B b1 = new C(); // d)
        b1.doX();

        IX x = new C();// e)
        X x1 = (X) x;
        x1.doA();

        IX x2 = new C();  // f)
        B b2 = (B) x2;
        b2.doC();

        A a1 = new B();  // g)
        a1.doA();

        IA a2 = new A();  // h)
        a2.doA();

         */
    }

    interface IA { void doA();}
    interface IX { void doX();}

    abstract class A implements IA {
        public void doA() { out.println("A.doA()"); }
    }

    class B extends A {
        void doC() { out.println("B.doC()"); }
    }

    class C extends B implements IX {
        public void doA() { out.println("C.doA()"); }
        public void doX() { out.println("C.doX()"); }
        void doC() { out.println("C.doC()"); }
    }

    class X implements IX {
       public  void doX() { out.println("X.doX()"); }
       void doA() { out.println("X.doA()"); }

    }
}
