package assignmentQuestion;

import java.util.*;

public class TwoIntegers {

	//Method to find the pairs of number whose sum will give the target.
	private static int[][] findPairs(int[] arr, int target) {
        int[][] pairs = new int[arr.length][2];
        int count = 0;

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    pairs[count][0] = arr[i];
                    pairs[count][1] = arr[j];
                    count++;
                    break;
                }
            }
        }

        return Arrays.copyOf(pairs, count);
    }

	//The method is to merge the pairs of numbers whose sum will give the target.
    private static int[] mergeArray(int[][] arr) {
    	int newSize = arr[1].length * arr.length;
        int[] mergedArray = new int[newSize];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
            	mergedArray[count] = arr[i][j];
            	count++;
            }
        }
        
        return mergedArray;
    }

//    private static int[][] findDoublePairs(int[] arr, int target, int index) {
//        
//    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 2, -4, -6, -2, 8};
        int target = 4;

        int[][] pairs = findPairs(array, target);
        System.out.println("First Combination For “4” : " + Arrays.deepToString(pairs));

        int[] mergedArray = mergeArray(pairs);
        System.out.println("Merge Into a single Array : " + Arrays.toString(mergedArray));

        int doubleTarget = target * 2;
//        int[][] combinations = findDoublePairs(array, doubleTarget);
//        System.out.println("Second Combination For “8” : " + Arrays.deepToString(combinations));
    }

}
