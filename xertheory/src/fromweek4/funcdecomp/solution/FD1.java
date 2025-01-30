package fromweek4.funcdecomp.solution;

import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.System.out;

/*
      Exercising functional decomposition

       Using functional decomposition, and a stack
       find out if sentence (word) is palindrome

       Your solution should use a stack (Deque, ArrayDeque)
 */
public class FD1 {

    public static void main(String[] args) {
        new FD1().program();
    }

    void program() {
        String str1 = "Sirap i paris";
        String str2 = "Madam I'm Adam";
        String str3 = "Was It A Rat I Saw?";
        String str4 = "Can a get a hot dog?";
        String str5 = "Some love red";

        out.println(isPalindrome(str1));
        out.println(isPalindrome(str2));
        out.println(isPalindrome(str3));
        out.println(!isPalindrome(str4));
        out.println(!isPalindrome(str5));

        // ------ Other approaches (fail on number of spaces) ------------
        out.println(reverse2(str1).toLowerCase().equals(str1.toLowerCase()));

        // Functional approach (optional)
        out.println(new StringBuilder(str1)
                .reverse()
                .toString()
                .toLowerCase()
                .equals(str1.toLowerCase()));
    }


    boolean isPalindrome(String str) {
        String tmp = removeNonLetters(str.toLowerCase());
        String rev = reverse(tmp);
        return rev.equals(tmp);
    }

    String removeNonLetters(String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // There are easier ways.
    String reverse(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    // Low level using indexes
    String reverse2(String str) {
        char[] chs = str.toCharArray();
        for (int i = 0; i < str.length() / 2; i++) {
            char tmp = chs[i];
            chs[i] = chs[str.length() - 1 - i];
            chs[str.length() - 1 - i] = tmp;
        }
        return new String(chs);
    }


}
