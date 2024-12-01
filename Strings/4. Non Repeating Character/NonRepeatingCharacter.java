import java.util.*;
import java.io.*;

public class NonRepeatingCharacter {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}


class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Step 1: Create a frequency array for 26 lowercase letters
        int[] frequency = new int[26];
        // Step 2: Track the order of characters
        int[] firstIndex = new int[26];
        for (int i = 0; i < 26; i++) {
            firstIndex[i] = -1;
        }

        // Step 3: Populate frequency and firstIndex arrays
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            frequency[index]++;
            if (firstIndex[index] == -1) {
                firstIndex[index] = i;
            }
        }

        // Step 4: Find the first non-repeating character
        int minIndex = Integer.MAX_VALUE;
        char result = '$'; // Default to '$' if no non-repeating character
        for (int i = 0; i < 26; i++) {
            if (frequency[i] == 1 && firstIndex[i] < minIndex) {
                minIndex = firstIndex[i];
                result = s.charAt(minIndex);
            }
        }

        return result;
    }
}
