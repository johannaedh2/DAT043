package fromweek2.beforeafter;

import java.util.Arrays;

/*
 *   Before, call, after
 */
public class BA8 {

    public static void main(String[] args) {
        new BA8().program();
    }

    void program() {
        int[] a = new int[]{1, 2, 3};
        M m1 = new M(a, "abc");
        M m2 = new M(a, "def");  // Before

        doIt(m1, 0, m2.a[2], m2.s);  // The call
                                    // After
    }

    void doIt(M m, int i, int v, String s) {
        m.a[i] = v;
        m.s = s;
    }

    class M {
        int[] a;
        String s;

        M(int[] a, String s) {
            this.a = a;
            this.s = s;
        }

        public String toString() {
            return s + Arrays.toString(a);
        }
    }


}
