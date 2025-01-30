package fromweek2.beforeafter;

/*
 *   Before, call, after
 *
 *   Draw a picture using our graphical language
 *   at the points before, and after during execution
 */
public class BA1 {

    public static void main(String[] args) {
        new BA1().program();
    }


    void program() {
        int[] a1 = {1, 2, 3};
        int[] a2 = {4, 5, 6};   // Before
        int[] a3 = doIt(a1, a2);  // Call
                                // After
    }

    int[] doIt(int[] x, int[] y) {
        x[0] = y[1];
        return x;
    }


}






