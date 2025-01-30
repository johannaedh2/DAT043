package fromweek2.beforeafter;

import static java.lang.System.out;

/*
 *   Before, call, after
 */
public class BA6 {
    public static void main(String[] args) {
        new BA6().program();
    }

    void program() {
        A a1 = new A(1, null);
        A a2 = new A(2, a1);
        A a3 = new A(3, a2);   // Before
        a3.doIt(77);          // Call
        plot(a3);            // After
    }

    class A {
        A a;
        int i = 1;

        A(int i, A a) {
            this.i = i;
            this.a = a;
        }

        void doIt(int i) {
            A t = a;
            while (t.a != null) {
                t = t.a;
            }
            t.a = new A(i, null);
        }
    }

    void plot(A a) {
        while (a != null) {
            out.println(a + ":" + a.i);
            a = a.a;
        }
    }

}
