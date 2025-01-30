import java.util.Arrays;

import static java.lang.System.out;

/*
    Find three elements in sorted array that adds up to 0.
    Return indices to the elements as an array.
 */
public class Ex5ThreeSumToZero {

    public static void main(String[] args) {
        new Ex5ThreeSumToZero().program();
    }


    void program() {
        int[] arr1 = {-25, -10, -7, -3, 2, 4, 8, 10}; // Must be sorted
        int[] arr2 = {0, 1, 2, 4, 8, 10};
        int[] arr3 = {-2, 1, 1};
        int[] arr4 = {0, 0, 0, 0};

        out.println(Arrays.toString(getThreeSum(arr1)));    // [1, 4, 6]
        out.println(Arrays.toString(getThreeSum(arr2)));    // []
        out.println(Arrays.toString(getThreeSum(arr3)));    // [0, 1, 2]
        out.println(Arrays.toString(getThreeSum(arr4)));    // [ 0, 1 ,3 ] or any
    }

    int[] getThreeSum1(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int x = -arr[i];
            int index1 = i+1;
            int index2 = arr.length-1;
            while (index1 != index2) {
                int sum = arr[index1] + arr[index2];
                if (sum < x) {
                    index1++;
                }
                else if (sum > x) {
                    index2--;
                }
                else {
                    int[] arr2 = new int[] {arr[i], arr[index1], arr[index2]};
                    return arr2;
                }
            }
        }
        return null;
    }


    // NOTE: Solution may not contain nested loops
    int[] getThreeSum(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            int acho = -arr[i];
            int lead = i + 1;
            int trail = arr.length - 1;
            while (lead != trail) {
                int sum = arr[lead] + arr[trail];
                if (sum < acho) {
                    lead++;
                } else if (sum > acho) {
                    trail--;
                } else {
                    return new int[]{i, lead, trail};
                }
            }
        }
        return null;
    }
}
