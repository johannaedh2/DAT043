package fromweek6.types;

import static java.lang.System.out;

/*
         What compiles (and not), any runtime errors?
         If ok what will be printed? Try to predict then uncomment.
 */
public class T3 {

    public static void main(String[] args) {
        new T3().program();
    }

    private void program() {
        /*
        A a = new B(); // a
        a.doIt();

        IX x = new D();// b
        B b = (B) x;
        b.doIt();

        A a1 = new C();// c
        a1.doIt();

        A a2 = new B();// d
        C c = (C) a2;
        c.doit();

        IX x1 = new D();// e
        x1.doOther();

        IX x2 = new D(); // f
        C c1 = (C) x2;
        c1.doIt();

        B b1 = new A();// g
        b1.doIt();

         */

    }

    interface IX {
        void doOther();
    }

    class A {
        void doIt() {
            out.println("A doIt");
        }
    }

    class B extends A {
        void doIt() {
            out.println("B doIt");
        }
    }

    abstract class C extends A implements IX {
        void doYetOther() {
            out.println("C doYetOther");
        }
    }

    class D extends C {
        public void doOther() {
            out.println("D doOther");
        }
    }
}
