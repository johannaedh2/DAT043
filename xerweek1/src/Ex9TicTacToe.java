import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 *  The TicTacToe Game
 *  See https://en.wikipedia.org/wiki/Tic-tac-toe.
 *
 *  This is exercising functional decomposition and testing
 *  - Any non trivial method should be tested (in test() method far below)
 *  - IO methods never tested.
 *
 *  NOTE: Just use an array for the board (we print it to look square, see plotBoard())
 *
 */
public class Ex9TicTacToe {

    public static void main(String[] args) {
        new Ex9TicTacToe().program();
    }

    final Scanner sc = new Scanner(in);
    final Random rand = new Random();
    final char EMPTY = '-';        // This is so that we easy can change the value in one place

    void program() {
        //test();       // <--------- Comment out to test

        Player p1 = new Player("olle", 'X');
        Player p2 = new Player("fia", 'O');
        Player current;
        Player winner = null;
        char[] board = createBoard();

        out.println("Welcome to Tic Tac Toe, board is ...");
        plotBoard(board);

        if (rand.nextBoolean()) {
            current = p1;
        } else {
            current = p2;
        }

        // TODO Game loop

        for (int i=0; i<9; i++) {
            int c = getPlayerSelection(current);

            if (board[c]==EMPTY) {

                for (int j = 0; j < 9; j++) {
                    if (j == c) {
                        board[j] = current.mark;
                        plotBoard(board);
                    }
                }

                if ((board[0]==current.mark & board[0]==board[1] & board[1]==board[2])
                        | (board[3]==current.mark & board[3]==board[4] & board[4]==board[5])
                        | (board[6]==current.mark & board[6]==board[7] & board[7]==board[8])) {
                    winner = current;
                    break;
                }
                else if ((board[0]==current.mark & board[0]==board[3] & board[3]==board[6])
                        | (board[1]==current.mark & board[1]==board[4] & board[4]==board[7])
                        | (board[2]==current.mark & board[2]==board[5] & board[5]==board[8])) {
                    winner = current;
                    break;
                }
                else if ((board[0]==current.mark & board[0]==board[4] & board[4]==board[8]) |
                        (board[2]==current.mark & board[2]==board[4] & board[4]==board[6])) {
                    winner = current;
                    break;
                }
                else if (current == p1) {
                    current = p2;
                }
                else {
                    current = p1;
                }
            }
            else {
                i--;
                out.println("Not empty");
                plotBoard(board);
            }
        }

        out.println("Game over!");
        plotBoard(board);

        if (winner != null) {
            out.println("Winner is " + current.name);
        } else {
            out.println("Draw");
        }
    }


    // ---------- Methods  ----------------

    char[] createBoard() {
        char[] board = new char[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = EMPTY;
        }
        return board;
    }

   // TODO More methods

    // ---------- IO Methods  ----------------

    int getPlayerSelection(Player player) {
        int selection;
        while (true) {
            out.println("Player is " + player.name + "(" + player.mark + ")");
            out.print("Select position to put mark (0-8) > ");
            selection = sc.nextInt();
            if (0 <= selection && selection <= 8) {
                break;
            }
            out.println("Bad choice (0-8 allowed)");
        }
        return selection;
    }

    void plotBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            out.print(board[i] + " ");
            if ((i + 1) % 3 == 0) {
                out.println();
            }
        }
    }

    // A class (blueprint) for players.
    class Player {
        String name;
        char mark;
        Player(String name, char mark) {
            this.name = name;
            this.mark = mark;
        }
    }

    // This is used to test methods in isolation
    // Any non trivial method should be tested.
    // If not ... can't build a solution out of possible failing parts!
    void test() {
        char[] b = createBoard();
        out.println(b.length == 9);

        // "Hard coded" test boards
        char[] fullBoard = {'X', 'X', 'X', '0', 'O', 'X', 'O', '0', 'O'};
        char[] nonFullBoard = {'-', 'X', 'X', '-', 'O', '-', 'O', '-', 'O'};
        char[] fullColumn = {'-', 'X', '0', '-', 'X', '-', 'O', 'X', 'O'};
        char[] fullRow = {'X', 'X', 'X', '-', 'O', '-', 'O', '-', 'O'};
        char[] winner = {'X', '0', '-', '-', 'X', '0', 'O', '-', 'X'};

        //out.println(is it full(fullBoard));   // true

        exit(0);
    }
}