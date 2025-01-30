package ex4types;

import static java.lang.System.out;

/*
    Similar to a generic class, a generic interface
    This is a big topic, just for general background here
 */
public class T5GenericInterface {

    public static void main(String[] args) {
        new T5GenericInterface().program();
    }

    void program() {
        IRememberable<String> r = new Box<>("Hello");
        out.println(r.getRemembered());


    }

    //--------- Generic interface-------------

    interface IRememberable<T> {
        T getRemembered();
    }

    //--------- Class -------------

    // Class implements generic interface
    class Box<T> implements IRememberable<T> {
        T toRemember;    // T is any reference type

        public Box(T toRemember) {
            this.toRemember = toRemember;
        }

        @Override
        public T getRemembered() {
            return toRemember;
        }
    }

}















