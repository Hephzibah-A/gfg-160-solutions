import java.util.*;

public class ReverseArray {
    
}

class Solution {
    public void reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        // Swap elements from start and end until the pointers meet
        while (start < end) {
            // Swap arr[start] and arr[end]
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move the pointers
            start++;
            end--;
        }
    }
}
