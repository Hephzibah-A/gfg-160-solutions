import java.util.*;
import java.io.*;

public class SmallestPositiveMissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // Read the line of integers (prices)
            String input = br.readLine().trim();

            // Split the input line into integers and store in an array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the missingNumber method
            int res = ob.missingNumber(arr);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}


class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;

        // Step 1: Replace negative numbers and zeros with a placeholder (n + 1)
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }

        // Step 2: Mark indices corresponding to positive numbers
        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);
            if (val <= n) {
                arr[val - 1] = -Math.abs(arr[val - 1]); // Mark as visited
            }
        }

        // Step 3: Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1; // Index + 1 is the missing number
            }
        }

        // Step 4: If all numbers are present, the missing number is n + 1
        return n + 1;
    }
}

