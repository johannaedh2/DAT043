import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * The Rock, paper, scissor game.
 * See https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors
 *
 * This is exercising smallest step programming (no methods needed)
 * Write the full program in program()
 *
 * Rules:
 *
 *       -----------  Beats -------------
 *       |                              |
 *       V                              |
 *      Rock (1) --> Scissors (2) --> Paper (3)
 *
 */
public class Ex8RPS {

    public static void main(String[] args) {
        new Ex8RPS().program();
    }

    final Random rand = new Random();
    final Scanner sc = new Scanner(in);

    void program() {

        int maxRounds = 5;
        int human;          // Outcome for player
        int computer;       // Outcome for computer
        int result;         // Result for this round
        int round = 0;      // Number of rounds
        int total = 0;      // Final result after all rounds

        // All code here ... (no method calls)

        out.println("Welcome to Rock, Paper and Scissors");

        while (round < maxRounds) {  // Game loop
            // -------- Input --------------

            out.println("Select 1, 2 or 3 (for R, P or S) ");
            int x = sc.nextInt();
            int y = rand.nextInt(3)+1;

            // ----- Process -----------------
            out.println("Computer choose: " + y);

            if ((x==1 && y==2) || (x==2 && y==3) || (x==3 && y==1)) {
                result = y;
                out.println("You won");
                total --;
            }

            else if ((y==1 && x==2) || (y==2 && x==3) || (y==3 && x==1)) {
                result = x;
                out.println("You won");
                total ++;
            }

            else {
                out.println("Lika ");
            }


            // ---------- Output --------------

            round++;
        }

        out.println("Game over! ");
        if (total == 0) {
            out.println("Draw");
        } else if (total > 0) {
            out.println("Human won.");
        } else {
            out.println("Computer won.");
        }
    }
}
