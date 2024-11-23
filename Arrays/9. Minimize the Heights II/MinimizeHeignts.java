import java.util.*;
import java.io.*;

public class MinimizeHeignts {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}


class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;

        // Edge case: if only one tower, no difference to minimize
        if (n == 1) {
            return 0;
        }

        // Create a list of modified heights
        List<int[]> variations = new ArrayList<>();
        int[] freq = new int[n];

        // Populate variations with both increased and decreased heights
        for (int i = 0; i < n; i++) {
            if (arr[i] - k >= 0) { // Only add valid heights
                variations.add(new int[]{arr[i] - k, i});
            }
            variations.add(new int[]{arr[i] + k, i});
        }

        // Sort the variations by height
        variations.sort((x, y) -> Integer.compare(x[0], y[0]));

        int left = 0, coveredTowers = 0, minDifference = Integer.MAX_VALUE;

        // Sliding window to find the smallest range
        for (int right = 0; right < variations.size(); right++) {
            int index = variations.get(right)[1];
            if (freq[index]++ == 0) {
                coveredTowers++; // Count unique towers included in the range
            }

            // Shrink the window if all towers are included
            while (coveredTowers == n) {
                minDifference = Math.min(minDifference, variations.get(right)[0] - variations.get(left)[0]);

                int leftIndex = variations.get(left)[1];
                if (--freq[leftIndex] == 0) {
                    coveredTowers--;
                }
                left++;
            }
        }

        return minDifference;
    }
}
