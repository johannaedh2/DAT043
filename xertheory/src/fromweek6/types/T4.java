package fromweek6.types;

import static java.lang.System.out;

/*
         What compiles (and not), any runtime errors?
         If ok what will be printed? Try to predict then uncomment.
 */
public class T4 {

    public static void main(String[] args) {
        new T4().program();
    }

    private void program() {
/*
        D d = new D(); // a
        C c = d;
        c.doIt();

        IY iy = new D();  // b
        C c1 = (C) iy;
        c1.doOther();

        A a = new B();  // c
        a.doIt(1);

        IX ix = new B(); // d
        IY iy1 = new C();
        ix = (IX) iy1;
        ix.doIt();

        A a1 = new C(); // e
        D d1 = (D) a1;
        d1.doIt(1.0);

        C c2 = new D(); // f
        B b = (B) c2;

        C c3 = new C(); // g
        A a2 = c3;
        a2.doOther();
        */
    }
    interface IX { void doIt();}
    interface IY { void doOther();}
    class A {
        void doIt(double d) {
            out.println("doIt A " + d);
        }
    }
    class B extends A implements IX {
        public void doIt() {
            out.println("doIt B");
        }
        void doIt(int i) {
            out.println("doIt B " + i);
        }
    }
    class C extends A implements IY {
        void doIt() {
            out.println("doIt C");
        }
        public void doOther() {
            out.println("doOther " +
                    this.getClass().getSimpleName());
        }
    }
    class D extends C {
        void doIt() {
            out.println("doIt D");
        }
    }
}
