package fromweek5.oomodels.solution.harbour;

public class Ship {
    private final String id;
    private final int length;
    private final int depth;

    public Ship(String id, int length, int depth) {
        this.id = id;
        this.length = length;
        this.depth = depth;
    }


    // setter/getter omitted

    public int getLength() {
        return length;
    }

    public int getDepth() {
        return depth;
    }


}