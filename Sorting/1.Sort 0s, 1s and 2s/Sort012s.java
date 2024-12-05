import java.util.*;
import java.io.*;

public class Sort012s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        int low = 0; // Pointer for 0s
        int mid = 0; // Pointer for current element
        int high = arr.length - 1; // Pointer for 2s

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid], then increment both low and mid
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    // Move mid pointer forward
                    mid++;
                    break;
                case 2:
                    // Swap arr[mid] and arr[high], then decrement high
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }

    // Helper function to swap two elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
