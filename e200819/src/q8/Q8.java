package q8;

import static java.lang.System.out;

public class Q8 {

    public static void main(String[] args) throws Exception {
        new Q8().program();
    }


    void program() {
        /*
            a)
         */
        X x = new Y();
        x.doIt(5);    //int blir till double, har inget annat val av doIt
        Y y = new Y();
        y.doIt(5.0);   //om Ys doIt hade tagit in double som parameter hade det varit det,nu finns ett bättre val = den extendade


        /*
            b)
         */
        C c = new C(1);

        /* This has to do with initialization. Before an object can be created the classmust be loaded. */

    }


    // ------------- a) -----------------

    class X {
        void doIt(double d) {
            out.println("doIt X " + d);
        }
    }

    class Y extends X {
        void doIt(int i) {
            out.println("doIt Y " + i);
        }
    }
}