import java.util.*;
import java.io.*;

public class MoveAllZeroesToEnd {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr);
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int index = 0; // Pointer to place non-zero elements

        // Traverse the array and place non-zero elements at `index`
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }

        // Fill the remaining positions with zeroes
        while (index < n) {
            arr[index++] = 0;
        }
    }
}
