package spaceinv.model;

import static spaceinv.model.SI.PROJECTILE_HEIGHT;
import static spaceinv.model.SI.PROJECTILE_WIDTH;

/*
       A projectile fired from the Gun or dropped by a spaceship

       TODO This class should later be refactored (and inherit most of what it needs)
 */
public class Projectile extends Positionable {

    public boolean shot;
    private double dy;

    public Projectile(double x, double y, double width, double height, double dy ) {
        super(x,y,width,height);
        this.dy = dy;
    }

    public Projectile(double dy) {
        this(0, 0, PROJECTILE_WIDTH, PROJECTILE_HEIGHT, dy);
        // Below: HINT
        //super(0, 0, PROJECTILE_WIDTH, PROJECTILE_HEIGHT, 0, dy);
    }

    //@Override
    public void accelerate() {
        setY(getY() - getDy());
        setDy(1.05 * getDy());  // Accelerate
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
