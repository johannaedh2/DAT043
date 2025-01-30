package spaceinv.model.ships;

import spaceinv.model.Movable;
import spaceinv.model.Positionable;
import spaceinv.model.SpaceShip;

/*
 *   Type of space ship
 */
public class Frigate extends SpaceShip {

    // Default value
    public static final int FRIGATE_POINTS = 300;


    public Frigate(double x, double y, double width, double height, double dx, int points) {
        super(x, y,width,height,dx,points);
    }
}
