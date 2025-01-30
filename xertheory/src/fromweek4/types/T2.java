package fromweek4.types;

import static java.lang.System.out;


/*
         Which rows compile and which doesn't? Why?
         Of ok what will be printed? Try to predict then uncomment.
 */
public class T2 {

    public static void main(String[] args) {
        new T2().program();
    }

    void program() {

        A a = new A();
        B b = new B();

//        IX ix = a;    // 1
//        IY iy = a;    // 2
//        a.doIt();     // 3
//        ix.doIt();    // 4
//        iy.doIt();    // 5
//        iy.doOther();  // 6
//
//
//        iy = b;        // 7
//        iy = (IY) b;    // 8
//        iy.doOther();    // 9
//
//        iy = new C();   // 10
//        iy.doOther();   // 11

    }



    interface IX {
        void doIt();
    }

    interface IY {
        void doOther();
    }

    class A implements IX, IY {
        public void doIt() {
            out.println("A doIt()");
        }

        public void doOther() {
            out.println("A doOther()");
        }
    }

    class B {
        public void doOther() {
             out.println("B doOther()");
        }
    }

    class C implements IY {
        public void doOther() { out.println("C doOther()"); }
    }
}
