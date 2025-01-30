import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static java.lang.System.out;

/*
 *
 *  Use a Stack to check parentheses (balanced and correct nesting)
 *  The parentheses are: (), [] and {}
 *
 *  See:
 *  - ex2shortforswitch/SwitchStatement
 *  - ex5collections/C4Stack
 *  - ex5collections/C5Palindrome
 */
public class Ex4CheckParen {

    public static void main(String[] args) {
        new Ex4CheckParen().program();
    }

    void program() {
        // All should be true
        /*Deque<Character> stack = new ArrayDeque<>();
        stack.pop();
        stack.push(null);
        stack.isEmpty();
        stack.peek();

        out.println(checkParantheses("([)]"));*/


        out.println(checkParentheses("()"));
        out.println(checkParentheses("(()())"));
        out.println(!checkParentheses("(()))")); // Unbalanced
        out.println(!checkParentheses("((())")); // Unbalanced

        out.println(checkParentheses("({})"));
        out.println(!checkParentheses("({)}"));  // Bad nesting
        out.println(checkParentheses("({} [()] ({}))"));
        out.println(!checkParentheses("({} [() ({)})"));  // Unbalanced and bad nesting


    }
    // ---------------- Methods --------------------


    boolean checkParentheses(String expr) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch: expr.toCharArray()) { // går igenom alla tecken som en array
            if (isOpeningParen(ch)) {
                stack.push(ch);
            } else if (isClosingParen(ch)) {
                if (stack.isEmpty()) { // finns inget matchande kvar
                    return false;
                }
                char topValue = stack.peek();
                if (matching(ch) == topValue) {
                    stack.pop(); // tar bort från stacken för att det har matchat
                } else {
                    return false; // man har något annat tecken
                }
            } else {
                // Skip any other
            }
        }
        return stack.isEmpty(); // om något är kvar är det fel
    }

    boolean isOpeningParen(char ch) {
        return "({[".indexOf(ch) >= 0;
        /*if (ch=='(' || ch=='[' || ch=='{') {
            return true;
        } else {
            return false;
        }*/
    }

    boolean isClosingParen(char ch) {
        return ")}]".indexOf(ch) >= 0;
    }


    // This is interesting because method has to return, but what if no match?!?
    char matching(char ch) {
        switch (ch) {
            case ')':
                return '(';  // c = '('
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                // If throwing exception don't need to return
                throw new IllegalArgumentException("No match found");
        }
    }
}
