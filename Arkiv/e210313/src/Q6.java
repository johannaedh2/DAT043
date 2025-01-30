/*
        Solution to question 6 here.
 */

public class Q6 {

    public static void main(String[] args) {
        new Q6().program();
    }

    private void program() {
        // TODO Use any tool (or by hand) to draw a picture of this
        //  Must add the picture to the project (png preferred)
        A a = new A(new A[]{new A(-1), new A(1)}, 0); // Before
        doIt(a);  // Call
                  // After


    }

    void doIt(A a) {
        A[] tmp = new A[2];
        a.as[0].as = tmp;
        tmp[1] = a;
    }

    class A {
        int i;
        A[] as;

        A(A[] as, int i) {
            this.i = i;
            this.as = as;
        }

        A(int i) {
            this.i = i;
        }
    }
}

