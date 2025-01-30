
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 *  The Mexico dice game
 *  See https://en.wikipedia.org/wiki/Mexico_(game)
 *
 */
public class Mexico {

    public static void main(String[] args) {
        new Mexico().program();
    }

    final Random rand = new Random();
    final Scanner sc = new Scanner(in);
    final int maxRolls = 3;      // No player may exceed this
    final int startAmount = 3;   // Money for a player. Select any
    final int mexico = 1000;     // A value greater than any other

    void program() {
    //    test();            // <----------------- UNCOMMENT to test

        int pot = 0;         // What the winner will get
        Player[] players;    // The players (array of Player objects)
        Player current;      // Current player for round
        Player leader;       // Player starting the round

        players = getPlayers();
        current = getRandomPlayer(players);
        leader = current;

        out.println("Mexico Game Started");
        statusMsg(players);

        while (players.length > 1) {                                   // Game over when only one player left

          current.nRolls = 0;                                          // Ingen har slagit än

            // Ny runda
            for (int i=0; i< players.length; i++) {

                // ----- In ----------
                String cmd = getPlayerChoice(current);
                if ("r".equals(cmd) & current.nRolls <= maxRolls+1) {

                    // --- Process ------

                    rollDice(current);                                 // Spelarens tärningar slås och ges till spelaren

                    // ---- Out --------
                    roundMsg(current);                                 // Vad spelaren fick skrivs ut
                    current.nRolls ++;                                 // Antalet slag ökas med ett
                    i--;                                               // Spelaren ges en ny chans att eventuellt slå igen
                }

                else if ("n".equals(cmd) || current.nRolls > maxRolls) {
                    out.println("Next player ");
                    current.nRolls = 0;                                // Spelaren är klar för rundan och antalet slag nollställs
                    current = next(players, current);                  // Nästa spelares tur
                    current.nRolls = 0;                                // Nästa spelares antal slag nollställs
                }
                else {
                    out.println("?");
                    i--;                                               // Spelaren får en ny chans att eventuellt slå igen
                }
            }

            //if ( round finished) {
                // --- Process -----
            Player loser = getLoser(players, leader);                          // Loser fås m.h.a. getLoser och getScore
            //Player loser = getLoser(players[0], players[1], players[2]);

            // ----- Out --------------------
            if (loser.amount <= 0) {                                   // Pot ökas
                players = removePlayer(players, loser);                // Loser tas bort
                out.println("Round done. " + loser.name + " lost the round and the game!");
                pot++;
            }
            else {
                out.println("Round done. " + loser.name + " lost the round!");
                pot++;
            }

            current = getRandomPlayer(players);
            leader = current;
            statusMsg(players);

            if (players.length <= 1) {                                  // För att "Next to roll is " inte ska skrivas ut till vinnaren
                break;
            }

            out.println("Next to roll is " + current.name);


        }
        out.println("Game Over, winner is " + players[0].name + ". Will get " + pot + " from pot");
    }


    // ---- Game logic methods --------------

    // TODO implement and test methods (one at the time)

    Player rollDice(Player p1) {
        p1.fstDice = rand.nextInt(6) + 1;
        p1.secDice = rand.nextInt(6) + 1;
        p1.nRolls++;
        return p1;
    }

    int indexOf(Player[] players, Player player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == player) {
                return i;
            }
        }
        return -1;
    }

    Player getRandomPlayer(Player[] players) {
        return players[rand.nextInt(players.length)];
    }

    Player next(Player[] players, Player current) {
        if ((indexOf(players, current)) != ((players.length)-1)) {
            int x = (indexOf(players, current) + 1);
            return players[x];
        }
        else return players[0];
    }

    int getScore(Player p) {
        int dice1 = p.fstDice;
        int dice2 = p.secDice;
        if (dice1 == dice2) {
            return dice1*100;
        }
        else if ((dice1 == 2 && dice2 == 1) || (dice1 == 1 && dice2 == 2)) {
            return mexico;
        }
        else if (dice1 > dice2) {
            return (dice1*10 + dice2);
        }
        else
            return (dice2*10 + dice1);
    }
