package spaceinv.model;

public class SpaceShip extends Movable{

    double points;
    public SpaceShip(double x, double y, double width, double height, double dx, int points) {
        super(x, y, width, height, dx);
        this.points = points;
    }
}
