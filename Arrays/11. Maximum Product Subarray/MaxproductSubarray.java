import java.util.*;
import java.io.*;

public class MaxproductSubarray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
         int n = arr.length;

        // Initialize variables
        int maxProduct = arr[0];
        int minProduct = arr[0];
        int result = arr[0];

        // Iterate through the array
        for (int i = 1; i < n; i++) {
            int current = arr[i];

            // Swap maxProduct and minProduct if current is negative
            if (current < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // Update maxProduct and minProduct
            maxProduct = Math.max(current, maxProduct * current);
            minProduct = Math.min(current, minProduct * current);

            // Update the global result
            result = Math.max(result, maxProduct);
        }

        return result;
    }
}