// |
    Player getLoser(Player[] p,Player leader) {
        Player loser = p[0];
        Player x1 = next(p,leader);
        Player x2 = next(p,x1);
        for (int i = 0; i < p.length-1; i++) {
            if ((getScore(p[i]) <= getScore(p[i+1])) & (getScore(p[i]) <= getScore(loser))) {
                loser = p[i];
            }
            else if ((getScore(p[i+1])) <= getScore(loser) & (getScore(p[i+1])) <= getScore(p[i])) {
                loser = p[i+1];
            }
        }
        if (loser!=leader & getScore(loser)==getScore(leader)) {
            loser = leader;
        }
        else if (loser!=leader & getScore(x1)==getScore(x2)) {
            p = removePlayer(p,leader);
            loser = getRandomPlayer(p);
        }
        loser.amount--;
        return loser;
    }


    Player[] removePlayer(Player[] players, Player loser) {
        Player[] newArr = new Player[(players.length)-1];
        int p = 0;
        for (int i=0; i<= players.length-2; i++) {
            if (players[i+p] != loser) {
            newArr[i] = players[i+p];
            }
            else {
                i--;
                p++;
            }
        }
        return newArr;
    }

    Player getLoser2(Player[] players) {
        int min = mexico;
        int minIndex = 0;
        for (int i = 0; i < players.length; i++) {
            int score = getScore(players[i]);
            if (score < min) {
                min = score;
                minIndex = i;
            }
        }
        return players[minIndex];
    }

    Player[] removeLoser2(Player[] Players, int loserIndex){
        Player[] newPlayers = new Player[Players.length-1];
        int j = 0;
        for(int i=0;i<newPlayers.length;i++){
            if (i == loserIndex) j++;
            newPlayers[i] = Players[j];
            j++;
        }
        return newPlayers;
    }


    // ---------- IO methods (nothing to do here) -----------------------

    Player[] getPlayers() {
        // Ugly for now. If using a constructor this may
        // be cleaned up.
        Player[] players = new Player[3];
        Player p1 = new Player();
        p1.name = "Olle";
        p1.amount = startAmount;
        Player p2 = new Player();
        p2.name = "Fia";
        p2.amount = startAmount;
        Player p3 = new Player();
        p3.name = "Lisa";
        p3.amount = startAmount;
        players[0] = p1;
        players[1] = p2;
        players[2] = p3;
        return players;
    }

    void statusMsg(Player[] players) {
        out.print("Status: ");
        for (int i = 0; i < players.length; i++) {
            out.print(players[i].name + " " + players[i].amount + " ");
        }
        out.println();
    }

    void roundMsg(Player current) {
        out.println(current.name + " got " +
                current.fstDice + " and " + current.secDice);
    }

    String getPlayerChoice(Player player) {
        out.print("Player is " + player.name + " > ");
        return sc.nextLine();
    }

    // Possibly useful utility during development
    String toString(Player p){
        return p.name + ", " + p.amount + ", " + p.fstDice + ", "
                + p.secDice + ", " + p.nRolls;
    }

    // Class for a player
    class Player {
        String name;
        int amount;   // Start amount (money)
        int fstDice;  // Result of first dice
        int secDice;  // Result of second dice
        int nRolls;   // Current number of rolls
    }

    /**************************************************
     *  Testing
     *
     *  Test are logical expressions that should
     *  evaluate to true (and then be written out)
     *  No testing of IO methods
     *  Uncomment in program() to run test (only)
     ***************************************************/
    void test() {
        // A few hard coded player to use for test
        // NOTE: Possible to debug tests from here, very efficient!
        Player[] ps = {new Player(), new Player(), new Player()};
        ps[0].fstDice = 2;
        ps[0].secDice = 6;
        ps[1].fstDice = 6;
        ps[1].secDice = 5;
        ps[2].fstDice = 1;
        ps[2].secDice = 1;

        //out.println(getScore(ps[0]) == 62);
        //out.println(getScore(ps[1]) == 65);
        //out.println(next(ps, ps[0]) == ps[1]);
        //out.println(getLoser(ps) == ps[0]);

        exit(0);
    }


}
