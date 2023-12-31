package assignmentQuestion;

import java.util.*;

public class TwoIntegers {

    //Method to find the pairs of number whose sum will give the target.
    private static int[][] findPairs(int[] arr, int target) {
        int[][] pairs = new int[arr.length][2]; // Initialize a 2D array to store pairs
        int count = 0; // Counter for valid pairs

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) { // Check if the sum of two numbers equals the target
                    pairs[count][0] = arr[i]; // Store the first number in the pair
                    pairs[count][1] = arr[j]; // Store the second number in the pair
                    count++; // Increment the counter
                    break; // Break the inner loop since a pair is found
                }
            }
        }

        return Arrays.copyOf(pairs, count); // Return the valid pairs without any null element
    }
    // Time Complexity: O(N^2), where N is the length of the input array. The method uses nested loops to check all pairs of numbers, resulting in quadratic time complexity.
    // Space Complexity: O(N), as the method creates a 2D array to store pairs, which has a size proportional to the number of pairs found.

	
    //The method is to merge the pairs of numbers whose sum will give the target.
    private static int[] mergeArray(int[][] arr) {
    	int newSize = arr[1].length * arr.length; // Calculate the size of the merged array
        int[] mergedArray = new int[newSize]; // Initialize the merged array
        int count = 0; // Counter for elements in the merged array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
            	mergedArray[count] = arr[i][j]; // Store the element in the merged array
            	count++; // Increment the counter
            }
        }
        
        Arrays.sort(mergedArray); // Sort the merged array in ascending order
        
        return mergedArray; // Return the merged array
    }
    // Time Complexity: O(N), where N is the total number of elements in the input 2D array. The method iterates over all elements in the array to merge them into a single array.
    // Space Complexity: O(N), as the method creates a new array to store the merged elements, and the size of the array is equal to the total number of elements in the input 2D array.

	
    // Recursive method to find sub-sequences with target sum
    private static void findDoublePairs(int[] arr, int target, int index, int sum, List<Integer> current, List<List<Integer>> result) {
        // Base case: if the sum is equal to the target, add the current sub-sequence to the result list
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Base case: if index exceeds the array length or the sum exceeds the target, return
        if (index >= arr.length || sum > target) {
            return;
        }

        // Explore all possible combinations by including the current element at index 'i'
        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]); // Add the current element to the current sub-sequence
            findDoublePairs(arr, target, i + 1, sum + arr[i], current, result); // Recursively find sub-sequences starting from index 'i+1' with updated sum
            current.remove(current.size() - 1); // Backtrack: remove the last element from the current sub-sequence
        }
    }
    // Time Complexity: O(2^N), where N is the length of the input array. The method generates all possible subsequences of the array, and the number of subsequences is exponential in the worst case.
    // Space Complexity: O(N), as the method uses recursion and maintains a call stack with a maximum depth equal to the length of the input array.
	

    // Method to find sub-sequences with target sum
    public static List<List<Integer>> findDoublePairs(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>(); // Initialize the result list
        findDoublePairs(arr, target, 0, 0, new ArrayList<>(), result); // Call the recursive method to find the sub-sequences
        return result; // Return the result
    }
    // Time Complexity: O(2^N * N), where N is the length of the input array. The method uses the recursive findDoublePairs method to find subsequences, which has an exponential time complexity. Additionally, for each subsequence found, the method calculates the sum of its elements, resulting in an additional iteration of size N.
    // Space Complexity: O(2^N), as the method uses the recursive findDoublePairs method, which has an exponential space complexity due to the recursion and the storage of subsequences.

    // Main method
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 2, -4, -6, -2, 8};
        int target = 4;

        int[][] pairs = findPairs(array, target); // Find pairs whose sum equals the target
        System.out.println("First Combination For “4” : " + Arrays.deepToString(pairs));

        int[] mergedArray = mergeArray(pairs); // Merge pairs into a single array
        System.out.println("Merge Into a single Array : " + Arrays.toString(mergedArray));

        int doubleTarget = target * 2; // find again the combination of digits (can be multiple digits ) that are equal to the double targeted value and return it.
        List<List<Integer>> answer = findDoublePairs(array, doubleTarget);
      	System.out.println("Second Combination For "+ doubleTarget + " : " + answer);
    }

}

// Time Complexity: The most significant factor is the findDoublePairs method with a time complexity of O(2^N * N). The other methods contribute to the overall time complexity with lower-order terms. Therefore, the overall time complexity can be considered as O(2^N * N).
// Space Complexity: The most significant factor is the findDoublePairs method with a space complexity of O(2^N). The other methods contribute to the overall space complexity with lower-order terms. Therefore, the overall space complexity can be considered as O(2^N).
