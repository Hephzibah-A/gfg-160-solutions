import java.util.*;
import java.io.*;

public class MaxCircularSubarraySum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}

class Solution {
    public int circularSubarraySum(int arr[]) {
        int n = arr.length;

        // Step 1: Calculate max subarray sum using Kadane's algorithm
        int maxKadane = kadane(arr);

        // Step 2: Calculate total sum and min subarray sum
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i]; // Invert the array elements to find min subarray sum
        }
        int minKadane = kadane(arr); // minKadane is the negative of maximum sum of inverted array
        minKadane = -minKadane; // Restore it to actual minimum subarray sum

        // Step 3: Handle edge case (all elements negative)
        if (totalSum == minKadane) {
            return maxKadane; // All elements are negative
        }

        // Step 4: Return the maximum of non-circular and circular cases
        return Math.max(maxKadane, totalSum - minKadane);
    }
    // Helper function to find the maximum subarray sum using Kadane's algorithm
    private int kadane(int[] arr) {
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
