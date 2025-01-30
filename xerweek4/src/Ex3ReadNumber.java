import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/*
 *   Extract numbers form Strings
 *
 *   See:
 *  - ex3string/
 *      S1Character
 *      S2String
 *      S3StringBuilder
 *  -ex5collections
 *      C1ListArrayList
 */

public class Ex3ReadNumber {

    public static void main(String[] args) {
        new Ex3ReadNumber().program();
    }

    void program() {
        List<String> numbers = new ArrayList<>();
/*
        // Argument 0 is index to start looking for digits.
        // Return value is index directly after last read digit
        out.println(readNumber(numbers, "1", 0) == 1);
        // The number should be in the list numbers (method should add number to list)
        out.println(numbers.contains("1"));
        numbers.clear();

        out.println(readNumber(numbers, "123", 0) == 3);
        out.println(numbers.contains("123") && !numbers.contains("1"));
        numbers.clear();

        out.println(readNumber(numbers, "123abc", 0) == 3);
        out.println(numbers.contains("123"));
        numbers.clear();

        out.println(readNumber(numbers, "12345abc", 0) == 5);
        out.println(numbers.contains("12345"));
        numbers.clear();

        out.println(readNumber(numbers, "abc123abc", 3) == 6);
        out.println(numbers.contains("123"));

        out.println(readNumber(numbers, "", 0) == 0);
*/
    }

    // ----------- Methods-----------------------------------

    /*int readNumber(List<String> numbers,String str,int startIndex) {

        for (int i=startIndex; i<str.length(); i++) {
            if (str.charAt(i) )
        }
        return 7;

    }*/

}
