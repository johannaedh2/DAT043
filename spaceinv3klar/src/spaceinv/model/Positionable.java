package spaceinv.model;

/*
   Must be implemented by anything that can be positioned in the world.
   Used by GUI. This must be fulfilled by any object the GUI shall render
 */
public abstract class Positionable {

    double x,y,width,height;

    public Positionable(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX(){
        return x;
    };      // x and x is upper left corner (y-axis pointing down)

    public double getY(){
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight(){
        return height;
    }

}
