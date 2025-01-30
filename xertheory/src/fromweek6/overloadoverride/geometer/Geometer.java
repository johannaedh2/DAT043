package fromweek6.overloadoverride.geometer;
import static java.lang.Math.PI;


/*
    This is bad code. Rework it using polymorphism (overriding,
    interfaces, inheritance)
 */
public class Geometer {

    public static final int SQUARE = 0;
    public static final int RECTANGLE = 1;
    public static final int CIRCLE = 2;
    private double a, b, r;

    public Geometer(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Geometer(double r) {
        this.r = r;
    }

    public double computeArea(int shape) {
        double area = 0;
        switch (shape) {
        case SQUARE: area = a * a; break;
        case RECTANGLE: area = a * b;break;
        case CIRCLE: area = PI * r * r;break;
        }
        return area;
    }

    public double computePerimeter(int shape) {
        double perimeter = 0;
        switch (shape) {
        case SQUARE:perimeter = 4 * a;break;
        case RECTANGLE:perimeter = 2 * (a + b);break;
        case CIRCLE:perimeter = 2 * PI * r;break;
        }
        return perimeter;
    }
}
