import java.util.*;
import java.io.*;


public class InsertIntervals {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            int h[] = new int[2];
            h[0] = sc.nextInt();
            h[1] = sc.nextInt();
            Solution obj = new Solution();
            ArrayList<int[]> ans = obj.insertInterval(a, h);
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[");
                System.out.print(ans.get(i)[0] + "," + ans.get(i)[1]);
                System.out.print("]");
                if (i != ans.size() - 1) System.out.print(",");
            }
            System.out.println("]");

            System.out.println("~");
        }
    }
}



class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();

        int i = 0, n = intervals.length;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        // Add all intervals that come before the new interval
        while (i < n && intervals[i][1] < newStart) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }
        result.add(new int[]{newStart, newEnd});

        // Add all intervals that come after the new interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result;
    }
}
