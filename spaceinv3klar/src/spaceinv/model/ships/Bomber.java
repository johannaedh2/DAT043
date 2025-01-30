package spaceinv.model.ships;


import spaceinv.model.Movable;
import spaceinv.model.SpaceShip;

/*
 *   Type of space ship
 */
public class Bomber extends SpaceShip {

    // Default value
    public static final int BOMBER_POINTS = 200;


    public Bomber(double x, double y, double width, double height,double dx, int points) {
        super(x, y,width,height,dx, points);
    }
}
