package spaceinv.model;


import static spaceinv.model.SI.*;

/*
 *    A Gun for the game
 *    Can only fire one projectile at the time
 */
public class Gun extends Movable  {


    public Gun(double x, double y, double width, double height, double dx, boolean alreadyShot){
    super(x,y,width,height,dx);
    }



}
