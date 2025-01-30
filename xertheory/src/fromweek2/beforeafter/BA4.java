package fromweek2.beforeafter;


/*
 *   Before, call, after
 */
public class BA4 {

    public static void main(String[] args) {
        new BA4().program();
    }

    void program() {
        A a = new A();
        a.arr = new int[]{1, 2, 3};
        a.d = 1.5;
        A b = new A();
        b.arr = new int[]{4, 5, 6};
        b.d = 2.5;    // Before

        a = doIt(b);  // Call
                     // After
    }

    A doIt(A a) {
        A tmp = new A();
        tmp.arr = a.arr;
        tmp.d = a.d;
        return tmp;
    }


    class A {
        int[] arr;
        double d;
    }
}
