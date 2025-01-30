package fromweek6.inherit;

// See TestInherit
public class B extends A {
    int i = 2;

    int f() {
        return -i;
    }

    // Also try this
    /*int f() { return this.i; }
    */
    static char g() {
        return 'B';
    }
}

/*
2
-2
B
B
1
-2
A
A*/