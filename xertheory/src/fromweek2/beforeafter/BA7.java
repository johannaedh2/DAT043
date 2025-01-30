package fromweek2.beforeafter;

/*
 *   Before, call, after
 */
public class BA7 {

    public static void main(String[] args) {
        new BA7().program();
    }

    void program() {
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
