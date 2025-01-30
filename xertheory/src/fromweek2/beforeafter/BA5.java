package fromweek2.beforeafter;

/*
 *   Before, call, after
 */
public class BA5 {

    public static void main(String[] args) {
        new BA5().program();
    }

    void program() {
       B b1 = new B("b");
       A a1 = new A( b1 );   // Before
       b1 = doIt( a1 );      // Call
                             // After

    }

    B doIt( A a ){
        a.b.s = "c";
        return a.b;
    }

    class A {
        int i;
        B b;
        A( B b ){
            this.b = b;
        }
    }

    class B {
        int i;
        String s;
        B ( String s ){
            this.s = s;
        }

    }

}
