import java.io.*;
import java.util.*;

public class NextPermutation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output
        }
    }
}

class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;

        // Step 1: Find the first index `i` from the right such that arr[i] < arr[i + 1]
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find the first index `j` from the right such that arr[j] > arr[i]
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }

            // Step 3: Swap arr[i] and arr[j]
            swap(arr, i, j);
        }

        // Step 4: Reverse the subarray from i + 1 to the end of the array
        reverse(arr, i + 1, n - 1);
    }

    // Helper function to swap two elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Helper function to reverse elements in the array between indices start and end
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
