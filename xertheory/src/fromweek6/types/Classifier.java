package fromweek6.types;

import static java.lang.System.out;


/*
            Will it compile? If so will it run without exception?
            If so what is printed? Try to predict!

 */

public class Classifier {
    public static void main(String[] args) {
        new Classifier().program();
    }

    void program() {
        /*
        Object[] o = { 0, "abc", 1.23 };
        for (int i = 0; i < o.length; i++) {
            classify(o[i]);
        }

         */
    }

    public void classify(Integer i) {
        out.println("It's an integer");
    }

    public void classify(String s) {
        out.println("It's a String");
    }

    public void classify(Object o) {
        out.println("Don't know, it's anything...");
    }
}
