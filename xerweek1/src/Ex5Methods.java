import static java.lang.System.out;

/*
 *  Implement methods to make program produce correct output (normally print true)
 *
 * See:
 * - ex4methods
 */
public class Ex5Methods {

    public static void main(String[] args) {
        new Ex5Methods().program();
    }

    void program() {
        // All, except last,  should print true
        // Uncomment one at the time
        out.println(sumTo(5) == 15);     // 1 + 2 + ... + 5 = 15
        out.println(sumTo(23) == 276);
        out.println(factorial(3) == 6);    // 3 * 2 * 1 = 6
        out.println(factorial(5) == 120);
        out.println(digitSum(1111) == 4);   // 1 + 1 + 1 + 1 = 4
        out.println(digitSum(12345) == 15);

        String winner = "Olle";
        // A special case, should print: "Winner is Olle" (or whatever name)
        winnerMsg(winner);

    }

    // ------ Write methods below this  -----------

    // TODO

    int sumTo (int c) {
        int b = 0;
        while (c > 0) {
            b = b + c;
            c--;
        }
        return b;
    }

   int factorial (int a) {
        int b = a;
        while (a > 1)
        {
            b = b*(a-1);
            a--;
        }
        return b;
   }

   int digitSum (int x) {
        int z = x;
        int y = 0;
        int v;
        while (z > 0) {
            v = (z % 10);
            y = y + v;
            z = (z-v)/10;
        }
        return y;
   }

   void winnerMsg (String str) { // void returnar inget värde utan uför tex bara något
        out.println("The winner is: " + str);
    }



}
