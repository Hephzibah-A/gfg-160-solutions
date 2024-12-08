import java.util.*;
import java.io.*;

public class OverlappingIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // List to store the merged intervals
        List<int[]> result = new ArrayList<>();

        // Sort the intervals based on the starting time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize the first interval as the current interval to be merged
        int[] currentInterval = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // Check if the current interval overlaps with the next interval
            if (currentInterval[1] >= arr[i][0]) {
                // Merge the intervals by updating the end time
                currentInterval[1] = Math.max(currentInterval[1], arr[i][1]);
            } else {
                // Add the current interval to the result and move to the next
                result.add(currentInterval);
                currentInterval = arr[i];
            }
        }

        // Add the last interval to the result
        result.add(currentInterval);

        return result;
    }
}
