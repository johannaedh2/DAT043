/*
        Solution to question 7 here.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static java.lang.System.*;

public class Q7 {

    public static void main(String[] args) {
        new Q7().program();
    }

    private void program() {

    }

    // TODO

    class Bag {
        private final List<Tile> tiles;

        public Bag (List<Tile> tiles) {
            this.tiles = tiles;
        }

        public boolean isEmpty() {
            return tiles.isEmpty();
        }

        private final Random rand = new Random();

        Tile getTile() {
            int randIndex = rand.nextInt(tiles.size());
            return tiles.remove(randIndex);
        }
    }

    class Rack {
        private final List<Tile> tiles = new ArrayList<>();
        public final int max = 7;

        /*Rack (List<Tile> tiles) { behövs inte med new ArrayList?
            this.tiles = tiles;
        }*/

        public boolean add(Tile tile) {
            if (tiles.size() < max) {
                tiles.add(tile);
                return true;
            }
            else return false;
        }

        public Tile remove(Tile tile) {
            if (tiles.contains(tile)) {
                tiles.remove(tiles.indexOf(tile));
                return tile;
            }
            else return null;
        }
    }

    class Player {
        private final String name;
        private Rack rack = new Rack();

        Player(String name) {
            this.name = name;
        }

        public Rack getRack() {
            return rack;
        }
    }

    class Scrabble {
        private final List<Player> players = new ArrayList<>();
        private final Board board;
        private final Bag bag;
        private Player current;

        public Scrabble(Board board,Bag bag) {
            this.board = board;
            this.bag = bag;
        }

        public boolean addToRack() {
            if (bag.isEmpty()) {
                return false;
            }
            Tile t = bag.getTile();
            return current.getRack().add(t);
        }

        boolean putOnBoard(Tile tile, int row, int col) {
            Tile t = current.getRack().remove(tile);
            if (t != null) {
                return board.put(tile, row, col);
            }
            return false;}
    }

    class Tile {
        private final char letter;
        private final int points;

        public Tile(char letter, int points) {
            this.letter = letter;
            this.points = points;
        }

        public char getLetter() {
            return letter;
        }

        public int getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return "{" + letter + points + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tile tile = (Tile) o;
            return letter == tile.letter &&
                    points == tile.points;
        }

        @Override
        public int hashCode() {
            return Objects.hash(letter, points);
        }
    }

    class Board {
        boolean put(Tile tile, int row, int col) {
            return true;
        }

    }

}

