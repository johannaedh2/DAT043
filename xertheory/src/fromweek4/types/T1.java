package fromweek4.types;


/*
         Which rows compile and which doesn't? Why?
         Try to predict then uncomment.
 */
public class T1 {

    public static void main(String[] args) {
        new T1().program();
    }

    void program() {

        A a = new A();
        B b = new B();

//        IX ix  = new IX(); // 1
//        IY iy = null;        // 2
//
//        a = b;               // 3
//        b = (A) a;           // 4
//
//        ix = iy;            // 5
//        iy = ix;            // 6
//
//        ix = a;             // 7
//        a = (A) ix;         // 8
//        ix = b;             // 9
//        iy = b;             // 10
//
//        ix = (IX) iy;      // 11

    }


    interface IX {
    }

    interface IY {
    }

    class A implements IX {
    }

    class B implements IY {
    }
}
