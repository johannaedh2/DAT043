/*
        Solution to question 3 here.
 */

import java.util.Arrays;
import static java.lang.System.out;

public class Q3 {

    public static void main(String[] args) {
        new Q3().program();
    }

    private void program() {
        int[] arr1 = {1, 9, 1, 5, 1, 7};
        int[] arr2 = {10, 2};
        int[] arr3 = {2, 9, 3, 21, 3, 7};


        out.println(Arrays.equals(expand(arr1), new int[]{9,5,7}));
        out.println(Arrays.equals(expand(arr2), new int[]{2,2,2,2,2,2,2,2,2,2}));
        out.println(Arrays.equals(expand(arr3), new int[]{9,9,21,21,21,7,7,7}));



    }

    // TODO

    int[] expand(int[] arr) {
        int even = 0;
        int odd = 1;
        int[] newArr = new int[20];
        int index = 0;

        while (even < arr.length) {
            for (int j=0; j<arr[even]; j++) {
                newArr[index] = arr[odd];
                index++;
            }
            even += 2;
            odd += 2;
        }
        int[] result = new int[index];
        for (int j=0; j<result.length; j++) {
            result[j]=newArr[j];
        }

        return result;
    }




}

