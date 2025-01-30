/*
        Solution to question 5 here.
 */


import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.System.out;

public class Q5 {

    public static void main(String[] args) {
        new Q5().program();
    }

    private void program() {
        String str = "aba accb accabc";



        out.println(smallestSubStr(str, "a").equals("a"));
        out.println(smallestSubStr(str, "aa").equals("aba"));
        //out.println(smallestSubStr(str, "aaa").equals("aba a"));
       // out.println(smallestSubStr(str, "abc").equals("cab"));
        //out.println(smallestSubStr(str, "babc").equals("ba accb"));
       // out.println(smallestSubStr(str, "aaaaabbbccccc").equals(str));
        out.println(smallestSubStr(str, "ax").equals(str));

    }

    // TODO

    String smallestSubStr(String s,String t) {
        StringBuilder sb = new StringBuilder();
        Deque<String> stack1 = new ArrayDeque<>();
        Deque<String> stack2 = new ArrayDeque<>();

        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            //int j=i;
            if (t.charAt(index) == s.charAt(i))
                sb.append(s.charAt(i));
            while (!s.equals(Character.toString(t.charAt(index))) && i<s.length()) {
                sb.append(s.charAt(i));
                i++;
            }
            index++;
        }
        String str = sb.toString();
        return str;
    }


    boolean contains(String str, String t,int i) {
        for (int j=0; j<t.length(); j++) {
            String g = Character.toString(t.charAt(j));
            if (!str.contains(g)) {
                return false;
            }
            //str.remove(g);
        }
        return true;
    }




}

