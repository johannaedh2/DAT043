package fromweek5.oomodels.solution.thatslife;

import java.util.List;

/*
        Class for overall game
 */
public class Game {

    private final List<Tile> tiles;  // Sorted order
    private final List<Piece> pieces;
    private Piece actual;

    public Game(List<Piece> pieces, List<Tile> tiles) {
        this.pieces = pieces;
        this.tiles = tiles;
        this.actual = pieces.get(0);
    }

    public void move(int steps) {
        Tile oldPos = actual.getPosition();
        int i = tiles.indexOf(oldPos);
        Tile newPos;
        if (i + steps < tiles.size()) {
            newPos = tiles.get(i + steps);
        } else {
            newPos = tiles.get(tiles.size() - 1);
        }
        actual.setPosition(newPos);
        boolean empty = true;
        for (Piece p : pieces) {
            if (p.getPosition() == oldPos) {
                empty = false;
            }
        }
        if (empty) {
            actual.getOwner().addTile(oldPos);
            tiles.remove(oldPos);
        }

    }

}
















