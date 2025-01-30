import java.util.Arrays;
import java.util.Random;

import static java.lang.System.exit;
import static java.lang.System.out;

/*
 *  Simulation of LCR game. See, https://en.wikipedia.org/wiki/LCR_(dice_game)
 */
public class Ex8LCRSimulation {

    public static void main(String[] args) {
        new Ex8LCRSimulation().program();
    }

    final Random rand = new Random();

    void program() {
        //test();        // < --- Uncomment to run tests ---

        // Hard coded data
        final Player[] players = {new Player("olle", 3),
                new Player("fia", 3), new Player("pelle", 3)};
        Player current = players[0];
        out.println("Simulation starts");
        displayPlayers(players);

        // Runt the simulation
        while (true) {
            char[] result = rollDice(current);
            distributeChips(result, players, current);
            displayState(current, result, players);
            if (simulationDone(players)) {
                break;
            }
            current = getPlayerLeft(players, current);
        }
    }

    // ---- Logical methods -----------------

    boolean simulationDone(Player[] players) {
        int count = 0;
        for (int i=0; i<players.length; i++) {
            if (players[i].chips > 0) {
                count ++;
            }
        }
        return count == 1;
    }

    void distributeChips(char[] result, Player[] players, Player current) {
        removeChips(current, result);
        for (int i=0; i<result.length; i++) {
            if (result[i] == 'L') {
                Player left = getPlayerLeft(players, current);
                left.chips++;
            } else if (result[i] == 'R') {
                getPlayerRight(players, current).chips++;
            }
        }
    }

    void removeChips(Player player, char[] result) {
        for (int i = 0; i<result.length; i++) {
            if (result[i] == 'L' || result[i] == 'C' || result[i] == 'R') {
                player.chips--;
            }
        }
    }

    char[] rollDice(Player player) {
        char[] outcomes = {'.','.',',','L','C','R'};
        int nRolls = player.chips;
        if (nRolls > 3) {
            nRolls = 3;
        }
        char[] result = new char[nRolls];
        for (int i=0; i<nRolls; i++) {
            int r = rand.nextInt(outcomes.length);
            result[i] = outcomes[r];
        }
        return result;
    }

    Player getPlayerRight(Player[] players, Player current) {
        int i = indexOf(players, current);
        return players[(i+1) % players.length];
    }

    Player getPlayerLeft(Player[] players, Player current) {
        int i = indexOf(players, current);
        return players[(i + players.length - 1) % players.length];
    }


    int indexOf(Player[] players, Player player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == player) {
                return i;
            }
        }
        return -1;
    }

    // ----------------  IO ----------------------------

    void displayState(Player actual, char[] result, Player[] players) {
        out.print(actual.name + " got ");
        out.println(Arrays.toString(result));
        displayPlayers(players);
    }

    void displayPlayers( Player[] players ){
         for (int i = 0; i < players.length; i++) {
            out.print(players[i].name + ":" + players[i].chips + " ");
        }
        out.println();
    }

    // ------- Class to hold player data -----------

    class Player {
        String name;
        int chips;

        public Player(String name, int chips) {
            this.name = name;
            this.chips = chips;
        }
    }

    // ********************** Testing *************************************''

    void test() {
        // Local hard coded test data
        Player[] players = {new Player("1", 1),
                new Player("2", 2), new Player("3", 3)};


        exit(0);
    }
}
