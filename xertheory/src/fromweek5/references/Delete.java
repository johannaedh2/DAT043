package fromweek5.references;

import java.util.Arrays;

import static java.lang.System.out;
/*
    Is this a good way to delete objects?
    If not wy?
 */

public class Delete {

    public static void main(String[] args) {
        new Delete().program();
    }

    void program() {
        Integer[] many = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        delete(many);

        out.println(Arrays.toString(many));
    }

    // Try to delete the array
    public static void delete(Object object) {
        object = null;
    }
}
