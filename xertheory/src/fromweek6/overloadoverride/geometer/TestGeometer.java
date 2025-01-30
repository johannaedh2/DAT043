package fromweek6.overloadoverride.geometer;

import static java.lang.System.out;

/*
    This is usage of bad class. See Geometer
 */
public class TestGeometer {
    public static void main(String[] args) {
        new TestGeometer().program();
    }

    void program() {
        Geometer g = new Geometer(3,4 );
        out.println(g.computeArea(Geometer.RECTANGLE));

    }

}
