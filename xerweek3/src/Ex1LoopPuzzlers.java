import static java.lang.System.out;

/*
 *  Some puzzlers
 *  General improvement of programming skills
 *
 *  See:
 *  - lectweek2/ex4algorithms/A3NestedLoops
 */
public class Ex1LoopPuzzlers {

    public static void main(String[] args) {
        new Ex1LoopPuzzlers().program();
    }


    void program() {
        // Write solution (for loops) directly here

        // Multiplication table
        int x=1;
        for (int r=1; r<11; r++) {
            for (int c=1; c<11; c++) {
                out.print(x*c + " ");
            }
            x++;
            out.println();
        }


        // Plot a half square
        for (int i = 10; i > 0; i--) {
            for (int j = i; j < 10; j++) {  // Sometimes inner loop depends on outer
                out.print("X");
            }
            out.println();
        }

        out.println();

        // Plot a rhombus
        for (int i=8; i>0; i--) {
            for (int j=i; j<8; j++) {
                out.print(" ");
            }
            for (int p=0; p<10; p++) {
                out.print("X");
            }
            out.println();
        }
    }
}
