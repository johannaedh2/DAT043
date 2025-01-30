package spaceinv.model;

import static spaceinv.model.SI.*;

/*
    Used to check if projectiles from gun have left our world
    Non visible class
 */
public class OuterSpace {

    double yRoof, XL, XR;

    public OuterSpace(double y, double XL, double XR) {
        this.yRoof = 0;
        this.XL = 0;
        this.XR = GAME_WIDTH;
    }

    public boolean outside(Positionable object) {
        return (object.getY() < yRoof || XL > object.getX() || object.getX() > XR);
    }
}
