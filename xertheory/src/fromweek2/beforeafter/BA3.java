package fromweek2.beforeafter;

/*
 *   Before, call, after
 */
public class BA3 {

    public static void main(String[] args) {
        new BA3().program();
    }

    void program() {
        A[] as = new A[3];
        A a1 = new A();
        a1.i = 1;
        a1.s = "aaa";

        A a2 = new A();
        a2.i = 2;
        a2.s = "bbb";

        as[0] = a1;
        as[1] = a2;       // Before
        as[2] = doIt(as); // Call
        // After
    }

    A doIt( A[] as ){
        as[0].s = as[1].s;
        return as[0];
    }

    class A {
        int i;
        String s;
    }



}
