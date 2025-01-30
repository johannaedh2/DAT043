import java.util.*;

import static java.lang.Double.NaN;
import static java.lang.Math.pow;
import static java.lang.System.out;


/*
 *   A calculator for rather simple arithmetic expressions
 *
 *   This is not the program, it's a class declaration (with methods) in it's
 *   own file (which must be named Calculator.java)
 *
 *   NOTE:
 *   - No negative numbers implemented
 */
public class Calculator {

    // Here are the only allowed instance variables!
    // Error messages (more on static later)
    final static String MISSING_OPERAND = "Missing or bad operand";
    final static String DIV_BY_ZERO = "Division with 0";
    final static String MISSING_OPERATOR = "Missing operator or parenthesis";
    final static String OP_NOT_FOUND = "Operator not found";

    // Definition of operators
    final static String OPERATORS = "+-*/^";

    // Method used in REPL
    double eval(String expr) {
        if (expr.length() == 0) {
            return NaN;
        }
        List<String> tokens = tokenize(expr);
        List<String> postfix = infix2Postfix(tokens);
        return evalPostfix(postfix);
    }

    // ------  Evaluate RPN expression -------------------

    double evalPostfix(List<String> postfix) {
        Deque<Double> stack = new ArrayDeque<>();
        for (String s : postfix) {
            if (Character.isDigit(s.charAt(0))) {
                Double r = Double.valueOf(s);
                stack.push(r);
            }
            else {
                if (stack.size() >= 2) {
                    double d1 = stack.pop();
                    double d2 = stack.pop();
                    double apply = applyOperator(s, d1, d2);
                    stack.push(apply);
                }
                else {
                    throw new IllegalArgumentException(MISSING_OPERAND);
                }
            }
        }
        if (stack.size()>1) {
            throw new IllegalArgumentException(MISSING_OPERATOR);
        }
        double result = stack.pop();
        return result;
    }

    double applyOperator(String op, double d1, double d2) {
        switch (op) {
            case "+":
                return d1 + d2;
            case "-":
                return d2 - d1;
            case "*":
                return d1 * d2;
            case "/":
                if (d1 == 0) {
                    throw new IllegalArgumentException(DIV_BY_ZERO);
                }
                return d2 / d1;
            case "^":
                return pow(d2, d1);
        }
        throw new RuntimeException(OP_NOT_FOUND);
    }

    // ------- Infix 2 Postfix ------------------------

    List<String> findLeft(Deque<String> stack, List<String> postfix) {
        if (!stack.contains("(")) {
            throw new IllegalArgumentException(MISSING_OPERATOR);
        }
        while (true) {
            if ((stack.peek()).equals("(")) {
                stack.pop();
                break;
            } else  {
                postfix.add(stack.pop());
            }
        }
        return postfix;
    }

    void rightAssos(Deque<String> stack, List<String> postfix,String s){
        while (!stack.isEmpty() && getAssociativity(stack.peek()) == Assoc.RIGHT) {
            postfix.add(stack.pop());
        }
        stack.push(s);
    }


    List<String> infix2Postfix(List<String> infix) {
        List<String> postfix = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        for (String s : infix) {
            if (Character.isDigit(s.charAt(0))) {
                postfix.add(s);
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                postfix = findLeft(stack, postfix);
            } else {
                if (stack.isEmpty() || (stack.peek()).equals("(")) {
                    stack.push(s);
                }
                else if (((getPrecedence(stack.peek()) > getPrecedence(s))) ||
                        (getPrecedence(stack.peek()) == getPrecedence(s) && getAssociativity(s) == Assoc.LEFT)) {
                   if ((getAssociativity(stack.peek()) == Assoc.RIGHT) && ((getAssociativity(s)) == Assoc.LEFT)) {
                       rightAssos(stack,postfix,s);
                    }
                   else {
                        postfix.add(stack.pop());
                        stack.push(s);
                    }
                }
                else {
                    stack.push(s);
                }
            }
        }

        int length = stack.size();
        for (int j = 0; j < length; j++) {
            if (stack.peek().equals("(")) {
                throw new IllegalArgumentException(MISSING_OPERATOR);
            }
            postfix.add(stack.pop());
        }
        return postfix;
    }

    int getPrecedence(String op) {
        if ("+-".contains(op)) {
            return 2;
        } else if ("*/".contains(op)) {
            return 3;
        } else if ("^".contains(op)) {
            return 4;
        } else {
            throw new RuntimeException(OP_NOT_FOUND);
        }
    }

    Assoc getAssociativity(String op) {
        if ("+-*/".contains(op)) {
            return Assoc.LEFT;
        } else if ("^".contains(op)) {
            return Assoc.RIGHT;
        } else {
            throw new RuntimeException(OP_NOT_FOUND);
        }
    }

    enum Assoc {
        LEFT,
        RIGHT
    }

    // ---------- Tokenize -----------------------

    String digitCombiner(String expr, int i){
        StringBuilder sb = new StringBuilder();
        sb.append(expr.charAt(i));
        //int j = i;
        int next = 1;
        while (i+next<expr.length()) {
            if (Character.isDigit(expr.charAt(i+next)) ) {
                sb.append(expr.charAt(i+next));
                next++;
                //j++;
            }
            else {
                break;
            }
        }
        String s = sb.toString();
        //i=j;
        return s;
    }

    List<String> tokenize(String expr) {
        List<String> sList = new ArrayList<>();
        for (int i=0; i<expr.length(); i++) {
            if (!Character.isWhitespace(expr.charAt(i))) {
                if (Character.isDigit(expr.charAt(i))) {
                    String number = digitCombiner(expr,i);
                    sList.add(number);
                    i += number.length()-1;
                } else {
                    char c = expr.charAt(i);
                    String s = Character.toString(c);
                    sList.add(s);
                }
            }
        }
        return sList;
    }




    /*List<String> tokenize2(String expr) {
        List<String> sList = new ArrayList<>();
        for (int i=0; i<expr.length(); i++) {
            if (!Character.isWhitespace(expr.charAt(i))) {
                if (Character.isDigit(expr.charAt(i))) {
                    StringBuilder sb = new StringBuilder(); //Används för att sätta ihop siffror
                    sb.append(expr.charAt(i));              //Första siffran läggs till
                    int j = i;
                    int next = 1;
                    while (i+next<expr.length()) {
                        if (Character.isDigit(expr.charAt(i+next)) ) {
                            sb.append(expr.charAt(i+next));
                            next++;
                            j++;
                        }
                        else {
                            break;
                        }
                    }
                    String s = sb.toString();
                    sList.add(s);
                    i=j;                                    //for-loopen hoppar förbi talet
                } else {
                    char c = expr.charAt(i);
                    String s = Character.toString(c);
                    sList.add(s);
                }
            }
        }
        return sList;
    }*/
}
