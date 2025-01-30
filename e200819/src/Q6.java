/*
        Solution to question 6 here.
 */

import static java.lang.System.*;

public class Q6 {

    public static void main(String[] args) {
        new Q6().program();
    }

    private void program() {
        // TODO Use any tool (or by hand) to draw a picture of this
        // TODO Must add the picture to the project (png preferred)
        A a1 = new A(new int[]{1, 2});
        A a2;            // Before
        a2 = doIt(a1);   // Call
        // After

    }


    A doIt(A a) {
        A tmp = new A();
        a.i = tmp.i;
        return tmp;
    }

    class A {
        int[] i;

        A() {
            i = new int[]{0, 0};
        }

        A(int[] i) {
            this.i = i;
        }
    }


}

