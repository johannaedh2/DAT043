package fromweek4.references.solution;

import static java.lang.System.out;

/*
    Program behaves strange! Why? Fix it!
 */

public class R1 {

    public static void main(String[] args) {
        new R1().program();
    }

    void program() {
        DoubleBox a = new DoubleBox();
        a.setValue(18);
        DoubleBox b = a.copy();
        a.setValue(23);
        out.println("a is " + a.getValue());
        out.println("b is " + b.getValue());
    }

    // --------- Classes ----------------

    class DoubleBox {
        Box innerBox = new Box();

        void setValue(int v) {
            innerBox.setValue(v);
        }

        int getValue() {
            return innerBox.getValue();
        }

        DoubleBox copy() {
            DoubleBox newBox = new DoubleBox();
            newBox.innerBox = new Box();                     // <--------- HERE!
            newBox.innerBox.value = innerBox.getValue();
            return newBox;
        }
    }

    class Box {
        int value;

        void setValue(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }


    }
}
