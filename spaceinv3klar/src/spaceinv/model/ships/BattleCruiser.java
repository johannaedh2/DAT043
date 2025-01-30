package spaceinv.model.ships;

import javafx.geometry.Pos;
import spaceinv.model.Movable;
import spaceinv.model.Positionable;
import spaceinv.model.SpaceShip;

/*
 *   Type of space ship
 */
public class BattleCruiser extends SpaceShip {



    // Default value
    public static final int BATTLE_CRUISER_POINTS = 100;


    public BattleCruiser(double x, double y, double width, double height, double dx, int points) {
        super(x, y,width,height,dx,points);
    }
}
