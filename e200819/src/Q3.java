/*
        Solution to question 3 here.
 */

import static java.lang.System.*;
import java.util.Arrays;

public class Q3 {

    public static void main(String[] args) {
        new Q3().program();
    }

    private void program() {

        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        int[] arr3 = {1, 2, 3, 4};
        int[] arr4 = {1, 2, 2, 3, 6, 6, 6};
        int[] arr5 = {7, 5, 3, 6, 2, 2, 3, 6};


        out.println(Arrays.toString(inBoth(arr1, arr2)));
        out.println(Arrays.toString(inBoth(arr1, arr3)));
        out.println(Arrays.toString(inBoth(arr2, arr4)));
        out.println(Arrays.toString(inBoth(arr4, arr5)));


    }

    // TODO

    int[] inBoth(int[] arr1,int[] arr2) {
        int size = arr1.length;
        if (arr1.length < arr2.length) {
            size = arr2.length;
        }

        int[] newArr = new int[size];
        int index = 0;

        for (int i : arr1){
            for (int j : arr2) {
                if (i == j && !contains(newArr,i)) {
                    newArr[index] = i;
                    index++;
                    break;
                }
            }
        }

        int[] result = new int[index];
        for (int i=0; i<result.length; i++) {
            result[i]=newArr[i];
        }
        return result;
    }

    boolean contains(int[] arr, int n) {
        for (int i : arr) {
            if (i == n) {
                return true;
            }
        }return false;
    }
}

