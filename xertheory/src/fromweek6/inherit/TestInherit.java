package fromweek6.inherit;

import static java.lang.System.*;

/*
    What will be printed? Why?
 */
public class TestInherit {

    public static void main(String args[]) {
        B b = new B();
        out.println(b.i);
        out.println(b.f());
        out.println(b.g());  // Bad usage
        out.println(B.g());

        A a = b;
        out.println(a.i);
        out.println(a.f());
        out.println(a.g());   // Bad usage
        out.println(A.g());
    }



}
