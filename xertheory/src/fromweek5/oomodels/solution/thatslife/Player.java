package fromweek5.oomodels.solution.thatslife;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private final String name;
    private final List<Tile> collectedTiles = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void addTile(Tile tile) {
        collectedTiles.add(tile);
    }
}

