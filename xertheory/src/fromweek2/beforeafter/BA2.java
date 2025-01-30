package fromweek2.beforeafter;

/*
 *   Before, call, after
 */
public class BA2 {

    public static void main(String[] args) {
        new BA2().program();
    }

    void program() {
        H h1 = new H(1);
        H h2 = new H(2);  // Before

        doIt(h1, h2);  // Call
                       // After
    }

    void doIt(H h1, H h2) {
        h1.i = 4;
        H tmp = h1;
        h1 = h2;
        h2 = tmp;
    }

    class H {
        int i;
        H(int i) {
            this.i = i;
        }
    }

}
