package fromweek2.beforeafter;

/*
 *   Before, call, after
 */
public class BA9 {

    public static void main(String[] args) {
        new BA9().program();
    }

    void program() {
        C[] ca1 = {new C(1), new C(2), new C(3)};
        C[] ca2 = {new C(3), new C(2), new C(5)};    // Before
        doIt(ca1, ca2);                           // Call
                                                  // After
    }

    void doIt(C[] cArr1, C[] cArr2) {
        for (int i = 0; i < cArr1.length; i++) {
            if (cArr1[i].n == cArr2[i].n) {
                cArr1[i] = cArr2[i];
            } else {
                cArr1[i].n = cArr2[i].n;
            }
        }
    }

    class C {
        int n;

        C(int n) {
            this.n = n;
        }

    }


}
