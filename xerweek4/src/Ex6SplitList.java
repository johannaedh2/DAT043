import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/*
 * Partition a List into a number of sub lists with as equal length as possible
 *
 * See:
 * - ex5collections
 */
public class Ex6SplitList {

    public static void main(String[] args) {
        new Ex6SplitList().program();
    }

    void program() {
        // Will get an immutable list
        List<Integer> ints = Arrays.asList(1, 2, 3, 4);

        List<List<Integer>> ps = partition(ints, 1);
        out.println(ps.get(0).toString().equals("[1, 2, 3, 4]"));

        ps = partition(ints, 2);
        out.println(ps.get(0).toString().equals("[1, 2]"));
        out.println(ps.get(1).toString().equals("[3, 4]"));

        ps = partition(ints, 4);
        out.println(ps.get(0).toString().equals("[1]"));
        out.println(ps.get(1).toString().equals("[2]"));
        out.println(ps.get(2).toString().equals("[3]"));
        out.println(ps.get(3).toString().equals("[4]"));

        //ps = partition(null, 3); // Exception, list null or empty
        //ps = partition(ints, 5); // Exception, list too short (n > list.size())
        //ps = partition(ints, 0); // Exception, n must be positive

        ints = Arrays.asList(1, 2, 3, 4, 5);
        ps = partition(ints, 2);
        out.println(ps.get(0).toString().equals("[1, 2]"));
        out.println(ps.get(1).toString().equals("[3, 4, 5]"));

        ps = partition(ints, 3);
        out.println(ps.get(0).toString().equals("[1]"));
        out.println(ps.get(1).toString().equals("[2, 3]"));
        out.println(ps.get(2).toString().equals("[4, 5]"));

        ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        ps = partition(ints, 3);
        out.println(ps.get(0).toString().equals("[1, 2]"));
        out.println(ps.get(1).toString().equals("[3, 4]"));
        out.println(ps.get(2).toString().equals("[5, 6, 7]"));

        out.println();
    }

    List<List<Integer>> partition(List<Integer> ints, int n) {
        int count = ints.size()/n;
        List<List<Integer>> list = new ArrayList<>(6);


        for (int i=0; i<count; i++) {
            int m=0;
            List<Integer> pairs = new ArrayList<>();
            while (m<n) {
                pairs.add(ints.get(m));
                ints.remove(m);
                m++;
            }
            list.set(i,pairs);
        }


        return list;
    }




}
