import java.util.*;
import java.io.*;


public class FindHIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine().trim());

        while (test_cases-- > 0) {
            // Read the array from input line
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // Solution instance to invoke the function
            Solution ob = new Solution();
            int result = ob.hIndex(arr);

            System.out.println(result);
            System.out.println("~");
        }
    }
}



class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        int n = citations.length;

        // Sort the array in ascending order
        Arrays.sort(citations);

        // Traverse the array from the end to find the H-index
        int hIndex = 0;
        for (int i = 0; i < n; i++) {
            int h = n - i; // Number of papers with citations >= citations[i]
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }
        return hIndex;
    }
}
