import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/*
 * Count number of words in some text
 *
 * See:
 *  - ex3string/
 *      S1Character
 *      S2String
 */
public class Ex1WordCount {

    public static void main(String[] args) {
        new Ex1WordCount().program();
    }

    void program() {
        // All should print true

        /*char c = 'f';
        char b = 'b';
        StringBuilder bl = new StringBuilder();
        bl.append(c).append(b);

        String ss = bl.toString();
        List<String> h = new ArrayList<>();

        String j = "hej";
        String k = "bajs";

        h.add(j);
        h.add(k);
        List<String> immutableList = List.of("one", "two", "three");
        out.println(h);
        out.println(immutableList);*/


        out.println(countWords("") == 0);
        out.println(countWords("hello") == 1);
        out.println(countWords(" hello ") == 1);
        out.println(countWords("hello world ") == 2);
        out.println(countWords("hello        world") == 2);
        out.println(countWords("   hello        world  ") == 2);
        String s = "Education is what remains after one has forgotten what one has learned in school.";
        out.println(countWords(s) == 14);

    }

    // ---------------- Methods -----------------------

    int countWords(String s) {
        int count = 0;
        if (s.isEmpty()) {
            return 0;
        }
        //if (Character.isLetter(s.charAt(0)))
        for (int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            if (Character.isLetter(a) && (Character.isWhitespace(b) || i>=s.length()-2 )) {
                count++;
            }
        }
        return count;
    }
    //for( String s : strs)
}
