import java.util.*;
import java.io.*;

public class CountInversions {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}

class Solution {
    // Function to count inversions in the array
    static int inversionCount(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSort(arr, temp, 0, n - 1);
    }

    // Merge sort function
    private static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int inversionCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in the left subarray
            inversionCount += mergeSort(arr, temp, left, mid);

            // Count inversions in the right subarray
            inversionCount += mergeSort(arr, temp, mid + 1, right);

            // Merge the two subarrays and count inversions across them
            inversionCount += merge(arr, temp, left, mid, right);
        }
        return inversionCount;
    }

    // Merge function that counts inversions during merging
    private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;     // Starting index for the left subarray
        int j = mid + 1;  // Starting index for the right subarray
        int k = left;     // Starting index for the merged subarray
        int inversionCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // All remaining elements in the left subarray (arr[i..mid]) are greater than arr[j]
                inversionCount += (mid - i + 1);
            }
        }

        // Copy the remaining elements of the left subarray (if any)
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy the remaining elements of the right subarray (if any)
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted subarray back into the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return inversionCount;
    }
}
