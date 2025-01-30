package spaceinv.model;


import spaceinv.event.EventBus;
import spaceinv.event.ModelEvent;
import spaceinv.view.SIGUI;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *  SI (Space Invader) class representing the overall
 *  data and logic of the game
 *  (nothing about the look/rendering here)
 */
public class SI {

    // Default values (not to use directly). Make program adaptable
    // by letting other programmers set values if they wish.
    // If not, set default values (as a service)
    public static final int GAME_WIDTH = 500;
    public static final int GAME_HEIGHT = 500;
    public static final int LEFT_LIMIT = 50;
    public static final int RIGHT_LIMIT = 450;
    public static final int SHIP_WIDTH = 20;
    public static final int SHIP_HEIGHT = 20;
    public static final int SHIP_MAX_DX = 3;
    public static final int SHIP_MAX_DY = 0;
    public static final int GUN_WIDTH = 20;
    public static final int GUN_HEIGHT = 20;
    public static final double GUN_MAX_DX = 2;
    public static final double PROJECTILE_WIDTH = 5;
    public static final double PROJECTILE_HEIGHT = 5;
    public static final int GROUND_HEIGHT = 20;
    public static final int OUTER_SPACE_HEIGHT = 10;

    public static final long ONE_SEC = 1_000_000_000;
    public static final long HALF_SEC = 500_000_000;
    public static final long TENTH_SEC = 100_000_000;

    private static final Random rand = new Random();

    // TODO More references here
    private final Gun gun;
    private final Ground ground;
    private final List<SpaceShip> ships;
    public boolean gameOver;


    private final List<Projectile> shipBombs = new ArrayList<>();
    private Projectile gunProjectile;
    private int points;
    private OuterSpace outerSpace = new OuterSpace(0,0,GAME_WIDTH);


    // TODO Constructor here
    public SI(Gun gun,Projectile projectile, Ground ground, List<SpaceShip> ships){
        this.gun = gun;
        this.gunProjectile = projectile;
        this.ground = ground;
        this.ships = ships;

    }




    // Timing. All timing handled here!
    private long lastTimeForMove;
    private long lastTimeForFire;
    private int shipToMove = 0;

    // ------ Game loop (called by timer) -----------------

    public void update(long now) {


        /*if( ships.size() == 0){
            EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.HAS_WON));
        }*/
        /*
             Movement
         */
        if (gameOver || ships.size() == 0){
            EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.HAS_WON, gun));
        }

        int numShips = ships.size();

        gun.move(); //Moving the gun
        if (gunProjectile != null) { //Moving the gun projectile
            gunProjectile.accelerate();
            gun.shot = !(gunProjectile.getY() < 0);
        }
        if (shipToMove < ships.size()) {
            if (shipHitLimit(ships.get(shipToMove).futureX())) {
                changeDirection();
                moveDown();
                shipToMove = 0;
            }
            else {
                ships.get(shipToMove).move();
                shipToMove++;
            }
        }
        if (shipToMove >= ships.size()){
            shipToMove = 0;
        }



        /*
            Ships fire
         */
        fireBombs(0.5);
        moveBombs();


        //Collisions
        removeBombs();
        checkCollision();
        for (Movable ship : ships){
            if (ship.y >= 460){
                gameOver = true;
            }
        }
        if (numShips > ships.size()){ accelerateShips();}

    }

    private boolean shipHitLimit(double x) {
        // TODO
        return (x < LEFT_LIMIT || x > RIGHT_LIMIT);
    }

    // ---------- Interaction with GUI  -------------------------

    public void fireGun() {
        if (gun.shot) return;
        else {
            EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.GUN_SHOOT, gun));
            gunProjectile = gun.fire(1);
        }
    }
    public void moveGun(int direction) {
        if (direction < 0) {
            gun.dx = -2;
        } else if (direction > 0) {
            gun.dx = 2;
        } else gun.dx = 0;
    }

    public void changeDirection(){
        for (Movable ship : ships){
            ship.dx = -ship.dx;
        }
    }

    public void accelerateShips(){
        for (Movable ship : ships)
        ship.dx = ship.dx*1.05;
    }
    public void moveDown(){
        for (Movable ship : ships){
            ship.y += 10;
        }
    }
    public void fireBombs(double persecond) {
        lastTimeForFire++;
        if (lastTimeForFire > persecond*60){
            Projectile proj = ships.get(rand.nextInt(ships.size())).fire(-1);
            shipBombs.add(proj);
            EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.BOMB_DROPPED, proj));

            lastTimeForFire = 0;
        }
    }
    public void removeBombs(){
        for (Projectile proj : shipBombs){
            if (proj.y > 470){
                EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.GUN_HIT_SHIP, proj));
                shipBombs.remove(proj);
                break;
            }
        }
    }
    public void moveBombs(){
        for (Projectile proj : shipBombs){
            proj.accelerate();
        }
    }
    public void checkCollision(){
        for (Projectile bomb : shipBombs){
            if (intersect(gun,bomb)){
                EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.BOMB_HIT_GUN,gun));
                gameOver = true;
                break;
            }
        }
        for (SpaceShip ship : ships){
            if (gunProjectile != null) {
                if (intersect(ship, gunProjectile)) {
                    EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.GUN_HIT_SHIP, gunProjectile));
                    points += ship.points;
                    gunProjectile = null;
                    gun.shot = false;
                    ships.remove(ship);
                    break;
                }
            }
        }
    }
    public boolean intersect(Movable ship, Projectile shot) {
        boolean ycollision = shot.x > ship.x && shot.x < ship.x + ship.width;
        boolean xcollision = shot.y > ship.y && shot.y < ship.y + ship.height;
        return ycollision && xcollision;
    }






    // TODO More methods called by GUI

    public List<Positionable> getPositionables() {
        List<Positionable> ps = new ArrayList<>();
        ps.add(ground);
        ps.add(gun);
        for (Positionable ship : ships) {
            ps.add(ship);
        }
        for (Projectile proj : shipBombs){
            ps.add(proj);
        }
        if (gunProjectile != null){
            ps.add(gunProjectile);
        }
        return ps;
    }

    public int getPoints() {
        return points;
    }


}
