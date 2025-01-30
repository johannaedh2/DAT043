/*
        Solution to question 5 here.
 */

import static java.lang.System.*;

public class Q5 {

    public static void main(String[] args) {
        new Q5().program();
    }

    private void program() {
        String walk1 = "e1w1s1n1";
        String walk2 = "e12w12s12n12";
        String walk3 = "e123w1";
        String walk4 = "e122w123e1";
        String walk5 = "n3e4s2e2";


        out.println(willHit(0, 0, 0, 0, walk1));
        out.println(willHit(1, 1, 1, 1, walk2));
        out.println(willHit(0, 0, 0, 0, walk3));
        out.println(willHit(0, 0, 0, 0, walk4));
        out.println(willHit(2, 2, 8, 3, walk5));

    }

    // TODO

    int getSteps(String expr, int i){
        StringBuilder sb = new StringBuilder();
        sb.append(expr.charAt(i));
        int next = 1;
        while (i+next<expr.length()) {
            if (Character.isDigit(expr.charAt(i+next)) ) {
                sb.append(expr.charAt(i+next));
                next++;
            }
            else {
                break;
            }
        }
        String s = sb.toString();
        int steps = Integer.valueOf(s);
        return steps;
    }


    boolean willHit(int startX,int startY,int endX,int endY,String walk){
        for (int i=0; i<walk.length()-1; i++) {
            char c = walk.charAt(i);
            if (!Character.isDigit(c)) {
                int steps = getSteps(walk,i+1);

                if (c == 'n') {
                    startY += steps;
                } else if (c == 'e') {
                    startX += steps;
                } else if (c == 's') {
                    startY += -steps;
                } else if (c == 'w') {
                    startX += -steps;
                } else {

                }
            }
        }
        if ((startX == endX) && (startY == endY)) {
            return true;
        }
        else return false;
    }


}

