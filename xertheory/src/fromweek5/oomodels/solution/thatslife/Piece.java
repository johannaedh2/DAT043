package fromweek5.oomodels.solution.thatslife;


import java.awt.*;

public class Piece {
    private final Color color;
    private final Player owner;
    private Tile position;

    public Piece(Color color, Player owner, Tile position) {
        this.color = color;
        this.owner = owner;
        this.position = position;
    }

    public Tile getPosition() {
        return position;
    }

    public void setPosition(Tile position) {
        this.position = position;
    }

    public Player getOwner() {
        return owner;
    }
}