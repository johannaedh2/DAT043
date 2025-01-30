package ex4algorithms;

import java.util.Arrays;

import static java.lang.System.out;

/*
       Some basic algorithms (using arrays).

       In these examples it doesn't matter that arrays parameters
       are references because we only read from the array
 */
public class A1BasicAlgs {

    public static void main(String[] args) {
        new A1BasicAlgs().program();
    }

    void program() {
        int[] arr = {1, 2, 3, 4, 5};

        out.println(sum(arr) == 15);  // Sum all elements in array

        out.println(findMin(arr) == 1);  // Min value

        // Linear search
        out.println(find(arr, 4) == 3);  // Value 4 is at index 3
        out.println(find(arr, 99) == -1);  // Not found

    }

    // ---- Methods ---------------------

    // Sum alla elements in array
    int sum(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i];
        }
        return s;
    }


    // Find min value in array
    int findMin(int[] arr) {
        int min = arr[0];     // Assume first is min ...
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {     // .. then check if any is smaller
                min = arr[i];
            }
        }
        return min;
    }

    // This is linear search
    // Return index (an int) to possibly found.
    // Reason:  Because if not found we can return -1 as a sign
    // that the value was not found
    // If returning the value what to return if not found?!?
    int find(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;   // Not found!
    }



}
