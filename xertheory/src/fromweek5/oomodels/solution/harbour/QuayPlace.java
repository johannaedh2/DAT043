package fromweek5.oomodels.solution.harbour;

public class QuayPlace {
    private final String id;
    private final int length;
    private final int depth;
    private Ship ship;


    public QuayPlace(String id, int length, int depth) {
        this.id = id;
        this.length = length;
        this.depth = depth;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }


    public boolean isOccupied() {
        return ship != null;
    }

    public int getLength() {
        return length;
    }

    public int getDepth() {
        return depth;
    }


    // setter/getter omitted
}