import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/*
 *  Using Steinhaus-Johnson-Trotter (non-recursive) algorithm for permutations
 *  See https://en.wikipedia.org/wiki/Steinhaus%E2%80%93Johnson%E2%80%93Trotter_algorithm
 *
 * See
 * - ex3string
 * - ex5collections
 *
 */
public class Ex8SJT {

    public static void main(String[] args) {
        new Ex8SJT().program();
    }

    private void program() {
        // Call permutation method
        List<String> perms = permutationSJT("123456");

        out.println(perms.size());  // 720
        for (String s : perms) {
            out.println(s);
        }

        int count = 0;
        for (String s : perms) {
            if (s.equals("123456")) {
                count++;
            }
        }
        out.println(count == 1);
    }

    // Steinhaus–Johnson–Trotter permutation algorithm iterative!
    // Use functional decomposition!
    List<String> permutationSJT(String set) {
       // TODO
        return null;
    }
}