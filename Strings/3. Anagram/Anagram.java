import java.util.*;
import java.io.*;

public class Anagram {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}

class Solution {
    // Function to check whether two strings are anagrams of each other.
    public static boolean areAnagrams(String s1, String s2) {
        // If lengths are different, they cannot be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Create a frequency array for 26 lowercase letters
        int[] frequency = new int[26];

        // Increment frequency for s1 and decrement for s2
        for (int i = 0; i < s1.length(); i++) {
            frequency[s1.charAt(i) - 'a']++;
            frequency[s2.charAt(i) - 'a']--;
        }

        // Check if all frequencies are zero
        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }

        return true; // Strings are anagrams
    }
}
