package q8;

import static java.lang.System.out;

public class B extends A {
    private static C c = new C(4); // Run first i.e. ctor A, B, C

    public B(int i) {
        super(i);
        out.println("ctor B");
    }

}
