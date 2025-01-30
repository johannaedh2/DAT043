package ex2references;


/*

    Garbage collection and null pointer exception

    No memory problems if losing all references to an object. Java uses
    garbage collection to remove unreachable objects (a major problem with
    languages with no garbage collection like C/C++).

    Java uses the special value null for a reference not referencing any object.
    To dereference (use) a null value will throw an exception, NullPointerException
    (NPE). NPEs very common...

 */
public class R6NPEAndGC {

    public static void main(String[] arg) {
        new R6NPEAndGC().program();
    }

    void program() {
        int[] arr1 = new int[1000000];

        // Object reference by arr1 lost! 4 Mb
        arr1 = new int[10];   // No problem, garbage collection (GC)...


        int[] i = getIt();
        //out.println(i[2]);        // NullPointerException
        //out.println(i.length);    // Again NPE

        if (i != null) {            // Very often have to check
            //out.println(i[2]);
        }
    }

    int[] getIt() {
        return null; // Very bad, just demonstration
    }


}
