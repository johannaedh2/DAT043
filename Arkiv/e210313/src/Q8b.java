/*
        Solution to question 8b here.
 */


import static java.lang.System.out;

public class Q8b {

    public static void main(String[] args) {
        new Q8b().program();
    }

    void program() {
        B b1 = new B(123, 1);
        B b2 = new B(123, 2);
        A a1 = b1;
        A a2 = new A(123);
        if (a1.equals(b2)) {
            out.println("Happy");
        } else {
            out.println("NOT happy");
        }
        if (a1.equals(a2)) {
            out.println("Happy");
        } else {
            out.println("NOT happy");
        }
    }

    public class A {
        private int aNumb;

        public A(int aNumb) {
            this.aNumb = aNumb;
        }

        public boolean equals(A a) {
            if (this == a) {
                return true;
            } else if (a == null) {
                return false;
            } else if (getClass() != a.getClass()) {
                return false;
            }
            return aNumb == a.aNumb;
        }
    }

    public class B extends A {
        private final int bNumb;

        public B(int aNumb, int bNumb) {
            super(aNumb);
            this.bNumb = bNumb;
        }

        public boolean equals(B b) {
            if (this == b) {
                return true;
            } else if (b == null) {
                return false;
            } else if (!super.equals(b)) {
                return false;
            } else if (getClass() != b.getClass()) {
                return false;
            }
            return bNumb == b.bNumb;
        }
    }
}
