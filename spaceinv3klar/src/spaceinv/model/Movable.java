package spaceinv.model;

import static spaceinv.model.SI.*;

public abstract class Movable extends Positionable {
    public double dx;
    public boolean shot;

    public Movable(double x, double y, double width, double height, double dx) {
        super(x, y, width, height);
        this.dx = dx;
    }


    public void move() {
        x += dx;
    }

    public double futureX() {
        return x + dx;
    }

    public Projectile fire(int direction) {
        Gun referencePoint = new Gun(x, y, height, width, 0, false);
        shot = true;
        return Shooter.fire(referencePoint, 3*direction);
    }
}