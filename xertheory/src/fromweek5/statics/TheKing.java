package fromweek5.statics;

import java.util.Calendar;

import static java.lang.System.out;

/*
    What will be printed? Why?
 */
public class TheKing {
    public static final TheKing theKing = new TheKing();
    private final int beltSize;
    private static final int this_year = Calendar.getInstance()
            .get(Calendar.YEAR);

    public TheKing() {
        beltSize = this_year - 1930;
    }

    public int beltSize() {
        return beltSize;
    }

    public static void main(String[] args) {
        out.println("TheKing wears a size " +
                theKing.beltSize() + " belt.");
    }
}
