# Unibit-Games-Assignment
Given an array of integers and a target value, We must determine which two integer's sum
equals the target and return a 2D array. Then merge the array into a single array with sorting (
ascending ) order, in the next step double the target value and find again the combination of
digits (can be multiple digits ) that are equal to the double targeted value and returned into a 2D
array.<br />
Sample Input : [1, 3, 2, 2, -4, -6, -2, 8];<br />
Target Value = 4,<br />
Output: First Combination For “4” : [ [1,3],[2,2],[-4,8]];<br />
Merge Into a single Array : [-4,1,2,2,3,8];<br />
Second Combination For “8” : [ [ 1,3,2,2], [8,-4,2,2],....,[n,n,n,n] ]<br />
### The solution is in the path Unibit_Games_Assignment/src/assignmentQuestion/TwoIntegers.java <br />
## OR
### You can directly go through the URL https://github.com/JavaDevShashwat/Unibit-Games-Assignment/blob/main/Unibit_Games_Assignment/src/assignmentQuestion/TwoIntegers.java
<br />
## The time and space complexity analysis for each method and the overall program is as follows:

### findPairs method:

Time Complexity: O(N^2), where N is the length of the input array. The method uses nested loops to check all pairs of numbers, resulting in quadratic time complexity.
Space Complexity: O(N), as the method creates a 2D array to store pairs, which has a size proportional to the number of pairs found.

### mergeArray method:

Time Complexity: O(N), where N is the total number of elements in the input 2D array. The method iterates over all elements in the array to merge them into a single array.
Space Complexity: O(N), as the method creates a new array to store the merged elements, and the size of the array is equal to the total number of elements in the input 2D array.

### findDoublePairs method (recursive):

Time Complexity: O(2^N), where N is the length of the input array. The method generates all possible subsequences of the array, and the number of subsequences is exponential in the worst case.
Space Complexity: O(N), as the method uses recursion and maintains a call stack with a maximum depth equal to the length of the input array.

### findDoublePairs method (non-recursive):

Time Complexity: O(2^N * N), where N is the length of the input array. The method uses the recursive findDoublePairs method to find subsequences, which has an exponential time complexity. Additionally, for each subsequence found, the method calculates the sum of its elements, resulting in an additional iteration of size N.
Space Complexity: O(2^N), as the method uses the recursive findDoublePairs method, which has an exponential space complexity due to the recursion and the storage of subsequences.

### Overall program:

Time Complexity: The most significant factor is the findDoublePairs method with a time complexity of O(2^N * N). The other methods contribute to the overall time complexity with lower-order terms. Therefore, the overall time complexity can be considered as O(2^N * N).
Space Complexity: The most significant factor is the findDoublePairs method with a space complexity of O(2^N). The other methods contribute to the overall space complexity with lower-order terms. Therefore, the overall space complexity can be considered as O(2^N).
