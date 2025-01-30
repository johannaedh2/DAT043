package ex5collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.System.out;

/*
    Traversing and Filtering (find element and possibly
    do something with it)
 */

public class C2TraverseFilter {

    public static void main(String[] args) {
        new C2TraverseFilter().program();
    }

    void program() {

        // ----- Traversing  ----------------------

        List<Integer> list = List.of(1, 2, 3, 4, 5);

        for (Integer i : list) {   // Use short for-loop ...
            out.print(i);
        }

        for (int i = 0; i < list.size(); i++) {   // ... or normal for loop
            out.print(list.get(i));
        }

        // ---- Filtering  --------------

        list = new ArrayList<>(List.of(1, 2, 3, 4, 5));  // Another list

        // Simple and safe way to remove many elements (also see last)
        List<Integer> toRemove = new ArrayList<>();  // Temp list
        for (Integer i : list) {
            if (i >= 3) {
                toRemove.add(i);   // Collect all to remove
            }
        }
        list.removeAll(toRemove);  // Finally remove all
        out.println(list);

        /*for( Integer i : list){   // Can't remove in short for loop
            if( i >= 3){
                list.remove(i);       // ConcurrentModificationException
            }
        }*/

        /*
        list = new ArrayList<>(List.of(1, 2, 3, 4, 5));  // Yet another list
        for (int i = 0; i < list.size(); i++) {          // BAD!
            // Uncomment and inspect, will skip one
            if (list.get(i) == 2 || list.get(i) == 3) {
                list.remove(i);
            }
        }
        out.println(list);
        */

        // Other way to remove element
        // Using an iterator (an object that knows how to traverse
        // a collection)
        Iterator<Integer> itr = list.iterator(); // Get iterator object for list.
        while (itr.hasNext()) {
            if (itr.next() >= 3) {
                itr.remove();
            }
        }
        out.println(list);
    }
}
